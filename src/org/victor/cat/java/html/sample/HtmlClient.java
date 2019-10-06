package org.victor.cat.java.html.sample;

class HtmlClient {

    public static void main(String[] args) {


        System.out.println("getTable ==== " + getTable());

//        System.out.println("createTable # " + createTable());
    }

    private static TABLE createTable() {
        TABLE table = new TABLE();
        table.tr(tr -> tr.td(td -> {
            // System.err.println("be invoked in lambda...");
        }));
        return table;
    }

    private static TABLE getTable() {
        TABLE table = new TABLE();
        table.tr(new Wrapper<TR>() {
            @Override
            public void invoke(TR tr) {
                tr.td(new Wrapper<TD>() {
                    @Override
                    public void invoke(TD td) {
                        // System.err.println("be invoked.");
                    }
                });
            }
        });
        return table;
    }
}
