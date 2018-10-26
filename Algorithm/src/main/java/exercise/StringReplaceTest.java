package exercise;

/**
 * Created by Frank on 2018/7/25.
 * String的replaceAll跟replaceFirst用到了正则表达式
 * “.”是正则表达式的元字符，匹配除换行符以外的任意字符
 * replace只是没有用到正则表达式，但会替换所有匹配的字符串
 */
public class StringReplaceTest {
    public static void main(String[] args) {
        String s = "my.test.txt";
        System.out.println(s.replace(".", "#"));
        System.out.println(s.replaceAll(".", "#"));
        System.out.println(s.replaceFirst(".", "#"));
        System.out.println(s.replaceFirst("\\.", "#"));
    }
}
/*
.匹配除换行符以外的任意字符

^匹配字符串的开始

$匹配字符串的结束

*重复零次或更多次

+重复一次或更多次

?重复零次或一次
*/