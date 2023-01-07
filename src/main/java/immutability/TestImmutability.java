package immutability;

import java.util.HashMap;
import java.util.Map;

public class TestImmutability {

  public static void main(String[] args) {
    Map<Integer, Integer> testMap = new HashMap<>();
    testMap.put(1, 2);
    testMap.put(3, 4);

    MutableVO mutableVO = new MutableVO("test1", true, testMap);
    ImmutableVO immutableVO = ImmutableVO.builder().test1(mutableVO.getTest1())
        .boolean1(mutableVO.isBoolean1()).testMap(mutableVO.getTestMap()).build();
    mutableVO.getTestMap().put(1, 5);

    mutableVO.setBoolean1(false);
    System.out.println("Immutability test: " + immutableVO.getTestMap());
    System.out.println("Immutability test: " + immutableVO.isBoolean1());

    ImmutableVO immutableVO1 = ImmutableVO.builder().test1(mutableVO.getTest1())
        .boolean1(mutableVO.isBoolean1()).testMap(mutableVO.getTestMap()).build();
    immutableVO1.setTest1("Bla");
  }
}
