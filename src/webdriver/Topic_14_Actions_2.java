package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Actions_2 {

    WebDriver driver;
    Actions actions;
    JavascriptExecutor jsExecutor;
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();

        //ép kiểu
        jsExecutor = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        actions = new Actions(driver);
    }

    @Test
    public void TC_01_Click_And_Hold_Block() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allItem = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allItem.size(), 30);

        // chọn từ 1 --> 12
        actions.clickAndHold(allItem.get(0)).moveToElement(allItem.get(11)).release().perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        //verify đã chọn
        Assert.assertEquals(driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")).size(), 12);
    }

    @Test
    public void TC_02_Click_And_Hold_Random() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allItem = driver.findElements(By.cssSelector("ol#selectable>li"));

        // nhấn phím Ctrl (chưa nhả ra)
        Keys keys = null;
        if (osName.contains("Windows")) {
            keys = Keys.CONTROL;
        } else keys = Keys.COMMAND;

        actions.keyDown(keys).perform();

        // chọn 3,5,7,9,13,17,21,25,29
        actions.click(allItem.get(2))
                .click(allItem.get(4))
                .click(allItem.get(6))
                .click(allItem.get(8))
                .click(allItem.get(12))
                .click(allItem.get(16))
                .click(allItem.get(20))
                .click(allItem.get(24))
                .click(allItem.get(28))
                .perform();

        //nhả phím ctrl
        actions.keyUp(keys).perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        //verify đã chọn
        Assert.assertEquals(driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")).size(), 9);
    }

    @Test
    public void TC_03_Double_Click() {
        driver.get("https://automationfc.github.io/basic-form/");

        if (driver.toString().contains("Firefox")) {
            //element phải trong viewport thì mới scroll được
            //actions.scrollToElement(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();

            // scroll đến mép trên cùng của viewport
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);",
                    driver.findElement(By.xpath("//button[text()='Double click me']")));

            // scroll đến mép dưới cùng của viewport
        /*jsExecutor.executeScript("arguments[0].scrollIntoView(false);",
                driver.findElement(By.xpath("//button[text()='Double click me']")));*/
        }

        actions.pause(Duration.ofSeconds(2));

        actions.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
    }

    @Test
    public void TC_04_Right_Click() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        // Quit context menu chưa hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        //Click chuột phải
        actions.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        // Quit context menu hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        // Hover vào Quit menu
        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        // Quit menu sẽ có thêm trạng thái hover
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        // Click vào Quit
        driver.findElement(By.cssSelector("li.context-menu-icon-quit")).click();

        //Accept alert
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent()).accept();
        Thread.sleep(2000);

        //Quit context menu chưa hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
