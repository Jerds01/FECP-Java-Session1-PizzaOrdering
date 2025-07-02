package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        if (quantity > 0) {
            pizzas.add(pizzaType);
            quantities.add(quantity);
        } else {
            System.out.println("Quantity must be positive");
        }
    }
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        if (index >= 0 && index < quantities.size()) {
            if (newQuantity > 0) {
                quantities.set(index, newQuantity);
            } else {
                System.out.println("Quantity must be positive");
            }
        } else {
            System.out.println("Invalid order number.");
        }
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        if (index >= 0 && index < pizzas.size()) {
            pizzas.remove(index);
            quantities.remove(index);
        } else {
            System.out.println("Invalid order number.");
        }
    }

    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        System.out.println("--- Current Orders ---");
        if (pizzas.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            for (int i = 0; i < pizzas.size(); i++) {
                System.out.println((i + 1) + ". " + pizzas.get(i) + " x " + quantities.get(i));
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        int index = 0; // Changed to 0-based for ArrayList indexing
        int quantity = 0;
        String pizzaType = "";
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n1. Add Order");
            System.out.println("2. Update Order");
            System.out.println("3. Remove Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Pizza type: ");
                    pizzaType = scanner.next();
                    System.out.print("Quantity: ");
                    quantity = scanner.nextInt();
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    index = scanner.nextInt();
                    System.out.print("New quantity: ");
                    int newQuantity = scanner.nextInt();
                    updateOrder(quantities, index - 1, newQuantity); // Adjust to 0-based index
                    break;
                case 3:
                    System.out.print("Order number to remove: ");
                    index = scanner.nextInt();
                    removeOrder(pizzas, quantities, index - 1); // Adjust to 0-based index
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    System.out.println("---Thank you!---");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}