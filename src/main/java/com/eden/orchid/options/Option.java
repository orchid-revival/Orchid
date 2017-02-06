package com.eden.orchid.options;

import com.eden.common.json.JSONElement;

/**
 * Denotes a Javadoc-style command-line argument.
 */
public interface Option {

    /**
     * Return the number of arguments this Option is expecting. This number is strictly enforced, and the option will
     * only be allowed to parse the command-line option if the number of arguments it finds exactly matches this value.
     *
     * For each custom option that you want to recognize, optionLength must return the number of separate pieces or
     * tokens in the option. For example, we want to be able to use the custom option of the form -tag mytag. This
     * option has two pieces, the -tag option itself and its value, so the optionLength method in our doclet must return
     * 2 for the -tag option.
     *
     * An option can return 0 if it isn't expecting any actual command-line option, but does want to add data to the
     * 'option' object.
     *
     * @return the length of this option, including the flag itself
     */
    int optionLength();

    /**
     * A callback for when an option on the command-line matches the optionLength or when optionLength is 0. Whatever
     * JSONElement is returned will be available in the root JSONObject at `options.{flag}`.
     *
     * @param options the raw values found on the command line. Its length will always be exactly equal to optionLength
     * @return the data parsed from the command-line option
     */
    JSONElement parseOption(String[] options);

    /**
     * Return true if this Option must be set before continuing with the Orchid build.
     *
     * @return true if this option is required, false otherwise.
     */
    boolean isRequired();

    /**
     * If this value is not false, this callback is used instead to get a value for this option. Whatever JSONElement is
     * returned will be available in the root JSONObject at `options.{flag}`.
     * @return the default value for this Option
     */
    JSONElement getDefaultValue();

    /**
     * The name of the flag used on the command-line. This value should _not_ start with a dash, but options specified
     * on the command-line _must_ begin with a dash. The value returned by `parseOption` is available in the root
     * JSONObject at `options.{flag}`.
     *
     * @return the flag, without any leading dash
     */
    String getFlag();

    /**
     * Return a description of this Option, which is displayed when listing available Options.
     *
     * @return this option's description
     */
    String getDescription();

    /**
     * Return the priority of this option. A higher priority means this option will be processed earlier.
     *
     * @return this option's priority
     */
    int priority();
}
