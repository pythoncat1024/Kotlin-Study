package org.victor.cat.java.html.hard;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

class Tag {

    private String name;

    private List<Tag> children = new ArrayList<>();

    Tag(String name) {
        this.name = name;
    }

    <T extends Tag> Void doInit(T child, Function<T, Void> init) {
        init.apply(child);
        children.add(child);
        return null;
    }

    private String childrenStr() {
        return children.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                ;
    }

    @Override
    public String toString() {
        return String.format(Locale.CHINA,
                "<%s>%s</%s>", name, childrenStr(), name);
    }
}
