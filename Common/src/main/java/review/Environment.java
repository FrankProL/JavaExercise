package review;

import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by Frank on 2018/12/17.
 * 系统变量使用范例
 */
public class Environment {
    public static void main(String[] args) {

        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.print("key:    " + entry.getKey() + "\t");
            System.out.println("value:  " + entry.getValue());
        }
        String s = System.getenv("JAVA_HOME");
        System.out.println(s);

        Properties prop = System.getProperties();
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            System.out.println("key:    "+entry.getKey()+"==============value:  "+entry.getValue());
        }
        prop.list(System.out);

        String version = prop.getProperty("java.version");
        System.out.println(version);

        prop.setProperty("myKey", "myValue");
        System.out.println(prop.getProperty("myKey", "default"));

        Enumeration<String> names = (Enumeration<String>) prop.propertyNames();
        while (names.hasMoreElements()) {
            String ss = names.nextElement();
            System.out.println(ss);
        }
    }

    private static void setProperty(String key, String value) {
        Properties prop = System.getProperties();
        prop.setProperty(key, value);
    }
}
