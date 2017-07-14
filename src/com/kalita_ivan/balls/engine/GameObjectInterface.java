package com.kalita_ivan.balls.engine;


import com.kalita_ivan.balls.engine.modifiers.ModifierInterface;

import java.awt.*;

interface GameObjectInterface {
    void render(Graphics g);
    ModifierInterface[] getModifiers();
}
