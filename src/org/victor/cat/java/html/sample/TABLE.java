package org.victor.cat.java.html.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class TABLE {

    private List<TR> children = new ArrayList<>();

    TABLE tr(Wrapper<TR> wrapper) {
        TR tr = new TR();
        wrapper.invoke(tr);
        children.add(tr);
        return this;
    }

    @Override
    public String toString() {
        String name = "table";
        return String.format(Locale.CHINA,
                "<%s>%s</%s>",
                name, ListUtils.toString(children), name);
    }
}
