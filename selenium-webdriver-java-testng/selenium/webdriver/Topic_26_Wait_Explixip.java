package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

public class Topic_26_Wait_Explixip {
    WebDriver driver;
    WebDriverWait explicitWait;
    WebElement element;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
//        Khởi tạo 1 explicit wwait có tổng thời gian là 10s polling là 0.5s mặc định
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/?locale=vi_VN");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC001_VerifyBtn() {
//        Chờ cho 1 alert presence trong HTML/ DOM trước khi thao tác lên
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
//        Chờ cho element không còn trong dom
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(""))));
//        Chờ element có trong dom (Không quan tâm có trên UI hay không)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
//        Chò cho 1 list element có trong dom
        explicitWait.until();
    }

    @Test
    public void TC002_Login() {


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
