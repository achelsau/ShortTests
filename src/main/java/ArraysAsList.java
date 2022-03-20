import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
  public static void main(String[] args) {
    List<String> arr = Arrays.asList("a", "b", "c");
    arr.remove("c");
  }
}
