package threads;

public class ThreadInterrupt {

  public static void main(String[] args) {
    Thread.currentThread().interrupt();

    System.out.println("Interrupted");

    throw new RuntimeException("Bla");
  }

}
