package com.facebook.soloader;

import android.os.StrictMode.ThreadPolicy;
import java.io.File;
import java.io.IOException;

public abstract class SoSource {
    public abstract int loadLibrary(String str, int i, ThreadPolicy threadPolicy) throws IOException;

    public void prepare(int i) throws IOException {
    }

    public String toString() {
        return getClass().getName();
    }

    public abstract File unpackLibrary(String str) throws IOException;
}
