package streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StringOccurrences {

  public static void main(String[] args) {
    List<String> input = List.of("ll", "llmm", "lmmm", "mmmm");
    //List<String> input = List.of("m", "mmm", "mm", "lll");

    Map<Set<Character>, Integer> occurrences = new HashMap<>();
    for (String s : input) {
      Set<Character> characters = s.chars()
          .mapToObj(e -> (char) e).collect(Collectors.toSet());

      occurrences.merge(characters, 1, Integer::sum);
    }

    for (Map.Entry<Set<Character>, Integer> entry : occurrences.entrySet()) {
      System.out.println(entry.getKey() + ", " + entry.getValue());
    }
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
