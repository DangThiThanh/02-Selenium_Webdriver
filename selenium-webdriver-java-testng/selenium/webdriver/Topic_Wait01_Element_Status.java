package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_Wait01_Element_Status {
    WebDriver driver;
    WebDriverWait explicitWait;
    WebElement element;
    By reconfirmEmailTextBox= By.cssSelector("input[name='reg_email_confirmation__']");

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.facebook.com/?locale=vi_VN");
    }

    @Test
    public void TC_001_Visible() {
    driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
    sleepInSeconds(2);
    driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("Dthanh@gmail.com");
    sleepInSeconds(3);
    explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextBox));
        Assert.assertTrue(driver.findElement(reconfirmEmailTextBox).isDisplayed());

    }

    @Test
    public void TC002_Invisible() {
//    Điều kiện 2 - Element ko xuất hiện trên UI và vẫn có trong cây HTML
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSeconds(2);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextBox));
//        Kiểm tra 1 element không hiển thị

        Assert.assertFalse(driver.findElement(reconfirmEmailTextBox).isDisplayed());


//    Điều kiện 3 - Element ko xuất hiện trên UI và cũng ko có trong cây HTML
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        driver.findElement(By.xpath("//div[text()='Đăng ký']/parent::div/preceding-sibling::img"));
        sleepInSeconds(2);

    }
    @Test
    public void TC003_Presence() {
        

    }
    @Test
    public void TC004_Stale() {


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
