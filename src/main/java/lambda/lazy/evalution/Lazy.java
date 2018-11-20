package lambda.lazy.evalution;

import java.util.Random;
import java.util.function.Supplier;

public class Lazy {

    private static Supplier<Boolean> operation1  = () -> {
        Boolean isNecessaryNextOperation = new Random().nextBoolean();
        System.out.println("Heavy operation 1. Next heavy operation necessary: " + isNecessaryNextOperation);
        return isNecessaryNextOperation;
    };
    private static Supplier<Boolean> operation2  = () -> {
        Boolean isNecessaryNextOperation = new Random().nextBoolean();
        System.out.println("Heavy operation 2. Next heavy operation necessary: " + isNecessaryNextOperation);
        return isNecessaryNextOperation;
    };

    public static void main(String[] args) {
        new Lazy().evaluateLazy(operation1, operation2);
    }

    private void evaluateLazy(Supplier<Boolean> operation1, Supplier<Boolean> operation2) {
        boolean result = operation1.get() && operation2.get();
    }
}
