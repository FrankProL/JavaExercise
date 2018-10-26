package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * ConcreteComponent
 * Component是定义一个对象接口，可以给这些对象动态地添加职责。
 * ConcreteComponent是定义了一个具体的对象，也可以给这个对象添加一些职责。
 */
public class Person {
    public Person() {

    }

    private String name;

    public Person(String name) {
        this.name=name;
    }

    public void Show() {
        System.out.println("装扮的"+name);
    }
}
