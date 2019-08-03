package MultiplyThread;

import java.util.ConcurrentModificationException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ZeroEvenOdd {
    private int n;

    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    private volatile int flag = 0;

    private static class IntConsumer{
        public void accept(int x){
            System.out.println(x);
        }
    }

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        try{
            lock.lock();
            for(int i = 1; i <= n; i++){
                while(flag != 0)
                    condition.await();

                if(i % 2 == 0)
                    flag = 1;
                else
                    flag = 2;

                printNumber.accept(0);
                condition.signalAll();
            }
        }
        catch(InterruptedException e){
            System.out.println(e.toString());
        }
        finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        try{
            lock.lock();
            for(int i = 2; i <= n; i += 2){
                while(flag != 1)
                    condition.await();

                flag = 0;
                printNumber.accept(i);
                condition.signalAll();
            }
        }
        catch(InterruptedException e){
            System.out.println(e.toString());
        }
        finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        try{
            lock.lock();
            for(int i = 1; i <= n; i+=2){
                while(flag != 2)
                    condition.await();

                flag = 0;
                printNumber.accept(i);
                condition.signalAll();
            }
        }
        catch(InterruptedException e){
            System.out.println(e.toString());
        }
        finally {
            lock.unlock();
        }
    }
}