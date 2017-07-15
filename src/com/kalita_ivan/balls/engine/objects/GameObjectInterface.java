package com.kalita_ivan.balls.engine.objects;

import com.kalita_ivan.balls.engine.modifiers.ModifierInterface;

import java.awt.*;

public interface GameObjectInterface {
    void render(Graphics g);
    ModifierInterface[] getModifiers();
}
