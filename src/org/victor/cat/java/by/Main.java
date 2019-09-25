package org.victor.cat.java.by;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {
    public static void main(String[] args) {

        Case cc = new Case();

        cc.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Object oldValue = evt.getOldValue();
                Object newValue = evt.getNewValue();
                String propertyName = evt.getPropertyName();
                Object propagationId = evt.getPropagationId();
                System.err.println(propagationId + "," + propertyName + "," + oldValue + "," + newValue);
                cc.removePropertyChangeListener(this);
            }
        });
        cc.setCaseName("case1");
        cc.setCaseLevel(11);

        System.out.println(cc);

        cc.setCaseLevel(9);
    }
}
