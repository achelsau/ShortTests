package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            integers.add(i);
        }
        System.out.println("Parallel Stream:");
        long start = System.currentTimeMillis();
        integers.parallelStream().forEach(i -> {
            try {
                System.out.print(i + " ");
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("");
        System.out.println("Parallel took: " + (System.currentTimeMillis() - start));
        System.out.println("Sequential Stream:");
        start = System.currentTimeMillis();
        integers.stream().forEach(i -> {
            try {
                System.out.print(i + " ");
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("");
        System.out.println("Sequential took: " + (System.currentTimeMillis() - start));

        java.util.List<Integer> result = Arrays.stream(Setting.values())
                .map(Setting::getValue)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
