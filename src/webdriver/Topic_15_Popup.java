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

public class Topic_15_Popup {
    WebDriver driver;
    int shortTimeout = 3;
    int longTimeout = 15;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_In_HTML() throws InterruptedException {
        driver.get("https://kmplayer.com/home");

        By popup = By.cssSelector("div[class='pop-container']");

        //1. Nếu popup hiển thị thì close đi --> click vào FAQ link
        //2. Nếu k hiển thị thì click vào FAQ link

        if (driver.findElement(popup).isDisplayed()) {
            System.out.println("--------------Popup hiển thị------------");
            driver.findElement(By.cssSelector("div[class='close']")).click();
            Thread.sleep(2000);
        }

        System.out.println("--------------Popup không hiển thị------------");

        // đều mong đợi k hiển thị trước khi click vào FAQ link
        Assert.assertFalse(driver.findElement(popup).isDisplayed());

        driver.findElement(By.xpath("//a[text()='FAQ']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='KMPlayer FAQ']")).isDisplayed());
    }

    @Test
    public void TC_02_Not_In_HTML() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);

        By popup = By.cssSelector("div.custom-dialog-paper");

        // verify popup hiển thị
        Assert.assertTrue(driver.findElement(popup).isDisplayed());
        driver.findElement(By.cssSelector("input[placeholder='Tài khoản đăng nhập']")).sendKeys("automation");
        driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("automation");
        driver.findElement(By.xpath("//form//button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");
        driver.findElement(By.cssSelector("h2>button.close-btn")).click();

        // verify popup k hiển thị
        //isDisplayed() k kiểm tra đc 1 element k có trong HTML đc
        //Assert.assertFalse(driver.findElement(popup).isDisplayed());

        // Khi xly các elament k tồn tại trong HTML thì nên set lại timeout của implicit về 1 con số ngắn hơn
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
        Assert.assertEquals(driver.findElements(popup).size(), 0);// list này actual trả về =1

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));

        //Note: nếu popup dạng fix cứng/random luôn tồn tại trong HTML dù đang hiển thị/k hển thị thì chỉ cần kt isDisplayed
        //nếu popup dạng fix cứng/random khi k hiển thị >> k còn trong HTML nữa thì dùng findElements để lấy kích thước của list Element & kt =0
    }

    @Test
    public void TC_03_TiKi() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(8000);

        // popup dạng random
        By bundlePopup = By.cssSelector("div#VIP_BUNDLE");

        //1. Nếu popup hiển thị thì close đi --> click vào Đăng nhập/Đăng ký
        //2. Nếu k hiển thị thì click vào Đăng nhập/Đăng ký

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
        List<WebElement> bundlePopupElement = driver.findElements(bundlePopup);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));

        if (bundlePopupElement.size() > 0 && bundlePopupElement.get(0).isDisplayed()) {
            // close đi
            driver.findElement(By.cssSelector("picture.webpimg-container>img[alt='close-icon']")).click();
            Thread.sleep(1500);
        }
            //click vào Đăng nhập/Đăng ký
            driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
            Thread.sleep(1000);

            // popup dạng fix cứng
            By loginPopup = By.cssSelector("div[class*='ReactModal__Content']");
            Thread.sleep(1000);

            // verify đang hiển thị
            Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

            driver.findElement(By.cssSelector("p[class='login-with-email']")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
            Thread.sleep(1000);

            Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());

            driver.findElement(By.cssSelector("img[class='close-img']")).click();
            Thread.sleep(1000);

            // verify không hiển thị
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
            Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
