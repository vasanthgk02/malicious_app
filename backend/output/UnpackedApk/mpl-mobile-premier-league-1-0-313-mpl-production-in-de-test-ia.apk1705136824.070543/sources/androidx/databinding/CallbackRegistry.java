package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class CallbackRegistry<C, T, A> implements Cloneable {
    public List<C> mCallbacks = new ArrayList();
    public long mFirst64Removed = 0;
    public int mNotificationLevel;
    public final NotifierCallback<C, T, A> mNotifier;
    public long[] mRemainderRemoved;

    public static abstract class NotifierCallback<C, T, A> {
        public abstract void onNotifyCallback(C c2, T t, int i, A a2);
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifierCallback) {
        this.mNotifier = notifierCallback;
    }

    public synchronized void add(C c2) {
        if (c2 != null) {
            int lastIndexOf = this.mCallbacks.lastIndexOf(c2);
            if (lastIndexOf < 0 || isRemoved(lastIndexOf)) {
                this.mCallbacks.add(c2);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    public Object clone() throws CloneNotSupportedException {
        CallbackRegistry callbackRegistry;
        CloneNotSupportedException e2;
        synchronized (this) {
            try {
                callbackRegistry = (CallbackRegistry) super.clone();
                try {
                    callbackRegistry.mFirst64Removed = 0;
                    callbackRegistry.mRemainderRemoved = null;
                    callbackRegistry.mNotificationLevel = 0;
                    callbackRegistry.mCallbacks = new ArrayList();
                    int size = this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        if (!isRemoved(i)) {
                            callbackRegistry.mCallbacks.add(this.mCallbacks.get(i));
                        }
                    }
                } catch (CloneNotSupportedException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return callbackRegistry;
                }
            } catch (CloneNotSupportedException e4) {
                CloneNotSupportedException cloneNotSupportedException = e4;
                callbackRegistry = null;
                e2 = cloneNotSupportedException;
                e2.printStackTrace();
                return callbackRegistry;
            }
        }
        return callbackRegistry;
    }

    public final boolean isRemoved(int i) {
        boolean z = true;
        if (i < 64) {
            if (((1 << i) & this.mFirst64Removed) == 0) {
                z = false;
            }
            return z;
        }
        long[] jArr = this.mRemainderRemoved;
        if (jArr == null) {
            return false;
        }
        int i2 = (i / 64) - 1;
        if (i2 >= jArr.length) {
            return false;
        }
        if (((1 << (i % 64)) & jArr[i2]) == 0) {
            z = false;
        }
        return z;
    }

    public synchronized void notifyCallbacks(T t, int i, A a2) {
        this.mNotificationLevel++;
        int size = this.mCallbacks.size();
        int length = this.mRemainderRemoved == null ? -1 : this.mRemainderRemoved.length - 1;
        notifyRemainder(t, i, null, length);
        notifyCallbacks(t, i, null, (length + 2) * 64, size, 0);
        int i2 = this.mNotificationLevel - 1;
        this.mNotificationLevel = i2;
        if (i2 == 0) {
            if (this.mRemainderRemoved != null) {
                for (int length2 = this.mRemainderRemoved.length - 1; length2 >= 0; length2--) {
                    long j = this.mRemainderRemoved[length2];
                    if (j != 0) {
                        removeRemovedCallbacks((length2 + 1) * 64, j);
                        this.mRemainderRemoved[length2] = 0;
                    }
                }
            }
            if (this.mFirst64Removed != 0) {
                removeRemovedCallbacks(0, this.mFirst64Removed);
                this.mFirst64Removed = 0;
            }
        }
    }

    public final void notifyRemainder(T t, int i, A a2, int i2) {
        if (i2 < 0) {
            notifyCallbacks(t, i, a2, 0, Math.min(64, this.mCallbacks.size()), this.mFirst64Removed);
            return;
        }
        long j = this.mRemainderRemoved[i2];
        int i3 = (i2 + 1) * 64;
        int min = Math.min(this.mCallbacks.size(), i3 + 64);
        notifyRemainder(t, i, a2, i2 - 1);
        notifyCallbacks(t, i, a2, i3, min, j);
    }

    public synchronized void remove(C c2) {
        if (this.mNotificationLevel == 0) {
            this.mCallbacks.remove(c2);
        } else {
            int lastIndexOf = this.mCallbacks.lastIndexOf(c2);
            if (lastIndexOf >= 0) {
                setRemovalBit(lastIndexOf);
            }
        }
    }

    public final void removeRemovedCallbacks(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = (i + 64) - 1; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.mCallbacks.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    public final void setRemovalBit(int i) {
        if (i < 64) {
            this.mFirst64Removed = (1 << i) | this.mFirst64Removed;
            return;
        }
        int i2 = (i / 64) - 1;
        long[] jArr = this.mRemainderRemoved;
        if (jArr == null) {
            this.mRemainderRemoved = new long[(this.mCallbacks.size() / 64)];
        } else if (jArr.length <= i2) {
            long[] jArr2 = new long[(this.mCallbacks.size() / 64)];
            long[] jArr3 = this.mRemainderRemoved;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.mRemainderRemoved = jArr2;
        }
        long j = 1 << (i % 64);
        long[] jArr4 = this.mRemainderRemoved;
        jArr4[i2] = j | jArr4[i2];
    }

    public final void notifyCallbacks(T t, int i, A a2, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.mNotifier.onNotifyCallback(this.mCallbacks.get(i2), t, i, a2);
            }
            j2 <<= 1;
            i2++;
        }
    }
}
