package com.kalita_ivan.exceptions;


class ArrayAccumulator {
    private String[][] array;
    private int size;

    ArrayAccumulator(String[][] array, int size) {
        this.array = array;
        this.size = size;
    }

    int sum() throws ArraySizeException, ArrayDataCastException {
        this.assertArraySize(this.array);
        int sum = 0;
        for (int i = 0; i < this.size; i++) {
            this.assertArraySize(this.array[i]);
            for (int j = 0; j < this.size; j++) {
                try {
                    sum += Integer.parseInt(this.array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataCastException(i, j, this.array[i][j]);
                }
            }
        }
        return sum;
    }

    private void assertArraySize(Object[] array) throws ArraySizeException {
        if (array.length != this.size) {
            throw new ArraySizeException(this.size, array.length);
        }
    }
}
