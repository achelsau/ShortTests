package threads;

public class PrinterThread {
  public static void main(String[] args) {
    // Create a new thread
    Thread t1 = new Thread(PrinterThread::print);
    Thread t2 = new Thread(PrinterThread::print);
    t1.start();
    t2.start();
  }

  public static void print() {
    for (int i = 1; i <= 500; i++) {
      System.out.print(i + " ");
    }
  }
}
