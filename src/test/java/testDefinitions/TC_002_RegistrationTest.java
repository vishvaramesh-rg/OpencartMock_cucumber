package testDefinitions;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObject.LoginPage;
import pageObject.MyaccountPage;
import pageObject.RegistrationPage;

public class TC_002_RegistrationTest {
	MyaccountPage map;
	RegistrationPage rp;
	LoginPage lp;
	Logger gl;
	Properties p;
	
	@Given("user is on registration page")
	public void user_is_on_registration_page() throws IOException {
		map=new MyaccountPage(BaseClass.getDriver());
		rp=new RegistrationPage(BaseClass.getDriver());
		gl=BaseClass.getlogger();
		p=BaseClass.getproperties();
		
		gl.info("***TC_002_RegistrationTest - started***");
		gl.debug("Application log started");
		map.clickMyaccount();
		map.clickRegister();
		gl.info("Enters into registration page");
		
	    
	}

	@When("user enters the details in the respective fields")
	public void user_enters_the_details_in_the_respective_fields(DataTable dataTable) throws InterruptedException {
		Map<String, String> d = dataTable.asMap(String.class,String.class);
		Thread.sleep(1000);
		rp.setFirstname(d.get("FirstName"));
		rp.setLastname(d.get("LastName"));
		rp.setEmail(BaseClass.alpa()+"@gm07.com");
		rp.setPhnumber(d.get("Phone"));
		String pass = BaseClass.name();
		rp.setpassword(pass);
		rp.setconfirmPassword(pass);
		
		gl.info("User details are passed");
	}

	@When("user accept the terms and click the submit button")
	public void user_accept_the_terms_and_click_the_submit_button() {
		rp.clickterms();
		rp.clickSubmit();
		gl.info("Clicked the submit button");
	}

	@Then("user navigates to the Registration page with confirmation message")
	public void user_navigates_to_the_registration_page_with_confirmation_message() throws InterruptedException {
	    Thread.sleep(1000);
	    boolean b = rp.RegisterVerification();
	    lp = new LoginPage(BaseClass.getDriver());
	    
	    if(b==true) {
	    	gl.info("Registered sucessfully");
	    	lp.clickLogout();
	    	Assert.assertTrue(true);
	    }
	    else {
	    	gl.info("Login Unsuccessfully");
			Assert.assertTrue(false);
		}

		gl.debug("Application log ended");
		gl.info("***TC_002_RegistrationTest - ended***");
	}

}
