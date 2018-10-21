package person;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    public void sortByAgeUseCollection(List<Person> people) {
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Collections.sort(people, comparator);
        System.out.println(people);
    }

    public void sortByAgeStream(List<Person> people) {
        people.stream().sorted((new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        })).forEach(System.out::print);
        System.out.println();

    }

    public void sortByAgeStreamV2(List<Person> people) {
        people.stream()
                .sorted((t1, t2) -> t1.getAge() - t2.getAge())
                .forEach(System.out::print);
        System.out.println();
    }

    public void sortByAgeStreamV3(List<Person> people) {
        people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(System.out::print);
        System.out.println();
    }

    public void sortByNameAndAge(List<Person> people) {
        people.stream()
                .sorted(Comparator.comparing(Person::getName).thenComparingInt(Person::getAge))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        final List<Person> people = Lists.newArrayList(new Person("John", 20), new Person("Sara", 45),
                new Person("Shakira", 20), new Person("Johnny", 19));

        System.out.print("Sorted list: ");
        new Sorting().sortByAgeStream(people);

        System.out.println("Original list: " + people);

        System.out.print("\nSorted list: ");
        new Sorting().sortByAgeUseCollection(people);
        System.out.println("Original list: " + people);

        people.add( new Person("Sara", 15));
        System.out.print("\nSorted by Name&age: ");
        new Sorting().sortByNameAndAge(people);

    }
}
