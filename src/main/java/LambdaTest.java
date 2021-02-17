import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by ariel on 24/07/2019.PMLpc
 */
public class LambdaTest {
    private static int cint = 0;

    public static void main(String[] args) {
        //new LambdaTest().lambdaTest();

        new LambdaTest().workaroundMultithreading();
    }

    public synchronized void lambdaTest() {
        List<String> l = Arrays.asList("a", "g", "r", "y", "p");
        int c = 0;
        cint++;
        l.stream().filter(e -> {
            System.out.println("filter: " + e + " with c: " + cint);
            return true;
        }).forEach(s -> System.out.println("forEach: " + s));

        System.out.println(c);
    }

    public int workaroundSingleThread() {
        int[] holder = new int[] { 2 };
        IntStream sums = IntStream
                .of(1, 2, 3)
                .map(val -> val + holder[0]);

        holder[0] = 0;

        return sums.sum();
    }

    public void workaroundMultithreading() {
        int[] holder = new int[] { 2 };
        Runnable runnable = () -> System.out.println(IntStream
                .of(1, 2, 3)
                .map(val -> val + holder[0])
                .sum());

        new Thread(runnable).start();

        // simulating some processing
        try {
            long millis = new Random().nextInt(3) * 1000L;
            //System.out.println("Sleeping " + millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        holder[0] = 0;
    }
}
