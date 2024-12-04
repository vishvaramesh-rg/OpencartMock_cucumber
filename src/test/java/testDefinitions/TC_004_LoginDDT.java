package testDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import pageObject.MyaccountPage;
import utilities.DataReader;

public class TC_004_LoginDDT {
	MyaccountPage map;
	LoginPage lp;
	Properties p;
	Logger gl;

	@When("user navigates to login page")
	public void user_navigates_to_login_page() throws IOException {
		map=new MyaccountPage(BaseClass.getDriver());
		gl=BaseClass.getlogger();
		p=BaseClass.getproperties();
		gl.info("***TC_004_LoginDDT started***");
		gl.debug("Application log started");

		map.clickMyaccount();
		map.clickLogin();
		gl.info("Entered into login page");
	}

	@Then("user redirected to the Myaccount page by passing username and password from the excel {string}")
	public void user_redirected_to_the_myaccount_page_by_passing_username_and_password_from_the_excel(String row) throws InterruptedException, AWTException, IOException {
		
		List<HashMap<String, String>> data = DataReader.data(System.getProperty("user.dir")+"\\testData\\OpenCart_loginDDT.xlsx","users");
		
		//string to int
		int index = Integer.parseInt(row)-1;
		String usern=data.get(index).get("username");
		String passw=data.get(index).get("password");
		String exp_res=data.get(index).get("res");
		
		lp=new LoginPage(BaseClass.getDriver());
		lp.setUsername(usern);
		lp.setPassword(passw);
		gl.info("Credentials are passed successfully");
		lp.clickLogin();
		Thread.sleep(1000);
		

		boolean b = lp.verifylogin();
		try {
			if(exp_res.equalsIgnoreCase("valid")) {

				if(b==true) {
					gl.info("Logged-in successfully with valid cred");
					lp.clickLogout();
					Assert.assertTrue(true);
				}else {
					gl.error("Login unsuccessful with valid cred");
					Assert.assertTrue(false);
				}
			}

			if(exp_res.equalsIgnoreCase("invalid")) {

				if(b==true) {
					gl.error("Logged-in successfully with Invalid cred");
					lp.clickLogout();
					Assert.assertTrue(false);
				}else {
					gl.info("Login unsuccessfully with Invalid cred");
					Assert.assertTrue(true);
				}
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
			BaseClass.screenShot();
		}
	}

}
