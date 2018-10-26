package exercise.com.runoob;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Frank on 2018/7/25.
 */
public class PropertyTest {
    public static void main(String[] args) {
        Properties capitals = new Properties();
        Set states;
        String str;

        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");
        //show all states and capitals in hashtable
        states=capitals.keySet();   // get set-view of keys
        Iterator itr  = states.iterator();
        while (itr.hasNext()) {
            str=(String)itr.next();
            System.out.println("the capital of "+ str + " is "+ capitals.getProperty(str));
        }
        System.out.println();
        //look for state not in list --specify default
        str = capitals.getProperty("Florida", "not found");
        System.out.println("the capital of Florida is "+ str);
    }
}
