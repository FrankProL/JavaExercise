package exercise.test;

/**
 * Created by Frank on 2018/11/5.
 *
 */
public class TestTriOpera {
    public static void main(String[] args) {
        int a=1;
        int b=3;
        System.out.println(a>b? a:b);

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int[] arr = new int[3];
        int[] brr = {1, 23, 45};
        arr=brr;
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
