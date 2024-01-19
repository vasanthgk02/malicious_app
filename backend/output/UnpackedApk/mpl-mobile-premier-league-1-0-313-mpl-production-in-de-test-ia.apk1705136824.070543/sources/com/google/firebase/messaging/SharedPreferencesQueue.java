package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

public final class SharedPreferencesQueue {
    public boolean bulkOperation = false;
    public final ArrayDeque<String> internalQueue = new ArrayDeque<>();
    public final String itemSeparator;
    public final String queueName;
    public final SharedPreferences sharedPreferences;
    public final Executor syncExecutor;

    public SharedPreferencesQueue(SharedPreferences sharedPreferences2, String str, String str2, Executor executor) {
        this.sharedPreferences = sharedPreferences2;
        this.queueName = str;
        this.itemSeparator = str2;
        this.syncExecutor = executor;
    }

    public static SharedPreferencesQueue createInstance(SharedPreferences sharedPreferences2, String str, String str2, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences2, str, str2, executor);
        synchronized (sharedPreferencesQueue.internalQueue) {
            try {
                sharedPreferencesQueue.internalQueue.clear();
                String string = sharedPreferencesQueue.sharedPreferences.getString(sharedPreferencesQueue.queueName, "");
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains(sharedPreferencesQueue.itemSeparator)) {
                        String[] split = string.split(sharedPreferencesQueue.itemSeparator, -1);
                        int length = split.length;
                        for (String str3 : split) {
                            if (!TextUtils.isEmpty(str3)) {
                                sharedPreferencesQueue.internalQueue.add(str3);
                            }
                        }
                    }
                }
            }
        }
        return sharedPreferencesQueue;
    }

    public final void syncState() {
        synchronized (this.internalQueue) {
            Editor edit = this.sharedPreferences.edit();
            String str = this.queueName;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.internalQueue.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(this.itemSeparator);
            }
            edit.putString(str, sb.toString()).commit();
        }
    }
}
