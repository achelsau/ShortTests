package main.java.generics;


import java.util.List;

public class TemplatedClass<T> {
  public List<T> bla;

  public List<T> getT() {
    return bla;
  }
}
