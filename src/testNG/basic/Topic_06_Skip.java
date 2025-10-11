package testNG.basic;

import org.testng.annotations.Test;

public class Topic_06_Skip {

    @Test
    public void TM_01_Regiter() {
        System.out.println("Register new account");
    }

    @Test(enabled = false) //bỏ qua k chạy
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

    //@Test  --> cũng bỏ qua không chạy
    public void TM_05_Ship() {
        System.out.println("Ship product");
    }

}
