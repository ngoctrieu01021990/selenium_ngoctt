package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Locator {
    // Khai bao bien dai dien cho selenium webdriver
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        // Khoi tao trinh duyet firefox len
        driver = new FirefoxDriver();

        // mo URL bat ky
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
    }

    @Test
    public void TC_01_id(){
        // Tim element: neu can tim 1 element --> dung Element, neu can tim nhieu element --> dung Elements
        driver.findElement(By.id("email"));
    }
    @Test
    public void TC_02_className(){
        // class chi truyen vao 1 phan neu co khoang trang
        // Lay het khi k co khoang trang
        driver.findElements(By.className("input-text required-entry"));
    }

    @Test
    public void TC_03_tagName(){
        // class chi truyen vao 1 phan neu co khoang trang
        // Lay het khi k co khoang trang
        int inPut = driver.findElements(By.tagName("input")).size();
        System.out.println(inPut);
    }
    @Test
    public void TC_04_linkText(){
        // Dung voi duong link
        //Tuyet doi: truyen ca duong link
        int inPut = driver.findElements(By.tagName("input")).size();
        System.out.println(inPut);
    }

    @Test
    public void TC_05_linkText(){
        // Dung voi duong link
        //Tuong doi: truyen 1 phan duong link
        driver.findElements(By.linkText("MY ACCOUNT"));
        driver.findElements(By.linkText("ORDERS AND RETURNS"));

    }

    @Test
    public void TC_06_Partial_linkText(){
        // Dung voi duong link
        //Tuong doi: truyen 1 phan hoac tat ca duong link
        driver.findElements(By.partialLinkText("ACCOUNT"));
        driver.findElements(By.partialLinkText("ORDERS"));
    }

    @Test
    public void TC_07_CSS(){
        // Css-ID
        driver.findElements(By.cssSelector("input[id='email']"));
        driver.findElements(By.cssSelector("#email"));
        driver.findElements(By.cssSelector("input#email"));

        // Css-class
        driver.findElements(By.cssSelector("div[class='account-login']"));
        driver.findElements(By.cssSelector(".account-login"));
        driver.findElements(By.cssSelector("div.account-login"));

        driver.findElements(By.cssSelector("div[class='col-2 registered-users']"));
        driver.findElements(By.cssSelector(".registered-users"));
        driver.findElements(By.cssSelector("div.registered-users"));
        driver.findElements(By.cssSelector("div.registered-users.col-2"));



        // Css-name
        // Css-tagName
        // Css-Link
        // Css-Partial Link
    }

    @Test
    public void TC_08_xPath(){
        // xpath -ID
        driver.findElements(By.xpath("//input[@id='email']"));

        // xpath-class
        driver.findElements(By.xpath("//div[@class='account-login']"));
        driver.findElements(By.xpath("//div[@class='col-2 registered-users']"));
        // xpath-name
        // xpath-tagName
        // xpath-Link
        // xpath-Partial Link
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
