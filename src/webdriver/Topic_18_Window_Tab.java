package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_18_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Github() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Lấy ra ID của tab hiện tại mà driver đang đứng
        String githubWindowID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(3);

        switchToWindowByID(githubWindowID);

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Automation testing");
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys(Keys.ENTER);
        sleepInSecond(3);

        String googleWindowID = driver.getWindowHandle();
        switchToWindowByID(googleWindowID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(3);

        switchWindowByTitle("Facebook");
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("abc@gmail.com");

        switchWindowByTitle("Selenium WebDriver");
        sleepInSecond(3);

        driver.findElement(By.xpath("//a[text()='LAZADA']")).click();
        sleepInSecond(3);

        closeAllWindowWithoutParent(githubWindowID);
    }

    @Test
    public void TC_02_TechPanda() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::" +
                "div[@class='actions']//a[text()='Add to Compare']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::" +
                "div[@class='actions']//a[text()='Add to Compare']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        sleepInSecond(2);

        switchWindowByTitle("Products Comparison List");
        sleepInSecond(2);

        //click vào close button
        driver.findElement(By.xpath("//button[@title='Close Window']")).click();
        sleepInSecond(2);

        // nếu thao tác tiếp sẽ báo lỗi: là đang thao tác trên 1 window bị đóng rồi
        //driver.getTitle();

        // cần switch lại trang chính
        switchWindowByTitle("Mobile");

        driver.findElement(By.xpath("//a[text()='Clear All']")).click();

        driver.switchTo().alert().accept();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The comparison list was cleared.");


    }

    @Test
    public void TC_03_Cambridge() {
        driver.get("https://dictionary.cambridge.org/vi/");

        String homeWindowID = driver.getWindowHandle();
        sleepInSecond(2);

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Đăng nhập']")).click();
        sleepInSecond(2);

        switchWindowByTitle("Login");

        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span[id*='login-form-loginID']")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.cssSelector("span[id*='login-form-password']")).getText(),"This field is required");
        sleepInSecond(2);

        closeAllWindowWithoutParent(homeWindowID);
        sleepInSecond(2);

        String keyword ="Selenium";

        driver.findElement(By.cssSelector("input#searchword")).sendKeys(keyword);
        driver.findElement(By.cssSelector("input#searchword")).sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(@class,'uk')]/preceding-sibling::div[@class='di-title']/span/span")).getText(),keyword.toLowerCase());
    }

    @Test
    public void TC_04_Harvard() {
        driver.get("https://courses.dce.harvard.edu/");
        String homePageWindowID= driver.getWindowHandle();

        driver.findElement(By.cssSelector("a[data-action='login']")).click();
        sleepInSecond(10);

        switchToWindowByID(homePageWindowID);

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='DCE Login Portal']")).isDisplayed());

        closeAllWindowWithoutParent(homePageWindowID);

        switchWindowByTitle("DEC Course Search");

        Assert.assertTrue(driver.findElement(By.cssSelector("div.activescreen")).isDisplayed());

        driver.findElement(By.cssSelector("button[class*='button--cancel']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input#crit-keyword")).sendKeys("Data Science: An Artificial Ecosystem");
        new Select(driver.findElement(By.cssSelector("select#crit-srcdb"))).selectByVisibleText("Harvard Summer School 2025");
        new Select(driver.findElement(By.cssSelector("select#crit-summer_school"))).selectByVisibleText("Harvard College");
        new Select(driver.findElement(By.cssSelector("select#crit-session"))).selectByVisibleText("Full Term");

        driver.findElement(By.cssSelector("button#search-button")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("span.result__headline>span.result__title")).getText(),"Data Science: An Artificial Ecosystem");
    }

    @Test
    public void TC_05_Selenium_4x() {
        //trang user vào mua sắm,...
        driver.get("https://demo.nopcommerce.com/");

        // trang admin: vào kt đơn hàng,...
        // tự driver switch qua luôn, k cần dùng hàm switchID nữa
        driver.switchTo().newWindow(WindowType.TAB).get("https://admin-demo.nopcommerce.com/");

        switchWindowByTitle("Home page title");
        sleepInSecond(2);
    }

    private void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // duy nhất 2 tab/window
    private void switchToWindowByID(String windowID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        // dùng vòng lặp để duyệt qua tất cả các cửa sổ
        for (String id : allWindowIDs) {

            // nếu cửa sổ nào khác ID cho truớc
            if (!id.equals(windowID)) {

                // switch vào cửa sổ đó
                driver.switchTo().window(id);
                break;
            }
        }
    }

    // cover luôn cả cách làm của switchID
    private void switchWindowByTitle(String expectedPageTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            sleepInSecond(1);

            if (driver.getTitle().contains(expectedPageTitle)) {
                break;
            }
        }
    }

    private void closeAllWindowWithoutParent(String windowID) {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);

                //đóng tab/window hiện tại đang active
                driver.close();
            }
        }
        driver.switchTo().window(windowID);
    }

    @AfterClass
    public void afterClass() {
        //đóng browser
        driver.quit();
    }
}
