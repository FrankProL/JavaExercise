package Strategy;

import simplefactory2.AbstractCashSuper;
import simplefactory2.CashNormal;
import simplefactory2.CashRebate;
import simplefactory2.CashReturn;

/**
 * Created by Frank on 2018/3/29.
 */
public class CashContext {
    //声明一个CashSuper对象
    private AbstractCashSuper acs;

    //通过构造方法，传入具体的收费策略
    /*
        public CashContext(AbstractCashSuper csuper) {
            this.acs = csuper;
        }
    */
    // 将实例化具体策略的过程由客户端转移到Context类中，简单工厂的应用
    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                CashNormal cs0 = new CashNormal();
                acs = acs;
                break;
            case "满300减100":
                CashReturn cr1 = new CashReturn("300", "100");
                acs=cr1;
                break;
            case "打8折":
                CashRebate cr2 = new CashRebate("0.8");
                acs = cr2;
                break;
        }
    }

    //根据收费策略的不同，获得计算结果
    public double GetResult(double money) {
        return acs.acceptCash(money);
    }
}
