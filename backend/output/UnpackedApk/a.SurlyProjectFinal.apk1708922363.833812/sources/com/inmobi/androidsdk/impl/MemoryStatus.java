package com.inmobi.androidsdk.impl;

import android.os.Environment;
import android.os.StatFs;

/* compiled from: UserInfo */
class MemoryStatus {
    private static final int ERROR = -1;

    MemoryStatus() {
    }

    static synchronized boolean externalMemoryAvailable() {
        boolean equals;
        synchronized (MemoryStatus.class) {
            equals = Environment.getExternalStorageState().equals("mounted");
        }
        return equals;
    }

    static synchronized long getTotalInternalMemorySize() {
        long blockCount;
        synchronized (MemoryStatus.class) {
            try {
                StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
                blockCount = ((long) stat.getBlockCount()) * ((long) stat.getBlockSize());
            }
        }
        return blockCount;
    }

    static synchronized long getTotalExternalMemorySize() {
        long j;
        synchronized (MemoryStatus.class) {
            try {
                if (externalMemoryAvailable()) {
                    StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    j = ((long) stat.getBlockCount()) * ((long) stat.getBlockSize());
                } else {
                    j = -1;
                }
            }
        }
        return j;
    }

    static synchronized String formatSize(long size) {
        String str;
        synchronized (MemoryStatus.class) {
            String suffix = null;
            if (size >= 1024) {
                suffix = " KB";
                try {
                    size /= 1024;
                }
            }
            if (size >= 1024) {
                suffix = " MB";
                size /= 1024;
            }
            if (size >= 1024) {
                suffix = " GB";
                size /= 1024;
            }
            str = String.valueOf(size) + suffix;
        }
        return str;
    }
}
