package recursion;

/**
 * 使用Stack实例来保存每个柱子上的盘子及它们的顺序。
 * Stack是队列的一种，其中的元素遵循“先进先出”（FIFO）的原则，即不允许从队尾取元素。
 * 这种队列通常也称为“栈”。栈对元素的进出约定与汉诺塔的规则一致。
 * resolve方法用来移动盘子，参数n表示要移动的盘子的数量，a是盘子所在的柱子，b是辅助柱子，c是目标柱子。
 * 注意此方法会首先检查参数n，当n为0时直接返回，这就是前面所说的“预定值”。
 * 如果没有对预定值的判断，resolve的递归过程将不会自然终止，而是无限进行下去，直到塞满系统内存堆栈而导致程序奔溃。
 * Created by Frank on 2018/7/10.
 */
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
    static int tmp = 0;
    public static void print(Stack<Integer> s) {
        Iterator<Integer> i = s.iterator();
        while (i.hasNext()) {
            System.out.printf("%d ", i.next());
        }
        System.out.println();
    }

    public static void resolve(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {

        if (n==0) return;
        tmp++;
        resolve(n-1, a, c, b);      //将n-1个盘子由a移动到b，以c为辅助柱子（注意参数顺序）
        c.push(a.pop());            //将a上的最后一个盘子移动到c
        resolve(n-1, b, a, c);      //将n-1个盘子由b移动到c，以a为辅助柱子
    }

    public static void main(String[] args) {
        int count = 20;
        Stack<Integer> a = new Stack<Integer>();
        Stack<Integer> b = new Stack<Integer>();
        Stack<Integer> c = new Stack<Integer>();

        for (int i=count; i>0; i--) {
            a.push(i);
        }

        print(a);
        long start = System.currentTimeMillis();
        resolve(count, a, b, c);
        long end = System.currentTimeMillis();
        print(c);

        System.out.println((end - start) / 1000);
        System.out.println(tmp);
    }
}

/*
 * 当最大的盘子由a移到c后，b上是余下的63个盘子，a为空。因此现在的目标就变成了将这63个盘子由b移到c。
 * 这个问题和原来的问题完全一样，只是由a柱换为了b柱，规模由64变为了63。
 * 因此可以采用相同的方法，先将上面的62个盘子由b移到a，再将最下面的盘子移到c……对照下面的过程，试着是否能找到规律：
 *
 * 将b柱子作为辅助，把a上的63个圆盘移动到b上
 * 将a上最后一个圆盘移动到c
 * 将a作为辅助，把b上的62个圆盘移动到a上
 * 将b上的最后一个圆盘移动到c
 * ......
 * 也许你已经发现规律了，即每次都是先将其他圆盘移动到辅助柱子上，并将最底下的圆盘移到c柱子上，
 * 然后再把原先的柱子作为辅助柱子，并重复此过程。
 * 这个过程称为递归，即定义一组基本操作，这组操作将规模小一点（或大一点）的操作当做一个整体——无需关心它的细节，
 * 只当它已经完成了——然后执行剩下的操作。而在更小或更大的规模中也依此操作，直到规模达到预定值。
 *
 * 假设函数func(n, a, b, c)用于将n个圆盘由a移动到c，b作为辅助柱子。那么我们可以这样实现这个递归过程：
 * func:
 * if n!=0 then            ;预定值
 *   func(n-1, a, c, b)    ;将n-1个盘子由a移动到b，以c为辅助柱子（注意参数顺序）
 *   move a[n] to c        ;将a上的最后一个盘子移动到c
 *   func(n-1, b, a, c)    ;将n-1个盘子由b移动到c，以a为辅助柱子
 * endif                   ;完成
 */