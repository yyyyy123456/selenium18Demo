package com.regis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.net.URL;
import java.net.MalformedURLException;

public class GridTest {

    //
    @DataProvider(name = "data4")
    public Object[][] test1(){
        return new Object[][]{{"firefox","http://169.254.216.207:4444/wd/hub"}, {"chrome","http://169.254.216.207:5555/wd/hub"}};
    }


    @Test(dataProvider = "data4")
    public void gridTest(String brower,String url) throws MalformedURLException, InterruptedException {
       DesiredCapabilities dc = null;
       if(brower.contentEquals("firefox")){
           dc = DesiredCapabilities.firefox();
       }else if(brower.contentEquals("chrome")){
           dc = DesiredCapabilities.chrome();
       }else{
           System.out.println("error");
       }
        WebDriver driver=new RemoteWebDriver(new URL(url),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }



}
