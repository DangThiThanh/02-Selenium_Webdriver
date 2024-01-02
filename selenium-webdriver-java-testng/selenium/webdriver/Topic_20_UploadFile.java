package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_UploadFile {
    WebDriver driver;
    WebElement element;

    String projectPath = System.getProperty("user.dir");
    String anh1Name = "anh1.jpg";

    String anh2Name = "anh2.jpg";
    String anh3Name = "anh3.jpg";
    String anh1FilePath = projectPath + "\\selenium-webdriver-java-testng\\selenium\\uploadFile\\" + anh1Name;
    String anh2FilePath = projectPath + "\\selenium-webdriver-java-testng\\selenium\\uploadFile\\" + anh2Name;
    String anh3FilePath = projectPath + "\\selenium-webdriver-java-testng\\selenium\\uploadFile\\" + anh3Name;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC001_Upload_Singer_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadBy = By.cssSelector("input[name='files[]']");

        driver.findElement(uploadBy).sendKeys(anh1FilePath);
        sleepInSeconds(2);
        driver.findElement(uploadBy).sendKeys(anh2FilePath);
        sleepInSeconds(2);
        driver.findElement(uploadBy).sendKeys(anh3FilePath);

        // FIle này nằm ở đâu

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
