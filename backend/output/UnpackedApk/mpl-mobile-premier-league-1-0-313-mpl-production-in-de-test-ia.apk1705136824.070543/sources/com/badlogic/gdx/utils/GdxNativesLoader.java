package com.badlogic.gdx.utils;

public class GdxNativesLoader {
    public static boolean nativesLoaded;

    public static synchronized void load() {
        synchronized (GdxNativesLoader.class) {
            if (!nativesLoaded) {
                nativesLoaded = true;
                new SharedLibraryLoader().load("gdx");
            }
        }
    }
}
