package simplefactory2;

/**
 * Created by Frank on 2018/3/29.
 */
public class Test {
    double total =0.0d;
    public static void main(String[] args) {
        AbstractCashSuper csuper = CashFactory.createCashAccept("满300减100");
        double totalPrices = 0d;
        totalPrices = csuper.acceptCash(355);
        System.out.println(totalPrices);
    }
}
