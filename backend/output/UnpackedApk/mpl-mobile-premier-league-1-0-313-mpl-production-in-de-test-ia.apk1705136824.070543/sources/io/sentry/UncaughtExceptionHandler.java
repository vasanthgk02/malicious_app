package io.sentry;

public interface UncaughtExceptionHandler {

    public static final class Adapter implements UncaughtExceptionHandler {
        public static final Adapter INSTANCE = new Adapter();

        public static UncaughtExceptionHandler getInstance() {
            return INSTANCE;
        }

        public java.lang.Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
            return Thread.getDefaultUncaughtExceptionHandler();
        }

        public void setDefaultUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    java.lang.Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler();

    void setDefaultUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
