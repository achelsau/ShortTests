package streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ForEach {
  public static void main(String[] args) {
    Set<Integer> programIds = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
    Set<Integer> existingProgramIds = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    existingProgramIds.forEach(programIds::remove);

    System.out.println(programIds);
  }
}
