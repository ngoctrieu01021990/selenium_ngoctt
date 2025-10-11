package Java_basic;

import java.util.Scanner;

public class Topic_13_String {
    public static void main(String[] args) {
        TC_05();
    }

    public static void kieudlString() {
        String schoolName = "automation testing";
        String scoreName = schoolName.toLowerCase(); // trả ra ở vùng nhớ mới
        System.out.println("KT 2 biến có bằng nhau k?" + schoolName == scoreName);

        String schoolAddress = "Hồ Chí Minh";
        System.out.println("Độ dài: " + schoolName.length());
        System.out.println("Lấy ra ký tự: " + schoolName.charAt(2));
        System.out.println("Nối chuỗi: " + schoolName.concat(schoolAddress));
        System.out.println("Cộng chuỗi: " + schoolName + schoolAddress);
        System.out.println("Kiểm tra 2 chuỗi = nhau tuyệt đối: " + schoolName.equals(scoreName));
        System.out.println("Kiểm tra 2 chuỗi = nhau tuyệt đối: " + schoolName.equals("Automation testing"));
        System.out.println("Kiểm tra 2 chuỗi = nhau tương đối: " + schoolName.equalsIgnoreCase(scoreName));

        //startsWith/endsWith/contains
        System.out.println("Kiểm tra có bắt đầu bằng ký tự/chuỗi ký tự không?: " + schoolName.startsWith("testing"));
        System.out.println("Kiểm tra có kết thúc bằng ký tự/chuỗi ký tự không?: " + schoolName.endsWith("te"));

        //k qtam ký tự ở đầu/giữa/cuối chuỗi
        System.out.println("Kiểm tra có chứa ký tự/chuỗi ký tự không?: " + schoolName.contains("a"));

        System.out.println("Kiểm tra vị trí của 1 ký tự/chuỗi kí tự trong chuỗi?: " + schoolName.indexOf("testing"));
        System.out.println("Kiểm tra vị trí của 1 ký tự/chuỗi kí tự trong chuỗi?: " + schoolName.indexOf("a"));
        System.out.println("Kiểm tra vị trí của 1 ký tự/chuỗi kí tự trong chuỗi?: " + schoolName.indexOf("automation"));

        System.out.println("Tách 1 ký tự/chuỗi kí tự trong chuỗi: " + schoolName.substring(11));
        System.out.println("Tách 1 ký tự/chuỗi kí tự trong chuỗi: " + schoolName.substring(11, 15));

        //split: tách chuỗi thành 1 mảng dựa vào ký tự/chuỗi kí tự
        String result = "View 48 of 132 results";
        String results[] = result.split(" ");
        System.out.println(results[1]);

        // replace
        String product = "$100.00";
        product = product.replace("$", "");
        System.out.println(product);

        float ProductF = Float.parseFloat(product);//convert sang kiểu số thực
        System.out.println(ProductF);

        // convert từ sang thực sang string
        product = String.valueOf(ProductF);
        System.out.println(product);

        String osName = System.getProperty("OS.name");
        System.out.println(osName);

        //cắt khoảng trắng, ký tự xuống dòng, tab
        String hello = " \n  \t Hello ";
        System.out.println(hello.trim());

        //
        String dynamic = "//button[@id='%s']";
        System.out.println("Click" + dynamic);
    }

    public static void TC_01() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi : ");
        String a = scanner.nextLine();
        char courseName[] = a.toCharArray();
        int count = 0;
        for (char charactor : courseName) {
            if (charactor <= 'Z' && charactor >= 'A') {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void TC_02() {
        String a = "Automation Testing 345 Tutorials Online 789";
        String b = a.toLowerCase();
        char courseName[] = b.toCharArray();
        int count = 0;
        for (char charactor : courseName) {
            if (charactor == 'a') {
                count++;
            }
        }
        System.out.println("Số ký tự 'a' có trong chuỗi là: " + count);
        System.out.println("Chuỗi có chứa từ 'Testing' không? " + a.contains("Testing"));
        System.out.println("Chuỗi có bắt đầu bằng từ 'Automation' không? " + a.startsWith("Automation"));
        System.out.println("Chuỗi có kết thúc bằng từ 'Online' không? " + a.endsWith("Online"));
        System.out.println("Vị trí của từ 'Tutorials' trong chuỗi: " + a.indexOf("Tutorials"));
        String c = a.replace("Online", "Offline");
        System.out.println(c);

        for (char charactor : courseName) {
            if (charactor <= '9' && charactor >= '0') {
                count++;
            }
        }
        System.out.println("Số ký tự là số có trong chuỗi là: " + count);

    }

    public static void TC_03() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi : ");
        String input = scanner.nextLine();
        String revert = new StringBuilder(input).reverse().toString();
        System.out.println("Chuỗi đảo ngược lại: " + revert);
    }

    public static void TC_04() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.matches("[789]\\d{9}")) {//[789] - biểu thức chính quy dùng để so khớp; \\d{9} - 1 hoặc nhiều số
            System.out.println("Số điện thoại hợp lệ.");
        } else {
            System.out.println("Số điện thoại không hợp lệ.");
        }
    }

    public static void TC_05() {
        String text = "Convert RGBA color value";
        // so sánh chuỗi tuyệt đối
        System.out.println(text.equals("Convert RGBA color value"));
        System.out.println(text.equals("Convert RGBA color value."));

        // so sánh chuỗi tuyệt đối k phân biệt hoa thường
        System.out.println(text.equalsIgnoreCase("convert rgba color value."));

        // so sánh tương đối
        System.out.println(text.contains("Convert RGBA"));
        System.out.println(text.contains("RGBA"));
        System.out.println(text.contains("color value."));

        System.out.println(text.startsWith("Convert"));
        System.out.println(text.endsWith("value."));

        // tách chuỗi
        String[] textArray = text.split("RGBA");
        for (String temp : textArray) {
            System.out.println(temp);
        }

        //nối chuỗi.
        System.out.println(text.concat("fomat with alpha channel support"));

        System.out.println(text.toLowerCase());
        System.out.println(text.toUpperCase());

        System.out.println(text.charAt(0));
        System.out.println(text.charAt(3));
        System.out.println(text.charAt(text.length() - 1));

        System.out.println(text.compareTo("fomat with alpha channel support"));
        System.out.println(text.indexOf("R"));

        System.out.println(text.isBlank());
        System.out.println(text.isEmpty());
        System.out.println(text.replace("RGBA","Hexa"));

        text="  \nConvert RGBA color value.\n   ";
        System.out.println(text.trim());

    }

}

