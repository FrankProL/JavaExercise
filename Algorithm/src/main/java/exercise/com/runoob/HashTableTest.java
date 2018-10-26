package exercise.com.runoob;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by Frank on 2018/7/24.
 * Java 2 重构的Hashtable实现了Map接口，因此，Hashtable现在集成到了集合框架中。
 * 它和HashMap类很相似，但是它支持同步。
 * 像HashMap一样，Hashtable在哈希表中存储键/值对。当使用一个哈希表，要指定用作键的对象，以及要链接到该键的值。
 * 然后，该键经过哈希处理，所得到的散列码被用作存储在该表中值的索引。
 * http://www.runoob.com/java/java-data-structures.html
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable balance = new Hashtable();
        Enumeration<String> names;
        String str;
        double bal;

        balance.put("Zara", new Double(3434.34));
        balance.put("Mahnza", new Double(123.22));
        balance.put("Ayan", new Double(1378.00));
        balance.put("Dasiy", new Double(99.22));
        balance.put("Qudir", new Double(-19.08));

        //show all balances in hashtable
        names=balance.keys();
        while (names.hasMoreElements()) {
            str=names.nextElement();
            System.out.println(str + ":" + balance.get(str));
        }
        System.out.println();
        //Deposit 1,000 into Zara's account
        bal=((Double)balance.get("Zara")).doubleValue();
        balance.put("Zara", new Double(bal + 1000));
        System.out.println("Zara's new balance :" + balance.get("Zara"));
    }
}
