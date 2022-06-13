package functions;

import java.util.List;
import java.util.function.IntFunction;

public class IntFunctionExample {
    public static void main(String[] args) {
        IntFunctionExample ife = new IntFunctionExample();
        IntFunction<List<Integer>> intFunction = ife::getInts;

        String s = "abc";
        if (s.equals(null)) {
            System.out.printf("Bla");
        }
    }

    private List<Integer> getInts(int i) {
        return null;
    }

    public List<Integer> getInts() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
 }
