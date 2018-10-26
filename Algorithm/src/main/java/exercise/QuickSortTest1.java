package exercise;

/**
 * Created by Frank on 2018/9/3.
 * https://mp.weixin.qq.com/s/9WSCS1rgMuf5tXIALRLFfw
 * 快速排序-挖坑法
 */
public class QuickSortTest1 {
    public static int[] quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, pivot - 1);
            quickSort(arr,pivot+1,rightIndex);
        }
        return arr;
    }

    public static int partition(int[] arr, int leftIndex, int rightIndex) {
        int pivot=arr[leftIndex];       // 取第一个位置的元素作为基准元素，保存该元素值
        int index=leftIndex;            // 记录坑的位置，初始等于pivot的位置
        while (leftIndex < rightIndex) {        //大循环在左右指针重合或者交错时结束
            while (leftIndex < rightIndex) {
                if (arr[rightIndex] < pivot) {      //right指针从右向左进行比较
                    arr[index] = arr[rightIndex];
                    index=rightIndex;
                    leftIndex++;
                    break;
                }
                rightIndex--;
            }

            while (leftIndex < rightIndex) {
                if (arr[leftIndex] > pivot) {       //left指针从左向右进行比较
                    arr[index] = arr[leftIndex];
                    index=leftIndex;
                    rightIndex--;
                    break;
                }
                leftIndex++;
            }
        }
        arr[index]=pivot;
        return index;
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2481, 23415, 435356, 7658, 345, 8769, 8, 34, 4352, 432};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
