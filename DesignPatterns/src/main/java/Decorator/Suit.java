package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * ConcreteDecorator
 */
public class Suit extends Finery {
    @Override
    public void Show() {
        System.out.println("西装");
        super.Show();
    }
}
