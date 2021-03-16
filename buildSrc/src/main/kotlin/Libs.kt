import kotlin.String

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Update this file with
 *   `$ ./gradlew buildSrcVersions`
 */
object Libs {
    /**
     * https://github.com/vsch/flexmark-java
     * CENTRAL
     */
    const val flexmark: String = "com.vladsch.flexmark:flexmark:" + Versions.com_vladsch_flexmark
    const val flexmark_ext_anchorlink: String = "com.vladsch.flexmark:flexmark-ext-anchorlink:" +
            Versions.com_vladsch_flexmark
    const val flexmark_ext_aside: String = "com.vladsch.flexmark:flexmark-ext-aside:" +
            Versions.com_vladsch_flexmark
    const val flexmark_ext_attributes: String = "com.vladsch.flexmark:flexmark-ext-attributes:" +
            Versions.com_vladsch_flexmark
    const val flexmark_ext_enumerated_reference: String =
            "com.vladsch.flexmark:flexmark-ext-enumerated-reference:" +
            Versions.com_vladsch_flexmark
    const val flexmark_ext_gfm_tasklist: String =
            "com.vladsch.flexmark:flexmark-ext-gfm-tasklist:" + Versions.com_vladsch_flexmark
    const val flexmark_ext_toc: String = "com.vladsch.flexmark:flexmark-ext-toc:" +
            Versions.com_vladsch_flexmark

    /**
     * https://kotlinlang.org/
     * CENTRAL
     */
    const val kotlin_gradle_plugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" +
            Versions.org_jetbrains_kotlin
    const val kotlin_scripting_compiler_embeddable: String =
            "org.jetbrains.kotlin:kotlin-scripting-compiler-embeddable:" +
            Versions.org_jetbrains_kotlin
    const val kotlin_stdlib_jdk8: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:" +
            Versions.org_jetbrains_kotlin
    const val kotlin_reflect: String = "org.jetbrains.kotlin:kotlin-reflect:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://github.com/danfickle/openhtmltopdf
     * CENTRAL
     */
    const val openhtmltopdf_core: String = "com.openhtmltopdf:openhtmltopdf-core:" +
            Versions.com_openhtmltopdf
    const val openhtmltopdf_pdfbox: String = "com.openhtmltopdf:openhtmltopdf-pdfbox:" +
            Versions.com_openhtmltopdf
    const val openhtmltopdf_slf4j: String = "com.openhtmltopdf:openhtmltopdf-slf4j:" +
            Versions.com_openhtmltopdf
    const val openhtmltopdf_svg_support: String = "com.openhtmltopdf:openhtmltopdf-svg-support:" +
            Versions.com_openhtmltopdf

    /**
     * https://junit.org/junit5/
     * CENTRAL
     */
    const val junit_jupiter_api: String = "org.junit.jupiter:junit-jupiter-api:" +
            Versions.org_junit_jupiter
    const val junit_jupiter_engine: String = "org.junit.jupiter:junit-jupiter-engine:" +
            Versions.org_junit_jupiter
    const val junit_jupiter_params: String = "org.junit.jupiter:junit-jupiter-params:" +
            Versions.org_junit_jupiter

    /**
     * https://copper-leaf.github.io/kodiak
     * JCENTER,SPRING-LIB-RELEASES
     */
    const val common_formatter: String = "com.eden.kodiak:common-formatter:" +
            Versions.com_eden_kodiak
    const val common_models: String = "com.eden.kodiak:common-models:" + Versions.com_eden_kodiak
    const val common_runner: String = "com.eden.kodiak:common-runner:" + Versions.com_eden_kodiak
    const val com_eden_kodiak_dokka_runner: String = "com.eden.kodiak:dokka-runner:" +
            Versions.com_eden_kodiak
    const val com_eden_kodiak_groovydoc_runner: String = "com.eden.kodiak:groovydoc-runner:" +
            Versions.com_eden_kodiak
    const val com_eden_kodiak_javadoc_runner: String = "com.eden.kodiak:javadoc-runner:" +
            Versions.com_eden_kodiak
    const val swiftdoc_runner: String = "com.eden.kodiak:swiftdoc-runner:" +
            Versions.com_eden_kodiak

    /**
     * http://www.nanohttpd.org
     * CENTRAL
     */
    const val nanohttpd: String = "org.nanohttpd:nanohttpd:" + Versions.org_nanohttpd
    const val nanohttpd_websocket: String = "org.nanohttpd:nanohttpd-websocket:" +
            Versions.org_nanohttpd

    /**
     * https://copper-leaf.github.io/dokka-json
     * JCENTER
     */
    const val com_eden_groovydoc_runner: String = "com.eden:groovydoc-runner:" +
            Versions.com_eden_groovydoc_runner
    const val com_eden_javadoc_runner: String = "com.eden:javadoc-runner:" +
            Versions.com_eden_javadoc_runner
    const val com_eden_dokka_runner: String = "com.eden:dokka-runner:" +
            Versions.com_eden_dokka_runner

    /**
     * https://javaeden.github.io/Common/Common
     * JCENTER!
     */
    const val com_eden_common: String = "com.eden:Common:" + Versions.com_eden_common

    /**
     * https://www.codacy.com
     * CENTRAL
     */
    const val codacy_coverage_reporter: String = "com.codacy:codacy-coverage-reporter:" +
            Versions.codacy_coverage_reporter

    /**
     * TODO remove and replace with maven central!
     */
    const val gradle_bintray_plugin: String = "com.jfrog.bintray.gradle:gradle-bintray-plugin:" +
            Versions.gradle_bintray_plugin

    /**
     * http://hibernate.org/validator
     * CENTRAL
     */
    const val hibernate_validator: String = "org.hibernate.validator:hibernate-validator:" +
            Versions.hibernate_validator
    /**
     * http://beanvalidation.org
     * CENTRAL
     */
    const val validation_api: String = "jakarta.validation:jakarta.validation-api:" + Versions.validation_api
    /**
     * http://el-spec.java.net
     * CENTRAL
     */
    const val javax_el: String = "org.glassfish:jakarta.el:" + Versions.javax_el

    /**
     * http://github.com/univocity/univocity-parsers
     * CENTRAL
     */
    const val univocity_parsers: String = "com.univocity:univocity-parsers:" +
            Versions.univocity_parsers

    /**
     * http://hamcrest.org/JavaHamcrest/
     * CENTRAL
     */
    const val hamcrest_library: String = "org.hamcrest:hamcrest-library:" +
            Versions.hamcrest_library

    /**
     * https://github.com/Kotlin/kotlinx.html
     * JCENTER + others
     */
    const val kotlinx_html_jvm: String = "org.jetbrains.kotlinx:kotlinx-html-jvm:" +
            Versions.kotlinx_html_jvm

    /**
     * https://commons.apache.org/proper/commons-lang/
     *  https://commons.apache.org/proper/commons-io/
     * CENTRAL
     */
    const val commons_lang3: String = "org.apache.commons:commons-lang3:" + Versions.commons_lang3

    const val commons_text: String = "org.apache.commons:commons-text:" + Versions.commons_text

    const val commons_io: String = "commons-io:commons-io:" + Versions.commons_io


    /**
     * http://atteo.org/static/evo-inflector
     * CENTRAL
     */
    const val evo_inflector: String = "org.atteo:evo-inflector:" + Versions.evo_inflector

    /**
     * https://github.com/coobird/thumbnailator
     * CENTRAL
     */
    const val thumbnailator: String = "net.coobird:thumbnailator:" + Versions.thumbnailator

    /**
     * https://github.com/asciidoctor/asciidoctorj
     * CENTRAL
     */
    const val asciidoctorj: String = "org.asciidoctor:asciidoctorj:" + Versions.asciidoctorj


    /**
     * https://github.com/mockito/mockito
     * CENTRAL
     */
    const val mockito_core: String = "org.mockito:mockito-core:" + Versions.mockito_core

    /**
     * https://strikt.io/
     * CENTRAL
     */
    const val strikt_core: String = "io.strikt:strikt-core:" + Versions.strikt_core
    const val filepeek: String = "com.christophsturm:filepeek:" + Versions.file_peek

    /**
     * https://github.com/classgraph/classgraph
     * CENTRAL
     */
    const val classgraph: String = "io.github.classgraph:classgraph:" + Versions.classgraph

    /**
     * http://www.snakeyaml.org
     * CENTRAL
     */
    const val snakeyaml: String = "org.yaml:snakeyaml:" + Versions.snakeyaml

    /**
     * https://github.com/javaee/jaxb-spec
     * https://github.com/eclipse-ee4j/jaxb-api
     * CENTRAL
     *
     */
    const val jaxb_api: String = "jakarta.xml.bind:jakarta.xml.bind-api:" + Versions.jaxb_api

    /**
     * http://plantuml.sourceforge.net
     * CENTRAL
     */
    const val plantuml: String = "net.sourceforge.plantuml:plantuml:" + Versions.plantuml

    /**
     * http://www.pygments.org
     * CENTRAL
     */
    const val pygments: String = "org.pygments:pygments:" + Versions.pygments
    /**
     * https://www.jython.org/
     * CENTRAL
     */
    const val jython_standalone: String = "org.python:jython-standalone:" +
            Versions.jython_standalone

    /**
     * https://javaeden.github.io/Clog/Clog4j
     * JCENTER???
     */
    const val clog4j: String = "com.eden:Clog4j:" + Versions.clog4j

    /**
     * https://square.github.io/okhttp/
     * CENTRAL
     */
    const val okhttp: String = "com.squareup.okhttp3:okhttp:" + Versions.okhttp

    /**
     * http://pebbletemplates.io
     * CENTRAL
     */
    const val pebble: String = "io.pebbletemplates:pebble:" + Versions.pebble

    /**
     * http://moandjiezana.com/toml/toml4j
     * CENTRAL
     */
    const val toml4j: String = "com.moandjiezana.toml:toml4j:" + Versions.toml4j

    /**
     * https://github.com/google/guice
     * CENTRAL
     */
    const val guice: String = "com.google.inject:guice:" + Versions.guice
    const val javax_inject: String = "jakarta.inject:jakarta.inject-api:" + Versions.javax_inject

    /**
     * https://gitlab.com/jsass/jsass
     * CENTRAL
     */
    const val jsass: String = "io.bit3:jsass:" + Versions.jsass

    /**
     * https://jsoup.org/
     * CENTRAL
     */
    const val jsoup: String = "org.jsoup:jsoup:" + Versions.jsoup

    /**
     * CENTRAL
     */
    const val json: String = "org.json:json:" + Versions.json

    /**
     * https://copper-leaf.github.io/krow
     * JCENTER
     */
    const val krow: String = "com.eden:krow:" + Versions.krow
}
