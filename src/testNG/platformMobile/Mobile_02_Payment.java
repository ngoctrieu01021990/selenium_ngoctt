package testNG.platformMobile;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mobile_02_Payment {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @Test(groups = {"platformMobile"})
    public void TC_01_Cheque() {

    }

    @Test(groups = {"platformMobile"})
    public void TC_02_Card() {

    }

    @Test(groups = {"platformMobile"})
    public void TC_02_Cash() {

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}