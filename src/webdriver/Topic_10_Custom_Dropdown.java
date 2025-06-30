package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;
    Select select;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        //Select select;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// chờ cho việc tìm kiếm element
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_ORangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");
        //login
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        // đợi cho all item biến mất
        Assert.assertTrue(isLoadingIconDisappear());

        //verify Dashboard page display
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        // click PIM link
        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        //verify Dashboard page display
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());

        /*Chọn item trong Employment Status*/

        selectItemInOrangeDropdown("Employment Status", "Employment Status", "Full-Time Contract");

        /*Chọn item trong include*/
        selectItemInOrangeDropdown("Include", "Include", "Current Employees Only");


        /*Chọn item trong Job Title*/
        selectItemInOrangeDropdown("Job Title", "Job Title", "Chief Executive Officer");

        /*Chọn item trong sub unit*/
        selectItemInOrangeDropdown("Sub Unit", "Sub Unit", "TechOps");

    }

    private void selectItemInOrangeDropdown(String parentLocator, String childLocator, String expectedItem) throws InterruptedException {
        /*Chọn item CTO trong Job Title*/
        /*1. Click vào dropdown cho sổ ra (Parent locator)*/
        driver.findElement(By.xpath("//label[text()='" + parentLocator + "']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']")).click();
        /*2. Chờ cho các item trong dropdown đc load ra hết (Child locator)*/
        // bắt 1 locator đại diện cho tất cả các item bên trong
        // lưu tất cả item vào 1 list item
        List<WebElement> allItem = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[text()='" + childLocator + "']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span")));


        // dùng vòng lặp duyệt qua hết tất cả các item trên
        for (WebElement temp : allItem) {
            // get text của từng item ra
            String textItem = temp.getText();

            /*3. Kt tất cả các item xem đâu là item cần chọn */
            if (textItem.equals(expectedItem)) {

                /*4. Nếu tìm thấy thì click vào item đó*/
                temp.click();
                Thread.sleep(2000);

                /*5. Chọn xong r thì tự động đóng dropdown*/
                break;
            }
        }
    }

    private Boolean isLoadingIconDisappear() {

        /* Chờ cho element/s hiển thị hết: visible - cần nhìn thấy được & có kích thước cụ thể
            Chờ cho element/s load ra hết: presence
            Chờ cho element/s biến  mất hết: invisible - chỉ cần có ở HTML thôi, k bắt buộc phải nhìn thấy
            Chờ cho element/s có thể click vào được: clickable
            Chờ cho element/s đã được chọn thành công: selected
        */
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
