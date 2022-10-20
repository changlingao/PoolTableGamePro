package PoolGame;

import PoolGame.objects.Ball;

import java.time.Duration;
import java.util.ArrayList;

public class Memento {
    private int score;
    private Duration duration;
    private ArrayList<Ball> balls = new ArrayList<>();

    public Memento(int score, Duration duration, ArrayList<Ball> balls) {
        this.score = score;
        this.duration = duration;
        // deep copy balls
        for (Ball ball: balls) {
            this.balls.add(ball.copy());
        }
    }

    public int getScore() {
        return score;
    }

    public Duration getDuration() {
        return duration;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }
}
