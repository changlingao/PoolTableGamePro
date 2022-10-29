package PoolGame;

import PoolGame.objects.Ball;

import java.time.Duration;
import java.util.ArrayList;

/**
 * Memento to keep track of score, duration, balls
 */
public class Memento {
    private int score;
    private Duration duration;
    private ArrayList<Ball> balls = new ArrayList<>();

    /**
     * a deep copy of score, duration, balls
     * @param score score
     * @param duration duration
     * @param balls balls
     */
    public Memento(int score, Duration duration, ArrayList<Ball> balls) {
        this.score = score;
        this.duration = duration;
        // deep copy balls
        for (Ball ball: balls) {
            this.balls.add(ball.copy());
        }
    }

    /** getter */
    public int getScore() {
        return score;
    }

    /** getter */
    public Duration getDuration() {
        return duration;
    }

    /** getter */
    public ArrayList<Ball> getBalls() {
        return balls;
    }
}
