package exercise.com.runoob;

/**
 * Created by Frank on 2018/7/23.
 */
public class Polymorphism {
    public static void show(Animal a) {
        a.eat();
        if (a instanceof Cat) {     //类型判断
            Cat c=(Cat) a;
            c.work();
        }else if (a instanceof Dog) {
            Dog c=(Dog) a;
            c.work();
        }
    }

    public static void main(String[] args) {
        show(new Cat());            //以Cat对象调用show（）方法
        show(new Dog());            //以Dog对象调用Dog（）方法

        Animal a = new Cat();       //向上转型
        a.eat();
        Cat c = (Cat)a;             //向下转型
        c.work();
    }
}
abstract class Animal{
    abstract void eat();
}

class Cat extends Animal{
    public void eat() {
        System.out.println("吃鱼");
    }

    public void work() {
        System.out.println("抓老鼠");
    }
}

class Dog extends Animal{
    public void eat() {
        System.out.println("啃骨头");
    }

    public void work() {
        System.out.println("看家");
    }
}