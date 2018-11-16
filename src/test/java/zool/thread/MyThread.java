package zool.thread;

/**
 * @author : zoolye
 * @date : 2018-10-18 13:57
 * @describe :
 */
public class MyThread extends Thread{

    private int count = 7;

    @Override
    public synchronized void run() {
            super.run();
            count--;
            System.out.println("由 " + Thread.currentThread().getName() + " 计算.count = "+count);

    }
}
