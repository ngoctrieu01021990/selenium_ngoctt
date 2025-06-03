package Java_basic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_08_BaiTap {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void Bai_01() {

        System.out.print("Nhập vào số nguyên n : ");
        int nNumber = scanner.nextInt();
        for (int i = 1; i <= nNumber; i++) {
            System.out.print(i + " ");
        }
        scanner.close();
    }

    @Test
    public void Bai_02() {

        System.out.print("Nhập vào số nguyên a : ");
        int a = scanner.nextInt();

        System.out.print("Nhập vào số nguyên b : ");
        int b = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            System.out.print(i + " ");
        }
        scanner.close();
    }

    @Test
    public void Bai_03() {
        int tong = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {  // Kiểm tra số chẵn
                tong += i;
            }
        }
        System.out.println("Tổng các số chẵn từ 1 đến 10 là: " + tong);

    }

    @Test
    public void Bai_04() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số nguyên a : ");
        int a = scanner.nextInt();

        System.out.print("Nhập vào số nguyên b : ");
        int b = scanner.nextInt();
        int b4tong = 0;
        for (int i = a; i <= b; i++) {
            b4tong += i;
        }
        System.out.println("Tổng là: " + b4tong);

    }

    @Test
    public void Bai_05() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số nguyên n: ");
        int n = scanner.nextInt();
        int tong = 0;
        for (int i = 1; i <= n; i += 2) {
            tong += i;
        }
        System.out.println("Tổng các số lẻ từ 1 đến n là: " + tong);

    }

    @Test
    public void Bai_06() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số nguyên a : ");
        int a = scanner.nextInt();

        System.out.print("Nhập vào số nguyên b : ");
        int b = scanner.nextInt();
        System.out.print("Dãy số chia hết cho 3 từ " + a + " đến " + b + " là: ");
        for (int i = a; i <= b; i++)
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số nguyên n : ");
        int n = scanner.nextInt();

        int giaiThua = 1;
        for (int i = 1; i <= n; i++)
            giaiThua *= i;
        System.out.println("Giai thừa của n là: " + giaiThua);

    }

}
