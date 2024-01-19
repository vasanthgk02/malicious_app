package com.twitter.sdk.android.core.internal.persistence;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;

public class PreferenceStoreStrategy<T> {
    public final String key;
    public final SerializationStrategy<T> serializer;
    public final PreferenceStore store;

    public PreferenceStoreStrategy(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, String str) {
        this.store = preferenceStore;
        this.serializer = serializationStrategy;
        this.key = str;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void save(T t) {
        PreferenceStoreImpl preferenceStoreImpl = (PreferenceStoreImpl) this.store;
        Editor putString = preferenceStoreImpl.sharedPreferences.edit().putString(this.key, this.serializer.serialize(t));
        if (preferenceStoreImpl != null) {
            putString.apply();
            return;
        }
        throw null;
    }
}
