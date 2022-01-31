import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        LocalTime time = LocalTime.now();
        int RestaurantCloses = time.compareTo(closingTime);
        int RestaurantOpens = time.compareTo(openingTime);
        if (RestaurantCloses < 0 && RestaurantOpens >= 0) {
            return true;
        } else {
            return false;
        }
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public List<Item> getMenu() {
        return this.menu;
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());
    }

    public String getName() {
        return name;
    }

    List<String> selectedItem = new ArrayList<String>();
    public void addToSelectedItems(String name) {
        selectedItem.add(getName());
    }

    public int getTotalCost(List<String> selectedItems) {
        int totalCost = 0;
        for (String itemName : selectedItems) {
            totalCost = totalCost + findItemByName(itemName).getPrice();

        }
        return totalCost;
    }

}
