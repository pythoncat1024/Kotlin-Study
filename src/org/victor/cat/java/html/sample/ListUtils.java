package org.victor.cat.java.html.sample;

import java.util.List;

class ListUtils {

    private ListUtils() {
    }

    static <T> String toString(List<T> list) {
        return list.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "");
    }
}
