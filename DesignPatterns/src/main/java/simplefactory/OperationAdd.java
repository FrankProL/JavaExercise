package simplefactory;

/**
 * Created by Frank on 2018/3/29.
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        double result = 0;
        result = getNumberA()+getNumberB();
        return result;
    }
}

