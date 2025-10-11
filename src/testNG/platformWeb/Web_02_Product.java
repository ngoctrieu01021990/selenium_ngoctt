package testNG.platformWeb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_02_Product {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @Test(groups = {"platformWeb","Product"})
    public void TC_01_CreateNewProduct() {

    }

    @Test(groups = {"platformWeb","Product"})
    public void TC_02_EditProduct() {

    }

    @Test(groups = {"platformWeb","Product"})
    public void TC_02_ViewProduct() {

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}