package zool.thread;

import org.junit.Test;

/**
 * @author : zoolye
 * @date : 2018-11-16 16:33
 * @describe :
 */
public class ThreadLocalTest {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set(){
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return longLocal.get();
    }

    public String getName(){
        return stringLocal.get();
    }

    @Test
    public void test() throws InterruptedException {

        ThreadLocalTest test = new ThreadLocalTest();

        test.set();

        System.out.println(test.getLong());
        System.out.println(test.getName());

        Thread thread = new Thread(() -> {
            test.set();
            System.out.println(test.getLong());
            System.out.println(test.getName());
        });

        thread.start();
        thread.join();

        System.out.println(test.getLong());
        System.out.println(test.getName());

    }

}
