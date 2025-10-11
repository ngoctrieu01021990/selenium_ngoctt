package testNG.basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_05_Priority {
    WebDriver driver;

    //Cách 1
    @Test(priority = 1)
    public void regiter() {
        System.out.println("Register new account");
    }

    @Test(priority = 2)
    public void login() {
        System.out.println("Login to system");
    }

    @Test(priority = 3)
    public void orderProduct() {
        System.out.println("Order product");
    }

    @Test(priority = 4)
    public void pay() {
        System.out.println("Pay product");
    }

    @Test(priority = 5)
    public void ship() {
        System.out.println("Ship product");
    }


    //Cách 2 - Nên dùng
    @Test
    public void TM_01_Regiter() {
        System.out.println("Register new account");
    }

    @Test
    public void TM_02_Login() {
        System.out.println("Login to system");
    }

    @Test
    public void TM_03_OrderProduct() {
        System.out.println("Order product");
    }

    @Test
    public void TM_04_Pay() {
        System.out.println("Pay product");
    }

    @Test
    public void TM_05_Ship() {
        System.out.println("Ship product");
    }

}
