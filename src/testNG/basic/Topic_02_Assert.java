package testNG.basic;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Topic_02_Assert {
    @Test
    public void TC_01_Login(){
        // bắt buộc kiểu dl trả về là boolean
        // selenium: tiền tố là isXXX: isDisplayed/isSelected/isEnabled/...
        // hoặc hàm tự define trả về boolean
        // assert true: khi cần kt dữ liệu trả về là đúng
        // assert false: khi cần kt dữ liệu trả về là sai
        Assert.assertTrue(5>3);
        Assert.assertFalse(5<3);

        // equals: kt dữ liệu mong đợi & thực tế giống nhau
        // 2 vế đều cùng 1 kiểu dl
        // kt về giá trị & kiểu dữ liệu
        String studentName="Nguyễn Văn A";
        Assert.assertEquals(studentName,"Nguyễn Văn A");

        Object name ="Nguyễn Văn A";
        Assert.assertEquals(studentName,name);

        int inumber=10;
        float fnumber=10;
        Assert.assertEquals(inumber,fnumber);
    }
}
