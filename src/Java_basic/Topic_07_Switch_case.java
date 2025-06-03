package Java_basic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_07_Switch_case {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void Bai_03() {

        System.out.print("Nhập vào tháng: ");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print("Tháng có 31 ngày");
                break;
            case 2:
                System.out.print("Tháng có 28 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("Tháng có 30 ngày");
                break;
            default:
                System.out.print("Tháng vừa nhập không đúng");
                break;
        }
    }

    @Test
    public void Bai_01() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số A: ");
        int aNumber = scanner.nextInt();

        switch (aNumber) {
            case 1:
                System.out.print("One");
                break;
            case 2:
                System.out.print("Two");
                break;
            case 3:
                System.out.print("Three");
                break;
            case 4:
                System.out.print("Four");
                break;
            case 5:
                System.out.print("Five");
                break;
            case 6:
                System.out.print("Six");
                break;
            case 7:
                System.out.print("Seven");
                break;
            case 8:
                System.out.print("Eight");
                break;
            case 9:
                System.out.print("Nine");
                break;
            case 10:
                System.out.print("Ten");
                break;
        }
    }

    @Test
    public void Bai_2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số A: ");
        int aNumber = scanner.nextInt();
        System.out.print("Nhập vào số B: ");
        int bNumber = scanner.nextInt();
        System.out.print("Nhập vào toán tử: ");
        String operator = scanner.next();
        switch (operator) {
            case "+":
                System.out.print("Tổng: " + (aNumber + bNumber));
                break;
            case "-":
                System.out.print("Hiệu: " + (aNumber - bNumber));
                break;
            case "*":
                System.out.print("Tích: " + (aNumber * bNumber));
                break;
            case "/":
                System.out.print("Thương: " + (aNumber / bNumber));
                break;
            case "%":
                System.out.print("Thương A%B: " + (aNumber % bNumber));
                break;
        }
    }

    @Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số A: ");
        int aNumber = scanner.nextInt();

        switch (aNumber) {
            case 1:
                System.out.print("One");
                break;
            case 2:
                System.out.print("Two");
                break;
            case 3:
                System.out.print("Three");
                break;
            case 4:
                System.out.print("Four");
                break;
            case 5:
                System.out.print("Five");
                break;
            case 6:
                System.out.print("Six");
                break;
            case 7:
                System.out.print("Seven");
                break;
            case 8:
                System.out.print("Eight");
                break;
            case 9:
                System.out.print("Nine");
                break;
            case 10:
                System.out.print("Ten");
                break;
        }
    }
}
