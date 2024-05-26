package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage extends Base {
	
	//POM for Customer Service Page. Search and navigate to Customer Service options and takes SS. 
	
	private WebDriver driver;
	
	UtilClass objUtil = new UtilClass();
	
	@FindBy(xpath="(//a[contains(text(), \"Prime Gaming\")])[1]")
	WebElement primeGaming;
	
	@FindBy(xpath="//div[@class=\"landing_section\"]//li[1]//a")
	WebElement getStarted;
	
	@FindBy(xpath="//article")
	WebElement article;
	
	@FindBy(id="helpsearch")
	WebElement helpSearchBox;
	
	
	
	public CustomerPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickPrimeGaming() {

		objUtil.waitExplicit(driver, primeGaming);
		
		primeGaming.click();
		
		logger.info("Prime Gaming clicked");
		
	}

	public void clickGetStarted() {

		objUtil.waitExplicit(driver, getStarted);
		
		getStarted.click();
		
		logger.info("Get Started clicked");
		
	}
	
	public void searchHelp(String word) {
		
		objUtil.waitExplicit(driver, helpSearchBox);
		
		Assert.assertTrue(helpSearchBox.isDisplayed());
		
		helpSearchBox.sendKeys(word);
		
		helpSearchBox.sendKeys(Keys.ENTER);
		
		logger.info("Word Searched in HelpBox: " + word);
		
		Assert.assertTrue(primeGaming.isDisplayed());
		
		logger.info("Prime Gaming is displayed");
		
	}

	public void screenshotSetup() throws IOException {

		objUtil.waitExplicit(driver, article);
		
		Assert.assertTrue(article.isDisplayed());
		
		objUtil.screenshotElement(article, objUtil.pathSS + "SetupInstructions.png");
		
		logger.info("Screenshot captured successfully");
	}

}
