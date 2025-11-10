package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentMapTest {
  private static final Map<String, String> rateLimiters = new ConcurrentHashMap<>();
  private static final Map<String, AtomicInteger> gauges = new ConcurrentHashMap<>();
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> operateOnMap("ethos38"));
    Thread t2 = new Thread(() -> operateOnMap("ethos38"));
    t1.start();
    t2.start();
    Thread.sleep(500);
    Thread t3 = new Thread(() -> operateOnMap("ethos38"));
    Thread t4 = new Thread(() -> operateOnMap("ethos38"));
    Thread t5 = new Thread(() -> operateOnMap("ethos38"));
    t3.start();
    t4.start();
    t5.start();
    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();

    System.out.println(rateLimiters);
    System.out.println(gauges);
  }

  public static void operateOnMap(String key) {
    System.out.println(Thread.currentThread().getName() + " is operating on " + key);
    final AtomicInteger gauge = getOrCreate(key);

    gauge.incrementAndGet();
    System.out.println("Thread " + Thread.currentThread().getName() + " says: current number of threads in method: " + gauge);
    // expensive operation
    try {
      Thread.sleep((long)(Math.random() * 1000L));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    gauge.decrementAndGet();
    System.out.println(gauges);
    System.out.println("Thread " + Thread.currentThread().getName() + " finished operating " + key);
  }

  public static AtomicInteger getOrCreate(String key) {
    AtomicInteger atomicInteger = gauges.computeIfAbsent(key, k -> new AtomicInteger(0));
    rateLimiters.computeIfAbsent(key, k -> k + "-value-rate-limiter");
    return atomicInteger;
  }

}
