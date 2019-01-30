package group.sort;

import com.google.common.collect.Lists;

import java.util.List;

import static java.util.Comparator.comparingInt;

public class Oldest {

    static void findOldest(List<Person> people) {
        if (people.isEmpty()) {
            return;
        }
        Person oldest = people.get(0);
        for (Person person : people) {
            if (person.getAge() > oldest.getAge()) {
                oldest = person;
            }
        }
        System.out.println("The oldest one is " + oldest);
    }

    static void findOldestStream(List<Person> people) {
        people.stream()
                .max(comparingInt(Person::getAge))
                .ifPresent(t -> System.out.println("The oldest is " + t));
    }

    public static void main(String[] args) {
        final List<Person> people = Lists.newArrayList(
                new Person("John", 20),
                new Person("Sara", 115),
                new Person("Shakira", 20),
                new Person("Johnny", 19));

        findOldest(people);

        findOldestStream(people);
    }
}