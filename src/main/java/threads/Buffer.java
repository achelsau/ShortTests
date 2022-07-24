package threads;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
  private List<Integer> data = new ArrayList<>();
  private boolean empty;
  public Buffer() {
    this.empty = true;
  }
  public synchronized void produce(int newData) {
    // Wait until the buffer is empty
    while (!this.empty) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // Store the new data produced by the producer
    this.data.add(newData);
    if (this.data.size() > 10) {
      // Set the empty flag to false, so the consumer may consume the data
      this.empty = false;
      // Notify the waiting consumer in the wait set
      this.notify();
      System.out.println("Produced:" + data);
    }

  }
  public synchronized List<Integer> consume() {
    // Wait until the buffer gets some data
    while (this.empty) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // Set the empty flag to true, so that the producer can store new data
    this.empty = true;
    List<Integer> consumed = new ArrayList<>();
    for (int i : data) {
      consumed.add(i);
    }
    // Notify the waiting producer in the wait set
    this.notify();
    System.out.println("Consumed: " + consumed);
    data.clear();
    return consumed;
  }
}
