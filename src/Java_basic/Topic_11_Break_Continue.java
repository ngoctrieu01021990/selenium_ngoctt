package Java_basic;

import java.util.Scanner;

public class Topic_11_Break_Continue {
    //lưu  trữ các phần từ có kiểu dl giống nhau
    public static void main(String[] args) {
        //break
        for (int i = 0; i <= 5; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }
        // continue
        for (int i = 0; i <= 5; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }

        TC_02();
    }

    public static void TC_01() {
        String[] trinhDuyet = {"Chrome", "Firefox", "IE", "Safari", "Opera", "Edge"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập trình duyệt: ");
        String a = scanner.nextLine();
        for (int i = 0; i < trinhDuyet.length; i++) {
            if (trinhDuyet[i].equals("IE")) {
                continue;
            }
            System.out.println(trinhDuyet[i]);
        }
        System.out.println("-------------------------");
        for (int i = 0; i < trinhDuyet.length; i++) {
            if (trinhDuyet[i].equals("IE")) {
                break;
            }
            System.out.println(trinhDuyet[i]);
        }

    }
    public static void TC_02() {
        String[] thang = {"JAN", "FEB", "MAT", "APR", "MAY", "JUN", "JUL", "AUTH", "SEP", "OCT", "NOV", "DEC"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tháng: ");
        int a = scanner.nextInt();
        for (int i =0; i<thang.length; i++){
            if (a==i+1){
                System.out.println(thang[i]);
                break;
            }
        }

    }


}
