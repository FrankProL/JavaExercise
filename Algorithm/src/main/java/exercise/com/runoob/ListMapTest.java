package exercise.com.runoob;

import java.util.*;

/**
 * Created by Frank on 2018/7/23.
 */
public class ListMapTest {
    public static void listTest(){
        List<String> list=new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("adfa");
        //第一种遍历方法，使用foreach遍历List（也可以使用常规的for循环）
        for(String str:list){                   //也可以改写for(int i=0;i<list.size();i++)这种形式
            System.out.println(str);
        }
        //第二种遍历方法，把链表变为数组相关的内容进行遍历
        String[] strArray = new String[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++){     //也可以改为foreach(String str:strArray)这种形式
            System.out.println(strArray[i]);
        }
        //第三种遍历方式，使用迭代器进行遍历
        Iterator<String> ite=list.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }

    public static void setTest() {
        Set<String> set = new HashSet<String>();
        set.add("JAVA");
        set.add("C");
        set.add("C++");
        // 重复数据添加失败
        set.add("JAVA");
        set.add("JAVASCRIPT");
        // 使用iterator遍历set集合
        Iterator<String> it= set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (String str : set) {
            System.out.println(str);
        }
    }
    public static void mapTest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        // 第一种，二次取值
        for (String key : map.keySet()) {
            System.out.println(key+"->"+map.get(key));
        }
        //第二种，通过map.entrySet使用iterator遍历key和value
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
        //第三种，通过map.entrySet遍历key和value，当容量大的时候推荐使用此种
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
        //第四种，通过map.values()遍历所有的value，但不能遍历key
        for (String v : map.values()) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) {
        listTest();
        setTest();
        mapTest();
    }
}
