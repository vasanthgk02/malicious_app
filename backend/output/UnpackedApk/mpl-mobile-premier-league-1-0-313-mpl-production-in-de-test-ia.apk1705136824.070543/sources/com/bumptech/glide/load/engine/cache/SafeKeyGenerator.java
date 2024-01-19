package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools$Pool;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bumptech.glide.util.pool.StateVerifier.DefaultStateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeKeyGenerator {
    public final Pools$Pool<PoolableDigestContainer> digestPool = FactoryPools.threadSafe(10, new Factory<PoolableDigestContainer>(this) {
        public Object create() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    });
    public final LruCache<Key, String> loadIdToSafeHash = new LruCache<>(1000);

    public static final class PoolableDigestContainer implements Poolable {
        public final MessageDigest messageDigest;
        public final StateVerifier stateVerifier = new DefaultStateVerifier();

        public PoolableDigestContainer(MessageDigest messageDigest2) {
            this.messageDigest = messageDigest2;
        }

        public StateVerifier getVerifier() {
            return this.stateVerifier;
        }
    }

    public String getSafeKey(Key key) {
        String str;
        synchronized (this.loadIdToSafeHash) {
            try {
                str = (String) this.loadIdToSafeHash.get(key);
            }
        }
        if (str == null) {
            Object acquire = this.digestPool.acquire();
            k.checkNotNull(acquire, (String) "Argument must not be null");
            PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) acquire;
            try {
                key.updateDiskCacheKey(poolableDigestContainer.messageDigest);
                str = Util.sha256BytesToHex(poolableDigestContainer.messageDigest.digest());
            } finally {
                this.digestPool.release(poolableDigestContainer);
            }
        }
        synchronized (this.loadIdToSafeHash) {
            try {
                this.loadIdToSafeHash.put(key, str);
            }
        }
        return str;
    }
}
