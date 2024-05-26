package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {
	
	//This is a util class to consolidate all common operations and use code reusability.
	
	public static final String FILE_PATH_CRED = new File("").getAbsolutePath() + "\\src\\main\\resources\\config.properties";
	private static final Properties properties = new Properties();
	
	static {
		try (FileInputStream inputStream = new FileInputStream(FILE_PATH_CRED)){
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static String url() {
		return properties.getProperty("BASE_URL");
	}

	public void sendKeysToHiddenElement(WebDriver driver, WebElement element, String keysToSend) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", element, keysToSend);
	}

	public void waitClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitInvisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOf(element));

	}

	public void waitExplicit(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void screenshotElement(WebElement element, String fullPath) throws IOException {

		File source = element.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(source, new File(fullPath));
	}

	public void screenshotFullPage(WebDriver driver, String fullPath) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileHandler.copy(source, new File(fullPath));

	}

	String pathSS = new File("").getAbsolutePath() + "\\Screenshots\\";

}
