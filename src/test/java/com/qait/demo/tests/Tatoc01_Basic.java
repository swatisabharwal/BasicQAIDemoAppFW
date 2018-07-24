package com.qait.demo.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import com.qait.automation.TestSessionInitiator;

import com.qait.automation.utils.YamlReader;


public class Tatoc01_Basic  {

	private TestSessionInitiator test;
	String username, password, loginUrl, input_code, input_name, customersetupurl,tatoc_url;

	@BeforeClass
	public void initializeVariable(){
		test = new TestSessionInitiator(this.getClass().getName());
		tatoc_url = YamlReader.getYamlValue("baseUrl");
	}
	
	@Test
	public void Test_01_Validate_User_Can_Launch_Application() {
		test.openUrl(tatoc_url);	
	}
	
	@Test
	public void Test_02_Validate_User_Is_Able_To_Proceed_On_Clicking_GreenBox() {
		Assert.assertTrue(test.tatocbasic.select_GreenBox(),"Assertion FAILED:User could not proceed post clicking the green Box");
	}
	
	@Test
	public void Test_03_Validate_User_Is_Able_To_Proceed_On_Matching_Color_Of_Both_Boxes() {		
		Assert.assertTrue(test.tatocbasic.select_SameColor(),"Assertion FAILED:User could not proceed post Painiting the second box same as the first one");
		
	}
	
	@Test
	public void Test_04_Validate_User_Is_Able_To_Drag_First_Box_To_Second_One() {
		Assert.assertTrue(test.tatocbasic.drag_DropElement(),"Assertion FAILED:User could not proceed post successfully dragging box to be outer box frame");
	}
	
	@Test
	public void Test_05_Validate_User_Is_Able_To_Launch_The_Popup() {
		test.tatocbasic.launch_PopUp();
		
	}
	
	@Test
	public void Test_06_User_Enters_And_Submit_Text() {
		test.tatocbasic.submit_Name();
	}
	
	@Test
	public void Test_07_User_Is_Able_To_Generate_Token() {
		test.tatocbasic.generate_Token();
	}
	
	@Test
	public void Test_08_Closing_The_Activity() {
		test.tatocbasic.finish();
	}
	
	@AfterClass	  
	public void closeBrowser() {
		test.closeBrowserSession();
	}

}


