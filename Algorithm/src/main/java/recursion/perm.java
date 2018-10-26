package recursion;

/**
 * 排列问题
 * <p/>
 * Created by Frank on 2018/7/9.
 */
public class perm {
    public static void swap(Object[] list, int k, int i) {
        Object t = list[k];
        list[k] = list[i];
        list[i] = t;
    }
/*
递归另一种写法：或者采用July的方法：

 从集合中依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理，
* 从而得到所有元素的全排列。以对字符串abc进行全排列为例，我们可以这么做：以abc为例：
* 固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
* 固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
* 固定c，求后面ba的排列：cba，cab。
 */
    public static void perm(Object[] list, int k, int m) {
        if (k == m) {
            for (int i = 0; i <= m; i++) {
                System.out.print(list[i]);
            }
            System.out.println();
        } else {
            for (int i = k; i <= m; i++) {
                swap(list, k, i);
                perm(list, k + 1, m);
                swap(list, k, i);
            }
        }
    }

    public static void permutation1(String str, String result, int len) {
        /* 全排列 递归实现
      递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */
        //结果 开始传入""   空字符进入   len   是这个数的长度
        if (result.length() == len) {            //表示遍历完了一个全排列结果
            System.out.println(result);
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (result.indexOf(str.charAt(i)) < 0) {    //返回指定字符在此字符串中第一次出现处的索引。
//                    System.out.println("字母："+str.charAt(i));
                    permutation1(str, result + str.charAt(i), len);
                }
            }
        }
    }

    public static void main(String[] args) {
//        Object[] list = new Object[5];
//        for (int i = 0; i < list.length; i++) {
//            list[i] = "sasdf" + i;
//        }
//        perm(list, 0, 4);


        String s = "abc";
        String result = "";
        permutation1(s, result, s.length());
    }
}
