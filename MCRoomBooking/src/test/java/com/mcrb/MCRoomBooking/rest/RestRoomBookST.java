package com.mcrb.MCRoomBooking.rest;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RestRoomBookST {

    private WebDriver driver;
       @Before
    public void setUp(){
           System.setProperty("webdriver.chrome.driver", "C:\\WorkBook\\chromedriver_win32\\chromedriver.exe");
           driver = new ChromeDriver();
    }

    @Test
    public void whenUserAdd_ThenSubmit(){
        System.setProperty("webdriver.chrome.driver", "C:\\WorkBook\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/admin/users?action=add");
        driver.findElement(By.id("name")).sendKeys("Clara");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("password2")).sendKeys("test123");
        System.out.println("Done with Submit");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void landingPageTest(){
            driver.get("http://localhost:4200/admin/rooms");
            String expectedURL = "http://localhost:4200/admin/rooms";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, expectedURL);
    }

    @After
    public void close(){
        driver.close();
        driver.quit();
    }

}
