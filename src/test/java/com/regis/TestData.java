package com.regis;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {

    @DataProvider(name =  "logindate")
    public Object[][] dataList(){
        return  new Object[][]{
                {"123456","yyy123455"},
                {"123456","yyy123456"}
        };
    }

    @Test(dataProvider = "logindate")
    public void getTest(String user , String pwd){
        System.out.println("用户名:"+user+"密码："+ pwd);
    }

}
