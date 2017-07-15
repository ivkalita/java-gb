package com.kalita_ivan.balls.engine;

import com.kalita_ivan.balls.engine.objects.GameObjectInterface;

public class Scene {
    final private static int MAX_OBJECTS_COUNT = 1000;

    private GameObjectInterface[] objects;
    private int objectsCount = 0;
    private double width;
    private double height;

    Scene(double width, double height) {
        this.width = width;
        this.height = height;
        this.objects = new GameObjectInterface[Scene.MAX_OBJECTS_COUNT];
    }

    void addObject(GameObjectInterface object) throws Exception {
        if (this.objectsCount + 1 > Scene.MAX_OBJECTS_COUNT) {
            throw new Exception("Scene maximum objects count exceeded");
        }
        this.objects[this.objectsCount] = object;
        this.objectsCount++;
    }

    GameObjectInterface objectAt(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.getObjectsCount()) {
            throw new IndexOutOfBoundsException();
        }
        return this.objects[i];
    }

    int getObjectsCount() {
        return this.objectsCount;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
