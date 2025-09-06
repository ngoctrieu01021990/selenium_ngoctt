package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Iframe {
    WebDriver driver;

    @BeforeClass
    public void beforClass() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_WordPress() {
        driver.get("https://toidicodedao.com/");

        // switch qua iframe/frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title*='Facebook Social Plugin']")));

        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Tôi đi code dạo']/parent::div/following-sibling::div")).getText(), "396,003 followers");

        // Quay lại trang chứa iframe
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("div#content-sidebar input[class='search-field']")).sendKeys("puppeteer");
        driver.findElement(By.cssSelector("div#content-sidebar input[class='search-field']")).sendKeys(Keys.ENTER);
    }

    @Test
    public void TC_02_FormSize() {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='details__form-preview-wrapper' " +
                "and contains(string(),'Interactive form loaded. Try filling out below.')]")).isDisplayed());

        //switch vào iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("South Dorm");
        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//a[@title='Get this form']")).click();
    }

    @Test
    public void TC_03_HDFC() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        Thread.sleep(4000);

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("Jonh");
        driver.findElement(By.cssSelector("a.login-btn")).click();
        Thread.sleep(4000);

        driver.switchTo().defaultContent();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#keyboard")));
        input.sendKeys("123456a@");
        //driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456a@");
        driver.findElement(By.cssSelector("a#loginBtn")).click();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
