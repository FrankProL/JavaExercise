package conquer;

/**
 * Created by Frank on 2018/7/11.
 */
public class MergeSort {
    public static void mergeSort(Comparable [] a){
        Comparable [] b = new Comparable[a.length];
        int s = 1;
        while (s<a.length){
            mergePass(a,b,s);
            s+=s;
            mergePass(b,a,s);
            s+=s;
        }
    }

    private static void mergePass(Comparable[] x, Comparable[] y, int s) {
        //合并大小为s的相邻子数组
        int i=0;
        while (i<=x.length-2*s){
            //合并大小为s的相邻2段子数组
            merge(x,y,i,i+s-1,i+2*s-1);
            i=i+2*s;
        }
        //剩下的元素个数少于2s
        if(i+s<x.length)
            merge(x,y,i,i+s-1,x.length-1);
        else
            //复制到y
            for (int j=i;j<x.length;j++)
                y[j]=x[j];
    }

    private static void merge(Comparable[] x, Comparable[] y, int i, int i1, int i2) {

    }
}
