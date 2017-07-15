package com.kalita_ivan.balls.engine;

import com.kalita_ivan.balls.engine.events.ClickEvent;
import com.kalita_ivan.balls.engine.events.InputEvent;
import com.kalita_ivan.balls.engine.events.InputEvents;
import com.kalita_ivan.balls.engine.geometry.Vector2;
import com.kalita_ivan.balls.engine.modifiers.TransitionHandler;
import com.kalita_ivan.balls.engine.modifiers.ModifierHandlerInterface;
import com.kalita_ivan.balls.engine.modifiers.RigidBodyHandler;
import com.kalita_ivan.balls.engine.objects.Background;
import com.kalita_ivan.balls.engine.objects.BallFactory;
import com.kalita_ivan.balls.engine.objects.GameObjectInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Engine {
    private Scene scene;
    private Canvas canvas;
    private Window window;
    private InputEvents events;
    private BallFactory ballFactory;

    private int width;
    private int height;
    private long lastTickTime;
    private int initialBallsCount;
    private double maxAllowedBallSpeed;
    private int msPerTick;

    private ModifierHandlerInterface[] modifierHandlers;

    Engine(int width, int height, int initialBallsCount, double maxAllowedBallSpeed, int msPerTick) {
        this.width = width;
        this.height = height;
        this.initialBallsCount = initialBallsCount;
        this.maxAllowedBallSpeed = maxAllowedBallSpeed;
        this.msPerTick = msPerTick;
        this.ballFactory = new BallFactory();

        this.createWindow();
        this.createScene();
        this.createHandlers();
        this.createInputEvents();
    }

    private void createWindow() {
        this.window = new Window(this.width, this.height);
        this.canvas = new Canvas((ActionEvent evt) -> {
            if (evt instanceof PaintEvent) {
                this.tick(((PaintEvent) evt).getG());
            }
        });
        this.window.add(this.canvas);
        Engine engine = this;
        this.canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                engine.events.add(new ClickEvent(engine.lastTickTime, e.getX(), e.getY()));
            }
        });
    }

    private void createScene() {
        this.scene = new Scene(this.width, this.height);
    }

    private void createHandlers() {
        this.modifierHandlers = new ModifierHandlerInterface[2];
        this.modifierHandlers[0] = new RigidBodyHandler(this.scene, this.maxAllowedBallSpeed);
        this.modifierHandlers[1] = new TransitionHandler();
    }

    private void createInputEvents() {
        this.events = new InputEvents();
    }

    void start() {
        Vector2 dimensions = new Vector2(this.width, this.height);
        try {
            this.scene.addObject(new Background(dimensions));
            for (int i = 0; i < this.initialBallsCount; i++) {
                this.scene.addObject(this.ballFactory.createRandomBall(this.width, this.height));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Timer timer = new Timer(this.msPerTick, (ActionEvent evt) -> this.canvas.repaint());
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
        for (int i = 0; i < this.events.count(); i++) {
            InputEvent ev = this.events.objectAt(i);
            if (ev instanceof ClickEvent) {
                Vector2 pos = ((ClickEvent) ev).getPosition();
                try {
                    this.scene.addObject(this.ballFactory.createRandomBallAt(pos));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.events.clear();
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
