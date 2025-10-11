package testNG.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_04_Alway_Run {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("----------Pass before class----------");

    }

    @Test
    public void regiter() {
        System.out.println("Action and verify");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
        System.out.println("----------Pass after class----------");
    }

}
