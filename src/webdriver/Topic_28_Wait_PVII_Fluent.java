package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_28_Wait_PVII_Fluent {
    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait;
    FluentWait<WebElement> elementFluentWait;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15),Duration.ofMillis(200));
    }

    @Test
    public void TC_01_Fluent() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        clickToElement("div#start>button");

        String helloText = getElementText("div#finish>h4");

        Assert.assertEquals(helloText, "Hello World!");
    }

    @Test
    public void TC_02_Fluent() {
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countdownElement = getElement("div#javascript_countdown_time");

        elementFluentWait = new FluentWait<>(countdownElement);

        elementFluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        Assert.assertTrue(elementFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                String text = element.getText();
                System.out.println("Text: " + text);
                return text.endsWith("00");
            }
        }));
    }

    @Test
    public void TC_03_WebdriverWait() {
        driver.get("https://automationfc.github.io/fluent-wait/");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='javascript_countdown_time' and text()='01:01:00']")));
    }

    //Viết hàm để sửa lại các hàm findElement/click/getText/isDisplayed với pooling time mới
    private WebElement getElement(String cssLocator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(cssLocator));
            }
        });
    }

    private void clickToElement(String cssLocator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector(cssLocator));
                    }
                }).click();
    }

    private String getElementText(String cssLocator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);//khai báo & khởi tạo

        return fluentWait.withTimeout(Duration.ofSeconds(15))// Tổng thời gian
                .pollingEvery(Duration.ofMillis(100))// Thời gian tìm lại
                .ignoring(NoSuchElementException.class)//nếu gặp exception thì bỏ qua
                .until(new Function<WebDriver, WebElement>() { // ĐK & trả về
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector(cssLocator));
                    }
                }).getText();
    }

    private boolean isElementDisplay(String cssLocator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        return fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector(cssLocator));
                    }
                }).isDisplayed();
    }
    private boolean waitVisible(){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);

        return fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector("")).isDisplayed();
                    }
                });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
