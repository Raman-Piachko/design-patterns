package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class ThreeTimesIterator implements Iterator<Integer> {
    private int[] array;
    private int currentIndex = 0;

    public ThreeTimesIterator(int[] array) {
        this.array = triple(array);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            currentIndex++;
            return array[currentIndex - 1];
        }
    }


    private int[] triple(int[] array) {
        return IntStream.of(array).flatMap(x -> IntStream.of(x, x, x)).toArray();
    }
}
