package Strategy;

/**
 * Created by Frank on 2018/3/29.
 * 策略模式（Strategy）
 * 它定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化，不会影响到使用算法的客户
 */
public class Test {
    double total = 0.0d;

    public static void main(String[] args) {
        /*CashContext cc=null;
        Scanner input = new Scanner(System.in);
        System.out.println("输入活动类型：");
        String type=input.next();
        switch (type) {
            case "正常收费":
                cc = new CashContext(new CashNormal());
                break;
            case "满300减100":
                cc = new CashContext(new CashReturn("300", "100"));
                break;
            case "打8折":
                cc = new CashContext(new CashRebate("0.8"));
                break;
        }*/
        CashContext cc=new CashContext("满300减100");
        double totalPrices=0d;
        totalPrices = cc.GetResult(350);
        System.out.println(totalPrices);
    }
}
/*
    策略模式是一种定义一系列算法的方法，从概念上来看，所有这些算法完成的都是相同的工作，只是实现方式不同，
    它可以以相同的方式调用所有的方法，减少了各种算法类与使用算法类之间耦合

    策略模式的Strategy类层次为Context定义了一系列的可供重用的算法或行为。继承有助于析取出这些算法的公共功能

    策略模式是用来封装算法的，但在实践中，我们发现可以用它来封装几乎任何类型的规则，只要在分析过程中听到
    需要在不同时间应用不同的业务规则，就可以考虑使用策略模式处理这种变化的可能性

    基本的策略模式中，选择所用具体实现的职责由客户端对象承担，并转给策略模式的Context对象，本身并没有解除
    客户端需要选择判断的压力，策略模式与工厂模式结合后，选择具体实现的职责也可以有Context来承担，大大减轻
    了客户端的职责。（反射技术能够更好的解决这类问题）
 */