package com.badlogic.gdx;

public interface Application {

    public enum ApplicationType {
        Android,
        Desktop,
        HeadlessDesktop,
        Applet,
        WebGL,
        iOS
    }

    void addLifecycleListener(LifecycleListener lifecycleListener);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th);

    ApplicationAdapter getApplicationListener();

    Graphics getGraphics();

    ApplicationType getType();

    void log(String str, String str2);

    void log(String str, String str2, Throwable th);

    void postRunnable(Runnable runnable);

    void removeLifecycleListener(LifecycleListener lifecycleListener);
}
