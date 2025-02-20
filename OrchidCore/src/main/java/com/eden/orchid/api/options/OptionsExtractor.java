package com.eden.orchid.api.options;

import com.caseyjbrooks.clog.Clog;
import com.eden.common.util.EdenPair;
import com.eden.common.util.EdenUtils;
import com.eden.orchid.api.OrchidContext;
import com.eden.orchid.api.options.annotations.Archetype;
import com.eden.orchid.api.options.annotations.Description;
import com.eden.orchid.api.options.annotations.Option;
import com.jakewharton.picnic.Table;
import com.jakewharton.picnic.TableSection;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

@Singleton
public class OptionsExtractor extends Extractor {

    private final OrchidContext context;
    private final OptionsValidator validator;

    @Inject
    public OptionsExtractor(OrchidContext context, Set<OptionExtractor> extractors, OptionsValidator validator) {
        super(new ArrayList<>(extractors), new AnnotatedValidatorWrapper(validator), context::resolve);
        this.context = context;
        this.validator = validator;
    }

    public void extractOptions(OptionsHolder optionsHolder, Map<String, Object> options) {
        super.extractOptions(optionsHolder, options);
    }

    public boolean validate(OptionsHolder optionsHolder) {
        try {
            validator.validate(optionsHolder);
            return true;
        }
        catch (Exception e) {
            Clog.e("{} did not pass validation", e, optionsHolder);
            return false;
        }
    }

    public boolean hasOptions(Object possibleObjectHolder) {
        return hasOptions(possibleObjectHolder, true, true);
    }

    public boolean hasOptions(Object possibleObjectHolder, boolean includeOwnOptions, boolean includeInheritedOptions) {
        if(possibleObjectHolder instanceof OptionsHolder) {
            EdenPair<Field, Set<Field>> fields = findOptionFields(possibleObjectHolder.getClass(), includeOwnOptions, includeInheritedOptions);
            return fields.second.size() > 0;
        }
        else if(possibleObjectHolder instanceof Class) {
            if(OptionsHolder.class.isAssignableFrom((Class) possibleObjectHolder)) {
                EdenPair<Field, Set<Field>> fields = findOptionFields((Class) possibleObjectHolder, includeOwnOptions, includeInheritedOptions);
                return fields.second.size() > 0;
            }
        }

        return false;
    }

// Describe Options
//----------------------------------------------------------------------------------------------------------------------

    public List<String> getOptionNames(Class<?> optionsHolderClass) {
        EdenPair<Field, Set<Field>> fields = findOptionFields(optionsHolderClass);

        List<String> optionNames = new ArrayList<>();

        for (Field field : fields.second) {
            String key = (!EdenUtils.isEmpty(field.getAnnotation(Option.class).value()))
                    ? field.getAnnotation(Option.class).value()
                    : field.getName();

            optionNames.add(key);
        }

        return optionNames;
    }

    public List<String> getOptionNames(Class<?> optionsHolderClass, boolean includeOwnOptions, boolean includeInheritedOptions) {
        EdenPair<Field, Set<Field>> fields = findOptionFields(optionsHolderClass, includeOwnOptions, includeInheritedOptions);

        List<String> optionNames = new ArrayList<>();

        for (Field field : fields.second) {
            String key = (!EdenUtils.isEmpty(field.getAnnotation(Option.class).value()))
                    ? field.getAnnotation(Option.class).value()
                    : field.getName();

            optionNames.add(key);
        }

        return optionNames;
    }

    public OptionHolderDescription describeOptions(Class<?> optionsHolderClass, boolean includeOwnOptions, boolean includeInheritedOptions) {
        return describeOptions(optionsHolderClass, findOptionFields(optionsHolderClass, includeOwnOptions, includeInheritedOptions));
    }

    public OptionHolderDescription describeAllOptions(Class<?> optionsHolderClass) {
        return describeOptions(optionsHolderClass, findOptionFields(optionsHolderClass, true, true));
    }

    public OptionHolderDescription describeOwnOptions(Class<?> optionsHolderClass) {
        return describeOptions(optionsHolderClass, findOptionFields(optionsHolderClass, true, false));
    }

    public OptionHolderDescription describeInheritedOptions(Class<?> optionsHolderClass) {
        return describeOptions(optionsHolderClass, findOptionFields(optionsHolderClass, false, true));
    }

    private OptionHolderDescription describeOptions(Class<?> optionsHolderClass, EdenPair<Field, Set<Field>> fields) {

        // describe options
        List<OptionsDescription> optionDescriptions = new ArrayList<>();
        if(fields.first != null) {
            optionDescriptions.add(new OptionsDescription(fields.first.getName(), Map.class, getFieldTypeParams(fields.first), "All options passed to this object.", "{}"));
        }
        for (Field field : fields.second) {
            String key = (!EdenUtils.isEmpty(field.getAnnotation(Option.class).value()))
                    ? field.getAnnotation(Option.class).value()
                    : field.getName();
            String description = (field.getAnnotation(Description.class) != null && !EdenUtils.isEmpty(field.getAnnotation(Description.class).value()))
                    ? field.getAnnotation(Description.class).value()
                    : "";
            String defaultValue = "N/A";

            for (OptionExtractor extractor : getExtractors()) {
                if (extractor.acceptsClass(field.getType())) {
                    defaultValue = extractor.describeDefaultValue(field);
                    break;
                }
            }

            optionDescriptions.add(new OptionsDescription(key, field.getType(), getFieldTypeParams(field), description, defaultValue));
        }
        optionDescriptions.sort(Comparator.comparing(OptionsDescription::getKey));

        // describe archetypes
        List<ArchetypeDescription> archetypeDescriptions = new ArrayList<>();
        for(Archetype archetype : getArchetypes(optionsHolderClass)) {
            String archetypeKey = archetype.key();
            Class<? extends OptionArchetype> archetypeClass = archetype.value();
            String archetypeDisplayName = Descriptive.getDescriptiveName(archetypeClass);
            String archetypeDescription = Descriptive.getDescription(archetypeClass);

            archetypeDescriptions.add(new ArchetypeDescription(
                    archetypeKey,
                    archetypeClass,
                    archetypeDisplayName,
                    archetypeDescription
            ));
        }

        return new OptionHolderDescription(
                Descriptive.getDescriptiveName(optionsHolderClass),
                Descriptive.getDescription(optionsHolderClass),
                optionDescriptions,
                archetypeDescriptions
        );
    }

    private Class<?>[] getFieldTypeParams(Field field) {
        final Class<?>[] genericClasses;
        if(field.getGenericType() instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
            Type[] parameterizedTypes = parameterizedType.getActualTypeArguments();
            genericClasses = new Class<?>[parameterizedTypes.length];
            for (int i = 0; i < parameterizedTypes.length; i++) {
                try {
                    genericClasses[i] = (Class<?>) parameterizedTypes[i];
                }
                catch (Exception e) {
                    genericClasses[i] = null;
                }
            }
        }
        else {
            genericClasses = null;
        }

        return genericClasses;
    }

    public Table getDescriptionTable(OptionHolderDescription optionsHolderDescription) {

        List<OptionsDescription> options = optionsHolderDescription.getOptionsDescriptions();
        Table.Builder builder = new Table.Builder()
                .setHeader(
                        new TableSection.Builder()
                        .addRow("Key", "Type", "Default Value", "Description")
                        .build()
                );
        TableSection.Builder rows = new TableSection.Builder();
        options.forEach(option -> {
            rows.addRow(
                    option.getKey(),
                    option.getOptionType().getSimpleName(),
                    option.getDefaultValue(),
                    option.getDescription()
            );
       });
       return builder.setBody(rows.build()).build();
    }
}
