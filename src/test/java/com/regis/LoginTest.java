package com.regis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver webDriver;
    @BeforeTest
    public void open(){
        System.setProperty("webdriver.chrome.dirver","F:\\text\\test\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void getTest(){
        webDriver.get("http://119.23.249.220:81/#/login");
        webDriver.findElement(LoginPage.userName).sendKeys("JSGLY");
        webDriver.findElement(LoginPage.userPWD).sendKeys("a1234567");
        webDriver.findElement(LoginPage.loginButton).click();
    }
    @AfterTest
    public void close(){
        webDriver.quit();
    }
}
