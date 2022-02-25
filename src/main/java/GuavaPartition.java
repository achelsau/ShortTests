import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class GuavaPartition {
  public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>();
    for (int i = 0; i < 50000000; i++) {
      ints.add(i + 1);
    }

    long start = System.currentTimeMillis();
    List<List<Integer>> partitions = Lists.partition(ints, 500);
    long end = System.currentTimeMillis();
    System.out.println("Took: " + (end - start));
    /*for (List<Integer> partition : partitions) {
      for (Integer e : partition) {
        System.out.print(e + ", ");
      }
      System.out.println();
    }*/
  }
}
