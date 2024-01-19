package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStore;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStoreImpl;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStoreStrategy;
import com.twitter.sdk.android.core.internal.persistence.SerializationStrategy;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class PersistedSessionManager<T extends Session> implements SessionManager<T> {
    public final AtomicReference<T> activeSessionRef;
    public final PreferenceStoreStrategy<T> activeSessionStorage;
    public final String prefKeySession;
    public final PreferenceStore preferenceStore;
    public volatile boolean restorePending;
    public final SerializationStrategy<T> serializer;
    public final ConcurrentHashMap<Long, T> sessionMap;
    public final ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> storageMap;

    public void clearSession(long j) {
        restoreAllSessionsIfNecessary();
        if (this.activeSessionRef.get() != null && ((Session) this.activeSessionRef.get()).id == j) {
            synchronized (this) {
                this.activeSessionRef.set(null);
                PreferenceStoreStrategy<T> preferenceStoreStrategy = this.activeSessionStorage;
                ((PreferenceStoreImpl) preferenceStoreStrategy.store).sharedPreferences.edit().remove(preferenceStoreStrategy.key).commit();
            }
        }
        this.sessionMap.remove(Long.valueOf(j));
        PreferenceStoreStrategy remove = this.storageMap.remove(Long.valueOf(j));
        if (remove != null) {
            ((PreferenceStoreImpl) remove.store).sharedPreferences.edit().remove(remove.key).commit();
        }
    }

    public T getActiveSession() {
        restoreAllSessionsIfNecessary();
        return (Session) this.activeSessionRef.get();
    }

    public final void internalSetSession(long j, T t, boolean z) {
        this.sessionMap.put(Long.valueOf(j), t);
        PreferenceStoreStrategy preferenceStoreStrategy = this.storageMap.get(Long.valueOf(j));
        if (preferenceStoreStrategy == null) {
            PreferenceStore preferenceStore2 = this.preferenceStore;
            SerializationStrategy<T> serializationStrategy = this.serializer;
            preferenceStoreStrategy = new PreferenceStoreStrategy(preferenceStore2, serializationStrategy, this.prefKeySession + "_" + j);
            this.storageMap.putIfAbsent(Long.valueOf(j), preferenceStoreStrategy);
        }
        preferenceStoreStrategy.save(t);
        Session session = (Session) this.activeSessionRef.get();
        if (session == null || session.id == j || z) {
            synchronized (this) {
                this.activeSessionRef.compareAndSet(session, t);
                this.activeSessionStorage.save(t);
            }
        }
    }

    public void restoreAllSessionsIfNecessary() {
        if (this.restorePending) {
            synchronized (this) {
                if (this.restorePending) {
                    PreferenceStoreStrategy<T> preferenceStoreStrategy = this.activeSessionStorage;
                    Session session = (Session) preferenceStoreStrategy.serializer.deserialize(((PreferenceStoreImpl) preferenceStoreStrategy.store).sharedPreferences.getString(preferenceStoreStrategy.key, null));
                    if (session != null) {
                        internalSetSession(session.id, session, false);
                    }
                    restoreSessions();
                    this.restorePending = false;
                }
            }
        }
    }

    public final void restoreSessions() {
        for (Entry next : ((PreferenceStoreImpl) this.preferenceStore).sharedPreferences.getAll().entrySet()) {
            if (((String) next.getKey()).startsWith(this.prefKeySession)) {
                Session session = (Session) this.serializer.deserialize((String) next.getValue());
                if (session != null) {
                    internalSetSession(session.id, session, false);
                }
            }
        }
    }
}
