package pl.coderslab.Guess_number_2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        zgadywanie();
    }

    private static void zgadywanie() {
        System.out.println("Think of a number in range 0-1000, and I'll guess it in 10 tries. " +
                "You can only use words: more, fewer, win");

        int min = 0;
        int max = 1001;
        int guess = (max - min) / 2 + min;

        System.out.println("I'm guessing: " + guess);
        Scanner scanner = new Scanner((System.in));
        String input = scanner.nextLine();

        input = checkIfCorrectWordInput(scanner, input);

        for (int i = 0; i < 10; i++) {

            switch (input) {
                case "fewer":
                    max = guess;
                    break;
                case "more":
                    min = guess;
                    break;
                case "win":
                    System.out.println("I won");
                    break;
            }

            guess = (max - min) / 2 + min;

            System.out.println("I'm guessing: " + guess);
            input = scanner.nextLine();

            input = checkIfCorrectWordInput(scanner, input);

            if (input.equals("win")) {
                System.out.println("I won");
                break;
            }

            if (i == 8) {
                System.out.println("You're cheating. Game over.");
                break;
            }
        }
        scanner.close();
    }

    private static String checkIfCorrectWordInput(Scanner scanner, String input) {
        while (!input.equals("more") && !input.equals("fewer") && !input.equals("win")) {
            System.out.println("You can only type: more, fewer, win");
            input = scanner.nextLine();
        }
        return input;
    }
}
