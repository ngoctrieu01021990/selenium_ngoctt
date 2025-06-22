package Java_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_02_dataType {
    // Primitive type/Value type: kiểu dl nguyên thủy - k có funcion đi theo

    byte bNumber;
    short sNumber;
    int iNumber;
    long lNumber;
    float fNumber = 12.65f;
    double dNumber = 12.65d;

    //reference type: kiểu dl tham chiếu -có funcion đi theo
    //String
    String address = "HCM";

    // Array,
    String[] studentAddress = {address, "Hà nội", "Đà Nẵng"};
    Integer[] studentNumber = {15, 20, 60};

    // class,
    Topic_02_dataType topic;

    // interface,
    WebDriver driver;

    // Object,
    Object aObject;

    // Collection: List/set/queue/map
    List<WebElement> homePageLink = driver.findElements(By.tagName("a"));//Lưu trùng
    Set<String> allWindows = driver.getWindowHandles();// Không lưu trùng
    List<String> productName = new ArrayList<String>();


    public static void main(String[] args) {

    }
}
