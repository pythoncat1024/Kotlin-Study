package org.victor.cat.java.html.hard;

class HtmlClient {

    public static void main(String[] args) {

        System.out.println(
                new Table().tr(tr -> tr.td(td -> { }))
        );

        System.err.println(createTable());
    }


    private static Tag createTable() {

        return new Table()
                .tr(new Action<Tr>() {
                    @Override
                    public void invoke(Tr tr) {
                        tr.td(new Action<Td>() {
                            @Override
                            public void invoke(Td td) {

                            }
                        });
                    }
                });
    }
}
