package streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StringOccurrences {

  public static long nextSeven(long x) {
    if (x % 10 == 7 && x % 3 == 0) {
      return x;
    }
    long next = (x / 10 + 1) * 10 + 7 - x % 10;
    if (next % 3 == 0) {
      return next;
    }
    return nextSeven(next);
  }

  public static long nextSevenProduct(long x, long y) {
    long nextX = nextSeven(x);
    long nextY = nextSeven(y);
    return nextX * nextY;
  }

  public static void main(String[] args) {
    List<String> input = List.of("deal", "filed", "life", "flied");
    //List<String> input = List.of("m", "mmm", "mm", "lll");

    Map<Set<Character>, Integer> occurrences = new HashMap<>();
    for (String s : input) {
      Set<Character> characters = s.chars()
          .mapToObj(e -> (char) e).collect(Collectors.toSet());

      occurrences.merge(characters, 1, Integer::sum);
    }

    Map<Set<Character>, Integer> occurrencesW = new HashMap<>();
    String str = new String("field");
    Set<Character> characters = str.chars()
        .mapToObj(e -> (char) e).collect(Collectors.toSet());
    occurrencesW.merge(characters, 1, Integer::sum);
    System.out.println(occurrencesW);

    for (Map.Entry<Set<Character>, Integer> entry : occurrences.entrySet()) {
      List<Character> word = entry.getKey().stream().collect(Collectors.toList());
      System.out.println(word.stream().map(e -> e.toString()).collect(Collectors.joining()) + ": " + entry.getValue());
    }

    TreeSet<Character> c = new TreeSet<>();
    c.add('b');
    c.add('t');
    c.add('z');
    c.add('n');
    c.stream().map(Object::toString).collect(Collectors.joining());

    /*int entryUrlNo = -5;
    entryUrlNo = entryUrlNo < 0 ? -entryUrlNo : 0;
    System.out.println(entryUrlNo);*/
    //System.out.println("NS:" + nextSevenProduct(18, 15));
  }

}

class ValueComparator implements Comparator<Integer> {
  Map<Integer, String> base;
  public ValueComparator(Map<Integer, String> base) {
    this.base = base;
  }
  public int compare(Integer a, Integer b) {
    return base.get(a).compareTo(base.get(b)) * -1;
  }
}
