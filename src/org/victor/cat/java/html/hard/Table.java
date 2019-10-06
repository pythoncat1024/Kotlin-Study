package org.victor.cat.java.html.hard;

import java.util.function.Function;

class Table extends Tag {

    Table() {
        super("table");
    }

    void tr(Function<Tr, Void> init) {
        doInit(new Tr(), init);
    }
}
