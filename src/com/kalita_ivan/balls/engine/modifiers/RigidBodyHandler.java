package com.kalita_ivan.balls.engine.modifiers;


import com.kalita_ivan.balls.engine.Scene;
import com.kalita_ivan.balls.engine.geometry.Vector2;

public class RigidBodyHandler extends AbstractModifierHandler implements ModifierHandlerInterface {

    public RigidBodyHandler(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void update(ModifierInterface[] modifiers, double delta) {
        for (int i = 0; i < modifiers.length; i++) {
            if (modifiers[i] instanceof RigidBody) {
                this.doUpdate((RigidBody)modifiers[i], delta);
            }
        }
    }

    private void doUpdate(RigidBody r, double delta) {
        Vector2 pos = r.getPosition();
        Vector2 speed = r.getSpeed();
        Vector2 acceleration = r.getAcceleration();

        speed = speed.add(acceleration.multiply(delta));
        pos = pos.add(speed.multiply(delta));

        if (pos.getX() < 0) {
            acceleration.setX(Math.abs(acceleration.getX()));
            speed.setX(Math.abs(speed.getX()));
        } else if (pos.getX() > this.scene.getWidth()) {
            acceleration.setX(-1 * Math.abs(acceleration.getX()));
            speed.setX(-1 * Math.abs(speed.getX()));
        }

        if (pos.getY() < 0) {
            acceleration.setY(Math.abs(acceleration.getY()));
            speed.setY(acceleration.getY());
        } else if (pos.getY() > this.scene.getHeight()) {
            acceleration.setY(-1 * Math.abs(acceleration.getY()));
            speed.setY(acceleration.getY());
        }

        r.setPosition(pos);
        r.setSpeed(speed);
        r.setAcceleration(acceleration);
    }


}
