package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_20_Xpath_CSS {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");
        //thuộc tính: //tagName[@attribute='value']
        driver.findElement(By.xpath("//li[@class='success-msg']//span"));
        // hàm: //tagName[function()='value'] hoặc //tagName[function(@attribute,'value')]
        driver.findElement(By.xpath("//span[text()='Sony Xperia was added to your shopping cart.']"));
        driver.findElement(By.xpath("//div[contains(@class,'page-title')]"));
        driver.findElement(By.xpath("//span[starts-with(text(),'Sony Xperia')]"));
    }

    @Test
    public void TC_02_PhuDinh() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        // phủ định
        driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']"));
    }

    @Test
    public void TC_03_StartsWith() {
        driver.get("https://www.lazada.vn/#?");
        // giá trị bắt đầu luôn cố định - từ giữa/cuối là động thì dùng starts-with()
        driver.findElement(By.xpath("//input[starts-with(@data-spm-anchor-id,'a2o4n.homepage')]"));
    }

    @Test
    public void TC_04_index() {
        driver.get("https://live.techpanda.org/index.php/mobile.html");
        // lấy theo index
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[2]"));
        driver.get("https://automationfc.github.io/jquery-selectable/");
        driver.findElement(By.xpath("(//ol[@id='selectable']//li)[3]"));
        driver.findElement(By.xpath("(//ol[@id='selectable']//li)[last()]"));
        driver.findElement(By.xpath("(//ol[@id='selectable']//li)[last()-1]"));
    }

    @Test
    public void TC_05_text() {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Flogin");
        // lấy text =
        driver.findElement(By.xpath("//strong[text()='Your Personal Details']"));
        driver.findElement(By.xpath("//span[text()='First name is required.']"));
        driver.findElement(By.xpath("//a[text()='Compare products list']"));

        //text có index ở đầu/gữa/cuối
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//h5[text()='Michael Jackson']"));
    }

    @Test
    public void TC_06_contains() {
        // lấy được ở index đầu
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//h5[contains(text(),'Hello World!')]"));
        driver.findElement(By.xpath("//h5[contains(text(),'Michael Jackson')]"));

        //contains "." hoặc string() --> text ở bất kỳ vị trí nào cũng lấy được --> chọn cách viết dễ hiểu (string())
        driver.findElement(By.xpath("//h5[contains(.,'Michael Jackson')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'Michael Jackson')]"));
    }

    @Test
    public void TC_07_concat() {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));
    }

    @Test
    public void TC_08_axes() {
        driver.get("https://live.techpanda.org/index.php/mobile.html");

        //từ node con lên note tổ tiên
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/ancestor::div[@class='main']"));

        // từ node con lên node cha: parent
        // node em đi lên node anh: preceding-sibling
        //node anh đi xuống node em: following-sibling
        driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']/button"));
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/button"));

        // đi lên node cha k cần dùng parent: /.. = parent::div
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/.."));
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/parent::div"));

        //----------------------------

        driver.get("https://subscription.packtpub.com/search?query=Selenium&products=Book%20%2B%20AI%20Assistant~Book&released=Available~Early%20Access");
        driver.findElement(By.xpath("//div[text()='Selenium Essentials']/ancestor::a/following-sibling::a//button[@class='cart-btn']"));
        driver.findElement(By.xpath("//div[text()='Learning Selenium Testing Tools - Third Edition']/ancestor::a/following-sibling::a//button[@class='cart-btn']"));

        //----------------------------
        driver.get("https://kajabi.com/pricing");
        driver.findElement(By.xpath("//h2[text()='Kickstarter']//parent::div/following-sibling::a[@id='pricing-kickstarter-annual']"));
        //----------------------------

        driver.get("https://demo.guru99.com/");
        driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td"));
    }

    @Test
    public void TC_09_Xpath_CSS() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        //1. Đi xuống 1 node
        //xpath
        driver.findElement(By.xpath("//div[@class='input-box']/input[@id='search']"));
        // CSS
        driver.findElement(By.cssSelector("div[class='input-box']>input[id='search']"));

        //2. Đi nhiều node
        // xpath
        driver.findElement(By.xpath("//form[@id='search_mini_form']//input[@id='search']"));
        //CSS
        driver.findElement(By.cssSelector("form[id='search_mini_form'] input[id='search']"));

        //3. ID
        // xpath
        driver.findElement(By.xpath("//input[@id='search']"));
        driver.findElement(By.xpath("//div[@class='page-header-container']"));
        // CSS
        driver.findElement(By.cssSelector("input[id='search']"));
        driver.findElement(By.cssSelector("input#search"));
        driver.findElement(By.cssSelector("#search"));

        driver.findElement(By.cssSelector("div[class='page-header-container']"));
        driver.findElement(By.cssSelector("div.page-header-container"));
        driver.findElement(By.cssSelector(".page-header-container"));

        //4. Khoảng trắng đại diện cho việc đi nhiều node --> dùng dấu "." để thay thế
        driver.findElement(By.cssSelector("input.input-text.required-entry"));
        driver.findElement(By.cssSelector("input.validate-email.input-text.required-entry"));

        // 5. attribute & value
        //xpath
        driver.findElement(By.xpath("//div[@class='page-header-container']"));
        //CSS
        driver.findElement(By.cssSelector("div[class='page-header-container']"));

        //6. nhiều attribute
        //and
        // xpath
        driver.findElement(By.xpath("//input[@id='search' and @name='q']"));
        //CSS
        driver.findElement(By.cssSelector("input[id='search'][name='q']"));

        //OR
        // xpath
        driver.findElement(By.xpath("//input[@id='search' or @name='q']"));
        //CSS
        driver.findElement(By.cssSelector("input[id='search'],input[name='q']"));

        //7. Phủ định
        //xpath
        driver.findElement(By.xpath("//input[not(@type='text')]"));
        //CSS
        driver.findElement(By.cssSelector("input:not([type='text'])"));

        //8. Contains
        //xpath: contains attribute, text
        driver.findElement(By.xpath("//input[contains(@placeholder,'entire store')]"));
        // CSS: contains attribute
        driver.findElement(By.cssSelector("input[placeholder*='entire store']"));

        //9. starts-with
        //Xpath
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search entire')]"));
        //CSS
        driver.findElement(By.cssSelector("input[placeholder^='Search entire']"));

        //10. Ends-with
        //xpath: k support
        //CSS
        driver.findElement(By.cssSelector("input[placeholder$='store here...']"));

        //11. Following:sibling
        //Từ node anh xuống node em, lấy toàn bộ node em, node anh-em cùng tên thẻ
        //xpath
        driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div/h2/following-sibling::div"));
        driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div/*"));
        //CSS
        driver.findElement(By.cssSelector("a[title='Xperia']~div>h2~div"));
        driver.findElement(By.cssSelector("a[title='Xperia']~div>*"));

        //Từ node anh xuống node em, lấy node gần kề nhất
        //xpath
        driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div/h2/following-sibling::div[@class='price-box']"));
        //CSS
        driver.findElement(By.cssSelector("a[title='Xperia']~div>h2+div"));

        //12. Đi ngược node
        // xpath hỗ trợ ngc: preceding:sibling/parent/ancestor
        // CSS không hỗ trợ

        //13. text
        // xpath: hỗ trợ text: contains/text/string
        //CSS: không hỗ trợ

        //14. Index
        // vị trí thứ mấy trong cùng node cha
        //xpath
        driver.get("https://automationfc.github.io/jquery-selectable/");
        driver.findElement(By.xpath("//ol[@id='selectable']/li[5]"));
        driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div/*[2]"));
        //CSS
        driver.findElement(By.cssSelector("ol[id='selectable']>li:nth-of-type(2)"));
        driver.findElement(By.cssSelector("a[title='Xperia']~div>*:nth-child(2)"));

        // first
        //xpath
        driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
        //CSS
        driver.findElement(By.cssSelector("ol[id='selectable']>li:nth-of-type(1)"));
        driver.findElement(By.cssSelector("ol[id='selectable']>li:first-of-type"));
        driver.findElement(By.cssSelector("a[title='Xperia']~div>h2:first-child"));

        // last
        //xpath
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()]"));
        //CSS
        driver.findElement(By.cssSelector("ol[id='selectable']>li:last-of-type"));
        driver.findElement(By.cssSelector("a[title='Xperia']~div>div:last-child"));

        // vị trí thứ mấy trong cùng node cha
        //xpath
        driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div/*[1]"));
        driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div/*[2]"));
        //CSS
        driver.findElement(By.cssSelector("a[title='Xperia']~div>h2:nth-child(1)"));
        driver.findElement(By.cssSelector("a[title='Xperia']~div>div:nth-child(2)"));

    }
    @Test
    public void Xpath_CSS_Tip(){
        //1. Kiểm tra lại locator và show Properties ra
        //xpath: $x("xpath")
        // CSS: $$("css")
        //var searchtext = $("input#homeSearch");
        //searchtext.value

        //var searchtext = document.querySelector("input[id='homeSearch']");
       // searchtext.value

        //2. KT xem có bao nhiêu element
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
