package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_Excercise_Register {
    WebDriver driver;

    @BeforeClass
    public void beforClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_register_emptydata() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("");
        driver.findElement(By.cssSelector("div.frmRegister button.btn_pink_sm")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void TC_02_InvalidEmail() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Jon");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("Jon@ken@us");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("Jon@ken@us");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("div.frmRegister button.btn_pink_sm")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Jon");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("Jon@us");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("Jon@ke1n@us");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("div.frmRegister button.btn_pink_sm")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC_04_InvalidPass() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Jon");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("Jon@us");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("Jon@us");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("12345");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("12345");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("div.frmRegister button.btn_pink_sm")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");

    }

    @Test
    public void TC_05_Incorrect_ConfirmPass() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Jon");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("Jon@us");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("Jon@us");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("12345");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("div.frmRegister button.btn_pink_sm")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");

    }

    @Test
    public void TC_06_InvalidPhone() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Jon");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("Jon@us");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("Jon@us");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        //phone không bắt đầu =0
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("54321");
        driver.findElement(By.cssSelector("div.frmRegister button.btn_pink_sm")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

        // phone < 10 số
        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("054321");
        driver.findElement(By.cssSelector("div.frmRegister button.btn_pink_sm")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // nhập vào k đúng định dạng số
        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("sfdf");
        driver.findElement(By.cssSelector("div.frmRegister button.btn_pink_sm")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(), "Vui lòng nhập con số");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
