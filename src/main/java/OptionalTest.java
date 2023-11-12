import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by ariel on 18/12/2017.
 */
public class OptionalTest {

    public static void main(String[] args) {
        /*Optional<String> optional = Optional.empty();

        optional = Optional.of(new String("a"));*/

        new OptionalTest().test();

        TestObj testObj1 = null;
        TestObj testObj2 = new TestObj(10);
        Integer optn = Optional.ofNullable(testObj1).map(t -> t.n * 2).orElse(0);
        System.out.println(optn);

        String namespace = "a";
        String result = Optional.ofNullable(namespace).orElseThrow();

        System.out.println(result);

        Object o = Optional.ofNullable(null).orElse(null);
        o.hashCode();
        System.out.println("Opt: " + o);
    }

    private int test() {
        for(;;) {
            try {
                return 1;
            } finally {
                break;
            }
        }
        return -1;
    }
}

class TestObj {
    public Integer n = 10;

    public TestObj(Integer n) {
        this.n = n;
    }
}
