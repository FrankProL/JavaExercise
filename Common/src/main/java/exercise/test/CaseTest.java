package exercise.test;

public class CaseTest {
	public static void main(String[] args) {
		/*
		 * switch
		 * byte、short、char、int、enum 、1.7之后添加对String的判断
		 */
		char str = 'A';
		switch (str) {
		case 'A':
		    System.out.println('A');
		    break;
		case 'B':
		    System.out.println('B');
		    break;
		case 'C':
		    System.out.println('C');
		    break;
		default:
		    System.out.println(0);
		}
	}
}
