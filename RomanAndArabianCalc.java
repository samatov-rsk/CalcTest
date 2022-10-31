import java.util.InputMismatchException;
import java.util.Scanner;

public class RomanAndArabianCalc {

    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static int arifmeticOperation() {
        int resultOperation = 0;
        switch (operation) {
            case '+':
                resultOperation = number1 + number2;
                break;
            case '-':
                resultOperation = number1 - number2;
                break;
            case '*':
                resultOperation = number1 * number2;
                break;
            case '/':
                resultOperation = number1 / number2;
                break;
        }
        return resultOperation;
    }

    public static String calc(String input) {
        char[] ch = new char[10];
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < input.length(); i++) {
            ch[i] = input.charAt(i);
            if (ch[i] == '+') {
                operation = '+';
            } else if (ch[i] == '-') {
                operation = '-';
            } else if (ch[i] == '*') {
                operation = '*';
            } else if (ch[i] == '/') {
                operation = '/';
            }
        }
        String chString = String.valueOf(ch);
        String[] varable = chString.split("[+-/*]");
        if (varable.length != 2) {
            throw new IllegalArgumentException("Неверное выражение");
        } else {
            String s1 = varable[0].trim();
            String s2 = varable[1].trim();
            number1 = romanToNumber(s1);
            number2 = romanToNumber(s2);
            if (number1 > 0 && number2 > 0) {
                result = arifmeticOperation();
                String resultRoman = convertNumToRoman(result);
                return resultRoman;
            }
            try {
                number1 = Integer.parseInt(s1);
                number2 = Integer.parseInt(s2);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Неверный ввод данных");

            }
            if ((number1 > 0 && number2 > 0) && (number1 <= 10 && number2 <= 10)) {
                result = arifmeticOperation();
                return String.valueOf(result);
            } else {
                throw new IllegalArgumentException("Неверно введены числа");
            }
        }
    }

    // Второй метод. Перевод арабаского числа в Римское...
    private static String convertNumToRoman(int numArab) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String s = roman[numArab];
        return s;
    }

    // Перевод Римского числа в арабское...
    private static int romanToNumber(String roman) {

        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        String resultOperation;
        System.out.println("Введите выражение: <Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя Арабскими или Римскими числами>: a + b, a - b, a * b, a / b");
        String input = scanner.nextLine();
        resultOperation = calc(input);
        System.out.println("Результат вычесления ");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + resultOperation);

    }
}


