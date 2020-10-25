package CONCURRENCY;

import java.util.concurrent.Semaphore;


public class PrintInOrderSemaphore {

    class Foo {
        private Semaphore semaphoreOne = new Semaphore(0);
        private Semaphore semaphoreTwo = new Semaphore(0);


        synchronized public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();//prints "first runned"
            semaphoreOne.release();//done with first - remove One barrier semaphopre for other to get to second print
        }

        synchronized public void second(Runnable printSecond) throws InterruptedException {
            semaphoreOne.acquire();//aquire sem One - for others not to jump over two
            printSecond.run();
            semaphoreTwo.release();//release two - to get to three


        }

        synchronized public void third(Runnable printThird) throws InterruptedException {
            semaphoreTwo.acquire();//aquire sec - for others not to jump over sec 
            printThird.run();


        }
    }
}
