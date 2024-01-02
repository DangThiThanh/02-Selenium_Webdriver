package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_18_Windown_Tab {
    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC013_Basic_Form() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        String basicFormID= driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSeconds(2);
        switchToWindowByTitle("Google");
        driver.switchTo().window(basicFormID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSeconds(2);
        switchToWindowByTitle("Facebook");
        driver.switchTo().window(basicFormID);

        closeAllWindowWithoutParent(basicFormID);
        System.out.println(driver.getTitle());
    }

    @Test
    public void TC014_Login() {
        driver.get("https://skills.kynaenglish.vn/");
        driver.findElement(By.cssSelector("div.hotline img[alt='facebook']")).click();
        sleepInSeconds(3);
        switchToWindowByTitle("Kyna.vn | Ho Chi Minh City | Facebook");
//        sleepInSeconds(3);
//        driver.findElement(By.cssSelector(""));

    }
    @Test
    public void TC015_Basic_Form() {
        driver.get("http://live.techpanda.org/index.php/mobile.html");
        String parentId= driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[@title='Sony Xperia']//following::div[@class='actions']//a[text()='Add to Compare']")).click();
        String a = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
        a.equals("The product Sony Xperia has been added to comparison list.");
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']//following::div[@class='actions']//a[text()='Add to Compare']")).click();
        String b = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
        a.equals("The product Samsung Galaxy has been added to comparison list.");
        driver.findElement(By.xpath("//span[text()='Compare']")).click();
        sleepInSeconds(5);
        System.out.println(driver.getWindowHandles());
        switchToWindowByTitle("Products Comparison List - Magento Commerce");
        String c = driver.findElement(By.xpath("//h1[text()='Compare Products']")).getText();
        c.equals("COMPARE PRODUCTS");
        closeAllWindowWithoutParent(parentId);
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        driver.switchTo().alert().accept();
        String d = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
        c.equals("The comparison list was cleared.");

    }
    @Test
    public void TC016_Selenium_Version_4() {
        driver.get("https://skills.kynaenglish.vn/");
        //New 1 tab mới/ windown mới
        WebDriver faceBookDriver= driver.switchTo().newWindow(WindowType.WINDOW);
        faceBookDriver.get("https://www.facebook.com/kyna.vn");

    }
    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void switchToWindowByTitle(String expectedTitle){
        //Lấy hết tất cả ID của các window /tab
        Set<String> allIDs = driver.getWindowHandles();
        sleepInSeconds(2);

//        Dùng vòng lặp duyệt qua các ID ở trên
        for (String id: allIDs){
            driver.switchTo().window(id);
//            Lấy ra title window/tab hiện tại
            String actualTitle = driver.getTitle();

            if(actualTitle.equals(expectedTitle)){
                break;
            }
        }
    }
    public  void closeAllWindowWithoutParent(String parentID){
        Set<String> allIDs = driver.getWindowHandles();
        for(String id: allIDs){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
