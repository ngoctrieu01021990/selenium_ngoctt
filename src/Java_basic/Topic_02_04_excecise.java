package Java_basic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_02_04_excecise {

    @Test
    public void TC_01() {
        int a = 6;
        int b = 2;
        System.out.println("Tong" + (a + b));
        System.out.println("Hieu" + (a - b));
        System.out.println("Tich" + (a * b));
        System.out.println("Thuong" + (a / b));
    }

    @Test
    public void TC_02() {
        float width = 7.5f;
        float height = 3.8f;
        System.out.println("Dien tich: " + (width * height));

    }

    @Test
    public void TC_03() {
        String name = "Automation Testing";
        System.out.println("Hello " + name);

    }

    //Bài 2
    @Test
    public void TC_05() {
        int a = 5;
        int b = 6;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a là: " + a);
        System.out.println("b là: " + b);

    }

    //Bài 3
    @Test
    public void TC_06() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập b: ");
        int b = scanner.nextInt();
        if (a > b) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    //Bài 1
    @Test
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Hiển thị yêu cầu nhập tên
        System.out.print("Nhập tên: ");
        // Đọc tên (bao gồm cả khoảng trắng)
        String name = scanner.nextLine();

        // Hiển thị yêu cầu nhập tên
        System.out.print("Nhập tuổi: ");
        String age = scanner.nextLine();

        // Hiển thị tên đã nhập
        System.out.println("After 15 years, age of " + name + " will be " + age);

        // Đóng đối tượng scanner
        scanner.close();
    }
}
