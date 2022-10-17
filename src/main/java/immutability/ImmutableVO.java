package immutability;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@AllArgsConstructor
@Getter
public class ImmutableVO {
  private final String test1;
  private final boolean boolean1;
  private final Map<Integer, Integer> testMap;
}
