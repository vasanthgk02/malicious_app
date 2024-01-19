package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import java.util.Date;

public class ConfigMetadataClient {
    public static final Date LAST_FETCH_TIME_NO_FETCH_YET = new Date(-1);
    public static final Date NO_BACKOFF_TIME = new Date(-1);
    public final Object backoffMetadataLock = new Object();
    public final Object frcInfoLock = new Object();
    public final SharedPreferences frcMetadata;

    public static class BackoffMetadata {
        public Date backoffEndTime;
        public int numFailedFetches;

        public BackoffMetadata(int i, Date date) {
            this.numFailedFetches = i;
            this.backoffEndTime = date;
        }
    }

    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        this.frcMetadata = sharedPreferences;
    }

    public BackoffMetadata getBackoffMetadata() {
        BackoffMetadata backoffMetadata;
        synchronized (this.backoffMetadataLock) {
            try {
                backoffMetadata = new BackoffMetadata(this.frcMetadata.getInt("num_failed_fetches", 0), new Date(this.frcMetadata.getLong("backoff_end_time_in_millis", -1)));
            }
        }
        return backoffMetadata;
    }

    public void setBackoffMetadata(int i, Date date) {
        synchronized (this.backoffMetadataLock) {
            this.frcMetadata.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }
}
