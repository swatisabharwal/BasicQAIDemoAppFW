package com.qait.demo.keywords;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;

public class CustomerSetupAction extends GetPage {
	
	
	WebDriver driver;
	/*WebElement add_new = element("add_new_category_btn");*/
	

	public CustomerSetupAction(WebDriver driver) {
		super(driver, "customersetup");
		
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	

public void categoryCreation(String code, String name,  String category_name, String category_column_number) {
	
	
	int category_column_number_for_tick_determination = Integer.parseInt(category_column_number)-1;
	String a = String.valueOf(category_column_number_for_tick_determination);
	
	Assert.assertTrue(element("add_new_category_btn").isDisplayed());
	element("add_new_category_btn").click();
	AssertJUnit.assertTrue(element("add_category").isDisplayed());
	switchToFrame("frame_1");
	element("code").sendKeys(code);
	element("name").sendKeys(name);
	//clickElementUsingJavaScript("individual_checkbox", For_Type);
	JavascriptExecutor js = (JavascriptExecutor) driver;  
	js.executeScript("document.getElementById('" + category_name +"').click()");
	
	js.executeScript("document.getElementById('main_content_ctl00_ButtonsPlaceHolder_btnSaveAndClose').click()");
	//Assert.assertTrue(elements("new_row", "1", code).size()!=0);
	//Assert.assertTrue(elements("new_row", "2", name).size()!=0);
	
	Assert.assertTrue(elements("check_tick", code, a ).size()!=0);
	
}


		
public void deleteCategoryAgainstCodeValue(String code_value) {
		
		element("edit_btn", "table table-striped table-bordered table-hover", code_value).click();
		switchToFrame("frame_1");
		element("delete_btn").click();
		switchToDefaultContent();
		element("delete_confirmation_ok").click();
		
		wait.hardWait(2);
		
	}



}
