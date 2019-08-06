package pl.coderslab.Gra_w_zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        guessMyNumber();
    }

    private static void guessMyNumber() {

        int myNumber = drawNumber();

        System.out.println("Zgadnij liczbę");
        Scanner scanner = new Scanner(System.in);

        checkIfNumber(scanner);

        int userNumber = scanner.nextInt();

        //Porównuję wylosowaną przez komputer liczbę z liczbą wpisaną przez gracza, wychodzę z pętli w momencie kiedy liczby są sobie równe
        while (userNumber != myNumber) {
            if (userNumber > myNumber) {
                System.out.println("Za dużo");
            }
            if (userNumber < myNumber) {
                System.out.println("Za mało");
            }
            checkIfNumber(scanner);

            userNumber = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Zgadłeś!");
    }

    private static void checkIfNumber(Scanner scanner) {
        //Zabezpieczam program przed wpisaniem innych wartosci niz liczbowe
        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest liczba");
            scanner.next();
        }
    }

    private static int drawNumber() {
        //Losuję liczbę z przedziału 1-100
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
