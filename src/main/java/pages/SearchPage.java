package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchPage extends Base {
	
	//POM for Search Page. Product Search, SS of products, Range Filter and add to cart functions.

	private WebDriver driver;

	UtilClass objUtil = new UtilClass();

	SearchPage searchPage;

	@FindBy(xpath = "//*[text()=\"Results\"]")
	WebElement ResultsText;

	@FindBy(xpath = "//input[@name=\"low-price\"]")
	WebElement minBox;

	@FindBy(xpath = "//input[@name=\"high-price\"]")
	WebElement maxBox;

	@FindBy(xpath = "//input[@class=\"a-button-input\"]")
	WebElement goButton;

	@FindBy(id = "a-autoid-21")
	WebElement rangeSubmit;

	@FindBy(xpath = "(//span[@class=\"a-declarative\"])[1]")
	WebElement firstProduct;

	@FindBy(xpath = "(//button[contains(text(), \"Add to cart\")])[1]")
	WebElement addToCartFirst;

	@FindBy(id = "nav-cart")
	WebElement cart;

	@FindBy(xpath = "//strong[text() = \"Item Added\"]")
	WebElement itemAdded;

	public SearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void resultsPageVisible() {

		objUtil.waitExplicit(driver, ResultsText);

		Assert.assertTrue(ResultsText.isDisplayed());

		logger.info("Results Page is visible");
	}

	public void setMinMax(int min, int max) {

		if (min > 0)
			objUtil.sendKeysToHiddenElement(driver, minBox, Integer.toString(min));

		if (max > 0)
			objUtil.sendKeysToHiddenElement(driver, minBox, Integer.toString(max));

		goButton.sendKeys(Keys.ENTER);

		logger.info("Range set from" + min + "to" + max);

		objUtil.waitExplicit(Base.driver, ResultsText);

		Assert.assertTrue(ResultsText.isDisplayed());

		logger.info("Filtered results displayed");

	}

	public void ssFirstProduct(String product) throws IOException {

		try {
			objUtil.waitExplicit(Base.driver, firstProduct);

			Assert.assertTrue(firstProduct.isDisplayed());

			objUtil.screenshotElement(firstProduct, objUtil.pathSS + "FirstResultSS_" + product + ".png");

		} catch (Exception e) {

			logger.error("Exception for First Product: " + e);

		}

	}

	public void addFirstProductToCart() {
		
		try {
			addToCartFirst.sendKeys(Keys.ENTER);
			
			objUtil.waitExplicit(driver, itemAdded);
			
			Assert.assertTrue(itemAdded.isDisplayed());
			
			logger.info("Item added successfully");
			
			objUtil.waitExplicit(driver, itemAdded);
			
			objUtil.waitInvisible(driver, itemAdded);
			
			objUtil.waitClickable(driver, cart);
		
		} catch(Exception e) {
			
			logger.error("Exception: " + e);
			
		}
		
	}

	public void cartClick() {

		cart.click();

		logger.info("Navigated to Cart Page");

	}

}
