package lambda.lazy;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

public class LazyStream {

    public static void main(String[] args) {
        final List<String> people = Lists.newArrayList("John", "Sara", "Lee", "Shakira", "Johnny");

        Stream<String> stringStream = people.stream()
                .filter(t -> getLength(t) == 3)
                .map(LazyStream::toUpperCase);

        System.out.println("Stream created.");
        String first = stringStream.findFirst().get();
        System.out.println(first);
    }

    private static <R> String toUpperCase(String s) {
        System.out.println("Converting to uppercase " + s);
        return s.toUpperCase();
    }

    private static int getLength(String string) {
        System.out.println("Length for " + string);
        return string.length();
    }
}
