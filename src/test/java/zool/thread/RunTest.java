package zool.thread;


/**
 * @author : zoolye
 * @date : 2018-10-18 14:13
 * @describe :
 */
public class RunTest {

    public static void main(String args[]){

        MyThread myThread = new MyThread();

        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"E");
        Thread f = new Thread(myThread,"F");
        Thread g = new Thread(myThread,"G");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
        g.start();
    }

}
