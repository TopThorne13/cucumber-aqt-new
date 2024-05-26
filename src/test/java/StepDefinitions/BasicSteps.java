package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.CustomerPage;
import pages.HomePage;

public class BasicSteps extends Base {
	
	private HomePage homePage = new HomePage(Base.driver);
	
	private CustomerPage customerPage = new CustomerPage(Base.driver);
	
	Integer localPin;
	
	@When("User enters {int}")
	public void user_enters(Integer PinCode) throws IOException {

		homePage.selectPin();
		
		homePage.changePin(PinCode);
		
		localPin = PinCode;
		
	}

	@Then("User gets to know availability of delivery at their location")
	public void user_gets_to_know_availability_of_delivery_at_their_location() throws IOException {

		homePage.pinAvailability(localPin);
		
	}

	@When("User navigates to Customer Service")
	public void user_navigates_to_customer_service() {

		homePage.clickCustomerService();
		
	}

	@When("User searches Prime Gaming")
	public void user_searches_prime_gaming() {
		
		customerPage.searchHelp("Prime Gaming");
		
	}

	@When("User clicks on Prime Gaming")
	public void user_clicks_on_prime_gaming() {

		customerPage.clickPrimeGaming();
		
	}

	@When("Clicks Get Started")
	public void clicks_get_started() {

		customerPage.clickGetStarted();
		
	}

	@Then("User takes Screenshot of Setup Details")
	public void user_takes_screenshot_of_setup_details() throws IOException {

		customerPage.screenshotSetup();
		
	}

}
