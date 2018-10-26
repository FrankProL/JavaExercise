package recursion;

/**
 * 整数划分问题
 * 将正整数n表示成一系列正整数之和
 * 将最大加数不大于m的划分个数记为q(n,m)
 * q(n,m)=
 *      1                   n=1,m=1
 *      q(n,n)              n<m
 *      q(n,n-1)+1          n=m
 *      q(n,m-1)+q(n-m,m)   n>m>1
 * Created by Frank on 2018/7/10.
 */
public class IntSplit {
    public static int q(int n,int m){
        if(n<1 | m<1) return 0;
        if(n==1 | m==1) return 1;
        if(n<m) return q(n,n);
        if(n==m) return q(n,m-1)+1;
        return q(n,m-1)+q(n-m,m);
    }

    public static void main(String[] args) {
        System.out.println(q(6,6));
    }
}
