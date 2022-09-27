package restaurant;
import java.time.Year;
import java.util.ArrayList;
import java.time.LocalDate;

public class Menu {
    private LocalDate lastUpdated; //the date of the most recent addition to the menu
    private final ArrayList<MenuItem> menuItems;

    public Menu(ArrayList<MenuItem> items) {
        this.menuItems = items;
        lastUpdated = LocalDate.now();
    }

    public void add(MenuItem item) {
        if (menuItems.contains(item)){
            System.err.println("Cannot add duplicate menu item: " +
                    item.toString());
        }
        else {
            menuItems.add(item);
            lastUpdated = LocalDate.now();
        }
    }

    public void remove(MenuItem item) {
        menuItems.remove(item);
    }

    public void remove(String name) {
        for (MenuItem item: menuItems) {
            if (item.getName().equals(name)) {
                menuItems.remove(item);
                break;
            }
        }
    }

    public void print() {
        for (MenuItem menuItem : this.menuItems) {
            menuItem.print();
        }
    }

    public int daysSinceLastUpdate() {
        LocalDate today = LocalDate.now();
        int dayCount = 0;
        if (today.getYear() == lastUpdated.getYear()) {
            dayCount = today.getDayOfYear() - lastUpdated.getDayOfYear();
        }
        else {
            dayCount += lastUpdated.lengthOfYear() - lastUpdated.getDayOfYear();
            for (int i = lastUpdated.getYear() + 1; i < today.getYear(); i++) {
                dayCount += Year.of(i).length();
            }
            dayCount += today.getDayOfYear();
        }
        return dayCount;
    }

    public void setLastUpdated(LocalDate date) {
        this.lastUpdated = date;
    }
}
