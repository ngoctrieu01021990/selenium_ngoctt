package Java_basic;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For_ForEach {
    @Test
    public void TC_01_for() {
        String cityName[] = {"Ha noi", "Da Nang", "Ho Chi Minh", "Can Tho"};
        for (int i = 0; i < cityName.length; i++) {
            if (cityName.equals("Da Nang")) {
                System.out.println("Do Action!");
            }
        }

    }

    @Test
    public void TC_02() {
        // thường dùng cho array/collection
        String cityName[] = {"Ha noi", "Da Nang", "Ho Chi Minh", "Can Tho"};//array
        List<String> cityAddress = new ArrayList<>();//collection
        cityAddress.add("Hai Duong");
        //for each
      /*  for (String city : cityName) {
            System.out.println(city);
        }
        System.out.println(cityAddress.size());
*/

        for (String cityAdd : cityName) {
            System.out.println(cityAdd);
        }
    }
}
