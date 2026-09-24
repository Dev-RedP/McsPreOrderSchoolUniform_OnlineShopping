package PracticalExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Run {

    @Test
    public void testCompleteUniformOrder() {

        // 1. SIMULATED USER INPUT
        StringBuilder simulatedUserInput = new StringBuilder();

        System.out.println("--- GENERATING SIMULATED USER INPUT ---");

        // Uniform Type
        simulatedUserInput.append("PE\n");

        // Uniform Size
        simulatedUserInput.append("L\n");

        // Stock Quantity
        simulatedUserInput.append("50\n");

        System.out.println("--- INPUT GENERATION COMPLETE ---\n");

        // 2. CONVERT INPUT INTO AN INPUT STREAM
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        simulatedUserInput.toString().getBytes()
                );

        // 3. CREATE AUTOMATED SCANNER
        Scanner scanner = new Scanner(inputStream);

        // 4. RUN YOUR ACTUAL PROGRAM
        PreOrderUniform uniformSystem = new PreOrderUniform();

        uniformSystem.PreOrderUniform(scanner);

        scanner.close();
    }
}