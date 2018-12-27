package review;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 2018/12/12.
 *  判断数组中是否包含特定值
 * 直接循环判断效率最高，如果有序可以使用Arrays.binarySearch()
 * 其次可以使用List，简便，不过效率会降低
 */
public class ContainsValue {
    //使用List
    public static boolean useList(String[] arr,String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }
    //使用Set
    /*This inspection reports all new expressions with type arguments which can be replaced with diamond type <>
Such <> syntax is not supported under Java 1.6 or earlier JVMs.  HashSet<String>中String可省略*/
    public static boolean useSet(String[] arr,String targetValue) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        return set.contains(targetValue);
    }
    //使用循环判断
    public static boolean useLoop(String[] arr,String targetValue) {
        for(String str:arr) {
            if(str.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }
    //use Arrays.binarySearch()
    //Arrays.binarySearch()方法只能用于有序数组！！！如果数组无序的话得到的结果就会很奇怪。
    public static boolean useArraysBinarySearch(String[] arr,String targetValue) {
        int a = Arrays.binarySearch(arr, targetValue);
        /*if(a > 0 ) {
            return true;
        }else {
            return false;
        }  此处可由下句替换*/
        return a>0;
    }
    // 测试
    public static void main(String[] args) {
        String[] arr = new String[] {  "CD",  "BC", "EF", "DE", "AB"};

        //use list
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useList(arr, "A");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("useList:  " + duration / 1000000);

        //use set
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useSet(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useSet:  " + duration / 1000000);

        //use loop
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useLoop(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useLoop:  " + duration / 1000000);

        //use Arrays.binarySearch()
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useArraysBinarySearch(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useArrayBinary:  " + duration / 1000000);

    }
}
