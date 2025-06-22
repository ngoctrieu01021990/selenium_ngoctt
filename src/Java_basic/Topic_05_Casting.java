package Java_basic;

public class Topic_05_Casting {
    public static void main(String[] args) {
       //Ngầm định: k mất dl
//        byte bNumber = 126;
//        System.out.println(bNumber);
//        short sNumber = bNumber;
//        System.out.println(sNumber);
//        int iNumber = sNumber;
//        System.out.println(iNumber);

        //Tường minh (casting qua)
        double dNumber=65432133422d;
        System.out.println(dNumber);
        float fNumber= (float) dNumber;
        System.out.println(fNumber);
        long lNumber= (long) fNumber;
        System.out.println(lNumber);


    }
}
