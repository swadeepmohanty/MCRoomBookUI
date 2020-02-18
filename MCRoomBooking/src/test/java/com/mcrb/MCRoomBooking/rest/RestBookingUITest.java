package com.mcrb.MCRoomBooking.rest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RestBookingUITest {

    private WebDriver webDriver;

    @Before
    public void setUp(){
        // Telling the system where to find the chrome driver
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        webDriver = new ChromeDriver();
        // Maximize the browser window
        //webDriver.manage().window().maximize();
    }

    @Test
    public void whenPassRoomIDtoEdit_ThenView(){
        webDriver.get("http://localhost:4200/admin/users?action=add");
        webDriver.findElement(By.id("name")).sendKeys("Clara");
        webDriver.findElement(By.name("password")).sendKeys("abc");
        webDriver.findElement(By.name("password")).sendKeys("abc");
        webDriver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Done with Submit");
    }
    @After
    public void close(){
        // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
    }

}
