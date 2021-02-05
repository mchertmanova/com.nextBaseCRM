package com.nextBaseCRM.MaryamChertmanova;

import com.nextBaseCRM.utilities.WebDriverFactory;
import com.sun.tools.internal.xjc.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.sun.tools.internal.xjc.Driver.*;

public class clickMessage { //login process
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {


        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://login2.nextbasecrm.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void logIn() throws InterruptedException {

        WebElement userName = driver.findElement(By.name("USER_LOGIN"));


        WebElement passwordField = driver.findElement(By.name("USER_PASSWORD"));


        WebElement loginButton = driver.findElement(By.className("login-btn"));
        userName.sendKeys("hr51@cybertekschool.com");
        passwordField.sendKeys("UserUser");
        loginButton.click();
    }


    @Test
     public void frame(){

            WebElement iframe = driver.findElement(By.id("blog_post"));
            driver.switchTo().frame(iframe);
            Assert.assertTrue(driver.findElement(By.id("blog_post")).isDisplayed());

            Assert.assertTrue(driver.findElement(By.id("success")).isDisplayed());


        }


        ///still working on


        @AfterMethod
        public void tearDown () throws InterruptedException {
            Thread.sleep(3000);
            driver.close();

        }
    }