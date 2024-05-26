package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.HomePage;
import pages.SearchPage;
import StepDefinitions.BaseHooks;


public class SearchSteps extends Base {
	
	private HomePage homepage;
	private SearchPage searchPage;
	
	@Given("User is on homepage")
	public void user_is_on_homepage() {
		
		homepage = new HomePage(Base.driver);
		
		homepage.checkLoginPage();
		
	}

	@When("User searches for a {string}")
	public void user_searches_for_a(String product) {
		
		homepage.search(product);
		
	}

	@Then("User gets search results")
	public void user_gets_search_results() {
		
		searchPage = new SearchPage(Base.driver);
		
		searchPage.resultsPageVisible();
		
	}

	@When("User gives {int} and {int} range")
	public void user_gives_and_range(Integer min, Integer max) {
		
		searchPage.setMinMax(min, max);

	}
	@Then("User takes screenshot of first {string}")
	public void user_takes_screenshot_of_first_product(String product) throws IOException {
		
		searchPage.ssFirstProduct(product);
		
	}

}
