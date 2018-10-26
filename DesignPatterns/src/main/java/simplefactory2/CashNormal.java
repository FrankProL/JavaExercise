package simplefactory2;

/**
 * Created by Frank on 2018/3/29.
 */
public class CashNormal extends AbstractCashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
