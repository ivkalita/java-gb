package com.kalita_ivan.exceptions;


public class ExceptionsApplication {
    public static void main(String[] args) {
        String[][] input = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
        };
        int size = 4;

        try {
            ArrayAccumulator accumulator = new ArrayAccumulator(input, size);
            int sum = accumulator.sum();
            System.out.println(String.format("Sum is %d", sum));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
