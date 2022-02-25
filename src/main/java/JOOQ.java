import org.jooq.lambda.Seq;
import org.jooq.lambda.Window;
import org.jooq.lambda.tuple.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class JOOQ {
  public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>();
    for (int i = 0; i < 50000000; i++) {
      ints.add(i + 1);
    }

    int pageSize = 500;
    long start = System.currentTimeMillis();
    Seq.of(ints.toArray()).window(0, pageSize - 1)
        .filter(w -> (w.count() == pageSize || w.count() == ints.size() % pageSize) && w.rowNumber() % pageSize == 0)
        .map(w -> w.toList());
    long end = System.currentTimeMillis();
    System.out.println("Took: " + (end - start));

    System.out.println(Math.ceil((double)9 / 3));
  }
}
