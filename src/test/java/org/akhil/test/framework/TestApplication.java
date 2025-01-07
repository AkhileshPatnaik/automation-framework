package org.akhil.test.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestApplication {
    WebDriver driver;

    @BeforeTest
    public void startBrowsing() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://google.com");
        WebElement searchbox = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.name("q")));
        System.out.println(searchbox);
    }

    @Test
    public void setup() {
        WebElement box = driver.findElement(By.name("q"));
        box.sendKeys("youtube");
        box.submit();
        WebElement link = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/']//h3[contains(text(),'YouTube')]"));
        link.click();
        WebElement text = driver.findElement(By.name("search_query"));
        text.sendKeys("latest song");
        text.click();
        WebElement play = driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'Morni | Badshah | Sharvi Yadav')]"));
        play.click();
        WebElement pause = driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'Morni | Badshah | Sharvi Yadav')]"));
        pause.click();
    }

    @AfterTest
    public void teardown() {
        System.out.println("Task over");
        driver.quit();
    }
}
