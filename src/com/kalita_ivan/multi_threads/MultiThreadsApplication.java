package com.kalita_ivan.multi_threads;

public class MultiThreadsApplication {
    private static final int size = 10000000;

    public static void main(String[] args) {
        System.out.println(String.format("Single thread = %d ms", singleThread()));
        for (int i = 2; i <= 32; i *= 2) {
            System.out.println(String.format("%d threads = %d ms", i, multiThreads(i)));
        }
    }

    private static float[] prepareArray()
    {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        return arr;
    }

    private static long singleThread()
    {
        float[] arr = prepareArray();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = calc(arr[i], i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static float calc(float value, int index) {
        return (float)(value * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
    }

    private static long multiThreads(int threadsCount) {
        float[] src = prepareArray();
        long start = System.currentTimeMillis();

        float[][] parts = split(src, threadsCount);
        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            final float[] part = parts[i];
            threads[i] = new Thread(() -> {
                for (int j = 0; j < part.length; j++) {
                    part[j] = calc(part[j], j);
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        merge(src, parts);
        long end = System.currentTimeMillis();

        return end - start;
    }

    private static float[][] split(float[] arr, int count) {
        if (arr.length % count != 0) {
            throw new RuntimeException("Unable to split an array.");
        }
        int partSize = arr.length / count;
        float[][] parts = new float[count][];
        for (int i = 0; i < count; i++) {
            parts[i] = new float[partSize];
            System.arraycopy(arr, partSize * i, parts[i], 0, partSize);
        }

        return parts;
    }

    private static void merge(float[] arr, float[][] parts) {
        int currentPosition = 0;
        for (int i = 0; i < parts.length; i++) {
            System.arraycopy(parts[i], 0, arr, currentPosition, parts[i].length);
            currentPosition += parts[i].length;
        }
    }
}
