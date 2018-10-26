package exercise.com.runoob;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Frank on 2018/7/24.
 */
public class Employee {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number) {
        System.out.println("构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void mailCheck() {
        System.out.println("邮寄支票给"+this.name+" "+this.address);
    }

    public String toString() {
        return name+" "+address+ " "+number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Salary extends Employee
{
    private double salary; // 全年工资

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        this.salary = salary;
    }

    public void mailCheck() {
        System.out.println("Salary 类的 mailCheck 方法 ");
        System.out.println("邮寄支票给：" + getName()
                + " ，工资为：" + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0.0) {
            this.salary=salary;
        }
    }

    public double computePay() {
        System.out.println("计算工资，付给：" + getName());
        return salary/52;
    }

    public static void main(String[] args) {
        Salary s = new Salary("员工A", "北京", 3, 3600);
        Employee e = new Salary("员工B", "上海", 2, 2400);
        System.out.println("使用Salary对象的引用调用 mailCheck");
        s.mailCheck();
        System.out.println("\n使用Employee对象的引用调用mailCheck");
        e.mailCheck();
        Deque<String> queue = new LinkedList<String>();
        queue.offer("data1");    //队列尾部加入元素
        queue.offer("data2");
        queue.offer("data3");
        System.out.println(queue.poll());    //取得队首元素，并从队列中删去

        Deque<String> stack = new LinkedList<String>();
        stack.push("element1");    //向栈顶压入元素
        stack.push("element2");
        stack.push("element3");
        System.out.println(stack.pop());    //取得栈顶元素，并从栈顶删去
    }
}