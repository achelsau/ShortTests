import com.google.common.base.Optional;

public class BoxingUnboxing {
    public static void main(String[] args) {
        //Integer i = null;
        //System.out.println("Value for null " + i);

        System.out.println("Bla: "  + Optional.fromNullable(null).get());
    }
}
