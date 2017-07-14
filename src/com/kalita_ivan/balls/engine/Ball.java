package com.kalita_ivan.balls.engine;


import java.awt.*;

public class Ball implements GameObjectInterface {
    private float x;
    private float y;
    private float radius;
    private Color color;

    Ball(float x, float y, float radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(this.color);
        g.fillOval((int)(x - radius), (int)(y - radius), (int)radius * 2, (int)radius * 2);
    }
}
