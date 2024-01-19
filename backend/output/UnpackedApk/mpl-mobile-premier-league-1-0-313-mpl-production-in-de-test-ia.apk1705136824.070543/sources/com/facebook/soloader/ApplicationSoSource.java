package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.StrictMode.ThreadPolicy;
import java.io.File;
import java.io.IOException;

public class ApplicationSoSource extends SoSource {
    public Context applicationContext;
    public int flags;
    public DirectorySoSource soSource;

    public ApplicationSoSource(Context context, int i) {
        Context applicationContext2 = context.getApplicationContext();
        this.applicationContext = applicationContext2;
        if (applicationContext2 == null) {
            this.applicationContext = context;
        }
        this.flags = i;
        this.soSource = new DirectorySoSource(new File(this.applicationContext.getApplicationInfo().nativeLibraryDir), i);
    }

    public static File getNativeLibDirFromContext(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    public boolean checkAndMaybeUpdate() throws IOException {
        File file = this.soSource.soDirectory;
        Context updatedContext = getUpdatedContext();
        File nativeLibDirFromContext = getNativeLibDirFromContext(updatedContext);
        if (file.equals(nativeLibDirFromContext)) {
            return false;
        }
        "Native library directory updated from " + file + " to " + nativeLibDirFromContext;
        int i = this.flags | 1;
        this.flags = i;
        this.soSource = new DirectorySoSource(nativeLibDirFromContext, i);
        this.applicationContext = updatedContext;
        return true;
    }

    public Context getUpdatedContext() {
        try {
            return this.applicationContext.createPackageContext(this.applicationContext.getPackageName(), 0);
        } catch (NameNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int loadLibrary(String str, int i, ThreadPolicy threadPolicy) throws IOException {
        return this.soSource.loadLibrary(str, i, threadPolicy);
    }

    public void prepare(int i) throws IOException {
        this.soSource.prepare(i);
    }

    public String toString() {
        return this.soSource.toString();
    }

    public File unpackLibrary(String str) throws IOException {
        DirectorySoSource directorySoSource = this.soSource;
        if (directorySoSource != null) {
            File file = new File(directorySoSource.soDirectory, str);
            if (file.exists()) {
                return file;
            }
            return null;
        }
        throw null;
    }
}
