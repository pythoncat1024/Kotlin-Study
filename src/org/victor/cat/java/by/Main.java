package org.victor.cat.java.by;

import kotlin.jvm.functions.Function2;

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

        compute(2, 3, new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer invoke(Integer x, Integer y) {
                return x + y;
            }
        });
        compute(2, 3, (x, y) -> x * y);

        // compute(2, 3) { a, b -> a + b } // kt 实现
    }


    public static int compute(int a, int b, Function2<Integer, Integer, Integer> func) {
        return func.invoke(a, b);
    }
}
