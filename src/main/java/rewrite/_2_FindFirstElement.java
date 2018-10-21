package rewrite;

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
}
