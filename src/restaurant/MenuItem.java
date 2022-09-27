package restaurant;
import java.time.LocalDate;
import java.util.Objects;

public class MenuItem {
    public static final String[] categories = {"appetizer", "main course", "dessert"};
    public static final int newCap = 60; //number of days a menu item can be considered new
    private double price;
    private String description;
    private int category;
    private final LocalDate dateAdded;
    private String name;

    public MenuItem(double price, String description, int category, String name) {
        this.price = price;
        this.description = description;
        this.category = category;
        this.dateAdded = LocalDate.now();
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        try {
            return MenuItem.categories[this.category];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid category code detected for menu item " +
                    this.toString());
            return "no category";
        }
    }

    public void setCategory(String category) {
        int i;
        for (i = 0; i < categories.length; i++) {
            if (categories[i].equals(category)) {
                this.category = i;
                break;
            }
        }
        if (i == categories.length) {
            System.err.println("Invalid category assigned to " +
                    this.toString());
            this.category = -1;
        }
    }

    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(this.name + "      $" + this.price + '\n');
        System.out.println(this.description + '\n');
    }

    /**
     * Check to see if this menuItem is still new.
     *
     * @return true if the menuItem is still new
     */
    public Boolean isNew() {
        LocalDate today = LocalDate.now();
        return this.dateAdded.plusDays(newCap).isAfter(today);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", dateAdded=" + dateAdded +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return category == menuItem.category &&
                Objects.equals(name, menuItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name);
    }

}
