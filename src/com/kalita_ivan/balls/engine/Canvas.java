package com.kalita_ivan.balls.engine;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


class Canvas extends JPanel {
    private ActionListener onRepaint;

    Canvas(ActionListener onRepaint) {
        this.onRepaint = onRepaint;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.onRepaint.actionPerformed(new PaintEvent(g, this, 1, ""));
    }
}
