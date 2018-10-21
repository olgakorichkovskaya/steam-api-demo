package rewrite;

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


}
