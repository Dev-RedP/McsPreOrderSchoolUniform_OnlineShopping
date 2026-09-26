package PracticalExam;

import java.util.Scanner;
public class ReservationPickUpSchedule {

    public static void main(String[] args) {
        Reservation();
    }

    public static void Reservation() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your reservation date: ");
        String reservationDate = scanner.nextLine();

        System.out.print("Enter your pick up scheduled time: ");
        String pickupTime = scanner.nextLine();

        System.out.print("Enter your Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter your pick up scheduled date: ");
        String pickupDate = scanner.nextLine();

        System.out.println("\n--- Reservation Details Captured: ---");
        System.out.println("Reservation Date: " + reservationDate);
        System.out.println("Pick Up Scheduled Time: " + pickupTime);
        System.out.println("Student ID: " + studentId);
        System.out.println("Pick Up Scheduled Date: " + pickupDate);
    }
}