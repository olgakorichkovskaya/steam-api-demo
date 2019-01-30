package rewrite;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class _6_FlatMap {

    // { {'A','B'}, {'C','D'}, {'E','F} } -> flatMap -> {'A','B','C','D','E','F'}
    public static void main(String[] args) {
        final List<List<String>> listsOfList = Arrays.asList(
            Lists.newArrayList("A", "B"),
            Lists.newArrayList("C", "D")
        );

        System.out.println("List of List: " + listsOfList);

        final List<String> flatList = convertToFlatList(listsOfList);
        System.out.println("Flat list: " + flatList);

    }

    private static List<String> convertToFlatList(List<List<String>> listsOfList) {
        final List<String> flatList = new ArrayList<>();
        for (List<String> subList : listsOfList) {
            for (String letter : subList) {
                flatList.add(letter.toLowerCase());
            }
        }
        return flatList;
    }

}
