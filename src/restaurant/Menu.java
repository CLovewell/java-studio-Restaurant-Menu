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
        menuItems.add(item);
        lastUpdated = LocalDate.now();
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
        //TODO: account for leap years
        int leapYearCount = 0;
        for (int i = lastUpdated.getYear(); i < today.getYear(); i++) {
            if (Year.of(i).isLeap()) {
                leapYearCount++;
            }
        }
        if (lastUpdated.isLeapYear() && lastUpdated.getDayOfYear() >= 60) {
            leapYearCount--;
        }
        return (today.getYear() - lastUpdated.getYear()) * 365
                + today.getDayOfYear() - lastUpdated.getDayOfYear()
                + leapYearCount;
    }

    public void setLastUpdated(LocalDate date) {
        this.lastUpdated = date;
    }
}
