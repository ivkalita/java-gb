package com.kalita_ivan.balls.engine.objects;

import com.kalita_ivan.balls.engine.geometry.Vector2;
import com.kalita_ivan.balls.engine.modifiers.ModifierInterface;
import com.kalita_ivan.balls.engine.modifiers.RigidBody;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ball extends AbstractGameObject {
    private double radius;
    private Color color;

    Ball(Vector2 position, Vector2 acceleration, Vector2 speed, double radius, Color color, double mass) {
        this.modifiers = new ModifierInterface[1];
        this.modifiers[0] = new RigidBody("physics", position, acceleration, speed, mass);
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void render(Graphics g) {
        RigidBody r = this.getModifierByType(RigidBody.class);
        if (r == null) {
            return;
        }
        Vector2 pos = r.getPosition();
        int x = (int) (pos.getX() - radius);
        int y = (int) (pos.getY() - radius);

        g.setColor(this.color);
        g.fillOval(x, y, (int) radius * 2, (int) radius * 2);
    }

    @Override
    public ModifierInterface[] getModifiers() {
        return this.modifiers;
    }
}
