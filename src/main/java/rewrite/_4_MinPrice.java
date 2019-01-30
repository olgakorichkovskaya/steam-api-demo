package rewrite;


import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

public class _4_MinPrice {

    private static void printMinPriceUSD(List<Price> prices) {
        final String usd = "USD";
        if (prices.isEmpty()) {
            System.out.println("No prices in " + usd);
            return;
        }

        Price min = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            final Price price = prices.get(i);
            if (price.getCurrency().equals(usd) && price.getAmount() < min.getAmount()) {
                min = price;
            }
        }
        if (min.getCurrency().equals(usd)) {
            System.out.println("The lowest price is " + min + " " + usd);
        } else {
            System.out.println("No prices in " + usd);
        }
    }

    private static void printMinPricePLN(List<Price> prices) {
        final String pln = "PLN";
        if (prices.isEmpty()) {
            System.out.println("No prices in " + pln);
            return;
        }

        Price min = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            final Price price = prices.get(i);
            if (price.getCurrency().equals(pln) && price.getAmount() < min.getAmount()) {
                min = price;
            }
        }
        if (min.getCurrency().equals(pln)) {
            System.out.println("The lowest price is " + min + " " + pln);
        } else {
            System.out.println("No prices in " + pln);
        }
    }

    public static void main(String[] args) {
        final List<Price> prices = Lists.newArrayList(new Price("USD", 2),
                new Price("PLN", 1),
                new Price("USD", 0),
                new Price("PLN", 5));

        printMinPricePLN(prices);
        printMinPriceUSD(prices);
        printMinPriceUSD(Collections.singletonList(new Price("EUR", 100)));
    }
}

@ToString(exclude = {"currency"})
@Getter
@AllArgsConstructor
class Price {
    String currency;
    int amount;
}