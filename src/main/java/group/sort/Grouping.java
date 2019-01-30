package group.sort;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grouping {

    private static Function<Person, Character> getFirstLetter
            = person -> person.getName().charAt(0);

    private static void groupByFirstLetter(List<Person> people) {
        final Map<Character, List<Person>> byFirstLetter =
                people.stream().collect(Collectors.groupingBy(getFirstLetter));
        System.out.println("Grouped by first letter " + byFirstLetter);
    }

    private void oldestInEachGroup(List<Person> people) {
        Comparator<Person> comparatorByAge = Comparator.comparingInt(Person::getAge);
        Map<Character, Optional<Person>> oldest = people.stream()
                .collect(Collectors.groupingBy(getFirstLetter,
                        Collectors.reducing(BinaryOperator.maxBy(comparatorByAge))));

        System.out.println("Oldest in each group: "+oldest);
    }

    public static void main(String[] args) {
        final List<Person> people = Lists.newArrayList(
                new Person("John", 20),
                new Person("Sara", 45),
                new Person("Sara", 15),
                new Person("Shakira", 20),
                new Person("John", 19));

        groupByFirstLetter(people);
        new Grouping().oldestInEachGroup(people);

    }


}
