package com.qait.demo.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

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

public class Tatoc01_Basic  {

	private TestSessionInitiator test;
	String username, password, loginUrl, input_code, input_name, customersetupurl,tatoc_url;

	@BeforeClass
	public void initializeVariable(){
		test = new TestSessionInitiator(this.getClass().getName());
		_initVars();
	}
	
	//@BeforeClass
	private void _initVars() {
		tatoc_url = YamlReader.getYamlValue("baseUrl");
	}

	@Test
	public void Tatoc01OpenUrl() {
		test.openUrl(tatoc_url);
	}
	
	@Test
	public void Tatoc02ClickGreenBox() {
		test.tatocbasic.select_GreenBox();
	}
	
	@Test
	public void Tatoc03SelectSameColor() {		
		test.tatocbasic.select_SameColor();
	}
	
	@Test
	public void Tatoc04DragDropBox() {
		test.tatocbasic.drag_DropElement();
	}
	
	@Test
	public void Tatoc05LaunchPopup() {
		test.tatocbasic.launch_PopUp();
		
	}
	
	@Test
	public void Tatoc06EnterName() {
		test.tatocbasic.submit_Name();
	}
	
	@Test
	public void Tatoc07GeneratToken() {
		test.tatocbasic.generate_Token();
	}
	
	@Test
	public void Tatoc08Finish() {
		test.tatocbasic.finish();
	}
	
	
	@AfterClass	  
	public void closeBrowser() {
		test.closeBrowserSession();
	}

}


