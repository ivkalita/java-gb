package com.kalita_ivan.exceptions;


class ArrayDataCastException extends Exception {
    private int row;
    private int column;
    private String value;

    ArrayDataCastException(int row, int column, String value) {
        super();
        this.row = row;
        this.column = column;
        this.value = value;
    }

    @Override
    public String getMessage() {
        return String.format("Unable to cast value %s at (%d, %d) to integer", this.value, this.row, this.column);
    }
}
