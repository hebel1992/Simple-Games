package pl.coderslab.Lotto_simulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        int[] playersNumbers = playerNumbersInput();

        int[] computerNumbers = computerNumbersGenerator();

        int result = 0;

        for (int i = 0; i < playersNumbers.length; i++) {
            for (int j = 0; j < computerNumbers.length; j++) {
                if (playersNumbers[i] == computerNumbers[j]) {
                    result++;
                }
            }
        }

        if (result >= 3) {
            System.out.println("Congratulation, you guessed: " + result);
        }
    }


    private static int[] computerNumbersGenerator() {

        Integer[] arrOfNumbers = new Integer[49];
        for (int i = 0; i < arrOfNumbers.length; i++) {
            arrOfNumbers[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(arrOfNumbers));

        int[] computerNumbers = new int[6];
        for (int i = 0; i < computerNumbers.length; i++) {
            computerNumbers[i] = arrOfNumbers[i];
        }

        System.out.println("Computer draws: " + Arrays.toString(computerNumbers));
        return computerNumbers;
    }

    private static int[] playerNumbersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put the first number from 1 to 49");
        int[] playerNumbers = new int[6];
        int numberRepeat = 0;

        for (int i = 0; i < playerNumbers.length; i++) {

            checkIfCorrectInputFormat(scanner);

            int input = scanner.nextInt();

            while (input > 49 || input < 1) {
                System.out.println("You can only put a number from 1 to 49");
                input = scanner.nextInt();
            }

            while (true) {
                for (int j = 0; j < playerNumbers.length; j++) {
                    if (input == playerNumbers[j]) {
                        numberRepeat++;
                    }
                }
                if (numberRepeat > 0) {
                    System.out.println("Number already given. Choose different number");
                    input = scanner.nextInt();
                    numberRepeat = 0;
                } else {
                    break;
                }
            }

            playerNumbers[i] = input;
            numberRepeat = 0;

            System.out.println("Put another number from 1 to 49");
        }
        scanner.close();
        Arrays.sort(playerNumbers);
        System.out.println("Your numbers: " + Arrays.toString(playerNumbers));
        return playerNumbers;
    }

    private static void checkIfCorrectInputFormat(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number");
            scanner.next();
        }
    }
}
