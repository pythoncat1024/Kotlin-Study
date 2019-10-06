package org.victor.cat.java.html.hard;

class Table extends Tag {

    Table() {
        super("table");
    }

    Table tr(Action<Tr> init) {
        doInit(new Tr(), init);
        return this;
    }
}
