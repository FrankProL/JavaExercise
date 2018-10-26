package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Frank on 2018/9/3.
 * https://mp.weixin.qq.com/s/9WSCS1rgMuf5tXIALRLFfw
 * 快速排序--指针交换法
 */
public class QuickSortTest2 {
    public static int[] quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, rightIndex);
        }
        return arr;
    }

    public static int partition(int[] arr, int leftIndex, int rightIndex) {
        int pivot=arr[leftIndex];           // 取第一个位置的元素作为基准元素
        int pivotIndex=leftIndex;
        while (leftIndex != rightIndex) {
            while (leftIndex <rightIndex && arr[rightIndex] > pivot) {    //控制right指针比较并左移
                rightIndex--;
            }
            while (leftIndex <rightIndex && arr[leftIndex] <= pivot) {     //控制right指针比较并右移  <=
                leftIndex++;
            }
            if (leftIndex < rightIndex) {               //交换left和right指向的元素
                swap(arr,leftIndex,rightIndex);
            }
        }

        swap(arr,pivotIndex,leftIndex);         //pivot和指针重合点交换

        return leftIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSortWithStack(int[] arr, int leftIndex, int rightIndex) {
        Stack<Map<String,Integer>> quickSortStack=new Stack<Map<String,Integer>>();
        Map rootParam = new HashMap<>();
        rootParam.put("leftIndex", leftIndex);
        rootParam.put("rightIndex", rightIndex);
        quickSortStack.push(rootParam);

        while (!quickSortStack.isEmpty()) {
            Map<String,Integer> param = quickSortStack.pop();
            int pivotIndex = partition(arr, param.get("leftIndex"), param.get("rightIndex"));
            if (param.get("leftIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("leftIndex", param.get("leftIndex"));
                leftParam.put("rightIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex+1<param.get("rightIndex")){
                Map<String,Integer> rightParam=new HashMap<>();
                rightParam.put("leftIndex", pivotIndex + 1);
                rightParam.put("rightIndex", param.get("rightIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2438, 2341, 4362, 56, 354, 75674, 65845, 4, 563, 243};
//        quickSort(arr, 0, arr.length - 1);
        quickSortWithStack(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
