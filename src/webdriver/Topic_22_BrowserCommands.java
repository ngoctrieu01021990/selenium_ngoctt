package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Topic_22_BrowserCommands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Khoi tao trinh duyet firefox len
        driver = new FirefoxDriver();
    }

    public void TC_01() {
        //mở ra 1 page URL hơp lệ bất kỳ
        driver.get("https://orangehrmlive.com/");

        // đóng trình duyệt: đóng hết tất cả, k qtam có bao nhiêu tab, window
        driver.quit();

        // đóng trình duyệt: chỉ  đóng tab/window mà nó đang active
        driver.close();

        //tìm 1 element
        driver.findElement(By.cssSelector(""));

        //tìm nhiều element
        driver.findElements(By.cssSelector(""));

        // URL của page hiện tại
        Assert.assertEquals(driver.getCurrentUrl(),"");

        //HTML của source code page hiện tại
        Assert.assertTrue(driver.getPageSource().contains("Computer"));

        //trả về title của page hiện tại
        driver.getTitle();


        // trả về ID của tab/window hiện tại đang active
        driver.getWindowHandle();

        // trả về ID của tab/window của tất các tab/window
        driver.getWindowHandles();

        // mở rộng trình duyệt
        driver.manage().window().maximize();

        // thu nhỏ trình duyệt
        driver.manage().window().minimize();

        // full màn hình, full viền
        driver.manage().window().fullscreen();

        // set kích thước của trình duyệt (responsive)
        driver.manage().window().setSize(new Dimension(1920,1080));

        // lấy ra kích thước của browser là bao nhiêu
        driver.manage().window().getSize();

        //set màn hình ằm ở vị trí nào so với độ phân giải màn hình hiện tại
        driver.manage().window().setPosition(new Point(0,50));

        // Lấy ra tọa độ của browser đang đứng
        driver.manage().window().getPosition();

        //set cho việc tìm kiếm element (findElement/findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));

        driver.manage().timeouts().getImplicitWaitTimeout();



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
