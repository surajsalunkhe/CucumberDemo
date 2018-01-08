package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigDataProvider;

public class SmokeTest {
	WebDriver driver;
	
	@Given("^open firefox and start application$")
	public void open_firefox_and_start_application() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    driver=ConfigDataProvider.getBrowser("chrome");
	    
	    
	}

	@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_enter_valid_uname_and_pwd(String uname,String pwd) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.findElement(By.id("email")).sendKeys(uname);
	    driver.findElement(By.id("pass")).sendKeys(pwd);
	    
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.findElement(By.id("loginbutton")).submit();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='feedx_sprouts_container']/div[1]/div[1]/div[1]/span[1]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='feedx_sprouts_container']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).sendKeys("Hello World");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='feedx_sprouts_container']/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]")).click();
		if(driver.getCurrentUrl().equalsIgnoreCase(
			      "https://www.facebook.com/home.php")){
			         System.out.println("Test Pass"); 
			      } else { 
			         System.out.println("Test Failed"); 
			      } 
		driver.quit();
	}

}
