package recursion;

/**
 * 递归定义斐波那契数列
 * 无穷数列1,1,2,3,5,8,13,21,34,55....称为Fibonacci数列
 * Created by Frank on 2018/7/9.
 */
public class Fibonacci {
    public static int fibonacci(int n){
        if (n<1) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
