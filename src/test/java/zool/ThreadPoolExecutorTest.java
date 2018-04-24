package zool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 我们使用线程的时候就去创建一个线程，这样实现起来非常简便，但是就会有一个问题：
 * 如果并发的线程数量很多，并且每个线程都是执行一个时间很短的任务就结束了，
 * 这样频繁创建线程就会大大降低系统的效率，因为频繁创建线程和销毁线程需要时间。
 * 那么有没有一种办法使得线程可以复用，就是执行完一个任务，并不被销毁，而是可以继续执行其他的任务?
 * 在Java中可以通过线程池来达到这样的效果。
 */
public class ThreadPoolExecutorTest {

    public static void main(String args[]) {

        /**
         * 创建线程池，参数1：核心池的大小，参数2：线程池最大线程数，参数3：表示线程没有任务执行时最多保持多久时间会终止，参数4：keepAliveTime的时间单位，参数5：阻塞队列，用来存储等待执行的任务
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            /*提交任务让线程去执行，没有返回结果*/
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + ", 队列中等待执行的任务数目："
                    + executor.getQueue().size() + ", 已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        /*关闭线程池(等待所有任务包括缓存队列中的任务执行完)*/
        executor.shutdown();
    }

}

class MyTask implements Runnable {

    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}