package rewrite;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class _3_ReducingCollectionToSingleValue {

    public void printTotalNumberOfCharacters(List<String> names) {
        int total = 0;
        for (int i = names.size() - 1; i >= 0; i--) {
            String name = names.get(i);
            total = +name.length();
        }
        System.out.println("Total number of characters " + total);
    }

    public void printLongestName(List<String> names) {
        if (0 == names.size()) {
            System.out.println("List is empty!");
        }
        String longest = names.get(0);
        for (int i = 1; i < names.size(); i++) {
            String name = names.get(i);
            if (longest.length() < name.length()) {
                longest = name;
            }
        }
        System.out.println("The longest name is " + longest);

    }
}

