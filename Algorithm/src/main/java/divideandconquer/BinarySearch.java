package divideandconquer;

/**
 * 二分搜索算法
 * 从n个已经排好序的元素中找出一个特定元素x
 * 二分搜索充分利用了元素间的次序关系，采用分治策略，最坏的情况下用O(logn)的时间完成搜索任务
 * 每一次while循环，待搜索的数组大小减少一半
 * Created by Frank on 2018/7/10.
 */
public class BinarySearch {
    public static int binarySearch(int [] a,int x,int n){
        int left = 0 ;int right=n-1;
        while (left<=right){
            int middle=(left+right)/2;
            if(x==a[middle])
                return middle;
            if(x>a[middle])
                left=middle+1;
            else
                right=middle-1;
        }
        return -1;              //未找到x
    }

    public static void main(String[] args) {
        int [] array={1,2,3,4,5};
        System.out.println("index:"+binarySearch(array, 4, array.length));
    }
}
