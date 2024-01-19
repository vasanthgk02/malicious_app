package com.facebook.datasource;

public class SimpleDataSource<T> extends AbstractDataSource<T> {
    public boolean setFailure(Throwable th) {
        if (th != null) {
            return super.setFailure(th);
        }
        throw null;
    }

    public boolean setProgress(float f2) {
        return super.setProgress(f2);
    }

    public boolean setResult(T t, boolean z) {
        if (t != null) {
            return super.setResult(t, z);
        }
        throw null;
    }

    public boolean setResult(T t) {
        if (t != null) {
            return super.setResult(t, true);
        }
        throw null;
    }
}
