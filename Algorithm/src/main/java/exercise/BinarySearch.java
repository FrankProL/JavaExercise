package exercise;

/**
 * Created by Frank on 2018/8/12.
 * 二分查找（折半查找）
 */
public class BinarySearch {
    public static int binarySearch(int[] array,int key) {
        int left=0;
        int right=array.length-1;

        while (left <= right) {
            int mid=(left+right)/2;
            if (key == array[mid]) {
                return mid;
            }
            else if (key < array[mid]) {
                right = mid - 1;
            }
            else left=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int key=5;
        System.out.println(binarySearch(array, key));;
    }
}
