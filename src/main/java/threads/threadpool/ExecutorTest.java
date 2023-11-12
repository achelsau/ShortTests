package threads.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(5);

    for (int i = 0; i < 100; i++) {
      Runnable r = () -> {
        Future<?> submittedFuture = executor.submit(() -> {
          System.out.println(Thread.currentThread() + " created. Will sleep for 5 seconds");
          try {
            TimeUnit.SECONDS.sleep(7);
          } catch (InterruptedException e) {
            System.out.println("Interrupted!!!");
            Thread.currentThread().interrupt();
          }
          executor.shutdown();

          System.out.println(Thread.currentThread() + " finished.");
        });

        while (!submittedFuture.isDone()) {
          System.out.println("Future is not done");

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            System.out.println("Interrupted!!!");
            throw new RuntimeException(e);
          }
        }

        System.out.println("Future is done");
        System.out.println("Future name " + submittedFuture);
      };
      Thread t = new Thread(r);
      t.start();
    }
    //executor.shutdown();
  }
}
