package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableDriver {

  public static void main(String[] args) throws IOException {
    try {
      NonserializableObj nonserializableObj = new NonserializableObj();
      nonserializableObj.setProperty("Example");
      SerializableContainer container = new SerializableContainer(nonserializableObj);

      FileOutputStream fileOutputStream
          = new FileOutputStream("serialization-result.txt");
      ObjectOutputStream objectOutputStream
          = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(container);
      objectOutputStream.flush();
      objectOutputStream.close();
      return;
    } finally {
      System.out.println("Finally!!!");
    }
  }
}
