package exercise.test;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		System.out.println("输入整数A：");
		Scanner in = new Scanner(System.in);
		int A=in.nextInt();
		System.out.println("输入整数B：");
		int B=in.nextInt();
		System.out.println("输入运算符：");
		String C=in.next();
		int D = 0;
		switch (C) {
		case "+":
			D=A+B;
			break;
		case "-":
			D=A-B;
			break;
		case "*":
			D=A*B;
			break;
		case "/":
			D=A/B;
			break;

		default:
			System.out.println("运算符错误");
			break;
		}
		System.out.println(A+C+B+"="+D);
	}
}
