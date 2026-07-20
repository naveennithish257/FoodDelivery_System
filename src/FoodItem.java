public class FoodItem {

    private String itemName;
    private int quantity;
    private double price;

    public FoodItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Calculate total for this item
    public double getTotalPrice() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("%-20s x %-2d ₹%.2f",
                itemName, quantity, getTotalPrice());
    }
}