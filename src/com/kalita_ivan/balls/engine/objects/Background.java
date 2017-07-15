package com.kalita_ivan.balls.engine.objects;

import com.kalita_ivan.balls.engine.geometry.Vector2;
import com.kalita_ivan.balls.engine.modifiers.Transition;
import com.kalita_ivan.balls.engine.modifiers.ModifierInterface;

import java.awt.*;

public class Background extends AbstractGameObject {
    private double width;
    private double height;

    public Background(Vector2 dimensions) {
        this.width = dimensions.getX();
        this.height = dimensions.getY();

        this.modifiers = new ModifierInterface[3];
        this.modifiers[0] = new Transition("r", 10, 0, 0, 255);
        this.modifiers[1] = new Transition("g", 15, 0, 0, 255);
        this.modifiers[2] = new Transition("b", -20, 255, 0, 255);
    }

    @Override
    public void render(Graphics g) {
        Color c = new Color(
            (int)this.getModifierByTypeAndIdentifier(Transition.class, "r").getValue(),
            (int)this.getModifierByTypeAndIdentifier(Transition.class, "g").getValue(),
            (int)this.getModifierByTypeAndIdentifier(Transition.class, "b").getValue()
        );
        g.setColor(c);
        g.fillRect(0, 0, (int)this.width, (int)this.height);
    }
}
