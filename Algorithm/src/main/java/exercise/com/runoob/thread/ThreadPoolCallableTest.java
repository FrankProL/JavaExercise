package exercise.com.runoob.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Frank on 2018/7/27.
 */
public class ThreadPoolCallableTest implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程任务执行 "+ Thread.currentThread().getName()+" "+i);
        }
        return null;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        ThreadPoolCallableTest c=new ThreadPoolCallableTest();
        //线程池中获取线程对象，调用run方法
        service.submit(c);
        //再获取一个
        service.submit(c);
        //关闭线程池
        service.shutdown();
    }
}
