package com.facebook.react.bridge;

public abstract class GuardedRunnable implements Runnable {
    public final NativeModuleCallExceptionHandler mExceptionHandler;

    @Deprecated
    public GuardedRunnable(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    public final void run() {
        try {
            runGuarded();
        } catch (RuntimeException e2) {
            this.mExceptionHandler.handleException(e2);
        }
    }

    public abstract void runGuarded();

    public GuardedRunnable(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mExceptionHandler = nativeModuleCallExceptionHandler;
    }
}
