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

public class Topic_23_Element_Excercise {
    WebDriver driver;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_displayed() {
        driver.get("https://automationfc.github.io/basic-form/");
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input[@id='mail']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Age:']/following-sibling::input[@id='under_18']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Education:']/following-sibling::textarea[@id='edu']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Name: User5']")).isDisplayed());
    }

    @Test
    public void TC_02_enable_disable() {
        driver.get("https://automationfc.github.io/basic-form/");
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input[@id='mail']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Age:']/following-sibling::input[@id='under_18']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Education:']/following-sibling::textarea[@id='edu']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Job Role 01')]/following-sibling::select[@id='job1']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Job Role 02')]/following-sibling::select[@id='job2']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Interests:']/following-sibling::input[@id='development']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Slider 01:']/following-sibling::input[@id='slider-1']")).isEnabled());

        Assert.assertFalse(driver.findElement(By.xpath("//lable[text()='Password:']/following-sibling::input[@id='password']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//lable[text()='Age:']/following-sibling::input[@id='radio-disabled']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//lable[text()='Biography:']/following-sibling::textarea[@id='bio']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Job Role 03')]/following-sibling::select[@id='job3']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Interests:']/following-sibling::input[@id='check-disbaled']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Slider 02:']/following-sibling::input[@id='slider-2']")).isEnabled());
    }

    @Test
    public void TC_Display_Enable_Selected() {
        driver.get("https://www.fahasa.com/customer/account/create");

        // element hiển thị: có thể nhìn thấy, có kích thước cụ thể
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone_otp")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-register")).isDisplayed());

        Assert.assertFalse(driver.findElement(By.cssSelector("input#login_username")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#login_password")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login")).isDisplayed());

        // element enable: có thể thao tác được
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#register_phone_otp")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#register_password")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-register")).isDisplayed());

        // element selected: đã được chọn
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");
        Assert.assertTrue(driver.findElement(By.cssSelector("input#is_subscribed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#is_subscribed")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#is_subscribed")).isSelected());
    }

    @Test
    public void TC_03_selected() {
        driver.get("https://automationfc.github.io/basic-form/");

        try {
            WebElement radioButtonAge = driver.findElement(By.xpath("//label[text()='Age:']/following-sibling::input[@id='under_18']"));
            if (radioButtonAge.isDisplayed()) {
                radioButtonAge.click();
            }
            System.out.println(radioButtonAge);
        } catch (Exception e) {
            // Accept button might not be there or already clicked — safe to ignore
        }

        try {
            WebElement radioButtonAge = driver.findElement(By.xpath("//label[text()='Languagues:']/following-sibling::input[@id='java']"));
            if (radioButtonAge.isDisplayed()) {
                radioButtonAge.click();
            }
        } catch (Exception e) {
            // Accept button might not be there or already clicked — safe to ignore
        }
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
