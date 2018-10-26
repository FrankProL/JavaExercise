package exercise;

/**
 * Created by Frank on 2018/8/24.
 * 静态代码块
 */
public class StaticTest {
    static {
        System.out.println("static println");
    }

    {
        System.out.println("{} println");
    }

    public StaticTest() {
        System.out.println("construct println");
    }

//    public static void main(String[] args) {
//        StaticTest st= new StaticTest();
//    }
}

class StaticTestChild extends StaticTest{
    static{
        System.out.println("child static println");
    }

    {
        System.out.println("child {} println");
    }

    public StaticTestChild() {
        System.out.println("child construct println");
    }

    public static void main(String[] args) {
        StaticTestChild stc= new StaticTestChild();
    }
}
