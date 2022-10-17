package threads.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newCachedThreadPool();
    Future<?> submittedFuture = executor.submit(()
                                           -> System.out.println(Thread.currentThread()));
    System.out.println("Future name " + submittedFuture);
    executor.shutdown();
  }
}
