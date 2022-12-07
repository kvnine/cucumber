import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,

        plugin = {"html:reports/cucumber-html-report",
                "json:reports/cucumber.json",
                "pretty"},
        tags = "@runss",
        features = {"src/test/features/Accounts.feature"}
//        glue = {"MyStepdefs"}
)
public class myRunner {
}
