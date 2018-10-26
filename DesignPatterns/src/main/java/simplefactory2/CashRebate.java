package simplefactory2;

/**
 * Created by Frank on 2018/3/29.
 */
public class CashRebate extends AbstractCashSuper {
    private double moneyRebate = 1d;

    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.valueOf(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money*moneyRebate;
    }
}
