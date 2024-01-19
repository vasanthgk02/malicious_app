package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Trace;
import java.util.HashSet;

public final class InitializationProvider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    public String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            if (AppInitializer.sInstance == null) {
                synchronized (AppInitializer.sLock) {
                    if (AppInitializer.sInstance == null) {
                        AppInitializer.sInstance = new AppInitializer(context);
                    }
                }
            }
            AppInitializer appInitializer = AppInitializer.sInstance;
            if (appInitializer != null) {
                try {
                    Trace.beginSection("Startup");
                    Bundle bundle = appInitializer.mContext.getPackageManager().getProviderInfo(new ComponentName(appInitializer.mContext.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                    String string = appInitializer.mContext.getString(R$string.androidx_startup);
                    if (bundle != null) {
                        HashSet hashSet = new HashSet();
                        for (String str : bundle.keySet()) {
                            if (string.equals(bundle.getString(str, null))) {
                                Class<?> cls = Class.forName(str);
                                if (Initializer.class.isAssignableFrom(cls)) {
                                    appInitializer.mDiscovered.add(cls);
                                    appInitializer.doInitialize(cls, hashSet);
                                }
                            }
                        }
                    }
                    Trace.endSection();
                    return true;
                } catch (NameNotFoundException | ClassNotFoundException e2) {
                    throw new StartupException(e2);
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                throw null;
            }
        } else {
            throw new StartupException((String) "Context cannot be null");
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
