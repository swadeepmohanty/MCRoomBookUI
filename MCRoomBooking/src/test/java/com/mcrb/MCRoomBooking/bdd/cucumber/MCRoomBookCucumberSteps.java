package com.mcrb.MCRoomBooking.bdd.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MCRoomBookCucumberSteps {

	private WebDriver driver;
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\WorkBook\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("^Admin browse to (.*)$")
	public void admin_browse_to_http_localhost_admin_users_action_add(String url) throws Throwable {
		driver.get(url);
	}

	@When("^username is (.*)$")
	public void username_is_clara(String username) throws Throwable {
		if(null==username){
			throw new PendingException();
		}
		driver.findElement(By.id("name")).sendKeys(username);
	}

	@When("^password is (.*)$")
	public void password_is_test(String password) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("^re confirm password is (.*)$")
	public void re_confirm_password_is_test(String rePassword) throws Throwable {
		driver.findElement(By.id("password2")).sendKeys(rePassword);
	}

	@Then("^user added as admin successfully$")
	public void user_added_as_admin_successfully() throws Throwable {
		driver.findElement(By.id("submit")).click();
	}

	// Room Addition by Admin User
	@When("^Name is GreenRoom$")
	public void name_is_GreenRoom() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^location is (\\d+)th floor$")
	public void location_is_th_floor(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^Theater size is (\\d+)$")
	public void theater_size_is(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^U-Shape size is (\\d+)$")
	public void u_Shape_size_is(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^BoardMeeting size is (\\d+)$")
	public void boardmeeting_size_is(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Room added succussfully$")
	public void room_added_succussfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@After
	public void clear(){
		driver.close();
		driver.quit();
	}
}
