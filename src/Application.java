import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        while (true) {
            System.out.println("\n--- Welcome to Grubbin Sanwich Deli ---");
            System.out.println("1. Add Order");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addOrder();
                    break;
                case "0":
                    System.out.println("Thank you for visiting!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void addOrder() {
        ArrayList<String> order = new ArrayList<>();
        double total = 0.0;

        while (true) {
            System.out.println("\n--- Order Menu ---");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    StringBuilder sandwichPreview = new StringBuilder("Current Sandwich: ");

                    // Bread Type
                    String breadType = "";
                    while (true) {
                        System.out.println("\n--- Choose Bread Type ---");
                        System.out.println("1. White");
                        System.out.println("2. Wheat");
                        System.out.println("3. Rye");
                        System.out.println("4. Wrap");
                        System.out.print("Enter choice: ");
                        String breadChoice = scanner.nextLine();

                        switch (breadChoice) {
                            case "1": breadType = "White"; break;
                            case "2": breadType = "Wheat"; break;
                            case "3": breadType = "Rye"; break;
                            case "4": breadType = "Wrap"; break;
                            default:
                                System.out.println("Invalid bread type. Please try again.");
                                continue;
                        }
                        System.out.println("Selected: " + breadType + " bread");
                        sandwichPreview.append(breadType).append(" bread");
                        break;
                    }

                    // Bread Size
                    String breadSize = "";
                    double breadPrice = 0.0;
                    double meatPrice = 0.0;
                    double extraMeatPrice = 0.0;
                    while (true) {
                        System.out.println("\n--- Choose Bread Size ---");
                        System.out.println("1. 4-inch ($5.50)");
                        System.out.println("2. 8-inch ($7.00)");
                        System.out.println("3. 12-inch ($8.50)");
                        System.out.print("Enter choice: ");
                        String sizeChoice = scanner.nextLine();

                        switch (sizeChoice) {
                            case "1": breadSize = "4-inch"; breadPrice = 5.50; meatPrice = 1.00; extraMeatPrice = 0.50; break;
                            case "2": breadSize = "8-inch"; breadPrice = 7.00; meatPrice = 2.00; extraMeatPrice = 1.00; break;
                            case "3": breadSize = "12-inch"; breadPrice = 8.50; meatPrice = 3.00; extraMeatPrice = 3.00; break;
                            default:
                                System.out.println("Invalid bread size. Please try again.");
                                continue;
                        }
                        System.out.println("Selected: " + breadSize + " bread - $" + String.format("%.2f", breadPrice));
                        sandwichPreview.insert(0, breadSize + " "); // Prepend the size
                        break;
                    }

                    // Meat choice
                    String meat = "";
                    while (true) {
                        System.out.println("\n--- Choose Meat ---");
                        System.out.println("1. Steak");
                        System.out.println("2. Ham");
                        System.out.println("3. Salami");
                        System.out.println("4. Roast beef");
                        System.out.println("5. Chicken");
                        System.out.println("6. Bacon");
                        System.out.print("Enter choice: ");
                        String meatChoice = scanner.nextLine();

                        switch (meatChoice) {
                            case "1": meat = "Steak"; break;
                            case "2": meat = "Ham"; break;
                            case "3": meat = "Salami"; break;
                            case "4": meat = "Roast beef"; break;
                            case "5": meat = "Chicken"; break;
                            case "6": meat = "Bacon"; break;
                            default:
                                System.out.println("Invalid meat choice. Please try again.");
                                continue;
                        }
                        System.out.println("Selected: " + meat + " - $" + String.format("%.2f", meatPrice));
                        sandwichPreview.append(", ").append(meat);
                        break;
                    }

                    // Ask for extra meat
                    boolean hasExtraMeat = false;
                    while (true) {
                        System.out.println("Would you like extra " + meat + " for an additional $" + String.format("%.2f", extraMeatPrice) + "?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print("Enter choice: ");
                        String extraMeatChoice = scanner.nextLine();

                        if (extraMeatChoice.equals("1")) {
                            hasExtraMeat = true;
                            sandwichPreview.append(" (extra)");
                            System.out.println("Added extra " + meat + " - $" + String.format("%.2f", extraMeatPrice));
                            break;
                        } else if (extraMeatChoice.equals("2")) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    }

                    // Cheese choice
                    String cheese = "No cheese";
                    double cheesePrice = 0.0;
                    while (true) {
                        System.out.println("\n--- Choose Cheese ---");
                        System.out.println("1. American");
                        System.out.println("2. Provolone");
                        System.out.println("3. Cheddar");
                        System.out.println("4. Swiss");
                        System.out.print("Enter choice: ");
                        String cheeseChoice = scanner.nextLine();

                        switch (cheeseChoice) {
                            case "1": cheese = "American"; break;
                            case "2": cheese = "Provolone"; break;
                            case "3": cheese = "Cheddar"; break;
                            case "4": cheese = "Swiss"; break;
                            default:
                                System.out.println("Invalid cheese choice. Please try again.");
                                continue;
                        }

                        switch (breadSize) {
                            case "4-inch": cheesePrice = 0.75; break;
                            case "8-inch": cheesePrice = 1.50; break;
                            case "12-inch": cheesePrice = 2.25; break;
                        }

                        System.out.println("Added " + cheese + " cheese - $" + String.format("%.2f", cheesePrice));
                        sandwichPreview.append(", ").append(cheese).append(" cheese");

                        // Ask for extra cheese
                        double extraCheesePrice = 0.0;
                        switch (breadSize) {
                            case "4-inch": extraCheesePrice = 0.30; break;
                            case "8-inch": extraCheesePrice = 0.60; break;
                            case "12-inch": extraCheesePrice = 0.90; break;
                        }

                        while (true) {
                            System.out.println("Would you like extra " + cheese + " cheese for an additional $" + String.format("%.2f", extraCheesePrice) + "?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            System.out.print("Enter choice: ");
                            String extraCheeseChoice = scanner.nextLine();

                            if (extraCheeseChoice.equals("1")) {
                                cheesePrice += extraCheesePrice;
                                sandwichPreview.append(" (extra cheese)");
                                System.out.println("Added extra " + cheese + " cheese - $" + String.format("%.2f", extraCheesePrice));
                                break;
                            } else if (extraCheeseChoice.equals("2")) {
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }

                        break;

                    }
                    // Ask for toppings
                    ArrayList<String> toppings = new ArrayList<>();
                    String[] availableToppings = {
                            "Lettuce", "Peppers", "Onions", "Tomatoes",
                            "Jalapeños", "Cucumbers", "Pickles",
                            "Guacamole", "Mushrooms"
                    };

                    System.out.println("\n--- Toppings ---");
                    for (String topping : availableToppings) {
                        while (true) {
                            System.out.print("Would you like " + topping + "? (Y/N): ");
                            String response = scanner.nextLine().trim().toUpperCase();
                            if (response.equals("Y")) {
                                toppings.add(topping);
                                break;
                            } else if (response.equals("N")) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter Y or N.");
                            }
                        }
                    }

                    if (!toppings.isEmpty()) {
                        sandwichPreview.append(", with ");
                        sandwichPreview.append(String.join(", ", toppings));
                    }
                    // Ask for sauces
                    ArrayList<String> sauces = new ArrayList<>();
                    String[] availableSauces = {
                            "Mayo", "Mustard", "Ketchup", "Ranch",
                            "Thousand Island", "Vinaigrette"
                    };

                    System.out.println("\n--- Sauces ---");
                    for (String sauce : availableSauces) {
                        while (true) {
                            System.out.print("Would you like " + sauce + "? (Y/N): ");
                            String response = scanner.nextLine().trim().toUpperCase();
                            if (response.equals("Y")) {
                                sauces.add(sauce);
                                break;
                            } else if (response.equals("N")) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter Y or N.");
                            }
                        }
                    }

                    if (!sauces.isEmpty()) {
                        sandwichPreview.append(", with ");
                        sandwichPreview.append(String.join(", ", sauces));
                    }

                    // Ask if sandwich should be toasted
                    while (true) {
                        System.out.println("\nWould you like your sandwich toasted?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print("Enter choice: ");
                        String toastChoice = scanner.nextLine();

                        if (toastChoice.equals("1")) {
                            sandwichPreview.append(", toasted");
                            break;
                        } else if (toastChoice.equals("2")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter 1 or 2.");
                        }
                    }


                    // Adds all of the Users choices to total
                    double totalSandwichPrice = breadPrice + meatPrice + cheesePrice;
                    if (hasExtraMeat) {
                        totalSandwichPrice += extraMeatPrice;
                    }

                    // Displays users final order
                    String sandwichDesc = sandwichPreview.toString() + " - $" + String.format("%.2f", totalSandwichPrice);
                    order.add(sandwichDesc);
                    total += totalSandwichPrice;

                    System.out.println("\n--- Sandwich Added ---");
                    System.out.println(sandwichDesc);
                    break;

                    // CANCELS ORDER DELETES
                    case "0":
                    order.clear();
                    total = 0.0;
                    System.out.println("Order cancelled returning to main menu...");
                    return; // return to main menu



                case "4":
                    System.out.println("\n--- Checkout ---");
                        if (order.isEmpty()) {
                            System.out.println("No items in order.");
                        } else {
                            System.out.println("Your order summary:");
                            for (int i = 0; i < order.size(); i++) {
                                System.out.println((i + 1) + ". " + order.get(i));
                            }
                            System.out.println("Total: $" + String.format("%.2f", total));
                            System.out.println("Thank you for your order!");

                            // Write order to file
                            ReceiptWriter.writeOrderToFile(order, total);

                            order.clear(); // reset order after checkout
                            total = 0.0;
                        }
                        return;

            }
        }
    }
}