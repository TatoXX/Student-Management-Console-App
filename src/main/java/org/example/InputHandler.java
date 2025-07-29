package org.example;

import java.util.Scanner;

public class InputHandler {
    public String SureToClear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Are you sure to clear the list that stores all students?"
        );
        System.out.println("Enter yes or no: ");
        String input = scanner.nextLine().trim();
        return input;
    }

}
