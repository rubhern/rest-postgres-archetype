package it.pkg.integration;


import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "it.pkg.integration")
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty,summary," +
                "html:target/cucumber-report.html," +
                "json:target/cucumber-report.json")
public class CucumberRunnerTest {
}
