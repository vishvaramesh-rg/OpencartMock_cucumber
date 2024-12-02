package testDefinitions;

import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObject.LoginPage;
import pageObject.MyaccountPage;

public class TC_001_LoginTest {

	MyaccountPage map;
	LoginPage lp;
	Properties p;
	Logger gl;



	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws IOException {
		map=new MyaccountPage(BaseClass.getDriver());
		lp=new LoginPage(BaseClass.getDriver());
		p = BaseClass.getproperties();
		gl = BaseClass.getlogger();
		gl.info("***login execution started***");
		gl.debug("Application log started");

		map.clickMyaccount();
		map.clickLogin();
	}

	@When("user enters the valid username and password")
	public void user_enters_the_valid_username_and_password() {
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		gl.info("Credentials are passed successfully");
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		lp.clickLogin();
		gl.info("clicked login button");
		
	}

	@Then("user navigates to the login page and click logout")
	public void user_navigates_to_the_login_page_and_click_logout() {
		boolean b = lp.verifylogin();
		if(b==true) {
			gl.info("Logged in successfully");
			Assert.assertTrue(true);
		}else {
			gl.info("Login Unsuccessfully");
			Assert.assertTrue(false);
		}
		
		gl.debug("Application log ended");
		gl.info("***login execution ended***");
	}

}
