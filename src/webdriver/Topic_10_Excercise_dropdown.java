package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_10_Excercise_dropdown {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        //driver.manage().window().setSize(new Dimension(1366,768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// chờ cho việc tìm kiếm element
        driver.manage().window().maximize();

        jsExecutor = (JavascriptExecutor) driver;//ép kiểu sang driver
    }
    @Test
    private void selectMultipleItemInDropdown(String multiSelectXPath, String childXPath, String[] expectedItem) throws InterruptedException {
        driver.get("http://multiple-select.wenzhixin.net.cn/templates/template.html?v=189&url=basic.html");
        //1. click vào dropdown cho xổ hết ra giá trị
        driver.findElement(By.xpath("//div[@class='ms-parent multiple-select ms-parent-open']/button[@class='ms-choice']")).click();
        driver.findElement(By.xpath("//div[@class='ms-parent multiple-select ms-parent-open']/button[@class='ms-choice']")).sendKeys("February, March");
        Thread.sleep(2000);

        //2.chờ cho tất cả giá trị trong dropdown được load ra thành công
        List<WebElement> allItem = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ms-parent multiple-select ms-parent-open']//div[@class='ms-drop bottom']/ul/li//span")));

        // duyệt qua hết các phần tử cho tới khi thỏa mãn đk
        for (WebElement childElement : allItem) {
            for (String item : expectedItem) {
                if (childElement.getText().equals(item)) {
                    //3. scroll đến item cần chọn (nếu item có thể nhìn thấy thì k cần scroll)
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                    Thread.sleep(2000);

                    //4. click vào item cần chọn
                    childElement.click();
                    Thread.sleep(2000);

                    List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='option-level-0 selected']//input"));
                    System.out.println("Item selected: " + itemSelected.size());
                    if (expectedItem.length == itemSelected.size()) {
                        break;
                    }

                }
            }
        }
    }

    @Test
    public boolean areItemSelected(String[] months) {
        List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='option-level-0 selected']//input"));
        int numberItemSelected = itemSelected.size();
        String allItemSelectedText = driver.findElement(By.xpath("(//button[@class='ms-choice']/span)[1]")).getText();
        System.out.println("item selected: " + allItemSelectedText);
        if (numberItemSelected <= 3 && numberItemSelected > 0) {
            boolean status = true;
            for (String item : months) {
                if (!allItemSelectedText.contains(item)) {
                    status = false;
                    return status;
                }
            }
            return status;
        } else if (numberItemSelected >= 12) {
            return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='All selected']")).isDisplayed();
        } else if (numberItemSelected > 3 && numberItemSelected < 12) {
            return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='" + numberItemSelected + " of 12 selected']")).isDisplayed();
        } else {
            return false;
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
