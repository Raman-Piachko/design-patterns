package com.epam.rd.autocode.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TableIterator implements Iterable<String> {
    private String[] columns;
    private int[] rows;

    public TableIterator(String[] columns, int[] rows) {
        this.columns = columns;
        this.rows = rows;
    }


    @Override
    public Iterator<String> iterator() {
        return makeTable().iterator();
    }

    private List<String> makeTable() {
        List<String> table = new ArrayList<>();
        Arrays.stream(columns)
                .forEachOrdered(column -> {
                    Arrays.stream(rows)
                            .mapToObj(row -> column + row)
                            .forEach(table::add);
                });
        return table;
    }
}
