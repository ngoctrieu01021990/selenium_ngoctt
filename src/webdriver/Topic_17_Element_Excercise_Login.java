package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Element_Excercise_Login {
    WebDriver driver;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_DisPlay_Enable_Selected() {
        driver.get("https://www.fahasa.com/customer/account/create");
        // element hiển thị: nhìn thấy được, có kích thước cụ thể
        //mong đợi 1 element hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone_otp")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-register")).isDisplayed());

        //mong đợi 1 element k hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("input#login_username")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#login_password")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login")).isDisplayed());

        // element enable: thao tác được (k bị disable)
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#register_phone_otp")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#register_password")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-register")).isEnabled());


        // element selected: đã được chọn
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        Assert.assertTrue(driver.findElement(By.cssSelector("input#is_subscribed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#is_subscribed")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#is_subscribed")).isSelected());

    }

    @Test
    public void TC_04_Mailchimp() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("ngoctk@gmail.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement acceptBtn = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
            if (acceptBtn.isDisplayed()) {
                acceptBtn.click();
            }
        } catch (Exception e) {
            // Accept button might not be there or already clicked — safe to ignore
        }

// Wait for the cookie policy banner to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("onetrust-policy-text")));

        // test case nhập vào pass toàn bộ là lower case
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("test");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        //Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


        // test case nhập vào pass toàn bộ là Upper case
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("TEST");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // test case nhập vào pass toàn bộ là số
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // test case nhập vào pass toàn bộ là ký tự đặc biệt
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@#$@#$");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // test case nhập vào pass 8 ký tự
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("ngoctk@gmail.com");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        // test case nhập vào pass thỏa mãn full y/c
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("1qazXSW@@");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

    }

    @Test
    public void TC_01_Login_empty_Email_Pass() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    public void TC_02_Login_invalid_Email() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("1234@2322.43434");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234566");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void TC_03_Login_invalid_Pass() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_04_Login_incorrect_email() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123123123");
        driver.findElement(By.cssSelector("button#send2")).click();
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("security.warn_submit_insecure", false);
        WebDriver driver = new FirefoxDriver(options);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
