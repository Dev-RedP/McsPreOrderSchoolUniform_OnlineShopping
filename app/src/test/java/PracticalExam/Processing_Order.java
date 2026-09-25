package PracticalExam;

import java.util.Scanner;

public class Processing_Order {

    public void processOrder(Scanner scanner) {
        int orderId;
        int orderQuantity;

        System.out.print("Enter Order ID: ");
        orderId = scanner.nextInt();
        System.out.println(orderId);

        System.out.print("Enter Order Quantity: ");
        orderQuantity = scanner.nextInt();
        System.out.println(orderQuantity);

        System.out.println("\nProcessing Order Details:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Quantity: " + orderQuantity);
    }
}