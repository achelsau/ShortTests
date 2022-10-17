package generics;


import java.util.List;

public class TemplatedClass<T> {
  List<T> bla;

  List<T> getT() {
    return bla;
  }
}
