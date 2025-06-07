package Java_basic;

import java.util.Scanner;

public class Topic_10_White_do_White {
    //white: kt đk trc rồi mới vào phần thân
    //do white: cho chạy phần thân trc ít nhất 1 lần rồi mới kt đk

    public static void main(String[] args) {
        TC_06_do_While();
    }

    public static void TC_01_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        while (n <= 100) {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
            n++;
        }
    }

    public static void TC_01_Do_while() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        do {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
            n++;
        }
        while (n <= 100);
    }

    public static void TC_02_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();
        while (a <= b) {
            if (a % 3 == 0 & a % 5 == 0) {
                System.out.print(a + " ");
            }
            a++;
        }
    }

    public static void TC_02_Do_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();

        do {
            if (a % 3 == 0 & a % 5 == 0) {
                System.out.print(a + " ");
            }
            a++;
        }
        while (a <= b);

    }

    public static void TC_03_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        int i = 1;
        int tong = 0;
        while (i <= n) {
            tong += i;
            i += 2;
        }
        System.out.println(tong);
    }

    public static void TC_03_do_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        int i = 1;
        int tong = 0;
        do {
            tong += i;
            i += 2;

        }
        while (i <= n);
        System.out.println(tong);
    }

    public static void TC_04_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();
        while (a <= b) {
            if (a % 3 == 0) {
                System.out.print(a + " ");
            }
            a++;
        }
    }

    public static void TC_04_do_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();
        do {
            if (a % 3 == 0) {
                System.out.print(a + " ");
            }
            a++;
        }
        while (a <= b);
    }

    public static void TC_05_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        int giaiThua = 1;
        int i = 1;
        while (i <= n) {
            giaiThua *= i;
            i++;
        }
        System.out.println("Giai thừa của n là: "+ giaiThua);
    }

    public static void TC_05_do_While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        int giaiThua = 1;
        int i = 1;
        do {
            giaiThua *= i;
            i++;
        }
        while (i <= n);
        System.out.println("Giai thừa của n là: "+ giaiThua);
    }

    public static void TC_06_While() {
        int i = 1;
        int tong=0;
        while (i <= 10) {
            if (i%2==0)
            tong += i;
            i++;
        }
        System.out.println("Tổng số chẵn từ 1-10 là: "+ tong);
    }

    public static void TC_06_do_While() {
        int i = 1;
        int tong=0;
        do {
            if (i%2==0)
                tong += i;
            i++;
        }
        while (i <= 10) ;
        System.out.println("Tổng số chẵn từ 1-10 là: "+ tong);
    }

}
