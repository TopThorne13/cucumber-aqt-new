package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.CartPage;
import pages.SearchPage;
import pages.UtilClass;

public class CartSteps extends Base {
	
	private SearchPage searchPage;
	
	private CartPage cartPage;

	@When("User gives {int} price")
	public void user_gives_price(Integer min) {
		
		searchPage = new SearchPage(Base.driver);
		
		searchPage.setMinMax(min, 0);
		
	}

	@Then("User adds first product to cart")
	public void user_adds_first_product_to_cart() throws InterruptedException {
		
		searchPage.addFirstProductToCart();
		
	}

	@Then("User clicks on Cart button")
	public void user_clicks_on_cart_button() {

		searchPage.cartClick();
		
	}
	
	@Then("User takes screenshot of entire page for {string}")
	public void user_takes_screenshot_of_entire_cart_for(String product) throws IOException {
		
		cartPage = new CartPage(Base.driver);

		cartPage.cartScreenshot(product);
		
	}

	@Then("Delivery is Free")
	public void delivery_is_free() {

		cartPage.freeDeliveryVisible();
		
	}
	
}
