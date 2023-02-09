package threads;

import threads.threadpool.ExecutorTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncThreadExecution {

  private static ExecutorService executorService = Executors.newCachedThreadPool();

  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    Future<Void> job = (Future<Void>) executorService.submit(() -> {
      try {
        Thread.sleep(5000);
        System.out.println("Sleeper thread done!");
      } catch (InterruptedException ex) {
        throw new RuntimeException(ex);
      }
    });

    try {
      job.get(3, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    } catch (TimeoutException e) {
      job.cancel(true);
      System.out.println("Took: " + (System.currentTimeMillis() - start) + " ms");
    }
    executorService.shutdownNow();
    System.out.println("Main Thread Done!");
  }

}
