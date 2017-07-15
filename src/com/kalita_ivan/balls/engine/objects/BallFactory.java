package com.kalita_ivan.balls.engine.objects;

import com.kalita_ivan.balls.engine.geometry.Vector2;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class BallFactory {
    public Ball createRandomBall(double maxX, double maxY) {
        double x = ThreadLocalRandom.current().nextDouble(0, maxX);
        double y = ThreadLocalRandom.current().nextDouble(0, maxY);
        double ax =ThreadLocalRandom.current().nextDouble(-30, 30);
        double ay =ThreadLocalRandom.current().nextDouble(-30, 30);
        double radius = ThreadLocalRandom.current().nextDouble(0, 30);
        int r = ThreadLocalRandom.current().nextInt(0, 255);
        int g = ThreadLocalRandom.current().nextInt(0, 255);
        int b = ThreadLocalRandom.current().nextInt(0, 255);
        double vx = ThreadLocalRandom.current().nextDouble(-30f, 30f);
        double vy = ThreadLocalRandom.current().nextDouble(-30f, 30f);

        return new Ball(
                new Vector2(x, y),
                new Vector2(ax, ay),
                new Vector2(vx, vy),
                radius,
                new Color(r, g, b),
                1
        );
    }

    public Ball createRandomBallAt(Vector2 position) {
        double ax =ThreadLocalRandom.current().nextDouble(-30, 30);
        double ay =ThreadLocalRandom.current().nextDouble(-30, 30);
        double radius = ThreadLocalRandom.current().nextDouble(0, 30);
        int r = ThreadLocalRandom.current().nextInt(0, 255);
        int g = ThreadLocalRandom.current().nextInt(0, 255);
        int b = ThreadLocalRandom.current().nextInt(0, 255);
        double vx = ThreadLocalRandom.current().nextDouble(-30f, 30f);
        double vy = ThreadLocalRandom.current().nextDouble(-30f, 30f);

        return new Ball(
                position,
                new Vector2(ax, ay),
                new Vector2(vx, vy),
                radius,
                new Color(r, g, b),
                1
        );
    }
}
