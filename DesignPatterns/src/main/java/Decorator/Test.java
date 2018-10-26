package Decorator;

/**
 * Created by Frank on 2018/3/30.
 * 装饰模式（Decorator）
 * 动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更加灵活
 * 把类中装饰的功能从类中搬移去除，这样可以简化原有的类。有效的把类的核心职责和装饰功能区分开，而且
 * 可以去除相关类中重复的装饰逻辑。
 */
public class Test {
    public static void main(String[] args) {
        Person xc = new Person("小菜");

        System.out.println("\n第一种装扮：");

        Sneakers pqx = new Sneakers();
        BigTrouser kk = new BigTrouser();
        TShirts dtx = new TShirts();

        pqx.Decorate(xc);
        kk.Decorate(pqx);
        dtx.Decorate(kk);
        dtx.Show();
        System.out.println("\n第二种装扮");
        LeatherShoes px = new LeatherShoes();
        Tie ld = new Tie();
        Suit xz = new Suit();
        px.Decorate(xc);
        ld.Decorate(px);
        xz.Decorate(ld);
        xz.Show();
    }
}
