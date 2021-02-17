import java.util.LinkedList;
import java.util.List;

/**
 * Created by ariel on 12/09/2019.
 */
public class OutOfMemoryError {
    public static void main(String[] args) {
        List<long[]> list = new LinkedList<long[]>();
        while (true) {
            list.add(new long[65536]); // an arbitrary number
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
