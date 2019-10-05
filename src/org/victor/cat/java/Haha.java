package org.victor.cat.java;

public class Haha {

    public static void main(String[] args) {
        Happy happy = new Happy() {
        };

        System.out.println(happy);

        System.err.println(happy.getClass().getName());
    }
}

interface Happy {
}
