package com.kalita_ivan.balls.engine.objects;

import com.kalita_ivan.balls.engine.modifiers.ModifierInterface;

@SuppressWarnings("unchecked")
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

    <T> T getModifierByTypeAndIdentifier(Class<T> type, String identifier) {
        for (int i = 0; i < this.modifiers.length; i++) {
            if (type.isInstance(this.modifiers[i]) && this.modifiers[i].getIdentifier().equals(identifier)) {
                return (T)(this.modifiers[i]);
            }
        }

        return null;
    }
}
