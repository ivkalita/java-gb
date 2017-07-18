package com.kalita_ivan.exceptions;


class ArraySizeException extends Exception {
    private int expected;
    private int actual;

    ArraySizeException(int expected, int actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public String getMessage() {
        return String.format("Unexpected size of array – expected %d, found %d", this.expected, this.actual);
    }
}
