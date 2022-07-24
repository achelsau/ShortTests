package threads;

import java.util.List;

public class Consumer extends Thread {
  private final Buffer buffer;
  public Consumer(Buffer buffer) {
    this.buffer = buffer;
  }
  @Override
  public void run() {
    List<Integer> data;
    while (true) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      // Consume the data from the buffer. We are not using the consumed
      // data for any other purpose here
      data = buffer.consume();
    }
  }
}
