package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_20_Upload {
    WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Single_File() throws InterruptedException {
        //file để ở đâu?
        // file cố định  trên máy --> sang máy khác k chạy được do k tìm thấy đường dẫn
        //==> bất kỳ máy nào cũng chạy được
        //==> Để file trong chính bộ source code --> lấy đường dẫn tương đối của file ra

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileBy = By.cssSelector("input[type='file']");

        //load file
        driver.findElement(uploadFileBy).sendKeys(flowerFilePath);
        driver.findElement(uploadFileBy).sendKeys(moonFilePath);
        driver.findElement(uploadFileBy).sendKeys(tigerFilePath);
        Thread.sleep(3000);

        //verify file được load lên thành công
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + flowerFileName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + moonFileName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + tigerFileName + "']")).isDisplayed());

        //upload file
        List<WebElement> startUploadButton = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton : startUploadButton) {
            startButton.click();
            Thread.sleep(1000);
        }

        // verify upload file
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + flowerFileName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + moonFileName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + tigerFileName + "']")).isDisplayed());
    }

    @Test
    public void TC_02_Multiple_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileBy = By.cssSelector("input[type='file']");

        //load file
        driver.findElement(uploadFileBy).sendKeys(flowerFilePath + "\n" + moonFilePath + "\n" + tigerFilePath);
        Thread.sleep(3000);

        //verify file được load lên thành công
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + flowerFileName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + moonFileName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + tigerFileName + "']")).isDisplayed());
        Thread.sleep(2000);

        //upload file
        List<WebElement> startUploadButton = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton : startUploadButton) {
            startButton.click();
            Thread.sleep(2000);
        }

        // verify upload file
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + flowerFileName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + moonFileName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + tigerFileName + "']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
