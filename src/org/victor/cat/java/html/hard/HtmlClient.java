package org.victor.cat.java.html.hard;

import java.util.function.Function;

class HtmlClient {

    public static void main(String[] args) {

        Table table = new Table();
        Function<Tr, Void> initTR = new Function<>() {
            @Override
            public Void apply(Tr tr) {
                Function<Td, Void> initTD = new Function<>() {
                    @Override
                    public Void apply(Td td) {
                        return null;
                    }
                };
                return tr.td(initTD);
            }
        };
        table.tr(initTR);
        System.out.println(table);

        System.err.println(createTable());
    }


    private static Tag createTable() {
        Table table = new Table();
        table.tr(tr -> tr.td(td -> null));
        return table;
    }
}
