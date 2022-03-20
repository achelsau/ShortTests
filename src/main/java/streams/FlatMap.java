package streams;

import com.sun.source.doctree.EndElementTree;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMap {
  public static void main(String[] args) {
    new FlatMap().map();
  }

  public void map() {
    Map<String, List<String>> mp = new HashMap<>();

    mp.put("a", List.of("1", "2"));
    mp.put("c", List.of("3", "4"));
    mp.put("e", List.of("5", "6"));
    mp.put("g", List.of("7", "8"));
    System.out.println(mp.entrySet().stream()
                           .flatMap(entry -> entry.getValue().stream()));
  }
}
