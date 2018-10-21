package rewrite;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Hints {

    //_1_FindingElements
    public List<String> startWithLetter(List<String> names, String letter) {
        return names.stream()
                .filter(startWithLetter(letter))
                .collect(Collectors.toList());
    }

    private Predicate<String> startWithLetter(String letter) {
        return s -> s.startsWith(letter);
    }

    //_3_ReducingCollectionToSingleValue
    void total(List<String> names) {
        int count = names.stream()
                .mapToInt(String::length)
                .sum();
    }

    //printLongestName
    void longest(List<String> names) {
        Optional<String> longest = names.stream().reduce((s, s2) -> s.length() >= s2.length() ? s : s2);
    }

    //_4_ MinPrice
    void min(List<Integer> integers) {
        Optional<Integer> max = integers.stream()
                .filter(greaterThan(0))
                .max(Comparator.comparingInt(value -> value));
    }

    Predicate<Integer> greaterThan(Integer compareTo) {
        return integer -> integer > compareTo;
    }

    // _5_Oldest - see class Grouping
}
