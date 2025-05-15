package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {
	
	WebDriver driver;
	
	@Given("I am in OrangeHRM login page")
	public void i_am_in_orange_hrm_login_page() {
	    driver=new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	@When("I give the username {string} and password {string}")
	public void i_give_the_username_and_password(String username, String password) {
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
  
	}
	@When("click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();	  
	}
	@Then("the page gets redirected to Dashboard")
	public void the_page_gets_redirected_to_dashboard() {
	String	expectedurl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	String acturl=driver.getCurrentUrl();
	Assert.assertEquals(acturl, expectedurl);
	driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
	driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();
	driver.close();
	}
	
	@Given("I am in login page and I give the username as {string} and password as {string}")
	public void i_am_in_login_page_and_i_give_the_username_as_and_password_as(String username, String password) {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);	  
	}

	@When("click the submit button")
	public void click_the_submit_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("the error message is displayed on login page")
	public void the_error_message_is_displayed_on_login_page() {
	    WebElement error=driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
	    String exp_inv_msg="Invalid credentials";
	    String act_inv_msg=error.getText();
	    Assert.assertEquals(exp_inv_msg, act_inv_msg);
	    driver.close();
	}
	@Given("I am in login page")
	public void i_am_in_login_page() {
	    driver=new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@When("I give the username as {string} and password as {string}")
	public void i_give_the_username_as_and_password_as(String username, String password) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@When("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
	}
	@Then("error message is dosplayed as Invalid credentials")
	public void error_message_is_dosplayed_as_invalid_credentials() {
		WebElement errorpass=driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
		String exp_msg="Invalid credentials";
		String actual=errorpass.getText();
		Assert.assertEquals(actual, exp_msg);
	}

}
