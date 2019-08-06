package pl.coderslab.Gra_w_zgadywanie_liczb_2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        zgadywanie();
    }

    private static void zgadywanie() {
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadne w max. 10 próbach. Używaj tylko słów: wiecej, mniej lub trafiles");

        int min = 0;
        int max = 1001;
        int guess = (max - min) / 2 + min;

        System.out.println("Zgaduję: " + guess);
        Scanner scanner = new Scanner((System.in));
        String input = scanner.nextLine();

        //Sprawdzam czy gracz wpisał jedno z trzech dozwolonych słów
        input = checkIfCorrectWord(scanner, input);

        for (int i = 0; i < 10; i++) {

            switch (input) {
                case "mniej":
                    max = guess;
                    break;
                case "wiecej":
                    min = guess;
                    break;
                case "trafiles":
                    System.out.println("Wygralem");
                    break;
            }

            guess = (max - min) / 2 + min;

            System.out.println("Zgaduje: " + guess);
            input = scanner.nextLine();

            input = checkIfCorrectWord(scanner, input);

            if (input.equals("trafiles")) {
                System.out.println("Wygralem");
                break;
            }

            //Sprawdzam czy odgadnieto liczbe w 10 ruchach, jesli nie, gracz oszukiwał i koncze gre
            if (i == 8) {
                System.out.println("Oszukujesz, koniec gry");
                break;
            }
        }
        scanner.close();
    }

    private static String checkIfCorrectWord(Scanner scanner, String input) {
        while (!input.equals("wiecej") && !input.equals("mniej") && !input.equals("trafiles")) {
            System.out.println("Możesz wpisać tylko: więcej, mniej lub trafiłeś");
            input = scanner.nextLine();
        }
        return input;
    }
}