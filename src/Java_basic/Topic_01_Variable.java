package Java_basic;

public class Topic_01_Variable {
    static int studentNumber;
    static boolean status;
    String studentName = "AutoFC";

    public static void main(String[] args) {
        System.out.println(studentNumber);
        System.out.println(status);
    }

    public String getStudentNumber() {
        return studentName;

    }
    public void setStudentName(String stdName)
    {
        this.studentName = stdName;
    }
}
