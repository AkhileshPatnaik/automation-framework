package org.akhil.test.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BankingApplication {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test
    public void customerpage() {
        WebElement customerlogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='customer()']")));
        customerlogin.click();
        WebElement selectuser = wait.until(ExpectedConditions.elementToBeClickable(By.name("userSelect")));
        Select list = new Select(selectuser);
        list.selectByVisibleText("Ron Weasly");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        WebElement balance = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[@class=\"ng-binding\"][2]")));
        String accbalance = balance.getText();
        System.out.println("Before balance is:" + accbalance);
        assertEquals(accbalance, "0", "Intial balance is not zero");
        WebElement clickdeposit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='deposit()']")));
        clickdeposit.click();
        WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='amount']")));
        text.sendKeys("500");
        WebElement cdeposit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        cdeposit.click();
        String message = driver.findElement(By.xpath("//span[@ng-show='message']")).getText();
        System.out.println("Print the message after deposit the amount: " + message);
        String amt = driver.findElement(By.xpath("//strong[@class='ng-binding'][2]")).getText();
        System.out.println("After depositing the amount is: " + amt);
        WebElement transaction = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='transactions()']")));
        transaction.click();
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn logout']")));
        logout.click();
    }
    @Test
    public void withdrawal() {
        WebElement customerlogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='customer()']")));
        customerlogin.click();
        WebElement selectuser = wait.until(ExpectedConditions.elementToBeClickable(By.name("userSelect")));
        Select list = new Select(selectuser);
        list.selectByVisibleText("Ron Weasly");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        WebElement balance = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[@class='ng-binding'][2]")));
        String accbalance = balance.getText();
        System.out.println("Before withdrawing the balance is:"+accbalance);
        assertEquals(accbalance, "0", "Intial balance is not zero");
        WebElement withdraw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='withdrawl()']")));
        withdraw.click();
        WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='amount']")));
        text.sendKeys("500");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        String errormessage = driver.findElement(By.xpath("//span[@ng-show='message']")).getText();
        System.out.println("While withdrawing it says: "+errormessage);
        WebElement awithbalance = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[@class='ng-binding'][2]")));
        String awbalance = awithbalance.getText();
        System.out.println("After withdrawing the balance is:"+awbalance);
        WebElement transaction = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='transactions()']")));
        transaction.click();
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn logout']")));
        logout.click();
    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
