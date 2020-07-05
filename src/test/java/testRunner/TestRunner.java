package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features//SearchCustomer.feature",".//Features//Login.feature"},
        glue = "stepDefinations",
        dryRun = false,
        monochrome=true,
        plugin = {"pretty","html:test-output"},
        tags = "@regression"

)
public class TestRunner {
}
