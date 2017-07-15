package com.kalita_ivan.balls.engine;

import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    Window(int width, int height) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.centerLocation();
        this.setVisible(true);
    }

    private void centerLocation() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
}
