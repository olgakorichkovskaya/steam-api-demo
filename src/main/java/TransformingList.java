import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformingList {

    private final List<String> letters = Arrays.asList("A", "B", "C", "D");

    public void transformToLowerCase() {
        //transforming
        final List<String> lowerCaseLetters = new ArrayList<>();
        for (String letter : letters) {
            lowerCaseLetters.add(letter.toLowerCase());
        }
        System.out.println(lowerCaseLetters);








        //use foreach
        final List<String> lowerCaseLetter2 = new ArrayList<>();
        letters.forEach(l -> lowerCaseLetter2.add(l.toLowerCase()));
        System.out.println(lowerCaseLetter2);








        //use streams and lambda expression
        letters.stream()
                .map(l->l.toLowerCase())
                .forEach(l -> System.out.print(l + " "));
        System.out.println();






        //stream + method ref
        letters.stream()
                .map(String::toLowerCase)
                .forEach(l -> System.out.print(l + " "));
        System.out.println();

    }
}
