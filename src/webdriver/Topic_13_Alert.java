package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.Headers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic_13_Alert {
    WebDriver driver;

    @BeforeClass
    public void beforClass() {
        driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1366,768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// chờ cho việc tìm kiếm element
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Accept_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(5000);

        //chờ cho alert presence (có xuất hiện trong html, k bắt buộc phải hiển thị trên UI)
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());

        //thao tác với alert
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        // accept alert
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
    }

    @Test
    public void TC_02_Confirm_Alert() {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void TC_03_Prompt_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS prompt");
        String text = "Alert Prompt";
        alert.sendKeys(text);
        Thread.sleep(3000);
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + text);
    }

    @Test
    public void TC_04_Accept_Alert() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("button[class*='search-box-button']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Please enter some search keyword");
        alert.accept();

        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("macbook");
        driver.findElement(By.cssSelector("button[class*='search-box-button']")).click();
    }

    @Test
    public void TC_05_Authentication_Alert() {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        // http://username:pass@URL
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/p")).getText(), "Congratulations! You must have the proper credentials.");
    }

    @Test
    public void TC_06_Authentication_Alert() {
        driver.get("http://the-internet.herokuapp.com/");

        String url = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getDomProperty("href");

        String[] urlArray = url.split("//");
        String username = "admin";
        String password = "admin";
        url = urlArray[0] + "//" + username + ":" + password + "@" + urlArray[1];
        driver.get(url);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/p")).getText(), "Congratulations! You must have the proper credentials.");
    }

    @Test
    public void TC_07_Authentication_Alert() {
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        //get dev tool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // start new session
        devTools.createSession();

        //Enable the network domain of devtool
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(),Optional.of(true)));

        //Encode user/pass
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic" + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        //send to header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
