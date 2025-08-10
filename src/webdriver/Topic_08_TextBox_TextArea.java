package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_08_TextBox_TextArea {
    WebDriver driver;
    String firstName, lastName, fullName, email, password, employeeId, passportNumber, passportComment;


    @BeforeClass
    public void beforClass() {

        driver = new FirefoxDriver();
        firstName = "Peter";
        lastName = "Crouch";
        fullName = firstName + " " + lastName;
        email = "peter" + new Random().nextInt(999) + "@hotmail.com";
        password = "Test@123";
        passportNumber="43216722";
        passportComment="Assigned Immigration \nRecords";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Techpanda() {

        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//div[@class='buttons-set']//a[@title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(email);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");

        String contact = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contact.contains(fullName));
        Assert.assertTrue(contact.contains(email));
        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        //Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getDomAttribute("value"),firstName);
        //or, với getDomProperty sẽ cover cho cả getDomAttribute
        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getDomProperty("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getDomProperty("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getDomProperty("value"), email);

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//h2/a[@title='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys("Thank you for registering with/n Main Website Store.");
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Thank you for registering with Main Website Store.");
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(fullName);
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Your review has been accepted for moderation.");
    }

    @Test
    public void TC_02_Orange() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");
        //login
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        // đợi cho all item biến mất
        Assert.assertTrue(isLoadingIconDisappear());

        //verify Dashboard page display
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        // click PIM link
        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        //verify Dashboard page display
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());

        // add employee
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        //tạo employee
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastName);
        employeeId = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getDomProperty("value");
        System.out.println(employeeId);
        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//span")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).clear();
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(email);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).clear();
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(2000);

        // verify success message display
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Successfully Saved']")).isDisplayed());

        // loading icon at add employee page
        Assert.assertTrue(isLoadingIconDisappear());

        // loading icon at personal detail page
        Assert.assertTrue(isLoadingIconDisappear());

        // personal detail page
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getDomProperty("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getDomProperty("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getDomProperty("value"),employeeId);

        //Immigration page
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();

        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(passportComment);

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(2000);

        // verify success message display
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Successfully Saved']")).isDisplayed());
        Assert.assertTrue(isLoadingIconDisappear());

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Passport']/parent::div/following-sibling::div/div[text()='"+
                passportNumber+"']")).isDisplayed());

        //logout
        driver.findElement(By.cssSelector("li.oxd-userdropdown")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        //login = acc được tạo
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        // đợi cho all item biến mất
        Assert.assertTrue(isLoadingIconDisappear());
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        // click vào My Info
        driver.findElement(By.xpath("//span[text()='My Info']/parent::a")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getDomProperty("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getDomProperty("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getDomProperty("value"),employeeId);

        Assert.assertTrue(driver.findElement(By.cssSelector("input[name='firstName']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name='lastName']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());

        //Immigration page
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconDisappear());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Passport']/parent::div/following-sibling::div/div[text()='"+
                passportNumber+"']")).isDisplayed());
    }

    private Boolean isLoadingIconDisappear() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
