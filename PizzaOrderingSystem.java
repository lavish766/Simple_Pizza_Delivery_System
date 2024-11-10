import java.util.ArrayList;
import java.util.Scanner;

// Pizza class represents each pizza item with a name and price.
class Pizza {
    String name; // Name of the pizza
    double price; // Price of the pizza

    // Constructor to initialize the pizza with a name and price
    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method to get the pizza's name
    public String getName() {
        return name;
    }

    // Method to get the pizza's price
    public double getPrice() {
        return price;
    }
}

// Order class stores all the pizzas that a user has selected to order
class Order {
    private ArrayList<Pizza> pizzas = new ArrayList<>(); // List to store pizzas in the order

    // Method to add a pizza to the order
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    // Method to calculate the total price of all pizzas in the order
    public double calculateTotal() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice(); // Adding each pizza's price to total
        }
        return total;
    }

    // Method to print the final bill with each pizza and total amount
    public void printBill() {
        System.out.println("\n--- Pizza Bill ---");
        for (Pizza pizza : pizzas) {
            System.out.printf("%s - $%.2f\n", pizza.getName(), pizza.getPrice()); // Print each pizza with price
        }
        System.out.printf("Total Amount: $%.2f\n", calculateTotal()); // Print total amount
    }
}

// Main class containing the menu, user interaction, and order processing
public class PizzaOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pizza> menu = new ArrayList<>(); // List to store menu of pizzas

        // Predefined menu items with name and price
        menu.add(new Pizza("Margherita", 5.99));
        menu.add(new Pizza("Pepperoni", 6.99));
        menu.add(new Pizza("BBQ Chicken", 7.99));
        menu.add(new Pizza("Veggie", 6.49));

        System.out.println("Welcome to the Pizza Ordering System!");
        System.out.println("Here is our menu:");

        // Display menu with pizza names and prices
        for (int i = 0; i < menu.size(); i++) {
            Pizza pizza = menu.get(i);
            System.out.printf("%d. %s - $%.2f\n", i + 1, pizza.getName(), pizza.getPrice());
        }

        Order order = new Order(); // Create a new order

        // Loop to take orders until user enters 0 to finish
        while (true) {
            System.out.print("Enter the pizza number to order (or 0 to finish): ");
            int choice = scanner.nextInt(); // Get user choice

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= menu.size()) {
                Pizza selectedPizza = menu.get(choice - 1);
                order.addPizza(selectedPizza);
                System.out.println("Added " + selectedPizza.getName() + " to your order.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // Print the final bill with all ordered pizzas and total amount
        order.printBill();
        System.out.println("Thank you for your order!");

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
