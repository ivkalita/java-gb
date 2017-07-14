package com.kalita_ivan.balls.engine;

import java.awt.*;
import java.awt.event.ActionEvent;


class PaintEvent extends ActionEvent {
    private Graphics g;

    PaintEvent(Graphics g, Object source, int id, String command) {
        super(source, id, command);
        this.g = g;
    }

    Graphics getG() {
        return g;
    }
}
