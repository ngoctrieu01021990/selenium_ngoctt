package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_26_Wait_PV_Explicit_Excercise {
    WebDriver driver;
    WebDriverWait explicitWait;
    String uploadFilePath = System.getProperty("user.dir") + "\\uploadFiles\\";

    String flowerFileName = "flower.jpg";
    String moonFileName = "moon.jpg";
    String tigerFileName = "tiger.jpg";

    String flowerFilePath = uploadFilePath + flowerFileName;
    String moonFilePath = uploadFilePath + moonFileName;
    String tigerFilePath = uploadFilePath + tigerFileName;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#start>button"))).click();

        //Cờ loading icon invisible
        //1. Chờ cho step trước đc hoàn thành >> rồi mới qua step sau (k qtam step sau làm gì)
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading"))));

        //Chờ cho text là Visible
        //2. sau khi step trước được bắt đầu>> nó chờ cho 1 đối tượng ở step sau đc xuất hiện
        //(k qtam tâm step trước đã hoàn thành hay chưa?)
        Assert.assertEquals(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4"))).getText(), "Hello World!");
    }

    @Test
    public void TC_02_Ajax() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // chờ trong vòng 30 giây để date picker được hiển thị
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1")));

        // wait cho text được xuất hiện trong vòng 30s
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe
                (By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"), "No Selected Dates to display.")));

        // wait cho element được phép click rồi click vào
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='18']"))).click();

        // wait cho loading icon biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector("div:not([style='display:none;'])>div.raDiv"))));

        //wait cho text được cập nhật lên trang
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe
                (By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"), "Thursday, September 18, 2025")));
    }

    @Test
    public void TC_03_Upload() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://gofile.io/home");

        // nếu trên cùng 1 trang có nhiều loading icon thì wait all
        // chờ cho tất cả loading icon trên trạng hiện ta biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements
                (By.cssSelector("div.animate-spin")))));

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")))
                .sendKeys(flowerFilePath + "\n" + moonFilePath + "\n" + tigerFilePath);

        // chờ tất cả upload progressbar biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements
                (By.cssSelector("div.file-progressbar")))));

        String uploadURL = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.linkSuccessCard"))).getDomAttribute("href");
        driver.get(uploadURL);

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements
                (By.cssSelector("div.animate-spin")))));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'item_open') and text()='" + flowerFileName + "']")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'item_open') and text()='" + moonFileName + "']")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'item_open') and text()='" + tigerFileName + "']")));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
