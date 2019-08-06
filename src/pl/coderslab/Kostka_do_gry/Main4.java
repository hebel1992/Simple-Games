package pl.coderslab.Kostka_do_gry;

public class Main4 {
    public static void main(String[] args) {
        System.out.println(rzutKostką("2D10+20"));
    }

    public static String rzutKostką(String kod) {

        StringBuilder str = new StringBuilder();
        char[] chars = kod.toCharArray();

        countThrows(str, chars[0]);

        str.append("kostką D");

        countWalls(str, chars);

        addValue(kod, str);

        return str.toString();
    }

    private static void countThrows(StringBuilder str, char aChar) {
        if (Character.isDigit(aChar)) {
            if (aChar == 1) {
                str.append(aChar + " rzut ");
            } else if (aChar < '5') {
                str.append(aChar + " rzuty ");
            } else {
                str.append((aChar + " rzutów "));
            }
        } else {
            //Sytuacja w której jako pierwsza występuje litera D, czyli jeden zwykły rzut
            str.append("Zwykły rzut ");
        }
    }

    private static void countWalls(StringBuilder str, char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                str.append(chars[i]);
            }
            if (chars[i] == '+') {
                break;
            }
        }
    }

    private static void addValue(String kod, StringBuilder str) {
        for (int i = 0; i < kod.length(); i++) {
            if (kod.charAt(i) == '+') {
                String sub = kod.substring(i + 1);
                str.append(", do wyniku dodaj " + sub);
                break;
            }
        }
    }
}

