package streams;

import com.sun.source.doctree.EndElementTree;

import lombok.Data;

import java.security.KeyPair;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMap {
  public static void main(String[] args) {
    new FlatMap().map();
  }

  public void map() {
    /*Map<String, List<String>> mp = new HashMap<>();

    mp.put("a", List.of("1", "2"));
    mp.put("c", List.of("3", "4"));
    mp.put("e", List.of("5", "6"));
    mp.put("g", List.of("7", "8"));
    mp.entrySet().stream()
                           .flatMap(entry -> {
                             System.out.println(entry);
                             return entry.getValue().stream();
                           })
        .distinct().sorted().forEach(System.out::println);*/

    Group group1 = new Group();
    group1.ident = 1;
    Group group2 = new Group();
    group2.ident = 2;
    Organization organization = new Organization();
    organization.setGroups(List.of(group1, group2));
    List<Organization> organizations = List.of(organization);
    List<Integer> collect = Optional.ofNullable(organizations)
        .orElse(Collections.emptyList()).stream().flatMap(org -> org.getGroups().stream())
        .map(Group::getIdent)
        .filter(Objects::nonNull)
        .distinct()
        .collect(Collectors.toList());
    System.out.println(collect);
  }

  @Data
  class Organization {
    List<Group> groups;
  }

  @Data
  class Group {
    Integer ident;
  }
}
