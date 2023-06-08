package fr.epita.assistants.pizzastreams;

import java.util.List;
import java.util.stream.Stream;

import fr.epita.assistants.pizzastreams.Topping.*;

public class PizzaStreams {
    /**
     * @return The sum of the prices of all the pizzas in the stream
     */
    public static Integer getTotalPrice(Stream<Pizza> pizzaStream) {
        Integer sum = pizzaStream.map(Pizza::getPrice).reduce(0, Integer::sum);
        return sum;
    }

    /**
     * @return The average price of the pizzas in the stream, or the
     * double NaN if the stream is empty
     */
    public static Double getAveragePrice(Stream<Pizza> pizzaStream) {
        Double sum = pizzaStream.mapToDouble(Pizza::getPrice).average().orElse(Double.NaN);
        return sum;
    }

    /**
     * @return Names of the pizzas, sorted by price in ascending order
     */
    public static List<String> sortByPrice(Stream<Pizza> pizzaStream) {
        List<String> sorted = pizzaStream.sorted((p1, p2) -> p1.getPrice() - p2.getPrice())
                .map(Pizza::getName)
                .toList();
        return sorted;
    }

    /**
     * @return The Pizza object that has the lowest price, or null by default
     */
    public static Pizza getCheapest(Stream<Pizza> pizzaStream) {
        Pizza cheapest = pizzaStream.min((p1, p2) -> p1.getPrice() - p2.getPrice()).orElse(null);
        return cheapest;
    }

    /**
     * @return Names of the pizzas with meat (Protein)
     */
    public static List<String> getCarnivorous(Stream<Pizza> pizzaStream) {
        List<String> carnivorous = pizzaStream.filter(p -> p.getTopping().getProtein().isPresent())
                .map(Pizza::getName)
                .toList();
        return carnivorous;
    }

    /**
     * @return Names of the pizzas with at least one Vegetable and no Proteins
     */
    public static List<String> getVeggies(Stream<Pizza> pizzaStream) {
        List<String> veggies = pizzaStream.filter(p -> p.getTopping().getProtein().isEmpty())
                .filter(p -> !p.getTopping().getVegetableList().isEmpty())
                .map(Pizza::getName)
                .toList();
        return veggies;
    }

    /**
     * @return true if all the pizzas with a nature dough are based with tomato
     * and mozzarella (italian pizza criteria), false otherwise
     */
    public static boolean areAllNatureItalians(Stream<Pizza> pizzaStream) {
        boolean allNatureItalians = pizzaStream.filter(p -> p.getDough() == Dough.NATURE)
                .allMatch(p -> p.getTopping().getSauce() == Sauce.TOMATO
                        && p.getTopping().getCheese() == Cheese.MOZZARELLA);
        return allNatureItalians;
    }
}
