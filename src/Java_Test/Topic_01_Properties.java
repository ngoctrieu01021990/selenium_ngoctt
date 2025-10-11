package Java_Test;

import org.testng.annotations.Test;

public class Topic_01_Properties {
    @Test
    public static void main(){
        String osName = System.getProperty("os.name");
        String projectPath= System.getProperty("user.dir");
        System.out.println(projectPath);


    }
}
