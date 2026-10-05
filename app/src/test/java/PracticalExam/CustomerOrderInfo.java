package PracticalExam;

import java.util.Scanner;

public class CustomerOrderInfo {

    public static void main(String[] args) {
        OrderInformation();
    }

    public static void OrderInformation() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Order Date: ");
        String orderDate = scanner.nextLine();

        System.out.print("Enter Place: ");
        String place = scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Order Number: ");
        String orderNumber = scanner.nextLine();

        System.out.println("\n--- Order Information Captured: ---");
        System.out.println("Order Date: " + orderDate);
        System.out.println("Place: " + place);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Number: " + orderNumber);
    }
}