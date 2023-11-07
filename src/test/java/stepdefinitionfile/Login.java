package stepdefinitionfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
WebDriver driver;
@Given("amazon loaded: {string}")
public void amazon_loaded(String string) {
    // Write code here that turns the phrase above into concrete actions
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Shalini\\AMAZONBDD\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get(string);
    throw new io.cucumber.java.PendingException();
}



@When("user ive input1")
public void user_ive_input1() {
	Actions ac=new Actions(driver);
	ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
	driver.findElement(By.id("ap_email")).sendKeys("v.vignesh.0811@gmail.com");
	driver.findElement(By.id("continue")).click();
	driver.findElement(By.id("ap_password")).sendKeys("Fresh@@1996");
	
	driver.findElement(By.name("rememberMe")).click();
	driver.findElement(By.id("signInSubmit")).click();
}


@Then("I validate the userdetails")
public void i_validate_the_userdetails() {
    // Write code here that turns the phrase above into concrete actions
	String value=driver.getTitle();
	Assert.assertEquals(value,"Hello, vignesh");
    throw new io.cucumber.java.PendingException();
}
}
