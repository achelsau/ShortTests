/**
 * Created by ariel on 27/07/2018.
 */
public class EnumsInnerClasses {
    public static void main(String[] args) {
        System.out.println("1: " + TestEnum.A.getClass());
        System.out.println("2: " + TestEnum.C.getClass());
    }

    enum TestEnum {
        A, B, C {
            public boolean isInSchema() {
                return false;
            }
        };

        public boolean isInSchema() {
            return true;
        }
    }
}
