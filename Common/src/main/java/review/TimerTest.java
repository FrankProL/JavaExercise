package review;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Frank on 2018/12/12.
 * 定时执行
 * Java通过Executors提供五种线程池：
 * 1. newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * 2. newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * 3. newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * 4. newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * 5. newWorkStealingPool：jdk1.8新增，创建持有足够线程的线程池来支持给定的并行级别，并通过使用多个队列，减少竞争，
 *   它需要穿一个并行级别的参数，如果不传，则被设定为默认的CPU数量。
 */
public class TimerTest {
    public static void executeEightAtNightPerDay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis("18:08:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

        Runnable runnable = new Runnable() {
            public void run() {
                // task to run goes here
                System.out.println("Hello !!"+new Date());

            }
        };

        executor.scheduleAtFixedRate(
                runnable,
                initDelay,
                oneDay,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 获取指定时间对应的毫秒数
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        TimerTest.executeEightAtNightPerDay();
        System.out.println(new Date());
//		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//	    long oneDay = 24 * 60 * 60 * 1000;
//	    long initDelay  = getTimeMillis("17:42:00") - System.currentTimeMillis();
//	    initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
//
//	    Runnable runnable = new Runnable() {
//            public void run() {
//                // task to run goes here
//                System.out.println("Hello !!"+new Date());
//
//            }
//        };
//
//
//	    executor.scheduleAtFixedRate(
//	            runnable,
//	            initDelay,
//	            oneDay,
//	            TimeUnit.MILLISECONDS);
    }
}
