package immutability;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class MutableVO {
  public String test1;
  public boolean boolean1;
  public Map<Integer, Integer> testMap;
}
