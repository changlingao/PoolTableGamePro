package PoolGame.strategy;

public class BallStrategy extends PocketStrategy {
    /**
     * Creates a new ball strategy.
     */
    public BallStrategy() {
        this.lives = 1;
    }

    public void reset() {
        this.lives = 1;
    }


    public BallStrategy(int lives) {
        this.lives = lives;
    }

    @Override
    public BallStrategy copy() {
        return new BallStrategy(lives);
    }
}
