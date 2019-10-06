package org.victor.cat.java.html.hard;

class Tr extends Tag {
    Tr() {
        super("tr");
    }

    Tr td(Action<Td> init) {
        doInit(new Td(), init);
        return this;
    }
}
