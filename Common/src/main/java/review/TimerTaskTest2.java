package review;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Frank on 2018/12/21.
 * 通过Timer、TimerTask实现在指定时间执行定时任务
 */
public class TimerTaskTest2 {
    Timer timer;

    public TimerTaskTest2() {
        Date time = getTime();
        System.out.println("指定时间：" + time);
        timer = new Timer();
        timer.schedule(new TimerTaskChid2(),time);
    }

    //指定时间
    public Date getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 58);
        calendar.set(Calendar.SECOND, 00);
        Date time = calendar.getTime();
        return time;
    }

    public static void main(String[] args) {
        new TimerTaskTest2();
    }

}

class TimerTaskChid2 extends TimerTask{
    @Override
    public void run() {
        System.out.println("指定时间运行线程任务！"+(new Date()));
    }
}
