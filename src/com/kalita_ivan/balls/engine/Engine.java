package com.kalita_ivan.balls.engine;


import javax.swing.*;

class Engine {
    private Scene scene;
    private Canvas canvas;
    private Window window;
    private int width;
    private int height;

    Engine(int width, int height) {
        this.width = width;
        this.height = height;
        this.createWindow();

        this.scene = new Scene();
    }

    private void createWindow() {
        this.window = new Window(this.width, this.height);
        this.canvas = new Canvas();
        this.window.add(this.canvas);
    }

    void start() {
        this.loop();
    }

    private void loop() {
        this.processInput();
        this.update();
        this.render();
        this.canvas.repaint();

        try {
            Thread.sleep((int) ((1f / 60f) * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(this::loop);
    }

    private void processInput() {

    }

    private void update() {

    }

    private void render() {
        System.out.println("Loop");
    }
}
