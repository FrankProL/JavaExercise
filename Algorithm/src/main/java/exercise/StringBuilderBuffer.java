package exercise;

/**
 * Created by Frank on 2018/8/2.
 * String StringBuilder StringBuffer
 * 主要涉及运算速度与线程安全
 * 1.String是不可变对象，每次修改拼接，都会创建新对象，并赋值给原来的对象名，
 *    而原来的对象就等待被jvm的垃圾回收机制（GC）给回收掉
 *    Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，所以执行速度很慢。
 *    每次对String的操作都会生成新的String对象，这样不仅效率低下，而且大量浪费有限的内存空间。
 * 2.而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，
 *    所以速度要比String快很多。
 * 3.在线程安全上，StringBuffer是线程安全的，StringBuilder不是.
 *    StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法带有synchronized关键字，所以可以保证线程是安全的，
 *    但StringBuilder的方法则没有该关键字,在单线程的情况下，还是StringBuilder速度比较快
 */
public class StringBuilderBuffer {
    public static void main(String[] args) {
        String str = "abc" + "de";      // 等价于String str= "abcde",不涉及修改速度也很快
        StringBuilder stringBuilder = new StringBuilder().append("abc").append("de");
        StringBuffer stringBuffer = new StringBuffer("abc").append("de");

        str = str + "fg";
        stringBuffer = stringBuffer.append("fg");
        stringBuilder = stringBuilder.append("fg");
    }
}
