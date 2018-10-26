package simplefactory;

/**
 * Created by Frank on 2018/3/29.
 * 简单工厂模式
 * 用一个单独的类来做创造实例的过程
 * 通过简单工厂模式实现计算器功能
 */
public class Test {
    public static void main(String[] args) {
        Operation oper;
        oper=OperationFactory.createOperate("-");
        oper.setNumberA(1);
        oper.setNumberB(2);
        double result=oper.getResult();
        System.out.println("the answer is :"+result);
    }
}
