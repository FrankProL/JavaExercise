package exercise;

/**
 * Created by Frank on 2018/8/24.
 */
public class ThreadTest {
    public class InnerThread extends Thread {
        public InnerThread() {
            System.out.println(Thread.currentThread().getName());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

    }
}
