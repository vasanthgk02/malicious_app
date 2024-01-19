package com.bumptech.glide.manager;

public class ApplicationLifecycle implements Lifecycle {
    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    public void removeListener(LifecycleListener lifecycleListener) {
    }
}
