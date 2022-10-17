package generics;

import com.sun.tools.javac.util.List;

public class UserOfTemplatedClass {
  static TemplatedClass<Integer> templatedClass = new TemplatedClass<>();

  public static void main(String[] args) {
    templatedClass.bla = List.of(1, 2);
    System.out.println(templatedClass.getT());
  }
}
