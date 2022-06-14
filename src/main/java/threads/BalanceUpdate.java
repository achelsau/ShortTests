package threads;

public class BalanceUpdate {
  private static int balance = 100;
  public static void main(String[] args) {
    startBalanceUpdateThread();
    startBalanceMonitorThread();
  }

  public static synchronized void updateBalance() {
    balance += 10;
    balance -= 10;
  }

  public static synchronized void monitorBalance() {
    int b = balance;
    if (b != 100) {
      System.out.println("Balance changed: " + b);
      System.exit(0);
    }
  }

  public static void startBalanceUpdateThread() {
    Thread t = new Thread(() -> {
      while (true) {
        updateBalance();
      }
    });
    t.start();
  }

  public static void startBalanceMonitorThread() {
    Thread t = new Thread(() -> {
      while (true) {
        monitorBalance();
      }
    });
    t.start();
  }

}
