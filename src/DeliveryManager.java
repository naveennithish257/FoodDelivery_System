import java.util.ArrayList;

public class DeliveryManager {

    public DeliveryOrder getOrder(int orderId) {

        for (DeliveryOrder order : orders) {

            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        return null;
    }

    private ArrayList<DeliveryOrder> orders = new ArrayList<>();
    private int nextOrderId = 1001;

    // Create a new order
    public DeliveryOrder createOrder(String customerName,
                                     String phone,
                                     String address,
                                     String restaurant,
                                     String paymentMode) {

        DeliveryOrder order = new DeliveryOrder(
                nextOrderId++,
                customerName,
                phone,
                address,
                restaurant,
                paymentMode);

        orders.add(order);

        return order;
    }

    // View all orders
    public void viewOrders() {

        if (orders.isEmpty()) {
            System.out.println("\nNo Orders Found.");
            return;
        }

        for (DeliveryOrder order : orders) {
            System.out.println(order);
        }
    }

    // Cancel Order
    public void cancelOrder(int orderId) {

        for (DeliveryOrder order : orders) {

            if (order.getOrderId() == orderId) {

                orders.remove(order);

                System.out.println("\nOrder Cancelled Successfully.");

                return;
            }
        }

        System.out.println("\nOrder Not Found.");
    }

    // Modify Order (Add another item)
    public void modifyOrder(int orderId, FoodItem item) {

        for (DeliveryOrder order : orders) {

            if (order.getOrderId() == orderId) {

                order.addFoodItem(item);

                System.out.println("\nItem Added Successfully.");

                return;
            }
        }

        System.out.println("\nOrder Not Found.");
    }

    // Restaurant Menu
    public void showMenu(int restaurantChoice) {

        switch (restaurantChoice) {

            case 1:

                System.out.println("\n========= A2B MENU =========");
                System.out.println("1. Idli          ₹40");
                System.out.println("2. Dosa          ₹80");
                System.out.println("3. Pongal        ₹90");
                System.out.println("4. Meals         ₹150");
                System.out.println("5. Finish Order");
                break;

            case 2:

                System.out.println("\n========= KFC MENU =========");
                System.out.println("1. Chicken Burger    ₹199");
                System.out.println("2. Chicken Bucket    ₹599");
                System.out.println("3. French Fries      ₹99");
                System.out.println("4. Pepsi             ₹50");
                System.out.println("5. Finish Order");
                break;

            case 3:

                System.out.println("\n========= DOMINO'S MENU =========");
                System.out.println("1. Margherita Pizza  ₹299");
                System.out.println("2. Veg Pizza         ₹399");
                System.out.println("3. Garlic Bread      ₹149");
                System.out.println("4. Coke              ₹60");
                System.out.println("5. Finish Order");
                break;

            case 4:

                System.out.println("\n========= BURGER KING MENU =========");
                System.out.println("1. Veg Burger        ₹149");
                System.out.println("2. Chicken Burger    ₹199");
                System.out.println("3. Fries             ₹99");
                System.out.println("4. Coke              ₹60");
                System.out.println("5. Finish Order");
                break;
        }
    }

    // Get Food Item
    public FoodItem getFoodItem(int restaurant, int choice, int quantity) {

        switch (restaurant) {

            case 1:

                switch (choice) {

                    case 1: return new FoodItem("Idli", quantity, 40);

                    case 2: return new FoodItem("Dosa", quantity, 80);

                    case 3: return new FoodItem("Pongal", quantity, 90);

                    case 4: return new FoodItem("Meals", quantity, 150);
                }

                break;

            case 2:

                switch (choice) {

                    case 1: return new FoodItem("Chicken Burger", quantity,199);

                    case 2: return new FoodItem("Chicken Bucket", quantity,599);

                    case 3: return new FoodItem("French Fries", quantity,99);

                    case 4: return new FoodItem("Pepsi", quantity,50);
                }

                break;

            case 3:

                switch (choice) {

                    case 1: return new FoodItem("Margherita Pizza", quantity,299);

                    case 2: return new FoodItem("Veg Pizza", quantity,399);

                    case 3: return new FoodItem("Garlic Bread", quantity,149);

                    case 4: return new FoodItem("Coke", quantity,60);
                }

                break;

            case 4:

                switch (choice) {

                    case 1: return new FoodItem("Veg Burger", quantity,149);

                    case 2: return new FoodItem("Chicken Burger", quantity,199);

                    case 3: return new FoodItem("Fries", quantity,99);

                    case 4: return new FoodItem("Coke", quantity,60);
                }
        }

        return null;
    }
}