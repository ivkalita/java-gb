package com.kalita_ivan.balls.engine.modifiers;

abstract public class AbstractModifier {
    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    AbstractModifier(String identifier) {
        this.identifier = identifier;
    }
}
