package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,

        plugin = {"html:reports/cucumber-html-report",
                "json:reports/cucumber.json",
                "pretty"},
        tags = "@updateApi",
        features = {"src/test/resources/features/Accounts.feature"},
        glue = "stepDefs",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class MyRunner {
}
