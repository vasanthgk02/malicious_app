package com.facebook.common.statfs;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import co.hyperverge.hypersnapsdk.c.k;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StatFsHelper {
    public static final long RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2);
    public static StatFsHelper sStatsFsHelper;
    public final Lock lock = new ReentrantLock();
    public volatile File mExternalPath;
    public volatile StatFs mExternalStatFs = null;
    public volatile boolean mInitialized = false;
    public volatile File mInternalPath;
    public volatile StatFs mInternalStatFs = null;
    public long mLastRestatTime;

    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper getInstance() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            try {
                if (sStatsFsHelper == null) {
                    sStatsFsHelper = new StatFsHelper();
                }
                statFsHelper = sStatsFsHelper;
            }
        }
        return statFsHelper;
    }

    public final void ensureInitialized() {
        if (!this.mInitialized) {
            this.lock.lock();
            try {
                if (!this.mInitialized) {
                    this.mInternalPath = Environment.getDataDirectory();
                    this.mExternalPath = Environment.getExternalStorageDirectory();
                    updateStats();
                    this.mInitialized = true;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public final void updateStats() {
        this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
        this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
        this.mLastRestatTime = SystemClock.uptimeMillis();
    }

    public final StatFs updateStatsHelper(StatFs statFs, File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (statFs == null) {
            try {
                statFs = new StatFs(file.getAbsolutePath());
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Throwable th) {
                k.propagateIfPossible(th);
                throw new RuntimeException(th);
            }
        } else {
            statFs.restat(file.getAbsolutePath());
        }
        return statFs;
    }
}
