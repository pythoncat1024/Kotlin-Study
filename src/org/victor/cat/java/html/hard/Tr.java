package org.victor.cat.java.html.hard;

import java.util.function.Function;

class Tr extends Tag {
    Tr() {
        super("tr");
    }

    Void td(Function<Td, Void> init) {
        return doInit(new Td(), init);
    }
}
