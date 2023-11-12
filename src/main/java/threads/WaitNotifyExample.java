package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyExample {

  public static Lock lock = new ReentrantLock();
  public static Condition shouldAwake = lock.newCondition();

  public static void main(String[] args) {
    T target1 = new T(lock, shouldAwake, 1);
    target1.monitor = shouldAwake;
    Thread t1 = new Thread(target1);
    t1.start();
    T target2 = new T(lock, shouldAwake, 2);
    target2.monitor = shouldAwake;
    Thread t2 = new Thread(target2);
    t2.start();

    T target3 = new T(lock, shouldAwake, 3);
    target3.monitor = shouldAwake;
    Thread t3 = new Thread(target3);
    t3.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    Notifier notifier = new Notifier(lock, shouldAwake);
    notifier.notifyTs();
  }
}

class T implements Runnable {

  public Condition monitor;
  public Lock lock;

  public int index;

  public T(Lock lock, Condition monitor, int index) {
    this.lock = lock;
    this.monitor = monitor;
    this.index = index;
  }

  @Override
  public void run() {
    //synchronized (monitor) {
    lock.lock();
      try {
        System.out.println("T" + index + " started waiting...");
        monitor.await();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.unlock();
      }
    //}

    System.out.println("Waiting is over for T" + index + ", let's do some stuff...");
  }
}

class Notifier {

  public Condition monitor;
  public Lock lock;

  public Notifier(Lock lock, Condition monitor) {
    this.lock = lock;
    this.monitor = monitor;
  }

  public void notifyTs() {
    lock.lock();
    //synchronized (monitor) {
      System.out.println("Notifier notifying...");
      monitor.signal();
    //}
    lock.unlock();
  }
}

class Monitor {

  public int i;

  public Monitor(int i) {
    this.i = i;
  }

  public int hashCode() {
    return 1;
  }

  public boolean equals(Object o) {
    return true;
  }
}
