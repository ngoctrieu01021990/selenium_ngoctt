package testNG.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_AAA_Pattern {
    //Arrange
    //Setup/Initial Data/Browser/Driver/Variable/DB/...
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.get("");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }

    //Action
    @Test
    public void register(){
        //----------------Action---------------
        //open page
        //Fill data to from
        //Submit

        //-----------------Assert/Verify---------------
        //Verify success msg

    }
}
