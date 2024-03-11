package code.helpAndHint;

import code.bullsAndCows.BullsAndCowsGiveHint;
import code.bullsAndCows.BullsAndCowsGuess;

import java.util.Scanner;

public class Hint {
    BullsAndCowsGuess guess;
    BullsAndCowsGiveHint giveHint;
    Scanner scanner = new Scanner(System.in);
    public void beforeStart() {
        System.out.println("Welcome to my miniGames Series, this is a game called 'bulls and cows'.'");
        System.out.println("If you don't know how to Play.");
        System.out.println("Press 1 to see the gameplay introduction.");
        System.out.println("Press 2 to start the game.");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    gettingHelp();
                    break;
                case 2:
                    chooseSide();
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }else {
            System.out.println("Invalid input!");
        }
    }

    public void gettingHelp() {
        System.out.flush();
        System.out.println("Here is how to play the game:");
        System.out.println("You will think of a secret number, and the I'll try to guess it.");
        System.out.println("If the guess has a correct digit in the correct position, it's called a 'bull.' " +
                "If the guess has a correct digit but in the wrong position, it's called a 'cow.'");
        System.out.println("After each guess, I'll ask you how many bulls and cows were there and you will give me the hint to help me guess.");
        System.out.println("Do you know how to play right now?");
        System.out.println("Press 1 if you need an example.");
        System.out.println("Press 2 to start.");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    gettingExample();
                    break;
                case 2:
                    chooseSide();
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }else {
            System.out.println("Invalid input!");
        }

    }

    public void chooseSide() {
        System.out.flush();
        System.out.println("Great! Let's start!");
        System.out.println("Do you want to guess the number or let me guess?");
        System.out.println("Press 1 if you want me to guess.");
        System.out.println("Press 2 if you want to guess.");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    guess = new BullsAndCowsGuess();
                    guess.start();
                    break;
                case 2:
                    giveHint = new BullsAndCowsGiveHint();
                    giveHint.start();
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }else {
            System.out.println("Invalid input!");
        }
    }
    public void gettingExample(){
        System.out.flush();
        System.out.println("Here is an example:");

    }
}
