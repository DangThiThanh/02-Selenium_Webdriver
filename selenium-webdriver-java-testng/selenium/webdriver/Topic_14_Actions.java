package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Actions {
    WebDriver driver;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        javascriptExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @Test
    public void TC005_Double_Click() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement elementClickButton = driver.findElement(By.xpath("//button[text()='Double click me']"));
        if (driver.toString().contains("firefox")) {
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", elementClickButton);
            sleepInSeconds(2);
        } else {
            actions.scrollToElement(elementClickButton).perform();
            sleepInSeconds(2);
        }
    }

    @Test
    public void TC006_Defaul_Checkbox() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement elementClickButton = driver.findElement(By.xpath("//button[text()='Double click me']"));
        if (driver.toString().contains("firefox")) {
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", elementClickButton);
            sleepInSeconds(2);
        } else {
            actions.scrollToElement(elementClickButton).perform();
            sleepInSeconds(2);
        }
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
