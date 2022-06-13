package streams;

import java.util.List;
import java.util.stream.Stream;

public class SquareIntSums {
  public static void main(String[] args) {
    // Compute the sum of the squares of all odd integers in the list
    int sum = Stream.of(1, 2, 3, 4, 5)
        .filter(n -> n % 2 == 1)
        .map(n -> n * n)
        .reduce(0, Integer::sum);
    System.out.println("Sum = " + sum);

    Stream.generate(Math::random)
        .limit(5)
        .forEach(System.out::println);

    int s = Stream.of(1, 2, 3, 4, 5)
        .peek(e -> System.out.println("Taking integer: " + e))
        .filter(n -> n % 2 == 1)
        .peek(e -> System.out.println("Filtered integer: " + e))
        .map(n -> n * n)
        .peek(e -> System.out.println("Mapped integer: " + e))
        .reduce(0, Integer::sum);
  }
}
