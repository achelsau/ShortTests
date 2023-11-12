import java.util.HashSet;

public class HashSetCollisions {

  public static void main(String[] args) throws InterruptedException {
    HashSet<Obj> set = new HashSet<>();
    /*set.add(new Obj());
    set.add(new Obj());
    set.add(new Obj());
    set.add(new Obj());*/

    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        set.add(new Obj());
      }
    };
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r1);
    Thread t3 = new Thread(r1);
    Thread t4 = new Thread(r1);
    Thread t5 = new Thread(r1);
    Thread t6 = new Thread(r1);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();

    t1.join();
    t2.join();
    t3.join();
    t4.join();
    t5.join();
    t6.join();
    System.out.println(set.size());
  }

  static class Obj {
    public int hashCode() {
      return 1;
    }

    public boolean equals(Object o) {
      return false;
    }
  }
}
