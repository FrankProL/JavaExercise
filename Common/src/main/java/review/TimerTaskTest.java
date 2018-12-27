package review;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Frank on 2018/12/19.
 * 通过Timer、TimerTask实现延时指定时间执行任务
 *
 */
public class TimerTaskTest {
    Timer timer;

    public TimerTaskTest(int time) {
        timer = new Timer();
        timer.schedule(new TimerTaskChid(), time * 1000);   //可以直接使用匿名内部类，new TimerTask

        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("(匿名内部类实现)延时到，开始执行!"+System.currentTimeMillis());
            }
        },time*1000);*/
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        new TimerTaskTest(3);
    }

}

/*
继承TimerTask类，实现run方法
 */
class TimerTaskChid extends TimerTask{
    @Override
    public void run() {
        System.out.println("延时到，开始执行!"+System.currentTimeMillis());
    }
}
