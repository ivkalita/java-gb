package com.kalita_ivan.balls.engine;


import javax.swing.*;

public class Game {
    final private static int GAME_FIELD_WIDTH = 1200;
    final private static int GAME_FIELD_HEIGHT = 1200;

    public void start() {
        SwingUtilities.invokeLater(() -> new Engine(Game.GAME_FIELD_WIDTH, Game.GAME_FIELD_HEIGHT).start());
    }
}
