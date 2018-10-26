package simplefactory2;

/**
 * Created by Frank on 2018/3/29.
 */
public class CashFactory {
    public static AbstractCashSuper createCashAccept(String type) {
        AbstractCashSuper acs = null;
        switch (type) {
            case "正常收费":
                acs = new CashNormal();
                break;
            case "满300减100":
                CashReturn cr1 = new CashReturn("300", "100");
                acs=cr1;
                break;
            case "打8折":
                CashRebate cr2 = new CashRebate("0.8");
                acs=cr2;
                break;
        }
        return acs;
    }
}
