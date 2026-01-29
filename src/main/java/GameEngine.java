public class GameEngine {
    private final int min;
    private final int max;
    private int target;
    private int attempts;
    private boolean gameWon;

    public GameEngine(int min, int max) {
        this.min = min;
        this.max = max;
        this.attempts = 0;
        this.gameWon = false;
        reset();
    }

    public GuessResult makeGuess(int guess) {
        attempts++;

        if (guess == target) {
            gameWon = true;
            return new GuessResult(true, "Correct! You guessed it in " + attempts + " attempts.", attempts);
        } else if (guess < target) {
            return new GuessResult(false, "Too low!", attempts);
        } else {
            return new GuessResult(false, "Too high!", attempts);
        }
    }

    public void reset() {
        target = Utils.randomInt(min, max);
        attempts = 0;
        gameWon = false;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    // For testing purposes only
    protected void setTarget(int target) {
        this.target = target;
    }

    protected int getTarget() {
        return target;
    }
}
