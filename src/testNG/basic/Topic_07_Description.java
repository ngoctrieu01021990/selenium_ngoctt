package testNG.basic;

import org.testng.annotations.Test;

public class Topic_07_Description {

    @Test(description = "Azure#99958 - Register new account")// thêm mô tả chạy test case nào? id bao nhiêu trên Azure/Jira,...
    public void TM_01_Regiter() {
        System.out.println("Register new account");
    }

    @Test(description = "Azure#99959 - Login system success")
    public void TM_02_Login() {
        System.out.println("Login to system");
    }

    @Test(description = "Azure#99960 - Order product")
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
