package exercise.com.runoob.thread;

/**
 * Created by Frank on 2018/7/26.
 * 创建一个线程，最简单的方法是创建一个实现 Runnable 接口的类。
 */
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo(String threadName) {
        this.threadName=threadName;
        System.out.println("Creating " + threadName);
    }
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread : " + threadName + "," + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();
    }
}
