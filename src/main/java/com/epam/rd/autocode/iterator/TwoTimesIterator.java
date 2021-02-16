package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class TwoTimesIterator implements Iterator<Integer> {
    private int[] array;
    private int currentIndex = 0;

    public TwoTimesIterator(int[] array) {
        this.array = twice(array);
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


    private int[] twice(int[] array) {
        return IntStream.of(array).flatMap(x -> IntStream.of(x, x)).toArray();
    }
}
