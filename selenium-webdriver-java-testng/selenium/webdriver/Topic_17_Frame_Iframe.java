package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Frame_Iframe {
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
    public void TC001_Double_Click() {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#formTemplateContainer")).click();
        sleepInSeconds(3);

        WebElement formIframe = driver.findElement(By.cssSelector("div"));
        Assert.assertTrue(formIframe.isDisplayed());

        driver.switchTo().frame("frame-one8559336");

        new Select(driver.findElement(By.cssSelector("select#RESULT_Radio"))).selectByVisibleText("Sophomore");
        driver.switchTo().defaultContent();
    }

    @Test
    public void TC003_KynaEnglish() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("dangthanh");
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("a.login-btn")).click();
        driver.switchTo().defaultContent();
        sleepInSeconds(5);

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("12345678");
        sleepInSeconds(5);
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
