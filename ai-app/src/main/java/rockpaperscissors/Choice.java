package rockpaperscissors;

public enum Choice {
    ROCK, PAPER, SCISSORS;

    public static Choice fromString(String input) {
        if (input == null) return null;
        switch (input.trim().toLowerCase()) {
            case "rock": return ROCK;
            case "paper": return PAPER;
            case "scissors": return SCISSORS;
            default: return null;
        }
    }

    @Override
    public String toString() {
        // Capitalize first letter, rest lowercase
        String name = name();
        return name.substring(0,1) + name.substring(1).toLowerCase();
    }
}
