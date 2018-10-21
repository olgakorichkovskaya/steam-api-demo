package rewrite;

import com.google.common.collect.Lists;

import java.util.List;


public class _2_FindFirstElement {

    public void findFirst(List<String> names, String startingLetter) {
        String foundName = null;
        for (int i = names.size() - 1; i >= 0; i--) {
            String name = names.get(i);
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }

        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No elements found.");
        }
    }


    public static void main(String[] args) {
        final List<String> names = Lists.newArrayList("Adam", "Brian", "Nick", "Brayan", "Andy", "Joe");
        new _2_FindFirstElement().findFirst(names, "B");
    }
}