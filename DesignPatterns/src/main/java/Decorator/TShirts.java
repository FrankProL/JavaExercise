package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * ConcreteDecorator
 */
public class TShirts extends Finery {
    @Override
    public void Show() {
        System.out.println("大T恤");
        super.Show();
    }
}
