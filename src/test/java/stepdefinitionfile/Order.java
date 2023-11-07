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

public class Order {
	WebDriver driver;
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	 Actions ac=new Actions(driver);
	@Given("amzon url loaded :{string}")
	public void amzon_url_loaded(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Shalini\\AMAZONBDD\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(string);
		
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		driver.findElement(By.id("ap_email")).sendKeys("v.vignesh.0811@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Fresh@@1996");
		
		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.id("signInSubmit")).click();
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on order page")
	public void i_click_on_order_page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		  
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")));
		ac.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
		
		
			
	}

	

	@Then("Order List for the Filter should be shown")
	public void order_list_for_the_filter_should_be_shown() {
		String data=driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[4]/form/label/span")).getText();
		Assert.assertEquals(data, "9 orders");
		 WebElement spandropdown=driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"));
			
			spandropdown.click();
			WebElement dropdownValue = driver.findElement(By.id("time-filter_0"));
			
			dropdownValue.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
		String data1=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/form/label/span")).getText();
		Assert.assertEquals(data1, "2 orders");
	}

	
	@Given("Amazon url {string}")
	public void amazon_url(String string)  {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Shalini\\AMAZONBDD\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(string);
		
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		driver.findElement(By.id("ap_email")).sendKeys("v.vignesh.0811@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Fresh@@1996");
		
		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.id("signInSubmit")).click();
	    throw new io.cucumber.java.PendingException();
	}

	@When("I move to cancel order tabe")
	public void i_move_to_cancel_order_tab() {
		 WebElement spandropdown1=driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"));
			spandropdown1.click();
			WebElement dropdownValue1 = driver.findElement(By.id("time-filter_3"));
			
			dropdownValue1.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
	}
	@Then("Order List for the Filter should be shown for cancelled orders")
	public void Order_for_List_the_Filter_should_be_shown_for_cancelled_orders() {
		String data2=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/form/label/span")).getText();
		Assert.assertEquals(data2, "7 orders");
	}



}
