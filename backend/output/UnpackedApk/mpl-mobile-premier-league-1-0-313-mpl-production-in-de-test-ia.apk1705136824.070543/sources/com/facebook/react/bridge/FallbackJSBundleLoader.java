package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public final class FallbackJSBundleLoader extends JSBundleLoader {
    public static final String RECOVERABLE = "facebook::react::Recoverable";
    public static final String TAG = "FallbackJSBundleLoader";
    public Stack<JSBundleLoader> mLoaders = new Stack<>();
    public final ArrayList<Exception> mRecoveredErrors = new ArrayList<>();

    public FallbackJSBundleLoader(List<JSBundleLoader> list) {
        ListIterator<JSBundleLoader> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            this.mLoaders.push(listIterator.previous());
        }
    }

    private JSBundleLoader getDelegateLoader() {
        if (!this.mLoaders.empty()) {
            return this.mLoaders.peek();
        }
        Throwable runtimeException = new RuntimeException("No fallback options available");
        Iterator<Exception> it = this.mRecoveredErrors.iterator();
        Throwable th = runtimeException;
        while (it.hasNext()) {
            th.initCause(it.next());
            while (th.getCause() != null) {
                th = th.getCause();
            }
        }
        throw runtimeException;
    }

    public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
        while (true) {
            try {
                return getDelegateLoader().loadScript(jSBundleLoaderDelegate);
            } catch (Exception e2) {
                if (e2.getMessage() == null || !e2.getMessage().startsWith(RECOVERABLE)) {
                    throw e2;
                }
                this.mLoaders.pop();
                this.mRecoveredErrors.add(e2);
                if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(6)) {
                    ((FLogDefaultLoggingDelegate) FLog.sHandler).println(6, TAG, "Falling back from recoverable error", e2);
                }
            }
        }
        throw e2;
    }
}
