import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by ariel on 18/12/2017.
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();

        optional = Optional.of(new String("a"));
    }
}
