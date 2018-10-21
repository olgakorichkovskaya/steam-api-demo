package rewrite;

import com.google.common.collect.Lists;

import java.util.List;

public class _0_TransformingList {

    public void transform(List<String> letters) {
        for (String letter : letters) {
            String l = letter.toLowerCase();
            System.out.print(l + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final List<String> letters = Lists.newArrayList("M", "f", "A", "B", "D");
        new _0_TransformingList().transform(letters);
    }
}
