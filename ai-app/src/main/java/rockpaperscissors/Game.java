package rockpaperscissors;

import java.util.Scanner;
 
public class Game {

    public void play() {
        var scanner = new Scanner(System.in);
        System.out.print("Enter Rock, Paper, or Scissors: ");
        String userInput = scanner.nextLine().trim();

        Choice userChoice = Choice.fromString(userInput);
        if (userChoice == null) {
            System.out.println("Invalid input. Please enter Rock, Paper, or Scissors.");
            return;
        }

        Choice programChoice = getRandomChoice();
        System.out.println("Program chose: " + programChoice);

        if (userChoice == programChoice) {
            System.out.println("Its a Tie");
        } else {
            System.out.println("Not a Tie");
        }
    }



private static long lcgSeed = System.currentTimeMillis();
protected Choice getRandomChoice() {
    // Linear Congruential Generator parameters (example values)
    lcgSeed = (lcgSeed * 1664525 + 1013904223) & 0xFFFFFFFFL;
    int idx = (int)(lcgSeed % Choice.values().length);
    if (idx < 0) idx += Choice.values().length;
    return Choice.values()[idx];
}


}
