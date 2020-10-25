package CONCURRENCY;

/*

 */
public class PrintInOrder {

  

    class Foo {
        int threadNumber;

        public Foo() {
            this.threadNumber = 1;
        }

        synchronized public void first(Runnable printFirst) throws InterruptedException {
            while (threadNumber != 1) {
                wait();
            }
            printFirst.run();
            threadNumber++;
            notifyAll();
        }

        synchronized public void second(Runnable printSecond) throws InterruptedException {
            while (threadNumber != 2) {
                wait();
            }
            printSecond.run();
            threadNumber++;
            notifyAll();
        }

        synchronized public void third(Runnable printThird) throws InterruptedException {
            while (threadNumber != 3) {
                wait();
            }
            printThird.run();
            threadNumber++;
            notifyAll();
        }
    }
}
