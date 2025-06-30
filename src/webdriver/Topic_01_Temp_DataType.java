package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Temp_DataType {
    WebDriver driver;// Khai báo biến
    @BeforeClass
    public void beforeClass(){// Khoi tạo dl: class, browser, driver, test, page,...>> Pre condition
    driver = new FirefoxDriver();
    driver.get("https://www.facebook.com/");
    }
    //Từ selenium 1,2,3,4 đều có 8 loại locator:
    // ID (Chạy nhanh nhất)
    // class/className (Chạy nhanh nhất)
    // Name, tagName (gần như k dùng)
    // LinkText (gần như k dùng)
    // Partial LinkText (gần như k dùng)
    // Css Selector (dùng nhiều nhất: corver hết các TH của 6 loại trên)
    // Xpath (dùng nhiều nhất:  corver hết các TH của 7 loại trên)

    //1. Kiểu dl nguyên thủy
    //Kieu ky tu: Chart
    //So nguyen: Byte, Short, int, long
    //So thuc: float, double
    // Logic: boolean

    // 2. Kiểu dữ liệu tham chiếu
    // Kieu chuoi: String
    //Array
    //List/Set/Queue
    // Class/Object

    @Test
    public void TC_01_Login() {// Test case

    }

    @AfterClass
    public void afterClass(){// Xóa dl
        driver.quit();
    }
}
