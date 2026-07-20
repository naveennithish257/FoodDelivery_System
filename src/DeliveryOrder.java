import java.util.ArrayList;

public class DeliveryOrder {

    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private String restaurantName;
    private ArrayList<FoodItem> foodItems;
    private String paymentMode;

    public DeliveryOrder(int orderId,
                         String customerName,
                         String phoneNumber,
                         String address,
                         String restaurantName,
                         String paymentMode) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.restaurantName = restaurantName;
        this.paymentMode = paymentMode;

        foodItems = new ArrayList<>();
    }

    // Add food item to the order
    public void addFoodItem(FoodItem item) {
        foodItems.add(item);
    }

    // Calculate total bill
    public double getTotalAmount() {

        double total = 0;

        for (FoodItem item : foodItems) {
            total += item.getTotalPrice();
        }

        return total;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    @Override
    public String toString() {

        StringBuilder bill = new StringBuilder();

        bill.append("\n=====================================\n");
        bill.append("          ORDER RECEIPT\n");
        bill.append("=====================================\n");

        bill.append("Order ID      : ").append(orderId).append("\n");
        bill.append("Customer      : ").append(customerName).append("\n");
        bill.append("Phone         : ").append(phoneNumber).append("\n");
        bill.append("Address       : ").append(address).append("\n");
        bill.append("Restaurant    : ").append(restaurantName).append("\n");

        bill.append("\nItems Ordered\n");
        bill.append("-------------------------------------\n");

        for (FoodItem item : foodItems) {
            bill.append(item).append("\n");
        }

        bill.append("-------------------------------------\n");
        bill.append("Total Amount  : ₹").append(getTotalAmount()).append("\n");
        bill.append("Payment Mode  : ").append(paymentMode).append("\n");
        bill.append("=====================================\n");

        return bill.toString();
    }
}