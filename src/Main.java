import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DeliveryManager manager = new DeliveryManager();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      FOOD DELIVERY SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Modify Order");
            System.out.println("4. Cancel Order");
            System.out.println("5. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Customer Name : ");
                    String customer = sc.nextLine();

                    System.out.print("Phone Number : ");
                    String phone = sc.nextLine();

                    System.out.print("Delivery Address : ");
                    String address = sc.nextLine();

                    System.out.println("\nChoose Restaurant");
                    System.out.println("1. A2B");
                    System.out.println("2. KFC");
                    System.out.println("3. Domino's");
                    System.out.println("4. Burger King");

                    System.out.print("Choice : ");
                    int restaurantChoice = sc.nextInt();
                    sc.nextLine();

                    String restaurant = "";

                    switch (restaurantChoice) {
                        case 1:
                            restaurant = "A2B";
                            break;
                        case 2:
                            restaurant = "KFC";
                            break;
                        case 3:
                            restaurant = "Domino's";
                            break;
                        case 4:
                            restaurant = "Burger King";
                            break;
                        default:
                            System.out.println("Invalid Restaurant.");
                            continue;
                    }

                    System.out.println("\nPayment Mode");
                    System.out.println("1. UPI");
                    System.out.println("2. Cash on Delivery");

                    System.out.print("Choice : ");
                    int pay = sc.nextInt();
                    sc.nextLine();

                    String payment =
                            (pay == 1) ? "UPI" : "Cash on Delivery";

                    DeliveryOrder order = manager.createOrder(
                            customer,
                            phone,
                            address,
                            restaurant,
                            payment);

                    while (true) {

                        manager.showMenu(restaurantChoice);

                        System.out.print("Choose Item : ");
                        int itemChoice = sc.nextInt();

                        if (itemChoice == 5)
                            break;

                        System.out.print("Quantity : ");
                        int qty = sc.nextInt();

                        FoodItem item =
                                manager.getFoodItem(
                                        restaurantChoice,
                                        itemChoice,
                                        qty);

                        if (item != null) {

                            order.addFoodItem(item);

                            System.out.println(item.getItemName()
                                    + " Added Successfully.");
                        } else {

                            System.out.println("Invalid Item.");
                        }

                    }

                    System.out.println(order);

                    break;

                case 2:

                    manager.viewOrders();

                    break;

                case 3:

                    System.out.print("Enter Order ID : ");
                    int modifyId = sc.nextInt();

                    DeliveryOrder modifyOrder = manager.getOrder(modifyId);

                    if (modifyOrder == null) {

                        System.out.println("Order Not Found.");
                        break;
                    }

                    int rest = 0;

                    if (modifyOrder.getRestaurantName().equals("A2B"))
                        rest = 1;

                    else if (modifyOrder.getRestaurantName().equals("KFC"))
                        rest = 2;

                    else if (modifyOrder.getRestaurantName().equals("Domino's"))
                        rest = 3;

                    else
                        rest = 4;

                    while (true) {

                        manager.showMenu(rest);

                        System.out.print("Choose Item : ");
                        int item = sc.nextInt();

                        if (item == 5)
                            break;

                        System.out.print("Quantity : ");
                        int qty = sc.nextInt();

                        FoodItem food =
                                manager.getFoodItem(rest,
                                        item,
                                        qty);

                        modifyOrder.addFoodItem(food);

                    }

                    System.out.println("Order Modified Successfully.");

                    break;

                case 4:

                    System.out.print("Enter Order ID : ");
                    int delete = sc.nextInt();

                    manager.cancelOrder(delete);

                    break;

                case 5:

                    System.out.println("\nThank You...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");
            }

        }

    }

}