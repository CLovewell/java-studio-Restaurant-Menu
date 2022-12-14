package restaurant;

import java.util.ArrayList;
import java.time.LocalDate;

public class Restaurant {
    private static final ArrayList<MenuItem> foodItems = new ArrayList<>();
    private static final Menu menu = new Menu(foodItems);

    public static void main(String... args) {
        menu.add(new MenuItem(6.99,
                "Breaded liquid gold.",
                0,
                "Cheese curds"));
        menu.add(new MenuItem(8.99,
                "The perfect (maybe the only) way to taste coffee.",
                2,
                "Tiramisu"));
        menu.add(new MenuItem(13.49,
                "A classic Italian comfort food. This hearty pasta dish" +
                        " is seasoned with just the right amount of cilantro.",
                1,
                "Chicken alfredo"));
        MenuItem nonsense = new MenuItem(0.99,
                "not a food",
                3,
                "nonsense");
        menu.add(nonsense);
        menu.print();
        nonsense.print();
        menu.remove(nonsense);
        menu.add(new MenuItem(1.99,
                "Fried breaded cow juice.",
                0,
                "Cheese curds"));
        menu.print();
    }
}
