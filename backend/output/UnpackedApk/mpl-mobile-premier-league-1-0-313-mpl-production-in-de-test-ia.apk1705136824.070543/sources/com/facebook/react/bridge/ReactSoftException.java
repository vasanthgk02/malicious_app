package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@DoNotStrip
@Deprecated
public class ReactSoftException {
    public static final List<ReactSoftExceptionListener> sListeners = new CopyOnWriteArrayList();

    public interface ReactSoftExceptionListener {
        void logSoftException(String str, Throwable th);
    }

    @DoNotStrip
    public static void addListener(ReactSoftExceptionListener reactSoftExceptionListener) {
        if (!sListeners.contains(reactSoftExceptionListener)) {
            sListeners.add(reactSoftExceptionListener);
        }
    }

    @DoNotStrip
    public static void clearListeners() {
        sListeners.clear();
    }

    @DoNotStrip
    public static void logSoftException(String str, Throwable th) {
        if (sListeners.size() > 0) {
            for (ReactSoftExceptionListener logSoftException : sListeners) {
                logSoftException.logSoftException(str, th);
            }
            return;
        }
        FLog.e(str, (String) "Unhandled SoftException", th);
    }

    @DoNotStrip
    public static void removeListener(ReactSoftExceptionListener reactSoftExceptionListener) {
        sListeners.remove(reactSoftExceptionListener);
    }
}
