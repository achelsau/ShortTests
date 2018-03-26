import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.internal.util.xml.impl.Input;

/**
 * Created by ariel on 18/12/2017.
 */
public class GenericsExtends {
    private static List<? extends InputStream> listTest = new ArrayList<FileInputStream>();
    private static List<? super InputStream> listTestSuper = new ArrayList<InputStream>();

    public static void main(String[] args) throws IOException {
        // NOT POSSIBLE!!!
        // listTest.add(new FileInputStream("file"));

        // POSSIBLE
        // listTest.get(0).available();

        listTestSuper.add(new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        });
        System.out.println(listTestSuper.get(0));
    }
}
