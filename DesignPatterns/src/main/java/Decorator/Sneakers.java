package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * ConcreteDecorator
 */
public class Sneakers extends Finery {
    @Override
    public void Show() {
        System.out.println("破球鞋");
        super.Show();
    }
}
