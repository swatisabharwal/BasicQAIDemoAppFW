package com.qait.demo.keywords;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;

public class Login extends GetPage {
	
	String url = YamlReader.getYamlValue("baseUrl");

	WebDriver driver;

	public Login(WebDriver driver) {
		super(driver, "applogin");
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void login(String username, String password) {
		element("username_field").sendKeys(username);
		element("password_field").sendKeys(password);
		element("login_btn").click();
		Assert.assertTrue(element("mainpagetitle").isDisplayed());
		
	}

}
