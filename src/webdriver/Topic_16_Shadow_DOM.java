package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_16_Shadow_DOM {
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
    public void TC_01_Home_Shop() {
        driver.get("https://shop.polymer-project.org/");

        //bắt buộc phải switch qua mới thao tác được: Alert, Window/Tab, Shadow, Frame/iframe
        // Shadown chỉ hỗ trợ css

        WebElement shopAppShadowHost = driver.findElement(By.cssSelector("shop-app"));
        SearchContext shopAppShadowRoot = shopAppShadowHost.getShadowRoot();

        WebElement shopHomeShadowHost = shopAppShadowRoot.findElement(By.cssSelector("iron-pages>shop-home"));
        SearchContext shopHomeShadowRoot = shopHomeShadowHost.getShadowRoot();
        shopHomeShadowRoot.findElement(By.cssSelector("a[href*='mens_outerwear']~shop-button")).click();
    }

    @Test
    public void TC_02_Nested() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        //driver đang thao tác với dom bên ngoài, chưa vào shadow
        Assert.assertEquals(driver.findElement(By.xpath("//a")).getText(), "scroll.html");
        Assert.assertEquals(driver.findElements(By.xpath("//a")).size(), 1);

        //switch qua
        WebElement firstShadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext firstShadowRoot = firstShadowHost.getShadowRoot();

        // thao tác với shadow dom đầu tiên
        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText(), "some text");
        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("a")).getText(), "nested scroll.html");
        Assert.assertEquals(firstShadowRoot.findElements(By.cssSelector("a")).size(), 1);

        //switch
        WebElement secondShadowHost = firstShadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext secondShadowRoot = secondShadowHost.getShadowRoot();

        // Thao tác với shadow dom thứ 2
        Assert.assertEquals(secondShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(), "nested text");
    }

    @Test
    public void TC_03() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(4000);

        WebElement bookAppShadowHost = driver.findElement(By.cssSelector("book-app"));
        SearchContext bookAppShadowRoot = bookAppShadowHost.getShadowRoot();

        bookAppShadowRoot.findElement(By.cssSelector("book-input-decorator>input#input")).sendKeys("Harry Potter");

        WebElement bookDecoratorHost = bookAppShadowRoot.findElement(By.cssSelector("book-input-decorator"));
        SearchContext bookDecoratorRoot = bookDecoratorHost.getShadowRoot();

        bookDecoratorRoot.findElement(By.cssSelector("div.icon")).click();

        bookAppShadowHost = driver.findElement(By.cssSelector("book-app"));
        bookAppShadowRoot = bookAppShadowHost.getShadowRoot();

        WebElement bookExplorerShadowHost = bookAppShadowRoot.findElement(By.cssSelector("book-explore"));
        SearchContext bookExplorerShadowRoot = bookExplorerShadowHost.getShadowRoot();
        Thread.sleep(3000);

        List<WebElement> listBookItems = bookExplorerShadowRoot.findElements(By.cssSelector("section>ul.books>li>book-item"));

        for (WebElement bookItem : listBookItems) {
            SearchContext bookItemShadowRoot = bookItem.getShadowRoot();
            System.out.println(bookItemShadowRoot.findElement(By.cssSelector("div.title-container>h2.title")).getText());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
