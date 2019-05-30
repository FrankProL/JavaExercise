package review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Frank on 2019/1/3.
 * 线程池
 * https://www.cnblogs.com/webglcn/p/5265901.html
 * 使用线程池的好处
 a. 重用存在的线程，减少对象创建、消亡的开销，性能佳。
 b. 可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞。
 c. 提供定时执行、定期执行、单线程、并发数控制等功能。
 newWorkStealingPool：jdk1.8新增，创建持有足够线程的线程池来支持给定的并行级别，并通过使用多个队列
 */
public class ThreadPoolTest {
    /*newCachedThreadPool
    创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
    线程池无限大，当执行第二个任务时若第一个任务已完成，会复用执行第一个任务的线程，而不用每次新建线程。
     */
    public static void cachedThreadPoolTest() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    /*newFixedThreadPool
    创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    定长线程池的大小最好根据资源进行设置，如Runtime.getRuntime().availableProcessors().
    例：线程池大小为3，每个任务输出index后sleep 2秒，所以每秒打印3个数字。
     */
    public static void fixedThreadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index=i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /*newScheduledThreadPool
    创建一个定长线程池，支持定时及周期性任务执行
     */
    public static void scheduledThreadPoolTest0() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {   //延时3秒后执行
            public void run() {
                System.out.println("delay 3 seconds ");
            }
        },3,TimeUnit.SECONDS);
    }
    public static void scheduledThreadPoolTest() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {    //  延迟1秒后，每3秒执行一次
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    /*
    newSingleThreadExecutor
    创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行（FIFO LIFO 优先级）
     */
    public static void singleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        ThreadPoolTest.cachedThreadPoolTest();
        ThreadPoolTest.fixedThreadPoolTest();
        ThreadPoolTest.scheduledThreadPoolTest0();
        ThreadPoolTest.scheduledThreadPoolTest();
        ThreadPoolTest.singleThreadExecutor();
    }
}
