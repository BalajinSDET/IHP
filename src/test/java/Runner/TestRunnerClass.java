package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/Features/Sign in as Job Seeker.feature"}, //Verify End to End Test Flow Hiring Job Seeker.feature
        glue = "StepDefinition",
        dryRun = false,
        monochrome = true,
        publish = true,
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:failed_scenarios/failed_scenarios.txt",
                "pretty",
                "html:target/cucumber-reports/report.html"
        }

)

public class TestRunnerClass extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
