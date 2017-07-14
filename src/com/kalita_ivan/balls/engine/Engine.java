package com.kalita_ivan.balls.engine;


import com.kalita_ivan.balls.engine.modifiers.ModifierHandlerInterface;
import com.kalita_ivan.balls.engine.modifiers.RigidBodyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class Engine {
    private Scene scene;
    private Canvas canvas;
    private Window window;
    private int width;
    private int height;
    private long lastTickTime;
    private ModifierHandlerInterface[] modifierHandlers;

    Engine(int width, int height) {
        this.width = width;
        this.height = height;
        this.createWindow();

        this.scene = new Scene(this.width, this.height);

        this.modifierHandlers = new ModifierHandlerInterface[1];
        this.modifierHandlers[0] = new RigidBodyHandler(this.scene);
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
                this.scene.addObject(Ball.random(this.width, this.height));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Timer timer = new Timer(20, (ActionEvent evt) -> this.canvas.repaint());
        this.canvas.repaint();
        timer.start();
    }

    private void tick(Graphics g) {
        long currentTime = System.nanoTime();
        double delta = (this.lastTickTime == 0 ? 0 : currentTime - this.lastTickTime) * 1e-9f;
        this.processInput();
        this.update(delta);
        this.render(g);
        this.lastTickTime = currentTime;
    }

    private void processInput() {

    }

    private void update(double delta) {
        for (int i = 0; i < scene.getObjectsCount(); i++) {
            GameObjectInterface object = scene.objectAt(i);
            for (int j = 0; j < this.modifierHandlers.length; j++) {
                this.modifierHandlers[j].update(object.getModifiers(), delta);
            }
        }
    }

    private void render(Graphics g) {
        for (int i = 0; i < scene.getObjectsCount(); i++) {
            scene.objectAt(i).render(g);
        }
    }
}
