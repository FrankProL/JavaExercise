package review;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Frank on 2018/12/19.
 * 定时执行---延时执行
 * 通过ScheduledExecutorService
 * scheduledExec.schedule(..)
 */
public class TimerTest2 {
    private ScheduledExecutorService scheduledExec;
    public long start;

    TimerTest2() {
        this.scheduledExec = Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public void timerOne() {
        scheduledExec.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("timerOne,the time:  "+(System.currentTimeMillis()-start));
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after sleep:    "+(System.currentTimeMillis()-start));
            }
        }, 1000, TimeUnit.MILLISECONDS);
    }

    public void timerTwo() {
        scheduledExec.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("timerTwo,the time:  "+(System.currentTimeMillis()-start));
            }
        }, 2000, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        TimerTest2 test = new TimerTest2();
        test.timerOne();
        test.timerTwo();

        test.scheduledExec.shutdown();
        /*
        守护线程与用户线程，JVM退出的条件是当前不存在用户线程，而线程池默认的ThreadFactory创建的线程是用户线程
        线程池默认的线程工厂创建创建的都是用户线程。而线程池里面的核心线程是一直会存在的，如果没有任务则会阻塞，
        所以线程池里面的用户线程一直会存在.而shutdown方法的作用就是让这些核心线程终止
        使用线程池的场景一定不要忘记了调用shutdown方法设置线程池状态和中断工作线程池
         */
    }
}
