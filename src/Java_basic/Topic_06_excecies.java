package Java_basic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_06_excecies {
    Scanner scanner = new Scanner(System.in);

    //Bài 1
    @Test
    public void Bai_1() {

        System.out.print("Nhập số n: ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.print("Số " + number + " là số chẵn");
        } else {
            System.out.print("Số lẻ");
        }
    }

    //Ba 2
    @Test
    public void Bai_2() {
        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();

        if (a >= b) {
            System.out.print(a + " lớn hơn hoặc bằng " + b);
        } else {
            System.out.print(a + " nhỏ hơn " + b);
        }
    }

    @Test
    public void Bai_03() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên bạn A: ");
        String aName = scanner.nextLine();
        System.out.print("Nhập tên bạn B: ");
        String bName = scanner.nextLine();

        if (aName.equals(bName)) {
            System.out.print("2 người cùng tên");
        } else {
            System.out.print("2 người khác tên");
        }
    }

    @Test
    public void Bai_4() {

        System.out.print("Nhập số a: ");
        int aNumber = scanner.nextInt();

        System.out.print("Nhập số b: ");
        int bNumber = scanner.nextInt();

        System.out.print("Nhập số c: ");
        int cNumber = scanner.nextInt();

        if (aNumber > bNumber && aNumber > cNumber) {
            System.out.print("Số lớn nhất là: " + aNumber);
        } else if (bNumber > aNumber && bNumber > cNumber) {
            System.out.print("Số lớn nhất là: " + bNumber);
        } else {
            System.out.print("Số lớn nhất là: " + cNumber);
        }
    }

    @Test
    public void Bai_5() {
        System.out.print("Nhập số a: ");
        int aNumber = scanner.nextInt();

        if (aNumber > 10 && aNumber < 100) {
            System.out.print("a nằm trong khoảng 10-100");
        } else {
            System.out.print("a nằm ngoài khoảng 10-100");
        }
    }

    @Test
    public void Bai_6() {

        System.out.print("Nhập điểm: ");
        double diem = scanner.nextDouble();

        if (diem >= 0 && diem < 5) {
            System.out.print("Xếp loại D");
        } else if (diem >= 5 && diem < 7.5) {
            System.out.print("Xếp loại C");
        } else if (diem >= 7.5 && diem < 8.5) {
            System.out.print("Xếp loại B");
        } else if (diem >= 8. && diem <= 10) {
            System.out.print("Xếp loại A");
        } else {
            System.out.print("Không xếp loại được");
        }
    }

    @Test
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào tháng: ");
        int month = scanner.nextInt();

        if (month== 1 || month == 3 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.print("Tháng có 31 ngày");
        } else if (month == 2) {
            System.out.print("Tháng có 28 ngày");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.print("Tháng có 30 ngày");
        } else {
            System.out.print("Không tính được số ngày. Nhập lại tháng");
        }
    }
}
