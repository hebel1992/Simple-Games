package pl.coderslab.Guess_number;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        guessMyNumber();
    }

    private static void guessMyNumber() {

        int myNumber = drawNumber();

        System.out.println("Guess the number");
        Scanner scanner = new Scanner(System.in);

        checkIfCorrectNumberInput(scanner);

        int userNumber = scanner.nextInt();

        while (userNumber != myNumber) {
            if (userNumber > myNumber) {
                System.out.println("Too big");
            }
            if (userNumber < myNumber) {
                System.out.println("Too small");
            }
            checkIfCorrectNumberInput(scanner);

            userNumber = scanner.nextInt();
        }
        scanner.close();
        System.out.println("You win!");
    }

    private static void checkIfCorrectNumberInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number!");
            scanner.next();
        }
    }

    private static int drawNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
