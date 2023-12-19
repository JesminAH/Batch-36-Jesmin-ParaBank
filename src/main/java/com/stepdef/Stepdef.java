package com.stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.DriverManager;
import com.pagefactory.MasterPageFactory;
import com.utility.Highlighter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdef {
	WebDriver driver;
	MasterPageFactory mpf;
	@Given("open the browser")
	public void open_the_browser() {
	    
		DriverManager dm = new DriverManager();
		driver = dm.getFirefoxDriver(driver);
		
	}
	
	@Given("pass the URL {string}")
	public void pass_the_url(String URL) {
		
		driver.navigate().to(URL);
	       
	}

	@When("enter username {string} in the user field")
	public void enter_username_in_the_user_field(String username) {
		
	mpf = new MasterPageFactory(driver); 
	Highlighter.addColor(driver, mpf.getUsername());
	mpf.getUsername().sendKeys(username);
	    
	}

	@When("enter password {string} in the password field")
	public void enter_password_in_the_password_field(String password) {
	  
	Highlighter.addColor(driver, mpf.getPassword());	
	 mpf.getPassword().sendKeys(password);   
	}

	@When("click on Login")
	public void click_on_login() {
	    
		Highlighter.addColor(driver, mpf.getLoginBtn());
		mpf.getLoginBtn().click();
	    
	}

	@Then("validate login is successful")
	public void validate_login_is_successful() {
	    
	    Assert.assertTrue(mpf.getLogoutBtn().isDisplayed(), "Login Successful");
	    if(mpf.getLogoutBtn().isDisplayed()) {
	    	System.out.println("Login is Successful");	
	    }else {
	    	System.out.println("Login not Successful");
	    	
	    }
		    
	}

	@When("click on Logout")
	public void click_on_logout() {
		
		Highlighter.addColor(driver, mpf.getLogoutBtn());
		mpf.getLogoutBtn().click();  
	    
	}

	@Then("Validate Logout is successful")
	public void validate_logout_is_successful() {
	    
	Assert.assertTrue(mpf.getLoginBtn().isDisplayed(), "Logout Successful");    
	
	if(mpf.getLoginBtn().isDisplayed()) {
		System.out.println("Logout is Successful");
		
	}else {
		System.out.println("Logout is Failed!");
	}
	}
}
