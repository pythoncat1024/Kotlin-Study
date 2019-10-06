package org.victor.cat.java.html.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class TR {


    private List<TD> children = new ArrayList<>();

    TR td(Wrapper<TD> wrapper) {
        TD td = new TD();
        wrapper.invoke(td);
        children.add(td);
        return this;
    }

    @Override
    public String toString() {
        String name = "tr";
        return String.format(Locale.CHINA,
                "<%s>%s</%s>",
                name, ListUtils.toString(children), name);
    }
}
