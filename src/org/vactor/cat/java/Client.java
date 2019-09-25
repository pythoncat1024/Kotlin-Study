package org.vactor.cat.java;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class Client {

    private String name = new Inner().get();

    PropertyChangeSupport support;
    PropertyChangeEvent event;
}

class Inner {

    private String text;

    public String get() {
        return text;
    }

    public void set(String value) {
        synchronized (Inner.class) {
            this.text = value;
        }
    }
}
