package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * ConcreteDecorator
 */
public class LeatherShoes extends Finery {
    @Override
    public void Show() {
        System.out.println("皮鞋");
        super.Show();
    }
}
