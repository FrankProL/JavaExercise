package exercise;

/**
 * Created by Frank on 2018/8/28.
 * https://github.com/FrankProL/JS-Sorting-Algorithm/blob/master/6.quickSort.md
 * 基于python版快排的java实现
 */
public class QuickSortTest {
    public static int[] quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int partitionIndex=partion(arr,leftIndex,rightIndex);
            quickSort(arr, leftIndex, partitionIndex - 1);
            quickSort(arr,partitionIndex+1,rightIndex);
        }
        return arr;
    }

    public static int partion(int[] arr, int leftIndex, int rightIndex) {
        int pivot=leftIndex;    // 基准位置
        int index=pivot+1;      // index记录小于基准值的后一个位置（初始基准后面第一个值，index左侧都小于等于基准）
        int i=index;            // i 用于遍历元素（基准取最左侧值，从第二个元素开始遍历）
        while (i <= rightIndex) {
            if (arr[i] < arr[pivot]) {      //如果元素值小于基准值
                swap(arr,i,index);          //将i元素交换到index位置,将index元素移动到后边i位置（index到i都是大于基准的值）
                index++;                    //同时index位置后移一位，
            }
            i++;                            //继续判断下一个元素
        }
        swap(arr,pivot,index-1);            //将基准元素和index前面元素交换（index前一个位置是最后一个小于基准的位置）

        return index-1;                     //返回基准元素位置
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 24, 5, 6, 72, 34, 7345, 735, 1231};
        QuickSortTest.quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
