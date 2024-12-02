package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(


		features = {".//Features/loginTest.feature"},
		glue="testDefinitions",
		dryRun = false,
		plugin = { "pretty", "html:reports/myreport.html",
					"rerun:target/re-run.txt",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},

		monochrome = true, //to avoid the junk
		publish=false //to publish the report in cucumber server
		
		//tags="@sanity"
		)
public class TestRunner {

}
