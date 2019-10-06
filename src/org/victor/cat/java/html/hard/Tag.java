package org.victor.cat.java.html.hard;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Tag {

    private String name;

    private List<Tag> children = new ArrayList<>();

    Tag(String name) {
        this.name = name;
    }

    <T extends Tag> void doInit(T child, Action<T> init) {
        init.invoke(child);
        children.add(child);
    }

    private String childrenStr() {
        return children.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "")
                ;
    }

    @Override
    public String toString() {
        return String.format(Locale.CHINA,
                "<%s>%s</%s>", name, childrenStr(), name);
    }
}
