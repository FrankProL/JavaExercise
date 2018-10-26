package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * ConcreteDecorator
 * ConcreteDecorator就是具体的装饰对象，起到给Component添加职责的功能
 */
public class BigTrouser extends Finery {
    @Override
    public void Show() {
        System.out.println("垮裤");
        super.Show();
    }
}
