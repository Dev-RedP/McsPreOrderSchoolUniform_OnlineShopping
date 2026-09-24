package PracticalExam;

import java.util.Scanner;

public class PreOrderUniform {

    public void PreOrderUniform(Scanner uniform) {

        String uniformType;
        String uniformSize;
        int stockQuantity;

        System.out.println("Uniform Information\n");

        System.out.print("Uniform Type (PE/Regular): ");
        uniformType = uniform.nextLine();

        System.out.print("Uniform Size (S/M/L/XL): ");
        uniformSize = uniform.nextLine();

        System.out.print("Stock Quantity: ");
        stockQuantity = uniform.nextInt();

        System.out.println("\nUniform Details:");
        System.out.println("Uniform Type: " + uniformType);
        System.out.println("Uniform Size: " + uniformSize);
        System.out.println("Stock Quantity: " + stockQuantity);
    }

    public static void main(String[] args) {

        Scanner uniform = new Scanner(System.in);

        PreOrderUniform obj = new PreOrderUniform();
        obj.PreOrderUniform(uniform);

        uniform.close();
    }
}
