package exercise.com.runoob.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Frank on 2018/7/27.
 */
public class ThreadPoolRunnableTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("自定义线程任务在执行 "+Thread.currentThread().getName()+"  " + i);
        }
    }

    public static void main(String[] args) {
        //创建线程池对象，参数5代表有5个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        //创建Runnable线程任务对象
        ThreadPoolRunnableTest task=new ThreadPoolRunnableTest();
        //从线程池中获取线程对象
        service.submit(task);
        System.out.println("------------------------");
        //再获取一个线程对象
        service.submit(task);
        //关闭线程池
        service.shutdown();
    }
}
