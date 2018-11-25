package infinite;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumbers {

    public static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(t -> number % t == 0);
    }


    public static int nextPrime(int prime){
        int next = prime + 1;
        if(isPrime(next)){
            return next;
        }else {
            return nextPrime((next));
        }
    }

    public static List<Integer> generatePrimes(int from, int count){
        return Stream.iterate(nextPrime(from - 1), PrimeNumbers::nextPrime)
                .limit(count)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println("10 primes from 1: "+generatePrimes(1,10));
        System.out.println("5 primes from 100: "+generatePrimes(100,5));
    }
}
