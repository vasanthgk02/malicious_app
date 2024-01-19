package com.badlogic.gdx.utils;

public class Sort {
    public static Sort instance;
    public TimSort timSort;

    public static Sort instance() {
        if (instance == null) {
            instance = new Sort();
        }
        return instance;
    }
}
