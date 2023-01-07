package streams;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MapCollectorMoreComplex {

  public static void main(String[] args) {
    IncidentConfig incidentConfig = new IncidentConfig();
    IncidentConfigMatcher matcher10 = new IncidentConfigMatcher(1, "mymatcher10");
    TreeSet<IncidentConfigMatcher> ts = new TreeSet<>();
    ts.add(matcher10);
    incidentConfig.setMatchers(ts);

    IncidentConfig incidentConfig2 = new IncidentConfig();
    IncidentConfigMatcher matcher20 = new IncidentConfigMatcher(1, "mymatcher20");
    IncidentConfigMatcher matcher21 = new IncidentConfigMatcher(2, "mymatcher21");
    TreeSet<IncidentConfigMatcher> ts1 = new TreeSet<>();
    ts1.add(matcher20);
    ts1.add(matcher21);
    incidentConfig2.setMatchers(ts1);

    IncidentConfig incidentConfig3 = new IncidentConfig();
    IncidentConfigMatcher matcher30 = new IncidentConfigMatcher(1, "mymatcher30");
    IncidentConfigMatcher matcher31 = new IncidentConfigMatcher(2, "mymatcher31");
    IncidentConfigMatcher matcher103 = new IncidentConfigMatcher(3, "mymatcher10");
    TreeSet<IncidentConfigMatcher> ts2 = new TreeSet<>();
    ts2.add(matcher30);
    ts2.add(matcher31);
    ts2.add(matcher103);
    incidentConfig3.setMatchers(ts2);

    List<IncidentConfig> incidentConfigList = Arrays.asList(incidentConfig, incidentConfig2, incidentConfig3);
    Map<IncidentConfigMatcher, IncidentConfig> result = incidentConfigList.stream()
        .flatMap(c -> c.getMatchers().stream()
            .map(m -> Map.entry(m, c)))
        .collect(
            Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new));
    for (Map.Entry<IncidentConfigMatcher, IncidentConfig> entry : result.entrySet()) {
      System.out.println(entry.getKey() + ", " + entry.getValue());
    }

    System.out.println("----------------------");

    Set<IncidentConfigMatcher> icmSet = new TreeSet<>();
    //icmSet.addAll(List.of(matcher10, matcher20, matcher21, matcher30, matcher31, matcher103));
    icmSet.add(matcher10);
    icmSet.add(matcher20);
    icmSet.add(matcher21);
    System.out.println(matcher10.hashCode() + ", " + matcher20.hashCode() + ", " + matcher21.hashCode() + ", " + matcher10.equals(matcher20));
    for (IncidentConfigMatcher matcher : icmSet) {
      System.out.println(matcher);
    }
  }

  @Getter
  @Setter
  static class IncidentConfig {
    private Set<IncidentConfigMatcher> matchers;

    public String toString() {
      return "IC: " + matchers.size();
    }
  }

  @Getter
  @AllArgsConstructor
  @ToString
  static class IncidentConfigMatcher implements Comparable<IncidentConfigMatcher> {
    private Integer priority;
    private String matcher;

    @Override
    public int compareTo(IncidentConfigMatcher o) {
      int priorityComp = o.getPriority().compareTo(this.getPriority());
      return priorityComp != 0 ? priorityComp : o.getMatcher().compareTo(this.getMatcher());
    }
  }
}
