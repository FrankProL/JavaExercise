package exercise.com.runoob.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 2018/7/25.
 * 类型通配符
 * 1、类型通配符一般是使用?代替具体的类型参数。
 *    例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
 * 2、类型通配符上限通过形如List来定义，
 *     List<? extends Number>如此定义就是通配符泛型值接受Number及其下层子类类型。
 *    类型通配符下限通过形如 List<? super Number>来定义，表示类型只能接受Number及其上层父类类型，如Objec类型的实例。
 */
public class GenericTest {
    public static void getData(List<?> data) {
        System.out.println("data: " + data.get(0));
    }

    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data: " + data.get(0));
    }

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(10);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

//        getUperNumber(name);//参数已经限定了参数泛型上限为Number，所以泛型为String是不在这个范围之内，所以会报错
        getUperNumber(age);
        getUperNumber(number);
    }
}
