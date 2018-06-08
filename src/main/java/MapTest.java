import java.util.HashMap;
import java.util.Map;

/**
 * Created by ariel on 18/12/2017.
 */
public class MapTest {

    private static Map<String, String> mapTest = new HashMap<>();

    public static void main(String[] args) {
        mapTest.put("a", "1");
        mapTest.put("b", "2");
        mapTest.put("c", "3");
        mapTest.put("d", "3");
        mapTest.put("e", "3");
        mapTest.put("f", "3");
        mapTest.put("g", "3");

        System.out.println(mapTest.keySet());
    }
}
