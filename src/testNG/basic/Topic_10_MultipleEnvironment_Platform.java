package testNG.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_10_MultipleEnvironment_Platform {
    WebDriver driver;
    String environmentURL;
    Platform platform;

    @Parameters({"browser", "environmentName","platformName"})
    @BeforeClass
    public void beforClass(String browserName, String environmentName, @Optional("Windows") String platformName) {
        System.out.println("Browser name: " + browserName);
        System.out.println("Environment name: " + environmentName);
        System.out.println("Platform name: " + platformName);

        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not support");
        }

        switch (environmentName.toUpperCase()) {
            case "DEV":
                environmentURL = "https://dev.fahasa.com";
                break;
            case "UAT":
                environmentURL = "https://uat.fahasa.com";
                break;
            case "PROD":
                environmentURL = "https://www.fahasa.com";
                break;
            default:
                throw new RuntimeException("Environment name is not support");
        }

        switch (platformName.toUpperCase()) {
            case "WINDOWS":
                platform = Platform.WINDOWS;
                break;
            case "MAC":
                platform = Platform.MAC;
                break;
            case "LINUX":
                platform = Platform.LINUX;
                break;
            case "ANDROID":
                platform = Platform.ANDROID;
                break;
            case "IOS":
                platform = Platform.IOS;
                break;
            default:
                throw new RuntimeException("Environment name is not support");
        }
        System.out.println("Platform name: " + platformName);

        driver.get(environmentURL + "/customer/account/create");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// chờ cho việc tìm kiếm element
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Fahasa() {

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
