package com.mcrb.MCRoomBooking.rest;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RestBookingUITest {

       @Before
    public void setUp(){
    }

    @Test
    public void whenPassRoomIDtoEdit_ThenView(){
        System.setProperty("webdriver.chrome.driver", "C:\\WorkBook\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/admin/users?action=add");
        driver.findElement(By.id("name")).sendKeys("ANB");
        driver.findElement(By.id("password")).sendKeys("ANB");
        driver.findElement(By.id("password2")).sendKeys("ANB");
        System.out.println("Done with Submit");
        driver.findElement(By.id("submit")).click();
        driver.close();
        driver.quit();
    }

    @Test
    public void landingPageTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\WorkBook\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/admin/rooms");
        String expectedURL = "http://localhost:4200/admin/rooms";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        driver.close();
        driver.quit();
    }

    @After
    public void close(){
        // Close the browser and WebDriver
    }

}
