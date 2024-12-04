package testDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObject.LoginPage;
import pageObject.MyaccountPage;
import pageObject.RegistrationPage;

public class TC_003_RegistrationAndLoginTest {

	MyaccountPage map;
	LoginPage lp;
	RegistrationPage rp;
	Properties p;
	Logger gl;
	String email , pass ;

	@Given("user is on the registration page")
	public void user_is_on_the_registration_page() throws IOException {
		map=new MyaccountPage(BaseClass.getDriver());
		p = BaseClass.getproperties();
		gl=BaseClass.getlogger();

		gl.info("***TC_003_RegistrationAndLoginTest - started***");
		gl.debug("Application log started");

		map.clickMyaccount();
		map.clickRegister();
		gl.info("Enter the register page");
	}

	@When("user enters the details in all the fields")
	public void user_enters_the_details_in_all_the_fields() throws InterruptedException, IOException {
		Thread.sleep(1000);
		rp=new RegistrationPage(BaseClass.getDriver());
		rp.setFirstname(BaseClass.alpa());
		rp.setLastname(BaseClass.alpa());
		email =BaseClass.alpa()+"@gm.com";
		rp.setEmail(email);
		rp.setPhnumber(BaseClass.num());
		pass = BaseClass.name();
		System.out.println(email+"    "+pass);
		rp.setpassword(pass);
		rp.setconfirmPassword(pass);
		gl.info("Credentials are passed");
	}

	@When("user accept the terms and clicks the submit button")
	public void user_accept_the_terms_and_clicks_the_submit_button() throws InterruptedException {
		rp.clickterms();
		rp.clickSubmit();
		Thread.sleep(1000);
	}

	@Then("user receives the account created page and click logout")
	public void user_receives_the_account_created_page_and_click_logout() throws IOException {
		lp=new LoginPage(BaseClass.getDriver());
		boolean b = rp.RegisterVerification();
		if(b==true) {
			gl.info("Registered successfully");
			lp.clickLogout();
			Assert.assertTrue(true);
		}else {
			gl.error("Registered unsuccessfully");
			Assert.assertTrue(false);
		}
	}

	@Then("user login with the same credetials")
	public void user_login_with_the_same_credetials() throws InterruptedException {
		map.clickMyaccount();
		map.clickLogin();
		gl.info("Entered into login page");
		Thread.sleep(1000);
		lp.setUsername(email);
		lp.setPassword(pass);
		gl.info("Credentials are passed successfully");
		lp.clickLogin();
		Thread.sleep(1000);
		boolean b = lp.verifylogin();
		if(b==true) {
			gl.info("Logged in successfully");
			lp.clickLogout();
			Assert.assertTrue(true);
		}else {
			gl.info("Login Unsuccessfully");
			Assert.assertTrue(false);
		}

		gl.debug("Application log ended");
		gl.info("***TC_003_RegistrationAndLoginTest - ended***");
	}

}
