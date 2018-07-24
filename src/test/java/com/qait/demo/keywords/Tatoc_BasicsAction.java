package com.qait.demo.keywords;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class Tatoc_BasicsAction extends GetPage {

	WebDriver driver;
	String box1Color, box2Color;
	Boolean flag;

	public Tatoc_BasicsAction(WebDriver driver) {
		super(driver, "Tatoc_TestData");
		this.driver = driver;
	}

	public boolean select_GreenBox() {
		boolean flag=false;
		element("basic_course").click();
		element("green_box").click();
		String changedTitle= getPageTitle();
		if(changedTitle.contains("Dungeon")){
			flag = true;
		}
		return flag;
	}

	public boolean select_SameColor() {
		boolean flag= repaint_The_Box();
		System.out.println("Flag::"+flag);
		return flag;
		//Assert.assertEquals(box1Color, box2Color);
	}

	public boolean drag_DropElement() {
		draganddrop(element("drag_box"), element("drop_box"));
		element("drag_proceed").click();
		flag = element("launch_popup").isDisplayed();
		return flag;
	}

	public void launch_PopUp() {
		element("launch_popup").click();
		switchToNewWindow();
		element("text_window").sendKeys("TestName");
		assertNotNull(element("text_window").getText());
	}

	public void submit_Name() {
		element("submit_button").click();
		switchtoOriginalWindow();
		element("launch_proceed").click();
	}

	public void generate_Token() {
		element("generate_token").click();
		addCookie("Token", getelementText("token_text"));
		assertNotSame(getelementText("token_text"), driver.manage().getCookies());
		
		
	}

	public void finish() {
		element("launch_proceed").click();
		wait.hardWait(2);
		Assert.assertEquals(element("finish_msg").getText(), "End");
	}

	public boolean repaint_The_Box() {
		boolean flag=false;
		switchToDefaultContent();
		switchToFrame("main_frame");
		box1Color = element("box_1").getCssValue("background-color");
		switchToFrame("child_frame");
		box2Color = element("box_2").getCssValue("background-color");
		if (box1Color.equals(box2Color)) {
			System.out.println("value true ");
			switchToDefaultContent();
			switchToFrame("main_frame");
			element("repaint_proceed").click();
		} else {
			switchToDefaultContent();
			switchToFrame("main_frame");
			element("repaint_link").click();
			repaint_The_Box();
		}
		flag=true;
		return flag;
	}

	public org.openqa.selenium.Cookie addCookie(String key, String cookieValue) {
		org.openqa.selenium.Cookie cookie = new org.openqa.selenium.Cookie(key, cookieValue);
		driver.manage().addCookie(cookie);
		return cookie;
	}

}
