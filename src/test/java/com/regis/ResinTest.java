package com.regis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ResinTest {
    WebDriver webDriver;

    @BeforeTest
    public void open(){
        System.setProperty("webdriver.chrome.driver","F:\\text\\test\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //等待所有元素加载完毕
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void registest() throws InterruptedException{
        webDriver.get("https://email2.163.com/");
        //控制权给frame里
        //因为这个frame为动态，所以只能按它是第几个frame来获取或者取他父节点的xpath后面加上  /子节点名
       // webDriver.switchTo().frame(0);
        WebElement we = webDriver.findElement(By.xpath("//*[@id=\"panel-163\"]/iframe"));
        webDriver.switchTo().frame(we);
        //点击去注册
        webDriver.findElement(By.id("changepage")).click();
        //获取当前窗口的句柄值
        String handle = webDriver.getWindowHandle();
        //循环获取所有handle，并把控制权转给指定的handle
        for(String handles : webDriver.getWindowHandles()){
            if(handles.equals(handle)){
                continue;
            }else{
                webDriver.switchTo().window(handles);
            }
        }
        webDriver.findElement(By.id("nameIpt")).sendKeys("yzd877109969");
        String name = webDriver.findElement(By.xpath("//*[@id=\"m_name\"]/span")).getText();
        System.out.println(name);
        webDriver.findElement(By.id("mainPwdIpt")).sendKeys("123456yzd");
        webDriver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123456yzd");
        webDriver.findElement(By.id("mainMobileIpt")).sendKeys("13829003451");
        webDriver.findElement(By.id("vcodeIpt")).sendKeys("1BCD");
        webDriver.findElement(By.id("sendMainAcodeBtn")).click();
        webDriver.findElement(By.id("mainAcodeIpt")).sendKeys("123456");
        String tips = webDriver.findElement(By.xpath("//*[@id=\"mainAcodeTips\"]/span")).getText();
        Assert.assertEquals(tips,"请查收手机短信，并填写短信中的验证码");

        //邮箱名可用随机码
        String num = String.valueOf(System.currentTimeMillis());
    }

    @AfterTest
    public void close(){
        webDriver.quit();
    }
}
