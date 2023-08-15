package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class Steps {
	public WebDriver driver;
	LoginPage lp = new LoginPage(driver);
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User opens URL {string}")
	public void user_opens_url(String baseURL) {
	    driver.get(baseURL);
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String pwd) {
	    lp.setUserName(uname);
	    lp.setPassword(pwd);
	}

	@When("Click on Login")
	public void click_on_login() {
	    lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful")) {
	    	driver.close();
	    	Assert.assertFalse(true);
	    }else {
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}

	@When("Click on Logout link")
	public void click_on_logout_link() {
	    lp.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	}
}
