import java.util.ArrayList;
import java.util.Scanner;

// Enum to represent types of recyclables
enum RecyclableType {
    PLASTIC, GLASS, PAPER, METAL
}

// Class representing a recyclable item
class RecyclableItem {
    private String name;
    private RecyclableType type;
    private double weight; // in kilograms

    public RecyclableItem(String name, RecyclableType type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public RecyclableType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", Type: " + type + ", Weight: " + weight + " kg";
    }
}

// Recycling Management System
class RecyclingManagementSystem {
    private ArrayList<RecyclableItem> items;

    public RecyclingManagementSystem() {
        this.items = new ArrayList<>();
    }

    // Add a new recyclable item
    public void addRecyclableItem(String name, RecyclableType type, double weight) {
        RecyclableItem item = new RecyclableItem(name, type, weight);
        items.add(item);
        System.out.println("Added: " + item);
    }

    // Display all recyclable items
    public void displayAllItems() {
        System.out.println("\nRecyclable Items:");
        for (RecyclableItem item : items) {
            System.out.println(item);
        }
    }

    // Display statistics by recyclable type
    public void displayStatistics() {
        double totalWeight = 0;
        double plasticWeight = 0, glassWeight = 0, paperWeight = 0, metalWeight = 0;

        for (RecyclableItem item : items) {
            totalWeight += item.getWeight();
            switch (item.getType()) {
                case PLASTIC -> plasticWeight += item.getWeight();
                case GLASS -> glassWeight += item.getWeight();
                case PAPER -> paperWeight += item.getWeight();
                case METAL -> metalWeight += item.getWeight();
            }
        }

        System.out.println("\nRecycling Statistics:");
        System.out.println("Total weight of recyclables: " + totalWeight + " kg");
        System.out.println("Plastic: " + plasticWeight + " kg");
        System.out.println("Glass: " + glassWeight + " kg");
        System.out.println("Paper: " + paperWeight + " kg");
        System.out.println("Metal: " + metalWeight + " kg");
    }
}

// Main class with a basic menu-driven interface
public class RecyclingApp {
    public static void main(String[] args) {
        RecyclingManagementSystem rms = new RecyclingManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Recycling Management System ---");
            System.out.println("1. Add a recyclable item");
            System.out.println("2. Display all items");
            System.out.println("3. Display recycling statistics");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.println("Select item type:");
                    System.out.println("1. Plastic");
                    System.out.println("2. Glass");
                    System.out.println("3. Paper");
                    System.out.println("4. Metal");
                    System.out.print("Choice: ");
                    int typeChoice = scanner.nextInt();
                    RecyclableType type = switch (typeChoice) {
                        case 1 -> RecyclableType.PLASTIC;
                        case 2 -> RecyclableType.GLASS;
                        case 3 -> RecyclableType.PAPER;
                        case 4 -> RecyclableType.METAL;
                        default -> throw new IllegalArgumentException("Invalid type choice");
                    };
                    System.out.print("Enter item weight (in kg): ");
                    double weight = scanner.nextDouble();
                    rms.addRecyclableItem(name, type, weight);
                }
                case 2 -> rms.displayAllItems();
                case 3 -> rms.displayStatistics();
                case 4 -> running = false;
                default -> System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
        System.out.println("Exiting Recycling Management System. Goodbye!");
    }
}

