package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Frank on 2019/8/5.
 * 按字符串字典排序
 */
public class StringSort {
    public static void sortDemoA() {
        String demos[]={"hello","软件小宇","test","中国"};
        Collections.sort(Arrays.asList(demos));
        for(String s:demos){
            System.out.println(s);
        }
    }

    public static void sortDemoB() {
        StringBuffer sb = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\test1\\b.txt"));

            sb = new StringBuffer();
            String text =null;
            while ((text=br.readLine())!= null){
                sb.append(text);// 将读取出的字符追加到stringbuffer中
            }
            br.close();  // 关闭读入流
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = sb.toString().toLowerCase(); // 将stringBuffer转为字符并转换为小写
        String[] words = str.split("[^(a-zA-Z)]+");  // 非单词的字符来分割，得到所有单词
        Map<String ,Integer> map = new HashMap<String, Integer>() ;

        for(String word :words){
            if(map.get(word)==null){  // 若不存在说明是第一次，则加入到map,出现次数为1
                map.put(word,1);
            }else{
                map.put(word,map.get(word)+1);  // 若存在，次数累加1
            }
        }

        // 排序
        List<Map.Entry<String ,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        Comparator<Map.Entry<String,Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
                return (left.getValue().compareTo(right.getValue()));
            }
        };
        // 集合默认升序升序
        Collections.sort(list,comparator);

        for(int i=0;i<list.size();i++){// 由高到低输出
            System.out.println(list.get(list.size()-i-1).getKey() +":"+list.get(list.size()-i-1).getValue());
        }
    }
    public static void main(String[] args) {
        StringSort.sortDemoA();

        ArrayList<String> arl = new ArrayList<String>();
        arl.add("D");
        arl.add("a");
        arl.add("E");
        arl.add("f");
        arl.add("C");
        arl.add("东海湾");
        arl.add("傲来");
        arl.add("东海湾-岩洞");
        arl.add("傲来药店");
        arl.add("北京");
        arl.add("上海");
        arl.add("湖南");
        arl.add("河南");
        arl.add("河北");

        Collections.sort(arl, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    // 取得比较对象的汉字编码，并将其转换成字符串
                    String s1 = new String(o1.toString().getBytes("GB2312"), "ISO-8859-1");
                    String s2 = new String(o2.toString().getBytes("GB2312"), "ISO-8859-1");
                    // 运用String类的 compareTo（）方法对两对象进行比较
                    return s1.compareTo(s2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });// 根据元素的自然顺序 对指定列表按升序进行排序。

        for (String s:arl) {
            System.out.println(s);
        }
    }
}
