package com.qait.demo.keywords;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.util.Cookie;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.DataBaseConnecter;
import com.qait.automation.utils.YamlReader;

public class Tatoc_AdvancedAction extends GetPage {
	
	WebDriver driver;
	String value2,value1;
	Boolean flag;
	private Object expected;
	String query = null ;
	String host="10.0.1.86",databaseName="tatoc", username="tatocuser", password="tatoc01";
	String foundid = null,foundname = null,foundpass = null;
	ResultSet resultSet,resultSet1;

	public Tatoc_AdvancedAction(WebDriver driver) {
		super(driver, "Tatoc_TestData");	
		this.driver = driver;
	}
	
	public void selectadvanced_Course()  {
		element("advanced_course").click();
		
	}
	
	public void select_GoNext() {
		element("menu2_select").click();
		element("gonext_click").click();

	}
	
	public void fetch_DatabaseDetails() throws SQLException {
		DataBaseConnecter.connectToDataBase(host, databaseName, username, password);
		String value = element("symbol_text").getText();
		resultSet = DataBaseConnecter.getResultSetOnExecutingASelectQuery("select id from identity where symbol='" + value + "';");
		if(resultSet.next()){
		   	  foundid = resultSet.getString(1);
		}
		query="select name,passkey FROM credentials where id='" + foundid + "'";
		resultSet1 = DataBaseConnecter.getResultSetOnExecutingASelectQuery(query);
		if(resultSet1.next()){
		   	  foundname = resultSet1.getString(1);
		   	  foundpass = resultSet1.getString(2);
		}
		element("name_value").sendKeys(foundname);
		element("password_value").sendKeys(foundpass);
		Assert.assertNotNull(element("name_value").getText());
		Assert.assertNotNull(element("password_value").getText());
	}
	
	public void proceedTo_VideoPage() {
		element("proceed_button").click();
		assertEquals(element("video_page_text").getText(),"Ooyala Video Player");
	}
	
	
}

