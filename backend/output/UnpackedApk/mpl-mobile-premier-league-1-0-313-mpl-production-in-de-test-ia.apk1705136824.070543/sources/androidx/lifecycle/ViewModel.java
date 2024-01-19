package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class ViewModel {
    public final Map<String, Object> mBagOfTags = new HashMap();
    public volatile boolean mCleared = false;

    public static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                for (Object closeWithRuntimeException : this.mBagOfTags.values()) {
                    closeWithRuntimeException(closeWithRuntimeException);
                }
            }
        }
        onCleared();
    }

    public <T> T getTag(String str) {
        T t;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            try {
                t = this.mBagOfTags.get(str);
            }
        }
        return t;
    }

    public void onCleared() {
    }

    public <T> T setTagIfAbsent(String str, T t) {
        T t2;
        synchronized (this.mBagOfTags) {
            try {
                t2 = this.mBagOfTags.get(str);
                if (t2 == null) {
                    this.mBagOfTags.put(str, t);
                }
            }
        }
        if (t2 != null) {
            t = t2;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t);
        }
        return t;
    }
}
