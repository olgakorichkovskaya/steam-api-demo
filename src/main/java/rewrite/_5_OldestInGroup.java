package rewrite;

import com.google.common.collect.Lists;
import group.sort.Person;

import java.util.*;
import java.util.function.Function;

public class _5_OldestInGroup {

    private void oldestInEachGroup(List<Person> people) {
        //people grouped by first letter
        Map<Character, List<Person>> grouped = new HashMap<>();
        for (Person person : people) {
            grouped.computeIfAbsent(getFirstLetter.apply(person), k -> new ArrayList<>()).add(person);
        }
        System.out.println("Grouped by first letter " + grouped);

        //find oldest in each group
        Map<Character, Optional<Person>> oldestInEachGroup = new HashMap<>();
        for (Map.Entry<Character, List<Person>> entry : grouped.entrySet()) {
            Optional<Person> max = entry.getValue().stream().max(Comparator.comparingInt(Person::getAge));
            oldestInEachGroup.put(entry.getKey(), max);
        }


        System.out.println("Oldest in each group: " + oldestInEachGroup);
    }

    private static Function<Person, Character> getFirstLetter = person -> person.getName().charAt(0);

    public static void main(String[] args) {
        final List<Person> people = Lists.newArrayList(new Person("John", 20),
                new Person("Sara", 45),
                new Person("Sara", 15),
                new Person("Shakira", 20),
                new Person("John", 19));
        new _5_OldestInGroup().oldestInEachGroup(people);
    }
}
