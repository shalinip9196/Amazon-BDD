package stepdefinitionfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class shoppingcart {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Actions ac = new Actions(driver);

	@Given("Loaded with amazon home page {string}")
	public void loaded_with_amazon_home_page(String string) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shalini\\AMAZONBDD\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(string);

		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		driver.findElement(By.id("ap_email")).sendKeys("dark");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("password#");

		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.id("signInSubmit")).click();
		throw new io.cucumber.java.PendingException();
	}

	@When("User Search item")
	public void user_search_item() {
		// search product add to cart
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("towels large");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@When("Add items to the cart")
	public void add_items_to_the_cart() {
		driver.get(
				"https://www.amazon.ca/Polyte-Professional-Quick-Microfiber-Drying/dp/B07NVWR2R7/ref=sr_1_1_sspa?crid=2L58G9VSYB6IM&keywords=towles+large&qid=1698878484&sprefix=towles+large%2Caps%2C231&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
		Select option = new Select(driver.findElement(By.id("quantity")));
		option.selectByValue("4");

		WebElement options = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		options.click();
		WebElement option4 = driver.findElement(By.xpath("//*[@id=\"quantity\"]/option[4]"));
		option4.click();
		ac.moveToElement(driver.findElement(By.id("submit.add-to-cart-announce"))).click().build().perform();
		System.out.print("cart clciked");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"sw-atc-details-single-container\"]")));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("note");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.get(
				"https://www.amazon.ca/AmazonBasics-Writing-Narrow-Orchid-6-Pack/dp/B07TQ8567K/ref=sr_1_1_ffob_sspa?crid=3GT96THI13LBW&keywords=note&qid=1698883890&sprefix=note%2Caps%2C293&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		ac.moveToElement(driver.findElement(By.id("submit.add-to-cart"))).click().build().perform();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"sw-atc-details-single-container\"]")));
		WebElement carticon1 = driver.findElement(By.id("nav-cart-count"));
		carticon1.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

	}

	@Then("cart should be loaded with the items")
	public void cart_should_be_loaded_with_the_items() {
		// WebElement
		// Quantityadd=driver.findElement(By.id("//*[@id=\"sw-atc-details-single-container\"]"));
		WebElement Quantityadd1 = driver.findElement(By.id("sc-subtotal-label-activecart"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Assert.assertEquals(Quantityadd1.getText(), "Subtotal (4 items):");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		throw new io.cucumber.java.PendingException();
	}

	@Then("price should be updated")
	public void price_should_be_updated() {
		// Write code here that turns the phrase above into concrete actions
		WebElement towelprice = driver.findElement(By.id("sc-subtotal-amount-buybox"));
		Assert.assertEquals(towelprice.getText(), "$128.89");
	}

	@Then("close the driver")
	public void close_the_driver() {
		driver.close();
	}

}
