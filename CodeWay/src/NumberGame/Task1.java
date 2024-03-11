package NumberGame;

import java.util.*;




import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        int min = 10;
        int max = 100;
        int randomNum = (int) (Math.random() * (max - min + 1)) + min;
        //System.out.println(randomNum);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your guess: ");

        int userGuess = 0;
        int count = 3;

        while (count > 0) {
            try {
                userGuess = myScanner.nextInt();
                if (userGuess == randomNum) {
                    System.out.println("Your guess is correct!");
                    break;
                } else if (userGuess > randomNum) {
                    count--;
                    System.out.println("Your guess is wrong. The number is too high. Try again: " + count + " chance(s) left.");
                } else if (userGuess < randomNum) {
                    count--;
                    System.out.println("Your guess is wrong. The number is too low. Try again: " + count + " chance(s) left.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                myScanner.next(); // consume invalid input
            }
        }

        if (count == 0) {
            System.out.println("You have no more chances left. Try again after 24 hours.");
        }

        myScanner.close();
    }
}


