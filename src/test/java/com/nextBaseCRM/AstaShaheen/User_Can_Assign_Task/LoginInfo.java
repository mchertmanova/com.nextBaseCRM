package com.nextBaseCRM.AstaShaheen.User_Can_Assign_Task;

import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginInfo {


    WebDriver driver;

    public void LogIn( ) {


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/login");

        WebElement userName = driver.findElement(By.name("USER_LOGIN"));
        userName.sendKeys("hr35@cybertekschool.com");
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser", Keys.ENTER);
    }

}
