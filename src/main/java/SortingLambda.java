import java.util.List;

import com.google.common.collect.Lists;

/**
 * Created by ariel on 02/08/2019.
 */
public class SortingLambda {
    public static void main(String[] args) {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12),
                new Human("Bill", 10),
                new Human("John", 9),
                new Human("James", 11),
                new Human("Dana", 12)
        );

        humans.sort(
                (Human h1, Human h2) -> h2.getAge() > h1.getAge() ? 1 : -1);

        System.out.println(humans);
    }
}

class Human {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Human{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
