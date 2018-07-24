package com.qait.demo.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.getpageobjects.BaseUi;
import com.qait.automation.utils.YamlReader;

public class CustomerSetupTest {

	private TestSessionInitiator test;
	String username, password, loginUrl, input_code, input_name, customersetupurl,tatoc_url;

	@BeforeClass
	public void initializeVariable(){
		test = new TestSessionInitiator(this.getClass().getName());
		_initVars();
	}
	
	//@BeforeClass
	private void _initVars() {
		/*username = YamlReader.getYamlValue("username");
		password = YamlReader.getYamlValue("password");
		loginUrl = YamlReader.getYamlValue("baseUrl");
		input_code = YamlReader.getYamlValue("sample_code");
		input_name = YamlReader.getYamlValue("sample_name");
		customersetupurl = YamlReader.getYamlValue("customersetupurl");*/
		tatoc_url = YamlReader.getYamlValue("baseUrl");
		
	}
	
/*	@Test
	public void Test01userCanLogin() {
		test.launchApplication(loginUrl);
		test.login.login(username, password);
		
	}
	
	@Test
	public void Test02userCanCreateIndividual() {
		test.openUrl(customersetupurl);
		String code = BaseUi.getStringWithTimestamp(input_code);
		String name = BaseUi.getStringWithTimestamp(input_name);
		String category_name = YamlReader.getYamlValue("category_individual");
		test.customerSetup.categoryCreation(code, name, category_name, "3");
		test.customerSetup.deleteCategoryAgainstCodeValue(code);
		
	}
	
	@Test
	public void Test03userCanCreateOrganization() {
		test.openUrl(customersetupurl);
		
		String code = BaseUi.getStringWithTimestamp(input_code);
		String name = BaseUi.getStringWithTimestamp(input_name);
		String category_name = YamlReader.getYamlValue("category_organization");
		test.customerSetup.categoryCreation(code, name, category_name, "4");
		test.customerSetup.deleteCategoryAgainstCodeValue(code);
	}

	@Test
	public void Test04userCanCreateGuest() {
		test.openUrl(customersetupurl);
		String code = BaseUi.getStringWithTimestamp(input_code);
		String name = BaseUi.getStringWithTimestamp(input_name);
		String category_name = YamlReader.getYamlValue("category_guest");
		test.customerSetup.categoryCreation(code, name, category_name, "5");
		test.customerSetup.deleteCategoryAgainstCodeValue(code);
		
	}

	@Test
	public void Test05userCanCreateCommittee() {
		test.openUrl(customersetupurl);
		String code = BaseUi.getStringWithTimestamp(input_code);
		String name = BaseUi.getStringWithTimestamp(input_name);
		String category_name = YamlReader.getYamlValue("category_committee");
		test.customerSetup.categoryCreation(code, name, category_name, "6");
		test.customerSetup.deleteCategoryAgainstCodeValue(code);
	}

	@Test(priority=0)
	public void Tatoc01ClickBasic() {
		test.openUrl(tatoc_url);
		test.tatocbasic.basic_Course();
	}
	
	@Test(priority=1)
	public void Tatoc01ClickAdvanced() throws SQLException {
		test.openUrl(tatoc_url);
		test.tatocadvanced.advanced_Course();
	}*/
	
	
	@AfterClass	  
	public void closeBrowser() {
		test.closeBrowserSession();
	}

}

