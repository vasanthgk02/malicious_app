package com.google.firebase.messaging;

import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public final class TopicsStore {
    public static WeakReference<TopicsStore> topicsStoreWeakReference;
    public final SharedPreferences sharedPreferences;
    public final Executor syncExecutor;
    public SharedPreferencesQueue topicOperationsQueue;

    public TopicsStore(SharedPreferences sharedPreferences2, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPreferences2;
    }

    public synchronized TopicOperation getNextTopicOperation() {
        String peek;
        SharedPreferencesQueue sharedPreferencesQueue = this.topicOperationsQueue;
        synchronized (sharedPreferencesQueue.internalQueue) {
            peek = sharedPreferencesQueue.internalQueue.peek();
        }
        return TopicOperation.from(peek);
    }
}
