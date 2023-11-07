package stepdefinitionfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class security {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Actions ac = new Actions(driver);

	@Given("amazon lofin security page")
	public void loaded_with_your_account() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shalini\\AMAZONBDD\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.ca");

		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		driver.findElement(By.id("ap_email")).sendKeys("dark");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("password#");

		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.id("signInSubmit")).click();
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I edit the button")
	public void i_edit_the_button() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")));
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[2]/a/div/div/div/div[2]/div")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("auth-cnep-edit-name-button")));
		driver.findElement(By.id("auth-cnep-edit-name-button")).click();
		driver.findElement(By.id("auth-cnep-edit-name-button")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys("updated");

		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Username should be update")
	public void username_should_be_update() {
		// Write code here that turns the phrase above into concrete actions
		WebElement messgae = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/h4"));
		Assert.assertEquals(messgae.getText(), "Success");
		throw new io.cucumber.java.PendingException();
	}
}
