package MultiplyThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleThreadTest implements Runnable{
    private static volatile int curNum;
    private static volatile int curCount;
    private volatile int threadNum;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public SimpleThreadTest(int threadNum){
        curNum = 0;
        curCount = 0;
        this.threadNum = threadNum;
    }

    public void run(){
        try{
            lock.lock();
            for(int i = 0; i < 10; i++) {
                while((curNum != i && curCount != 10))
                    condition.await();

                if(curCount == 10){
                    curCount = 1;
                    curNum = i;
                }

                System.out.println(this.hashCode() + "__" + i);
                curCount++;
                condition.signalAll();
            }
        }
        catch(InterruptedException e){
            System.out.println(e.toString());
        }
        finally{
            lock.unlock();
        }
    }
}
