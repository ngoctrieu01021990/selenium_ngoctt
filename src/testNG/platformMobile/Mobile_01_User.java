package testNG.platformMobile;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mobile_01_User {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @Test(groups = {"platformMobile"})
    public void TC_01_CreateNewUser() {

    }

    @Test(groups = {"platformMobile"})
    public void TC_02_EditUser() {

    }

    @Test(groups = {"platformMobile"})
    public void TC_02_ViewUser() {

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}