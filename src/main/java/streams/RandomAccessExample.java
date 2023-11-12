package streams;
import java.io.RandomAccessFile;
import java.io.IOException;

public class RandomAccessExample {
  public static void main(String[] args) {
    try {
      // Open the file in read-only mode
      RandomAccessFile file = new RandomAccessFile("ShortTests.iml", "r");

      // Seek to position 10 in the file
      file.seek(100);

      // Read 4 bytes of data from the file
      byte[] data = new byte[4];
      file.read(data);

      // Close the file
      file.close();

      // Print the data we read
      System.out.println(new String(data));
    } catch (IOException e) {
      System.err.println("An error occurred: " + e.getMessage());
    }
  }
}
