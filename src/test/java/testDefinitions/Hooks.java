package testDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
	Properties p;

	@Before
	public void setUp() throws IOException {

		driver = BaseClass.driverLaunch();
		p= BaseClass.getproperties();
		driver.get(p.getProperty("appurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}


	@After
	public void name() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

	public void screenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot tk = (TakesScreenshot) driver;
			byte[] as = tk.getScreenshotAs(OutputType.BYTES);
			scenario.attach(as, "image/png", scenario.getName());
		}
	}

}
