import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Item class to represent an item in the bill
class Item {
    private String name;
    private int quantity;
    private double price;

    // Constructor
    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }
}

// Billing System class
public class BillingSystem {
    private List<Item> itemList;
    private Scanner scanner;

    // Constructor
    public BillingSystem() {
        itemList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add an item to the bill
    public void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price per unit: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline

        Item item = new Item(name, quantity, price);
        itemList.add(item);

        System.out.println("Item added successfully!");
        pause();
    }

    // Method to display the bill
    public void displayBill() {
        System.out.println("\n--- Bill Summary ---");
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Item", "Quantity", "Price", "Total");
        
        double totalAmount = 0;
        for (Item item : itemList) {
            System.out.printf("%-20s %-10d %-10.2f %-10.2f\n",
                    item.getName(), item.getQuantity(), item.getPrice(), item.getTotalPrice());
            totalAmount += item.getTotalPrice();
        }
        System.out.println("-------------------------------");
        System.out.printf("Total Amount: Rs%.2f\n", totalAmount);
        pause();
    }

    // Method to pause the console until the user presses Enter
    private void pause() {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to display the menu and handle user input
    public void run() {
        int choice;
        do {
            System.out.println("\nBilling System Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. Display Bill");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    displayBill();
                    break;
                case 3:
                    System.out.println("Exiting the Billing System. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
        BillingSystem billingSystem = new BillingSystem();
        billingSystem.run();
    }
}
