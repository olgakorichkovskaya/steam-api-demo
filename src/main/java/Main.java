import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        //iterating
         final List<String> letters = Arrays.asList("A", "B", "C", "D");

        // old good for loop
        for (int i = 0; i < letters.size(); i++) {
            System.out.println(letters.get(i));
        }

        // better old good for loop
        for (String letter : letters) {
            System.out.println(letter);
        }

        //java 8 foreach
        letters.forEach(new Consumer<String>() {
            public void accept(String letter) {
                System.out.println(letter);
            }
        });

        //shorter version
        letters.forEach((final String letter) -> {System.out.println(letter);});



        //java compiler automatically detects type
        letters.forEach((letter) -> System.out.println(letter));

        
        //method reference
        letters.forEach(System.out::println);



    }
}
