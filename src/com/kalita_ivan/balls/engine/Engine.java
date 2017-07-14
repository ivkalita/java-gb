package com.kalita_ivan.balls.engine;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.ThreadLocalRandom;

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
        this.canvas = new Canvas((ActionEvent evt) -> {
            if (evt instanceof PaintEvent) {
                this.tick(((PaintEvent) evt).getG());
            }
        });
        this.window.add(this.canvas);
    }

    void start() {
        try {
            for (int i = 0; i < 500; i++) {
                int x = ThreadLocalRandom.current().nextInt(0, this.width);
                int y = ThreadLocalRandom.current().nextInt(0, this.height);
                int radius = ThreadLocalRandom.current().nextInt(0, 30);
                int r = ThreadLocalRandom.current().nextInt(0, 255);
                int g = ThreadLocalRandom.current().nextInt(0, 255);
                int b = ThreadLocalRandom.current().nextInt(0, 255);
                this.scene.addObject(new Ball(x, y, radius, new Color(r, g, b)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Timer timer = new Timer(20, (ActionEvent evt) -> this.canvas.repaint());
        this.canvas.repaint();
        timer.start();
    }

    private void tick(Graphics g) {
        this.processInput();
        this.update();
        this.render(g);
    }

    private void processInput() {

    }

    private void update() {

    }

    private void render(Graphics g) {
        for (int i = 0; i < scene.getObjectsCount(); i++) {
            scene.objectAt(i).render(g);
        }
    }
}
