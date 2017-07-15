package com.kalita_ivan.balls.engine;

import javax.swing.*;

public class Game {
    final private static int GAME_FIELD_WIDTH = 600;
    final private static int GAME_FIELD_HEIGHT = 600;

    public void start() {
        SwingUtilities.invokeLater(() -> new Engine(
                Game.GAME_FIELD_WIDTH,
                Game.GAME_FIELD_HEIGHT,
                100,
                300,
                20
        ).start());
    }
}
