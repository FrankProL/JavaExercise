package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * Decorator
 * Decorator，装饰抽象类，继承了Component，从外类来扩展Component类的功能，但对于Component来说，
 * 是无需知道Decorator的存在的。
 *
 * 如果只有一个ConcreteComponent类而没有抽象的Component类，那么Decorator累可以是ConcreteComponent的一个子类。
 * 如果只有一个ConcreteDecorator类，就没必要建立一个单独的Decorator类，而可以把Decorator和ConcreteDecorator的
 * 职责合并成一个类。
 */
public class Finery extends Person {
    protected Person component;

    //打扮
    public void Decorate(Person component) {
        this.component = component;
    }

    @Override
    public void Show() {
        if (component != null) {
            component.Show();
        }
    }
}
