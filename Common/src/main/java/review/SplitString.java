package review;

import java.util.Scanner;

/**
 * Created by Frank on 2018/12/17.
 * 截取指定长度字符串
 */
public class SplitString {
    public static void main(String[] args) {
        System.out.println("输入：");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("输入要截取的长度：");
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();

        splitString(str, len);
    }

    public static void splitString(String str, int len) {
        if (null == str) {
            System.out.println("the string is null");
            return;
        }
        int byteNum=0;
        byte[] bt = str.getBytes();
        byteNum = bt.length;
        if (len > byteNum) {
            len = byteNum;
            str = new String(bt, 0, len);
            System.out.println(str);
        } else {
            str = new String(bt, 0, len);
            System.out.println(str);
        }
    }
}
