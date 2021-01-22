package com.nextBaseCRM.AsiaBizub;

import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory_14_Logout {

    WebDriver driver;

    @BeforeClass
    public void setUpMethod() {

        //Open chrome browser
        // Set up

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        // Go to: https://login2.nextbasecrm.com
        driver.get("https://login2.nextbasecrm.com");

        // Verify title equals:
        //Expected login page

        String expectedTitle = "Authorization";

        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Verification of the title page passed!");
        } else {
            System.err.println("Verification of the title page failed!");
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
        }
    }


    @Test
    public void test1() {

        System.out.println("Running test1");
    }

    @Test
    public void test2() {
        System.out.println("Running test2");
    }

    @Test
    public void test3() {
        System.out.println("Running test3");
    }

    @Test
    public void test4() {
        System.out.println("Running test4");
    }

    @Test
    public void test5() {
        System.out.println("Running test5");
    }

    @Test
    public void test6() {
        System.out.println("Running test6");
    }

    @AfterClass
    public void tearDownClass(){
        driver.close();
    }

}

/*

        //4. Enter username:
        // We need to locate the login input box and then sendKeys(userName) to it:
        //driver.findElement(By)).sendKeys(); username

        //5. Enter password:
        // We need to locate the password input box then sendKeys (password) to it:
        //driver.findElement(By)).sendKeys(); password
    }
}

/*
User Story 14:
As a user, I should be able to logout from the app

Acceptance Criteria:
Verify users can logout and return back to login page.

Scenario:
Users (hr, marketing and helpdesk) able to logout under user email

Credentials:
         UserName                 Password                QA
helpdesk35@cybertekschool.com     UserUser      login2.nextbasecrm.com
helpdesk36@cybertekschool.com     UserUser	    login2.nextbasecrm.com
marketing35@cybertekschool.com    UserUser      login2.nextbasecrm.com
marketing36@cybertekschool.com	  UserUser	    login2.nextbasecrm.com
hr35@cybertekschool.com           UserUser      login2.nextbasecrm.com
hr36@cybertekschool.com           UserUser      login2.nextbasecrm.com

 */
