package defaultmethod;

public interface DefaultMethInterface {
  void doSomething(int input);
  default void doSomethingElse(String s) {
    System.out.println(s);
    this.doSomethingPrivate(s);
  }

  private void doSomethingPrivate(String s) {
    System.out.println("Private " + s);
  }

}
