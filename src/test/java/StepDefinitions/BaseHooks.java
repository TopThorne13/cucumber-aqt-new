package StepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import pages.Base;
import pages.UtilClass;

public class BaseHooks extends Base {
	
	@Before
	public void init() {
		Base.driver = new ChromeDriver();		
		Base.driver.get(UtilClass.url());
		Base.driver.manage().window().maximize();
	}
	
	@After
	public void quitDriver() {
		Base.driver.quit();
	}
	
}