package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_07_Element_command {

    @Test
    public void TC_01() {
        WebDriver driver = new FirefoxDriver();

        //** click vào element dạng button, radio, checkbox, link, image,...
        driver.findElement(By.cssSelector("")).click();

        //**  nhập liệu vào element cho phép edit (editable): textbox, textArea/ editable dropdown
        driver.findElement(By.cssSelector("")).clear();//xóa dl trước khi nhập
        driver.findElement(By.cssSelector("")).sendKeys("");// nhập và gửi data đi

        driver.findElement(By.cssSelector("a")).findElement(By.cssSelector("b"));// cho phép find element nhiều lần
        //--> có thể gộp cho gọn như sau:
        driver.findElement(By.cssSelector("a>b"));

        // Kt 1 element là enable/disable
        //* Áp dụng cho tất cả các loại element
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isEnabled());

        // KT 1 element là hiển thị hay k hiển thị
        // thấy trên UI + kích thước >0
        // ** áp dụng cho tất cả caác loại element
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());

        // KT 1 element được chọn hay chưa
        // áp dụng cho check box, radio, dropdown
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isSelected());// đã chọn
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isSelected());//chưa chọn

        // lấy dl dạng text của các element
        // ** link, header, error msg,....
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(), "This is a required field");

        // Lấy ra giá trị của thuộc tính HTML
        // getAttribute - lỗi thời
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAttribute("Placeholder"), "Search entire store here...");

        //* được thay thế bởi getDomAttribute
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("Placeholder"), "Search entire store here...-- giá trị place holder");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("class"), "input text required-entry");

        // lấy ra giá trị của thuộc tính trong DOM (Document Object Model)
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomProperty("value"), "giá trị nhập vào tại ô search");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("Placeholder"), "Search entire store here...-- giá trị place holder");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("className"), "input text required-entry");

        //* lấy ra giá trị của css- ngôn ngữ của FE
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getCssValue("background-color"), "rgb(51,153,240) -- value màu của background");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getCssValue("font-size"), "13px");

        // Lấy ra chiều rộng/cao của element
        Dimension loginButtonSize = driver.findElement(By.cssSelector("")).getSize();
        loginButtonSize.getHeight();
        loginButtonSize.getWidth();

        // lấy ra vị trí của element so với màn hình
        Point loginButtonLocation = driver.findElement(By.cssSelector("")).getLocation();
        loginButtonLocation.getX();// trục tung
        loginButtonLocation.getY();// trục hoành

        // bao gồm cả location & size
        Rectangle LoginButtonRec = driver.findElement(By.cssSelector("")).getRect();
        LoginButtonRec.getHeight();
        LoginButtonRec.getWidth();
        LoginButtonRec.getX();
        LoginButtonRec.getY();

        loginButtonSize = LoginButtonRec.getDimension();
        loginButtonLocation = LoginButtonRec.getPoint();

        // lấy ra thẻ HTML của element đó
        String elementA = driver.findElement(By.cssSelector("#kenh14-toolbar-wrapper")).getTagName();//trả ra thẻ /div
        driver.findElement(By.cssSelector(elementA + "#kenh14-toolbar-wrapper"));

        //* Xly Shadow DOM
        driver.findElement(By.cssSelector("")).getShadowRoot();

        // chỉ áp dụng cho element nằm trong form
        //tương tự hành vi hửi request lên server
        driver.findElement(By.cssSelector("input#newsletter")).submit();
    }
}
