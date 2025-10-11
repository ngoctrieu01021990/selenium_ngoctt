package testNG.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_MultipleBrowser {
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void beforClass(String browserName) {

        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                driver=new FirefoxDriver();
                break;
            case "CHROME":
                driver=new ChromeDriver();
                break;
            case "EDGE":
                driver=new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not support");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// chờ cho việc tìm kiếm element
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fahasa() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By loginButton = By.cssSelector("button.fhs-btn-login");

        //verify button disable
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("098332467");

        //verify button enable
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(), "#C92127");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
