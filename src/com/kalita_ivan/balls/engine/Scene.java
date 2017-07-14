package com.kalita_ivan.balls.engine;


class Scene {
    final private static int MAX_OBJECTS_COUNT = 1000;

    private GameObjectInterface[] objects;
    private int objectsCount = 0;

    Scene() {
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
}
