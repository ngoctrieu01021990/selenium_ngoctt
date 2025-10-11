package testNG.platformWeb;

import org.testng.annotations.*;

public class Web_01_User {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @Test(groups = {"platformWeb","user"})
    public void TC_01_CreateNewUser() {

    }

    @Test(groups = {"platformWeb","user"})
    public void TC_02_EditUser() {

    }

    @Test(groups = {"platformWeb","user"})
    public void TC_02_ViewUser() {

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}