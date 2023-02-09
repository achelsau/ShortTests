package defaultmethod;

public class DefaultMethImpl implements DefaultMethInterface {

  @Override
  public void doSomething(int input) {

  }

  @Override
  public void doSomethingElse(String s) {
    DefaultMethInterface.super.doSomethingElse(s);
  }

  public static void main(String[] args) {
    new DefaultMethImpl().doSomethingElse("Test");
  }
}
