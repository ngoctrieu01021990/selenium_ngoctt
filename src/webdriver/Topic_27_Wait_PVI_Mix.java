package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_27_Wait_PVI_Mix {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test // Happy case
    public void TC_01_Element_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/login");

        System.out.println("Start time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#small-searchterms"));
        System.out.println("End time: " + getDateTimeNow());

        System.out.println("Start time: " + getDateTimeNow());
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#small-searchterms")));
        System.out.println("End time: " + getDateTimeNow());
    }

    @Test
    public void TC_02_Element_NotFound_Only_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/login");

        //3. Nếu như tìm element mà k thấy
        // Sẽ cố gắng tìm đi tìm lại cứ mỗi 1/2s 1 lần
        // nếu giữa chừng tìm thấy thì k cần chờ hết thời gian còn lại
        // nếu hết time còn lại mà k tìm thấy thì show ra exception: NosuchElement và đánh fail testcase tại vị trí code đó
        // k chạy tiếp các step còn lại

        System.out.println("Start time: " + getDateTimeNow());
        try {
            driver.findElement(By.cssSelector("input#small"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("End time: " + getDateTimeNow());
        }
    }

    @Test
    public void TC_03_Element_NotFound_Only_Explicit() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/login");

        System.out.println("Start time: " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#small")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("End time: " + getDateTimeNow());
        }
    }

    @Test // Equal/Less/More đều có output giông nhau
    public void TC_04_Element_NotFound_Combine_By() {
        // implicit luôn ưu tiên chạy trước vì dù muốn áp dụng bất kỳ action/đk gì lên Element thì phải tìm được nó trước
        // explicit kích hoạt sau implicit 0.5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com/login");

        System.out.println("Start time: " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#small")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("End time: " + getDateTimeNow());
        }
    }

    @Test // Equal/Less/More đều có output giông nhau
    public void TC_05_Element_NotFound_Combine_Element() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com/login");

        System.out.println("Start time: " + getDateTimeNow());

        // Nếu chỉ dùng duy nhất Explicit thì các hàm có tham số là Element sẽ nhận timeout=0
        // Nếu chỉ dùng duy nhất Explicit thì chỉ dùng các hàm có tham số là By
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#small"))));
            explicitWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("input#small"))));
            explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input#small"))));
            explicitWait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.cssSelector("input#small"))));
            explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("input#small"))));
            explicitWait.until(ExpectedConditions.textToBePresentInElement( driver.findElement(By.cssSelector("input#small")),"Automation"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("End time: " + getDateTimeNow());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private String getDateTimeNow() {
        return new Date().toString();
    }
}
