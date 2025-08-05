package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private enum Choice {
        ROCK, PAPER, SCISSORS
    }

    public void play() {
        var scanner = new Scanner(System.in);
        System.out.print("Enter Rock, Paper, or Scissors: ");
        String userInput = scanner.nextLine().trim();

        String userChoice = capitalize(userInput);
        if (!isValidChoice(userChoice)) {
            System.out.println("Invalid input. Please enter Rock, Paper, or Scissors.");
            return;
        }

        String programChoice = getRandomChoice();
        System.out.println("Program chose: " + programChoice);

        if (userChoice.equals(programChoice)) {
            System.out.println("Its a Tie");
        } else {
            System.out.println("Not a Tie");
        }
    }

    private boolean isValidChoice(String choice) {
        for (String valid : CHOICES2) {
            if (valid.equals(choice)) {
                return true;
            }
        }
        return false;
    }

private static long lcgSeed = System.currentTimeMillis();
protected String getRandomChoice() {
    // Linear Congruential Generator parameters (example values)
    lcgSeed = (lcgSeed * 1664525 + 1013904223) & 0xFFFFFFFFL;
    int idx = (int)(lcgSeed % CHOICES2.length);
    if (idx < 0) idx += CHOICES2.length;
    return CHOICES2[idx];
}

    private String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
