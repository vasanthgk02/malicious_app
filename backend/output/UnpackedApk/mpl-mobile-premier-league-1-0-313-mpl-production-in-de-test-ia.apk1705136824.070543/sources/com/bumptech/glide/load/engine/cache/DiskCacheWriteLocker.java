package com.bumptech.glide.load.engine.cache;

import co.hyperverge.hypersnapsdk.c.k;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class DiskCacheWriteLocker {
    public final Map<String, WriteLock> locks = new HashMap();
    public final WriteLockPool writeLockPool = new WriteLockPool();

    public static class WriteLock {
        public int interestedThreads;
        public final Lock lock = new ReentrantLock();
    }

    public static class WriteLockPool {
        public final Queue<WriteLock> pool = new ArrayDeque();
    }

    public void release(String str) {
        WriteLock writeLock;
        synchronized (this) {
            WriteLock writeLock2 = this.locks.get(str);
            k.checkNotNull(writeLock2, (String) "Argument must not be null");
            writeLock = writeLock2;
            if (writeLock.interestedThreads >= 1) {
                int i = writeLock.interestedThreads - 1;
                writeLock.interestedThreads = i;
                if (i == 0) {
                    WriteLock remove = this.locks.remove(str);
                    if (remove.equals(writeLock)) {
                        WriteLockPool writeLockPool2 = this.writeLockPool;
                        synchronized (writeLockPool2.pool) {
                            if (writeLockPool2.pool.size() < 10) {
                                writeLockPool2.pool.offer(remove);
                            }
                        }
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.interestedThreads);
            }
        }
        writeLock.lock.unlock();
    }
}
