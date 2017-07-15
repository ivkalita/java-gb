package com.kalita_ivan.balls.engine.events;

public class InputEvents {
    private final static int MAX_EVENTS_COUNT = 10;

    private InputEvent[] events;
    private int eventsCount;

    public InputEvents() {
        this.events = new InputEvent[InputEvents.MAX_EVENTS_COUNT];
        this.eventsCount = 0;
    }

    public void add(InputEvent a) {
        if (this.eventsCount >= InputEvents.MAX_EVENTS_COUNT) {
            return;
        }
        this.events[this.eventsCount] = a;
        this.eventsCount++;
    }

    public void clear() {
        for (int i = 0; i < this.eventsCount; i++) {
            this.events[i] = null;
        }
        this.eventsCount = 0;
    }

    public InputEvent[] getEvents() {
        return this.events;
    }

    public int count() {
        return this.eventsCount;
    }

    public InputEvent objectAt(int i) {
        if (i < 0 || i >= this.eventsCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.events[i];
    }
}
