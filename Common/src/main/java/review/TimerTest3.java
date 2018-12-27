package review;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Frank on 2018/12/19.
 * 每隔固定周期执行一次，可以设定初始延时
 * 实现方式同TimerTest,通过ScheduledExecutorService
 * scheduledExec.scheduleAtFixedRate(..)
 */
public class TimerTest3 {
    public static void main(String[] args) {
        System.out.println(new Date());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,定时执行!" + new Date());
            }
        };

        System.out.println(new Date());

        ScheduledExecutorService scheduledExec = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间 ，第四个为时间单位
        scheduledExec.scheduleAtFixedRate(runnable, 10, 3, TimeUnit.SECONDS);
    }
}
