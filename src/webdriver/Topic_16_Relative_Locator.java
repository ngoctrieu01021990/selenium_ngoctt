package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_16_Relative_Locator {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        //Remember me?
        WebElement rememberMeElement =  driver.findElement(RelativeLocator.with(By.tagName("label"))
                // ben tren button Login
                .above(By.cssSelector("button.login-button"))
                //.above(driver.findElement(By.cssSelector("button.login-button")))

                // ben duoi text password
                .below(By.id("Password"))

                // dung ben phai RememberMe checkbox
                .toRightOf(By.id("RememberMe"))

                // dung ben trai Forgot password?
                .toLeftOf(By.xpath("//a[text()='Forgot password?']"))
        );
        System.out.println(rememberMeElement.getText());
    }
}
