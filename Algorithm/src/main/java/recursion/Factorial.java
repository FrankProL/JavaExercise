package recursion;

/**
 * 递归定义阶乘函数
 * Created by Frank on 2018/7/9.
 */
public class Factorial {
    public static int factorial(int n )
    {
        if(n==0) return 1;
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        int num=factorial(3);
        System.out.println(num);
    }
}
