package practices;

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

import java.util.List;

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
    public void TC010_KynaEnglish_IFrame() {
        driver.get("https://skills.kynaenglish.vn/");
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content>iframe")));
        sleepInSeconds(3);

        WebElement element = driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div"));
        System.out.println(element.getText());
        if (element.getText().equals("169K followers")) {
            System.out.println("169K: Text is match");
        } else {
            System.out.println("169K: Text is not match");
        }
        sleepInSeconds(1);

        driver.switchTo().defaultContent();
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("iframe#cs_chat_iframe")).click();
        sleepInSeconds(3);

        driver.switchTo().frame("cs_chat_iframe");
        sleepInSeconds(1);

        driver.findElement(By.cssSelector("input.input_name")).sendKeys("Thanh");
        driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0387654321");
        new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Automation Test");
        sleepInSeconds(3);

        driver.switchTo().defaultContent();
        sleepInSeconds(3);

        CharSequence textSearch = "Excel";
        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys(textSearch);
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("button.search-button")).click();
        sleepInSeconds(5);

        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.cssSelector("div.k-box-card-wrap div.content h4"));
        System.out.println("Có " + elements.size() + " kết quả được tìm thấy");
        int numberTextContains = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().contains(textSearch)) {
                numberTextContains++;
            }
        }
        System.out.println("Số lượng kết quả có chứa từ khóa tìm kiếm " + numberTextContains);
    }

    @Test
    public void TC011_CampusSafety_IFrame() {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("div#imageTemplateContainer")).click();
        sleepInSeconds(5);

        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Senior");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("West Dorm");
        driver.findElement(By.cssSelector("input#RESULT_RadioButton-4_0~label")).click();
        driver.findElement(By.cssSelector("input#FSsubmit")).click();
        sleepInSeconds(5);

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("nav.header--desktop-floater .menu-item-login")).click();
        sleepInSeconds(5);

        driver.findElement(By.cssSelector("button#login")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");
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
