package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_01_Assert {
    @Test
    public void TC_01 (){
        //Kiểm tra dl đúng
        Assert.assertTrue(3<5);

        // KT dữ liệu sai
        Assert.assertFalse(false);

        // KT dl mong  đợi và dl thực tế = nhau
        Assert.assertEquals(15,16);
        Assert.assertEquals("Testing","Manual");
    }
}
