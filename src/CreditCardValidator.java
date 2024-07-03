import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card Number: ");
        String userInput = scanner.next();

        List<Integer> userLetter = new ArrayList<>();
        String validity = null;
        if (userInput.length() > 16) {
            validity = "Invalid";
        } else if (userInput.length() < 16) {
            validity = "Invalid";
        } else {
            validity = "Valid";
        }

        String cardType = null;
        if (Integer.parseInt(String.valueOf(userInput.charAt(0))) == 4) {
            cardType = "Visa card";
        } else if (Integer.parseInt(String.valueOf(userInput.charAt(0))) == 5) {
            cardType = "Master card";
        } else if (userInput.charAt(0) == '3' && userInput.charAt(1) == '7') {
            cardType = "American Express Card";
        } else if (Integer.parseInt(String.valueOf(userInput.charAt(0))) == 6) {
            cardType = "Discover card";
        } else {
            cardType = "Invalid";
        }

        for (int i = 0; i < userInput.length(); i++) {
            String letter = String.valueOf(userInput.charAt(i));
            userLetter.add(Integer.parseInt(letter));
        }

        System.out.println(userLetter.get(0) + userLetter.get(1));

        List<Integer> reversedUserLetter = new ArrayList<>();
        for (int i = userLetter.size() - 1; i >= 0; i--) {
            reversedUserLetter.add(userLetter.get(i));
        }
        System.out.println(reversedUserLetter);

        int secondDigitRes = 0;
        int firstDigit = 0;
        for (int i = 0; i < reversedUserLetter.size(); i++) {
            if (i % 2 != 0) {
                int res = reversedUserLetter.get(i) * 2;
                if (res > 9) {
                    String toString = String.valueOf(res);
                    int firstLetters = Integer.parseInt(String.valueOf(toString.charAt(0)));
                    int secondLetters = Integer.parseInt(String.valueOf(toString.charAt(1)));
                    secondDigitRes += firstLetters + secondLetters;
                } else {
                    secondDigitRes += res;
                }
            } else {
                firstDigit += reversedUserLetter.get(i);
            }
        }
        int sum = secondDigitRes + firstDigit;
        if (sum % 10 == 0) {
            validity = "Valid";
        } else {
            validity = "Invalid";
        }

        System.out.printf("""
            *************************************************
            ** Credit Card Type: %s
            ** Credit Card Number: %s
            ** Credit Card Digit Length: %s
            ** Credit Card Validity: %s
            **************************************************
            """, cardType, userInput, userLetter.size(), validity);
        System.out.println("This is the second digit sum: " + secondDigitRes);
        System.out.println("This is the first digit sum: " + firstDigit);
    }
}
