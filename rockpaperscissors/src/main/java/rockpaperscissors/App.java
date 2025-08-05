package rockpaperscissors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Rock Paper Scissors app started.");
        System.out.println("Welcome to Rock Paper Scissors!");
        Game game = new Game();
        game.play();
    }
}
