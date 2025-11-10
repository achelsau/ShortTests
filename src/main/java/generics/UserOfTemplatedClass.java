package generics;


import main.java.generics.TemplatedClass;

import java.util.List;

public class UserOfTemplatedClass {
  static TemplatedClass<Object> templatedClass = new TemplatedClass<>();

  public static void main(String[] args) {
    templatedClass.bla = List.of(1, 2);
    System.out.println(templatedClass.getT());
  }
}
