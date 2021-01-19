package com.nextBaseCRM.AstaShaheen.User_Can_Assign_Task;

import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class G18_67_Asign_HighPriority {

    WebDriver driver;

    @BeforeClass
    public void SetUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/login");


    }

    @Test
    public void login() {
        WebElement userName = driver.findElement(By.name("USER_LOGIN"));
        userName.sendKeys("hr35@cybertekschool.com");
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser", Keys.ENTER);
    }


    // Click on "Task" module

    @Test
    public void taskTab() {
        login();
        WebElement taskTab = driver.findElement(By.linkText("Tasks"));
        taskTab.click();
    }


   // From the task table click on any available task "name"
    @Test
    public void selectName(){
        taskTab();

//        List<WebElement> allRows= driver.findElements(By.xpath("//table[@class='main-grid-table']//tr"));
//        List<WebElement> allCells= driver.findElements(By.xpath("//table[@class='main-grid-table']//tr//td"));
//        for(WebElement each:allRows){
//            System.out.println("Row "+each.getText());
//        }
//        for(WebElement each:allCells){
//            System.out.println("Cell "+each.getText());
//        }

        WebElement firstSecection= driver.findElement(By.xpath("//div[@class='main-grid-container']//tr[1]//td[3]//a"));
       firstSecection.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        WebElement frame1= driver.findElement(By.xpath("//*[@class='side-panel-iframe']"));
        driver.switchTo().frame(frame1);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement fireSignNotSelected= driver.findElement(By.xpath("//span[@class='if-no']"));
        fireSignNotSelected.click();
        WebElement fireSignIsSelected= driver.findElement(By.xpath("//span[@class='if-no'][text()='High Priority']"));
        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//span[@title='Close']")).click();
        driver.navigate().refresh();

}


}
