package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(


		features = {".//Features/LoginDDT.feature",".//Features/registrationTestUsingTable.feature"},
		//features = {".//Features/loginTest.feature"},
		//features = {".//Features/registrationTestUsingTable.feature"},
		//features = {".//Features/registrationTest.feature"},
		//features = {".//Features/registrationTestUsingTable.feature",".//Features/loginTest.feature"},
		glue="testDefinitions",
		dryRun = false,
		plugin = { "pretty", "html:reports/myreport.html",
					"rerun:target/re-run.txt",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},

		monochrome = true, //to avoid the junk
		publish=true //to publish the report in cucumber server
		
		//tags="@sanity"
		)
public class TestRunner {

}
