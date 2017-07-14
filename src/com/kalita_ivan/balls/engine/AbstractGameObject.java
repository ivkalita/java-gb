package com.kalita_ivan.balls.engine;


import com.kalita_ivan.balls.engine.modifiers.ModifierInterface;

import java.lang.reflect.Type;


abstract public class AbstractGameObject implements GameObjectInterface {
    ModifierInterface[] modifiers;


    @Override
    public ModifierInterface[] getModifiers() {
        return this.modifiers;
    }

    <T> T getModifierByType(Class<T> type) {
        for (int i = 0; i < this.modifiers.length; i++) {
            if (type.isInstance(this.modifiers[i])) {
                return (T)(this.modifiers[i]);
            }
        }

        return null;
    }
}
