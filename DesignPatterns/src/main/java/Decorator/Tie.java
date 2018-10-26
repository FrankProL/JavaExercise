package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * ConcreteDecorator
 */
public class Tie extends Finery {
    @Override
    public void Show() {
        System.out.println("领带");
        super.Show();
    }
}
