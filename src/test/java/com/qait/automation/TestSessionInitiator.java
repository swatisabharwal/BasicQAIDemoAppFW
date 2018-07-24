package com.qait.automation;

import static com.qait.automation.utils.ConfigPropertyReader.getProperty;
import static com.qait.automation.utils.YamlReader.getYamlValue;
import static com.qait.automation.utils.YamlReader.setYamlFilePath;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.jayway.restassured.RestAssured;
import com.qait.automation.utils.TakeScreenshot;
import com.qait.demo.keywords.CustomerSetupAction;
import com.qait.demo.keywords.Login;
import com.qait.demo.keywords.Tatoc_AdvancedAction;
import com.qait.demo.keywords.Tatoc_BasicsAction;

public class TestSessionInitiator {

	protected WebDriver driver;
	private final WebDriverFactory wdfactory;
	String browser;
	String seleniumserver;
	String seleniumserverhost;
	String appbaseurl;
	String applicationpath;
	String chromedriverpath;
	String datafileloc = "";
	static int timeout;
	Map<String, Object> chromeOptions = null;
	DesiredCapabilities capabilities;

	/**
	 * Initiating the page objects
	 * 
	 */

	public TakeScreenshot takescreenshot;
	
	
	public Login login;
	public CustomerSetupAction customerSetup;
	public Tatoc_BasicsAction tatocbasic;
	public Tatoc_AdvancedAction tatocadvanced;

	public WebDriver getDriver() {
		return this.driver;
	}

	private void _initPage() {
	
	
	login = new Login(driver);
	customerSetup = new CustomerSetupAction(driver);
	tatocbasic =new Tatoc_BasicsAction(driver);
	tatocadvanced = new Tatoc_AdvancedAction(driver);

	}

	/**
	 * Page object Initiation done
	 * 
	 */
	public TestSessionInitiator(String testname) {
		wdfactory = new WebDriverFactory();
		testInitiator(testname);
	}

	private void testInitiator(String testname) {
		setYamlFilePath();
		System.out.println(setYamlFilePath());
		_configureBrowser();
		_initPage();
		takescreenshot = new TakeScreenshot(testname, this.driver);
	}

	private void _configureBrowser() {
		driver = wdfactory.getDriver(_getSessionConfig());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getProperty("timeout")), TimeUnit.SECONDS);
	}

	private Map<String, String> _getSessionConfig() {
		String[] configKeys = { "tier", "browser", "seleniumserver", "seleniumserverhost", "timeout", "driverpath" };
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, getProperty("./Config.properties", string));
		}
		return config;
	}

	public void launchApplication() {
		launchApplication(getYamlValue("baseUrl_hris"));
	}

	public void launchApplication(String loginUrl) {
		Reporter.log("\nThe application url is :- " + loginUrl, true);
		Reporter.log("The test browser is :- " + _getSessionConfig().get("browser") + "\n", true);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(loginUrl);
		
	}

	public void openUrl(String url) {
		driver.get(url);
	//	RestAssured.responseSpecification.get();
	
	}

	public void closeBrowserSession() {
		Reporter.log("\n", true);
		driver.quit();
	}

	public void stepStartMessage(String testStepName) {
		Reporter.log(" ", true);
		Reporter.log("***** STARTING TEST STEP:- " + testStepName.toUpperCase() + " *****", true);
		Reporter.log(" ", true);
	}


}
