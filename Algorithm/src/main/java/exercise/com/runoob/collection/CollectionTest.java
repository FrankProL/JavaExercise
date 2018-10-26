package exercise.com.runoob.collection;

import com.google.common.primitives.Ints;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Frank on 2018/7/28.
 * 数组转集合
 * 集合shuffle Collections.shuffle()
 * 集合反转Collections.reverse()
 * 只读集合Collections.unmodifiableList()
 * 循环移动Collections.rotate(list, 3)
 * 最大值Collections.max(list)
 * 最小值Collections.min(list)
 * 元素替换Collections.replaceAll(list, "one", "hundrea")
 * 查看子列表是否在集合中及其位置Collections.indexOfSubList(list, sublist))
 *  Collections.lastIndexOfSubList(list, sublist))
 */
public class CollectionTest {
    public static void arrayToList() {
        /*
         * 数组转集合
         *      普通非封装数据类型不能直接使用Arrays.asList(arr)转换
         * 集合转数组
         */
        int[] array=new int[5];
        int[] array2 = {1, 2, 3, 4, 5};

        String[] strArray = {"alsdkaf","alkdsfa"};
        String[] strArray2 = new String[5];
        for (int i = 0; i < strArray.length; i++) {
            strArray2[i]="str"+i;
        }
        String[] strArray3 = new String[]{"asldkf", "faklsd", "kdaf"};

        //使用 Java Util 类的 Arrays.asList(name) 方法将数组转换为集合
        List<String> list = Arrays.asList(strArray3);
        System.out.println(list.get(1));
        List<String> sList = new ArrayList<String>(Arrays.asList("sldfak","aksdf"));
        List aList = Arrays.asList("alkds", "askdf");
        ArrayList<String> bList = new ArrayList<String>(Arrays.asList("aksdfla", "alksdfa"));
        System.out.println("List new ArrayList<String>(Arrays.asList: "+sList);
        System.out.println("List Arrays.asList: "+aList);
        System.out.println("ArrayList new ArrayList<String>(Arrays.asList: "+bList);
        //对这个list的操作都会反映在原数组上，而且这个list是定长的，不支持add、remove等改变长度的方法。
        //list.add("aaaaaa");       //java.lang.UnsupportedOperationException

        //结合转换为数组，打印数组时，可以使用Arrays.toString(array)方法
        strArray=list.toArray(strArray);
        System.out.println(Arrays.toString(strArray));

        //asList接受的参数是一个泛型的变长参数，而基本数据类型是无法泛型化的
        //List<Integer> intList = Arrays.asList(array2);
        List intList = Arrays.asList(array2);   // 把int类型的数组当参数了，所以转换后的列表就只包含一个int[]元素。
        System.out.println(intList.get(0));

        // 通过其他方式实现
        // 1.逐个元素添加
        int [] buf= {1,2,3,4,5,6,7};
        List<Integer> newList = new ArrayList<Integer>();
        for(int i : buf){
            newList.add(i);
        }
        // 2.java8 函数式编程
        int[] arr1 = new int[]{111, 222, 333};
        List<Integer> anoList = IntStream.of(arr1).boxed().collect(Collectors.toList());
        anoList.forEach(System.out::println);
        // 3.guava类库的工具方法，List<Integer> list = Ints.asList(intArray);
        List<Integer> anoList2 = Ints.asList(arr1);
        System.out.println(anoList2.get(2));
    }

    public static void collectionsShuffle() {
        /*
         *  集合打乱顺序
         *  Collections.shuffle()  打乱集合元素顺序
         */
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(new Integer(i));
        }
        System.out.println("打乱前：");
        System.out.println(list);
        for (int i = 0; i < 6; i++) {
            System.out.println("第" + i + "次打乱：");
            Collections.shuffle(list);
            System.out.println(list);
        }
    }

    public static void collectionsReverse() {
        /*
        反转集合 Collections.reverse(list)
         */
        String[] coins = { "A", "B", "C", "D", "E" };
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(coins));
        System.out.println("反转前：");
        Iterator<String> it=list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        Collections.reverse(list);
        System.out.println("反转后：");
        System.out.println(list);
    }

    public static void collectionsRotate() {
        /*
        循环后移
         */
        List<String> list = Arrays.asList("one Two three Four five six".split(" "));
        System.out.println("list :");
        System.out.println(list);
        Collections.rotate(list, 3);
        System.out.println("rotate: "+list);
    }
    public static void main(String[] args) {
        arrayToList();
        collectionsShuffle();
        collectionsReverse();
        collectionsRotate();
    }
}
