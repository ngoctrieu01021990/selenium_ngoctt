package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_21_Wait_PI_Status {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Visible() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("button#send2")).click();

        //ĐK 1: Element hiển thị trên UI &  có trong DOM/HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
    }

    @Test
    public void TC_02_Invisible_In_HTML() throws InterruptedException {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("button#send2")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input#email")).sendKeys("ngoctt@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //ĐK2: Element k hiển thị trên UI & có trong DOM/HTML
        //an expectation for checking that an element either invisible

        System.out.println("Start wait: " + getDateTimeNow());
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
        System.out.println("End wait: " + getDateTimeNow());

    }

    @Test
    public void TC_02_Invisible_NotIn_HTML() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("input#email")).sendKeys("ngoctt@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //ĐK3: Element k có trên UI & k có trong DOM
        //not present on the DOM
        System.out.println("Start wait: " + getDateTimeNow());
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
        System.out.println("End wait: " + getDateTimeNow());
    }

    @Test
    public void TC_03_Present() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //ĐK 1: Element hiển thị trên UI &  có trong DOM/HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#advice-required-entry-email")));

        driver.findElement(By.cssSelector("input#email")).sendKeys("ngoctt@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //ĐK2: Element k hiển thị trên UI & có trong DOM/HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
    }

    @Test
    public void TC_04_Staless() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("button#send2")).click();

        //Element đã xh tại thời điểm trước đó r
        WebElement emailErrorMessage = driver.findElement(By.cssSelector("div#advice-required-entry-email"));

        driver.navigate().refresh();

        //ĐK3: Element k có trên UI & k có trong DOM
        // Tại thời điểm này mong đợi k có xuất hiện nữa
        explicitWait.until(ExpectedConditions.stalenessOf(emailErrorMessage));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private String getDateTimeNow() {
        return new Date().toString();
    }
}
