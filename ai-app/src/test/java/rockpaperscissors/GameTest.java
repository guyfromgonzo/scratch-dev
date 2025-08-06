package rockpaperscissors;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void testTie() {
        String userInput = "Rock\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Game game = new Game() {
            @Override
            protected Choice getRandomChoice() {
                return Choice.ROCK;
            }
        };
        game.play();
        String output = outContent.toString();
        assertTrue(output.contains("Its a Tie"));
    }

    @Test
    void testNotATie() {
        String userInput = "Paper\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Game game = new Game() {
            @Override
            protected Choice getRandomChoice() {
                return Choice.ROCK;
            }
        };
        game.play();
        String output = outContent.toString();
        assertTrue(output.contains("Not a Tie"));
    }

    @Test
    void testInvalidInput() {
        String userInput = "Lizard\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Game game = new Game();
        game.play();
        String output = outContent.toString();
        assertTrue(output.contains("Invalid input"));
    }
}
