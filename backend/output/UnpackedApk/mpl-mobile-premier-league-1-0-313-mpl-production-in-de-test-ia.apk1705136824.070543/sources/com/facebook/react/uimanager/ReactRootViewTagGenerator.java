package com.facebook.react.uimanager;

public class ReactRootViewTagGenerator {
    public static int sNextRootViewTag = 1;

    public static synchronized int getNextRootViewTag() {
        int i;
        synchronized (ReactRootViewTagGenerator.class) {
            try {
                i = sNextRootViewTag;
                sNextRootViewTag += 10;
            }
        }
        return i;
    }
}
