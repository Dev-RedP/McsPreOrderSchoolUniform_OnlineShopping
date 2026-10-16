package PracticalExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class RunProgram {

    @Test
    public void testCompleteUniformOrder() {

        StringBuilder simulatedUserInput = new StringBuilder();

        System.out.println("--- GENERATING SIMULATED USER INPUT ---");

        simulatedUserInput.append("PE\n");
        simulatedUserInput.append("L\n");
        simulatedUserInput.append("50\n");

        System.out.println("--- INPUT GENERATION COMPLETE ---\n");

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        simulatedUserInput.toString().getBytes()
                );

        Scanner scanner = new Scanner(inputStream);

        PreOrderUniform uniformSystem = new PreOrderUniform();

        uniformSystem.preorderuniform(scanner);

        scanner.close();
    }
}