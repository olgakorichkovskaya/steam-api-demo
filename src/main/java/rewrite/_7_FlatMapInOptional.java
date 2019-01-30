package rewrite;

import group.sort.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

public class _7_FlatMapInOptional {

    //nothing to rewrite, just for info
    public static void main(String[] args) {
        Person anna = new Person("Anna", 52);
        Employee annaEmployee = new Employee("Anna", 52);

        // In Optional
        int age = Optional.ofNullable(anna)
                .map(Person::getName)
                .map(String::length)
                .orElse(42);


        String name = Optional.ofNullable(annaEmployee)
                .flatMap(Employee::getOptionalName)
                .orElse("default");

    }
}

@AllArgsConstructor
@Getter
@ToString
 class Employee {

    private final String name;
    private final int age;

     Optional<String> getOptionalName(){
        return Optional.ofNullable(name);
    }

}