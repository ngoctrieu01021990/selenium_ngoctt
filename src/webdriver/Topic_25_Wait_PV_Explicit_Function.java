package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class Topic_25_Wait_PV_Explicit_Function {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void TC_01() {

        // đợi cho tới khi thỏa mãn đk là Alert đc presence
        explicitWait.until(ExpectedConditions.alertIsPresent());

        // 1. element visible (cho 1/ nhiều/tham số là gì)
        // visibilityOfAllElements đã tìm element rồi --> k cần tìm lại
        WebElement emailTextBox = (WebElement) explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("input#email"))));
        emailTextBox.sendKeys("automation@gmail.com");

        // phải tìm lại element
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");

        //truyền nhiều element khác nhau
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElement(By.cssSelector("input#email")),
                driver.findElement(By.cssSelector("input#name")),
                driver.findElement(By.cssSelector("input#password"))));

        //truyền nhiều element giống nhau
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("input[type='text']"))));

        // 2. element invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // 3. element presence
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // 4. element staleness
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // 5. element clickable
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // 6. element selected
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // 7. element có sl =? (ít hơn/=/ nhiều hơn)
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""),5));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""),5));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""),5));

        // 8. kết hợp 2 đk (and/or/not)
        // cả 2 đk đúng
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")),
                ExpectedConditions.elementToBeClickable(By.cssSelector(""))));

        // 1 trong 2 đk đúng
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")),
                ExpectedConditions.elementToBeClickable(By.cssSelector(""))));

        // phủ định đk = invisibilityOfElementLocated
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))));

        // 9. URL/title/text/
        explicitWait.until(ExpectedConditions.urlToBe(""));
        explicitWait.until(ExpectedConditions.urlContains(""));
        explicitWait.until(ExpectedConditions.urlMatches(""));

        explicitWait.until(ExpectedConditions.titleIs(""));
        explicitWait.until(ExpectedConditions.titleContains(""));

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""),"Automation"));
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""), Pattern.compile("")));
        explicitWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("")),"Automation"));

        //10. Attribute/ DOM property/ Frame
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"class","email"));

        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),"textContent","Hello"));
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),"id","finish"));

        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("facebook"));//text
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));//dùng index
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));//dùng index
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
