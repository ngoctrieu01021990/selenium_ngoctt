package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Topic_22_Wait_PII_FindElement {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_FindElement() {
        driver.get("https://demo.nopcommerce.com/login");

        //1. Nếu như tìm element thấy duy nhất 1 cái
        // k cần chờ hết tổng thời gian 10s
        // chuyển qua action tiếp theo luôn
        System.out.println("Start time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#small-searchterms"));
        System.out.println("End time: " + getDateTimeNow());

        //2. Nếu như tìm element thấy nhiều hơn 1 cái
        // k cần chờ hết tổng thời gian 10s
        // luôn lấy element đầu tiên để thao tác
        System.out.println("Start time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("ngoctt@gmail.com");
        System.out.println("End time: " + getDateTimeNow());

        //3. Nếu như tìm element mà k thấy
        // Sẽ cố gắng tìm đi tìm lại cứ mỗi 1/2s 1 lần
        // nếu giữa chừng tìm thấy thì k cần chờ hết thời gian còn lại
        // nếu hết time còn lại mà k tìm thấy thì show ra exception: NosuchElement và đánh fail testcase tại vị trí code đó
        // k chạy tiếp các step còn lại
        System.out.println("Start time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("automation");
        System.out.println("End time: " + getDateTimeNow());
    }

    @Test
    public void TC_02_FindElements() {
        driver.get("https://demo.nopcommerce.com/login");
        List<WebElement> elementList = null;

        //1. Nếu như tìm element thấy duy nhất 1 cái
        System.out.println("Start time: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#small-searchterms"));
        System.out.println("Tổng số lượng element trong list: " + elementList.size());
        System.out.println("End time: " + getDateTimeNow());

        //2. Nếu như tìm element thấy nhiều hơn 1 cái
        System.out.println("Start time: " + getDateTimeNow());
        elementList = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("End time: " + getDateTimeNow());

        System.out.println("Tổng số lượng element trong list: " + elementList.size());
        for (WebElement element : elementList) {
            System.out.println(element.getDomProperty("href"));
        }

        //3. Nếu như tìm element mà k thấy
        System.out.println("Start time: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#FirstName"));
        System.out.println("Tổng số lượng element trong list: " + elementList.size());
        System.out.println("End time: " + getDateTimeNow());

        // chờ hết time out
        // hết timeout k tìm thấy thì k đánh fail
        // trả về 1 list rỗng =0
    }

    @Test
    public void TC_03_Unique_Element() {
        driver.get("https://live.techpanda.org/");

        // Đang bị ẩn --> k thao tác được
        driver.findElement(By.xpath("//a[@title='My Account']")).click();

    }

    private String getDateTimeNow() {
        return new Date().toString();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
