package CONCURRENCY;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrderReentrantLock {



    class Foo {

        private int threadNumber; // common sync object
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public Foo() {
            this.threadNumber = 1;
        }//init common sync object

        synchronized public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();//always saret with locking the lock

            try {
                printFirst.run();
                this.threadNumber++;
                condition.signalAll();//let others know that condition is changed
            }finally {
                lock.unlock();//always unlock after done in method for not to get into infinite wait if smth goes wrong for this LOCK 
            }

        }

        synchronized public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();

            try{
                 while (threadNumber !=2){// check the coomon object is in desired state
                     condition.await();// if no WAIT
                 }
                 printSecond.run();
                this.threadNumber++;
                 condition.signalAll();//infor other threads that condition updated
            }finally {
                lock.unlock();//unlock after done
            }

        }

        synchronized public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try{
                while (threadNumber !=3){
                    condition.await();
                }

                printThird.run();
                this.threadNumber++;
                condition.signalAll();
            }finally {
                lock.unlock();
            }

        }
    }
}
