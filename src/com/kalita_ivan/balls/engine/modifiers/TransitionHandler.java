package com.kalita_ivan.balls.engine.modifiers;

public class TransitionHandler extends AbstractModifierHandler implements ModifierHandlerInterface {
    @Override
    public void update(ModifierInterface[] modifiers, double delta) {
        for (int i = 0; i < modifiers.length; i++) {
            if (modifiers[i] instanceof Transition) {
                ((Transition)modifiers[i]).calculate(delta);
            }
        }
    }
}
