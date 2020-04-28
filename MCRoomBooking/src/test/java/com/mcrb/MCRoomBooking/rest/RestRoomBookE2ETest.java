package com.mcrb.MCRoomBooking.rest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RestRoomBookE2ETest {

	@Ignore
	@Test
	public void pagePerformanceTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\WorkBook\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		for(int i=1;i<50;i++){
			driver.get("http://localhost:4200/admin/rooms");
			String expectedURL = "http://localhost:4200/admin/rooms";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
		}
		driver.close();
		driver.quit();

	}
}
