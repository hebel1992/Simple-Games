package pl.coderslab.Symulator_lotto;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        int[] playersNumbers = playerNumbersInput();

        int[] computerNumbers = computerNumbersGenerator();

        int result = 0;
        //Porownuje liczby wylosowane przez gracza z liczbami wygenerowanymi przez komputer
        for (int i = 0; i < playersNumbers.length; i++) {
            for (int j = 0; j < computerNumbers.length; j++) {
                if (playersNumbers[i] == computerNumbers[j]) {
                    result++;
                }
            }
        }
        //Jeśli trafiono conajmniej "trojke" gracz otrzyma komunikat
        if (result >= 3) {
            System.out.println("Gratulacje, trafiłeś: " + result);
        }
    }

    //Metoda generująca 6 losowych liczb z zakresu 1-49
    private static int[] computerNumbersGenerator() {

        //Tworzę tablicę do której przypisuję kolejno liczby od 1 do 49
        Integer[] arrOfNumbers = new Integer[49];
        for (int i = 0; i < arrOfNumbers.length; i++) {
            arrOfNumbers[i] = i + 1;
        }
        //Mieszam wszystkie liczby znajdujące się w tablicy
        Collections.shuffle(Arrays.asList(arrOfNumbers));

        //Tworzę nową tablice z pierwszych 6 liczb z wcześniej stworzonej i przemieszanej tablicy 'arrOfNumbers'
        int[] computerNumbers = new int[6];
        for (int i = 0; i < computerNumbers.length; i++) {
            computerNumbers[i] = arrOfNumbers[i];
        }

        System.out.println("Komputer wylosował: " + Arrays.toString(computerNumbers));
        return computerNumbers;
    }

    //Metoda pozwalajaca wprowadzic 6 liczb przez gracza z zakresu 1-49
    private static int[] playerNumbersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę z zakresu 1-49");
        int[] playerNumbers = new int[6];
        int numberRepeat = 0;

        //Pętla zapisująca do tablicy 'playerNumbers' wartości wpisane przez gracza
        for (int i = 0; i < playerNumbers.length; i++) {

            checkIfNumber(scanner);

            int input = scanner.nextInt();
            //Sprawdzam czy podana liczba mieści się w zakresie 1-49, jeśli nie to gracz wpisuje jeszcze raz, aż do skutku
            while (input > 49 || input < 1) {
                System.out.println("Możesz wybrać jedynie liczby z zakresu 1-49");
                input = scanner.nextInt();
            }
            //Sprawdzam czy wpisana przez gracza liczba nie powtórzyła się
            while (true) {
                for (int j = 0; j < playerNumbers.length; j++) {
                    if (input == playerNumbers[j]) {
                        numberRepeat++;
                    }
                }
                if (numberRepeat > 0) {
                    System.out.println("Podana wartosc zostala juz wpisana. Wybierz inna liczbe");
                    input = scanner.nextInt();
                    numberRepeat = 0;
                } else {
                    break;
                }
            }

            playerNumbers[i] = input;
            numberRepeat = 0;

            System.out.println("Podaj kolejną liczbę z zakresu 1-49");
        }
        scanner.close();
        Arrays.sort(playerNumbers);
        System.out.println("Twoje liczby to: " + Arrays.toString(playerNumbers));
        return playerNumbers;
    }

    private static void checkIfNumber(Scanner scanner) {
        //Zabezpieczam program przed wpisaniem innych wartości niż liczbowe
        while (!scanner.hasNextInt()) {
            System.out.println("Możesz wpisać tylko liczbę");
            scanner.next();
        }
    }
}
