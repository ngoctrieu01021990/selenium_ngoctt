package Java_basic;

public class Topic_12_Array {
    int id;
    int age;
    String name;
    double score;

    public static void main(String[] args) {
        TC_07();
    }

    public static void TC_01() {
        int arr[] = {2, 7, 6, 8, 9};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Phần tử lớn nhất" + max);
    }

    public static void TC_02() {
        int arr[] = {2, 7, 6, 8, 9};
        int sum = arr[0] + arr[arr.length - 1];
        System.out.println("Tổng: " + sum);
    }

    public static void TC_03() {
        int arr[] = {2, 7, 6, 8, 9, 16, 17, 20};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void TC_04() {
        int arr[] = {3, -7, 2, 5, 9, -6, 10, 12};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] > 0) {
                sum = sum + arr[i];
            }
        }
        System.out.print(sum);
    }

    public static void TC_05() {
        int arr[] = {3, -7, 2, 5, 9, -6, 10, 12};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 10) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void TC_06() {
        int arr[] = {3, 5, 7, 30, 10, 5, 8, 23, 0, -5};
        int sum = 0;
        double trungBinh = 1d;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            trungBinh = (double) sum / arr.length;
        }
        System.out.println("Tổng các phần tử của mảng: " + sum);
        System.out.print("TB cộng các phần tử của mảng: " + trungBinh);
    }

    // contructor: hàm khởi tạo
    public Topic_12_Array(int id, int age, String name, double score) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.score = score;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Age: " + age);
        System.out.println("Name: " + name);
        System.out.println("Score: " + score);
    }

    public static void TC_07() {
        Topic_12_Array[] student = new Topic_12_Array[4];
        student[0] = new Topic_12_Array(1, 12, "Long", 9.2);
        student[1] = new Topic_12_Array(2, 12, "Hải", 6.9);
        student[2] = new Topic_12_Array(3, 12, "Hoa", 8.5);
        student[3] = new Topic_12_Array(4, 12, "Trang", 7.8);
        for (int i = 0; i < student.length; i++) {
            student[i].display();
        }
    }

}
