public class Factorial {

  public static void main(String[] args) {
    System.out.println(fact(3));
  }

  private static int fact(int n) {
    if (n == 0) {
      return 1;
    } else {
      return fact(n) * fact(n - 1);
    }
  }
}
