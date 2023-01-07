package immutability;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@AllArgsConstructor
@Getter
@Setter
public final class ImmutableVO {
  private String test1;
  private final boolean boolean1;
  private final Map<Integer, Integer> testMap;
}
