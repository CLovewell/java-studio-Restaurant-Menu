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
        menu.add(new MenuItem(0.99,
                "not a food",
                3,
                "nonsense"));
        menu.remove("nonsense");
        menu.print();
        for (MenuItem item : foodItems) {
            System.out.println(item.getCategory());
        }
    }
}
