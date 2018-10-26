package recursion;

/**
 * 双递归函数---当一个函数以及它的一个自变量是由函数自身定义时，这个函数称为双递归函数
 * Ackerman函数A(m,n)有两个独立的整数变量m>=0和n>=0
 *      A(1,0)=2
 *      A(0,n)=1                    n>=0
 *      A(m,0)=m+2                  m>=2
 *      A(m,n)=A(A(m-1,n),n-1)      m,n>=1
 * A(m,n)的自变量n的每一值都定义了一个单变量函数
 * 单变量函数A(n)定义为A(n)=A(n,n),其拟逆函数a(n)在算法分析中经常遇到
 * Created by Frank on 2018/7/9.
 */
public class Ackerman {
    public static int ackerman(int m,int n){
        if (m==1 & n==0) return 2;
        if (m==0 & n>=0) return 1;
        if (n==0 & m>=2) return m+2;
        return ackerman(ackerman(m-1,n),n-1);
    }

    public static void main(String[] args) {
        System.out.println(ackerman(1,1));
        System.out.println(ackerman(0,8));
        System.out.println(ackerman(8,0));
        System.out.println(ackerman(2,2));
    }
}
