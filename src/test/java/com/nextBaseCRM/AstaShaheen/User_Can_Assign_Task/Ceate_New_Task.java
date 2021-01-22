package com.nextBaseCRM.AstaShaheen.User_Can_Assign_Task;

import com.github.javafaker.Faker;
import com.nextBaseCRM.utilities.WebDriverFactory;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Ceate_New_Task {

    WebDriver driver;

    @BeforeTest
    public void Login() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/login");


    }


    // Click on "Task" module


    @Test
    public void newTask() throws InterruptedException {

        WebElement userName = driver.findElement(By.name("USER_LOGIN"));

//        "hr35@cybertekschool.com"
//        "hr36@cybertekschool.com"
//        "marketing35@cybertekschool.com"
//        "marketing36@cybertekschool.com"
//        "helpdesk35@cybertekschool.com"
//        "helpdesk36@cybertekschool.com"

        userName.sendKeys("hr35@cybertekschool.com");
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser", Keys.ENTER);


        WebElement taskTab = driver.findElement(By.xpath("//li[@id='bx_left_menu_menu_tasks']"));//xpath("//a[@title='Tasks']"));//linkText("Tasks"));
        taskTab.click();
        WebElement newTask = driver.findElement(By.xpath(" //a[@id='tasks-buttonAdd']"));
        newTask.click();
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='side-panel-iframe']"));

        driver.switchTo().frame(iFrame);

        Faker faker = new Faker();
        String nameInput = faker.funnyName().name();

        WebElement taskName = driver.findElement(By.xpath("//div[@class='task-info-panel-title']//input"));
        taskName.sendKeys(nameInput);
        Thread.sleep(2000);

        WebElement checklist = driver.findElement(By.xpath("//span[@class='tasks-task-mpf-link'] "));
        checklist.click();

        WebElement checkListText = driver.findElement(By.xpath("//input[@class='js-id-checklist-is-form-title task-checklist-field-add']"));
        Thread.sleep(3000);
        checkListText.sendKeys("Testing", Keys.ENTER);
        checkListText.sendKeys("Testing2", Keys.ENTER);
        checkListText.sendKeys("Testing3", Keys.ENTER);
        checkListText.sendKeys("Testing4", Keys.ENTER);


        List<WebElement> checklistList = driver.findElements(By.xpath("//label[@class='block-read task-checklist-field-label']"));
        // System.out.println(checklistList.size());

        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-success']")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(3000);
        List<WebElement> allTasks = driver.findElements(By.xpath("//td[@class='main-grid-cell main-grid-cell-left']/../td[3]"));
        ArrayList<String> arrList = new ArrayList<>();

        for (WebElement each : allTasks) {

            arrList.add(each.getText());

        }
        System.out.println(arrList.get(arrList.size() - 1));

        String lastCreatedTaskName = arrList.get(arrList.size() - 1);

        Assert.assertEquals(nameInput, lastCreatedTaskName);
    }
}
