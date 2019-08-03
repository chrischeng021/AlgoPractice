package MultiplyThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleThreadTest implements Runnable{
    private int _tag;
    private AtomicInteger curNum;
    private AtomicInteger curCount;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public SimpleThreadTest(int val){
        this._tag = val;
        curNum = new AtomicInteger(Integer.MIN_VALUE);
        curCount = new AtomicInteger(0);
    }

    public void run(){
        try{
            for(int i = 0; i < 10; i++) {
                curNum.compareAndSet(Integer.MIN_VALUE, i);

                while(curNum.get() != i && curCount.get() !=10)
                    condition.await();

                if(curCount.get() == 10){
                    condition.signalAll();
                    lock.unlock();
                }

                if(i == curNum.get()){
                    System.out.println(String.valueOf(_tag) + "_" + i);
                    curCount.incrementAndGet();
                    condition.signalAll();
                }

                if(i != curNum.get() && curCount.get() == 10){
                    System.out.println(String.valueOf(_tag) + "_" + i);
                    curCount.compareAndSet(10, 1);
                    curNum.set(i);
                    condition.signalAll();
                }
            }
        }
        catch(InterruptedException e){
            System.out.println(e.toString());
        }
        finally{
        }
    }
}
