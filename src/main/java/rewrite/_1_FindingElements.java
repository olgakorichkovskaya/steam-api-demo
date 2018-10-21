package rewrite;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class _1_FindingElements {

    public List<String> startWithN(List<String> names) {
        final List<String> startWithN = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("N")) {
                startWithN.add(name);
            }
        }
        return startWithN;
    }

    public List<String> startWithB(List<String> names) {
        final List<String> startWithB = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("B")) {
                startWithB.add(name);
            }
        }
        return startWithB;
    }

    public static void main(String[] args) {
        final List<String> names = Lists.newArrayList("Adam", "Brian", "Nick", "Brayan", "Andy", "Joe");

        System.out.println("Start with B");
        new _1_FindingElements().startWithB(names).forEach(System.out::println);

        System.out.println("Start with N");
        new _1_FindingElements().startWithN(names).forEach(System.out::println);
    }
}
