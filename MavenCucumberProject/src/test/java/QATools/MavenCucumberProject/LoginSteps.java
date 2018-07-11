package QATools.MavenCucumberProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {

	WebDriver driver = setBrowserConfigStepDefinition.getDriver();

	
	 @After public void afterScenarioFinish() {
	 System.out.println("-----------------End of Scenario-----------------");
	 driver.quit(); 
	 }
	

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/");
		// driver.findElement(By.xpath("//a[contains(.,'Books')]")).click();
	}

	@When("^User clicks on login$")
	public void user_clicks_on_login() throws Throwable {
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		driver.findElement(By.id("Email")).sendKeys("mark1@enhance.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	}

	@Then("^User must be logged in and display username on the web site$")
	public void user_must_be_logged_in_and_display_username_on_the_web_site() throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header-links']")).getText().contains("mark1@enhance.com"));
	}

	@When("^User clicks Electronics$")
	public void user_clicks_Electronics() throws Throwable {
		driver.findElement(By.xpath("//div[@class='header-menu']/ul/li/a[contains(text(),'Electronics')]")).click();
	}

	@And("^Selects Smartphone$")
	public void selects_Smartphone() throws Throwable {
		driver.findElement(By.xpath("//div[@class='item-box']/div/h2/a[contains(text(),'Cell phones')]")).click();	
	}

	@And("^Selects Add to Cart button$")
	public void selects_Add_to_Cart_button() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();		
	}

	@Then("^Item should be added to cart$")
	public void item_should_be_added_to_cart() throws Throwable {
		Assert.assertFalse(driver.findElement(By.xpath("//div[@class='page-body']")).getText().contains("Your Shopping Cart is empty!"));	
	}

	@When("^User clicks Shopping Cart$")
	public void user_clicks_Shopping_Cart() throws Throwable {
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
	}

	@Then("^User will be redirected to Shopping Cart page$")
	public void user_will_be_redirected_to_Shopping_Cart_page() throws Throwable {
		// Assert page title. Should be Shopping Cart page
		Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
	}

	@When("^User complete the Checkout Information page$")
	public void user_complete_the_Checkout_Information_page() throws Throwable {
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Billing Information section
		driver.findElement(By.id("billing-address-select")).sendKeys("New Address");
		driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Mark");
		driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Tester");
		// driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("mark1@enhance.com");
		driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("New Zealand");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Auckland");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("53 Cook St.");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("1010");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0272135846");
		driver.findElement(By.xpath("//input[@title='Continue']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);

		// Shipping Information section
		driver.findElement(By.id("shipping-address-select")).sendKeys("New Address");
		driver.findElement(By.id("ShippingNewAddress_FirstName")).sendKeys("Mark");
		driver.findElement(By.id("ShippingNewAddress_LastName")).sendKeys("Tester");
		// driver.findElement(By.id("ShippingNewAddress_Email")).sendKeys("mark1@enhance.com");
		driver.findElement(By.id("ShippingNewAddress_CountryId")).sendKeys("New Zealand");
		driver.findElement(By.id("ShippingNewAddress_City")).sendKeys("Auckland");
		driver.findElement(By.id("ShippingNewAddress_Address1")).sendKeys("53 Cook St.");
		driver.findElement(By.id("ShippingNewAddress_ZipPostalCode")).sendKeys("1010");
		driver.findElement(By.id("ShippingNewAddress_PhoneNumber")).sendKeys("0272135846");
		driver.findElement(By.xpath("//div[@id='shipping-buttons-container']/input[@type='button']")).click();
		Thread.sleep(5000);

		// Shipping method section		
		driver.findElement(By.xpath("//div[@id='checkout-shipping-method-load']//input[@id='shippingoption_1']")).click();
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/input[@type='button']")).click();
		Thread.sleep(5000);

		// payment method section
		driver.findElement(By.id("paymentmethod_1")).click();
		driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/input[@type='button']")).click();
		Thread.sleep(5000);

		// payment Information section
		driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/input[@type='button']")).click();
		Thread.sleep(5000);

		// Click Confirm button
		driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/input[@type='button']")).click();
		Thread.sleep(5000);
	}


	@Then("^will see a message on the screen that the order is completed$")
	public void will_see_a_message_on_the_screen_that_the_order_is_completed() throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='master-wrapper-main']")).getText().contains("Thank you"));
	}

	@When("^User clicks on the logout link$")
	public void user_clicks_on_the_logout_link() throws Throwable {
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	}

	@Then("^User will be logged out$")
	public void user_will_be_logged_out() throws Throwable {
	}
}
