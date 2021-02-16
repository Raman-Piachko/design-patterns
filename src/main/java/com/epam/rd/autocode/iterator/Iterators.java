package com.epam.rd.autocode.iterator;

import java.util.Iterator;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array) {
        return new TwoTimesIterator(array);
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return new ThreeTimesIterator(array);
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return new FiveTimesIterator(array);
    }

    public static Iterable<String> table(String[] columns, int[] rows) {
        return new TableIterator(columns, rows);
    }
}