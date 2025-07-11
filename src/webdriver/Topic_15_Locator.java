package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Locator {
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
    public void TC_01_Id(){
        // Tim element: neu can tim 1 element --> dung Element, neu can tim nhieu element --> dung Elements
        driver.findElement(By.id("email"));
    }
    @Test
    public void TC_02_className(){
        // class chi truyen vao 1 phan neu co khoang trang
        // Lay het khi k co khoang trang
        driver.findElement(By.className("input-text required-entry"));
    }

    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("login[username]"));
        driver.findElement(By.name("login[password]"));
        driver.findElement(By.name("login[email]"));
    }

    @Test
    public void TC_04_tagName(){
        // class chi truyen vao 1 phan neu co khoang trang
        // Lay het khi k co khoang trang
        int inPut = driver.findElements(By.tagName("input")).size();
        System.out.println(inPut);
    }

    @Test
    public void TC_05_linkText(){
        // Dung voi duong link
        //Tuong doi: truyen 1 phan duong link
        driver.findElement(By.linkText("MY ACCOUNT"));
        driver.findElement(By.linkText("ORDERS AND RETURNS"));

    }

    @Test
    public void TC_06_Partial_linkText(){
        // Dung voi duong link
        //Tuong doi: truyen 1 phan hoac tat ca duong link
        driver.findElement(By.partialLinkText("ACCOUNT"));
        driver.findElement(By.partialLinkText("ORDERS"));
    }

    @Test
    public void TC_07_CSS(){
        // Css-ID
        driver.findElement(By.cssSelector("input[id='email']"));
        driver.findElement(By.cssSelector("#email"));
        driver.findElement(By.cssSelector("input#email"));

        // Css-class
        driver.findElement(By.cssSelector("div[class='account-login']"));
        driver.findElement(By.cssSelector(".account-login"));
        driver.findElement(By.cssSelector("div.account-login"));

        driver.findElement(By.cssSelector("div[class='col-2 registered-users']"));
        driver.findElement(By.cssSelector(".registered-users"));
        driver.findElement(By.cssSelector("div.registered-users"));
        driver.findElement(By.cssSelector("div.registered-users.col-2"));

        // Css-name
        driver.findElement(By.cssSelector("input[name='login[username]']"));

        // Css-tagName
        driver.findElement(By.cssSelector("input"));

        // Css-Link
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/customer/account/']"));

        // Css-Partial Link
        driver.findElement(By.cssSelector("a[href*='customer/account/']"));
    }

    @Test
    public void TC_08_xPath(){
        // xpath -ID
        driver.findElement(By.xpath("//input[@id='email']"));

        // xpath-class
        driver.findElement(By.xpath("//div[@class='account-login']"));
        driver.findElement(By.xpath("//div[@class='col-2 registered-users']"));

        // xpath-name
        driver.findElement(By.xpath("//input[@name='login[username]']"));

        // xpath-tagName
        driver.findElement(By.xpath("//input"));

        // xpath-Link
        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/customer/account/']"));
        driver.findElement(By.xpath("//a[text()='My Account']"));

        // xpath-Partial Link
        driver.findElement(By.xpath("//a[contains(@href,'customer/account/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
    }

    @Test
    public void Excercise(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtSearch"));
        driver.findElement(By.xpath("//input[@id='txtSearch']"));

        driver.findElement(By.xpath("//span[@class='box-item-login']/a"));
        driver.findElement(By.cssSelector("span[class='box-item-login']>a"));

        driver.findElement(By.cssSelector("span[class='box-item-login bor']>a"));
        driver.findElement(By.xpath("//span[@class='box-item-login bor']/a"));

        driver.findElement(By.xpath("//input[@id='txtFirstname']"));
        driver.findElement(By.cssSelector("input#txtFirstname"));

        driver.findElement(By.xpath("//input[@id='txtEmail']"));
        driver.findElement(By.cssSelector("input#txtEmail"));

        driver.findElement(By.xpath("//input[@id='txtCEmail']"));
        driver.findElement(By.cssSelector("input#txtCEmail"));

        driver.findElement(By.xpath("//input[@id='txtPassword']"));
        driver.findElement(By.cssSelector("input#txtPassword"));

        driver.findElement(By.xpath("//input[@id='txtCPassword']"));
        driver.findElement(By.cssSelector("input#txtCPassword"));

        driver.findElement(By.xpath("//input[@id='txtPhone']"));
        driver.findElement(By.cssSelector("input#txtPhone"));

        driver.findElement(By.xpath("//input[@id='chkRight']"));
        driver.findElement(By.cssSelector("input#chkRight"));

        driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']"));
        driver.findElement(By.cssSelector("div[class='field_btn']>button"));

        driver.findElement(By.xpath("//button[@id='btndknfooter']"));
        driver.findElement(By.cssSelector("button[id='btndknfooter']"));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
