package streams;

import com.sun.tools.javac.util.List;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParallelStreams {
    enum Setting {
        NONE(1, 2), SOME(2, 3), ALL(3, 4), WITHOUT(4,5);

        private int key;
        private int value;

        Setting(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(2, 5, 6, 9, 10, 2, 4);
        integers.parallelStream().forEach(System.out::println);

        java.util.List<Integer> result = Arrays.stream(Setting.values())
                .map(Setting::getValue)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
