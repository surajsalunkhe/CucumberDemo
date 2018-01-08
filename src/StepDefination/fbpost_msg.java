package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigDataProvider;

public class fbpost_msg {
	WebDriver driver;
	
	@Given("^user navigate to facebook$")
	public void user_navigate_to_facebook() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver=ConfigDataProvider.getBrowser("chrome");
	}

	@When("^enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_valid_and(String uname, String pwd) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.findElement(By.id("email")).sendKeys(uname);
	    driver.findElement(By.id("pass")).sendKeys(pwd);
	    driver.findElement(By.id("loginbutton")).submit();
	   	}

	@Then("^user should be able to login successfully and post status$")
	public void user_should_be_able_to_login_successfully_and_post_status() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		//driver.findElement(By.xpath("//*[@id='feedx_sprouts_container']/div[1]/div[1]/div[2]/div[1]/div[1]")).sendKeys("Hello World");
		//driver.findElement(By.xpath("//*[@id='feedx_sprouts_container']/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]")).click();
		driver.quit();
	   
	}



}
