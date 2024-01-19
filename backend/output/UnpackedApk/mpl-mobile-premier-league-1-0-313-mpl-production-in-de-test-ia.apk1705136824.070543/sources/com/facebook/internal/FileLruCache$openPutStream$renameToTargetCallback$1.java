package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.internal.FileLruCache.StreamCloseCallback;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/facebook/internal/FileLruCache$openPutStream$renameToTargetCallback$1", "Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "onClose", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FileLruCache.kt */
public final class FileLruCache$openPutStream$renameToTargetCallback$1 implements StreamCloseCallback {
    public final /* synthetic */ File $buffer;
    public final /* synthetic */ long $bufferFileCreateTime;
    public final /* synthetic */ String $key;
    public final /* synthetic */ FileLruCache this$0;

    public FileLruCache$openPutStream$renameToTargetCallback$1(long j, FileLruCache fileLruCache, File file, String str) {
        this.$bufferFileCreateTime = j;
        this.this$0 = fileLruCache;
        this.$buffer = file;
        this.$key = str;
    }

    public void onClose() {
        if (this.$bufferFileCreateTime < this.this$0.lastClearCacheTime.get()) {
            this.$buffer.delete();
            return;
        }
        FileLruCache fileLruCache = this.this$0;
        String str = this.$key;
        File file = this.$buffer;
        if (fileLruCache != null) {
            if (!file.renameTo(new File(fileLruCache.directory, Utility.md5hash(str)))) {
                file.delete();
            }
            ReentrantLock reentrantLock = fileLruCache.lock;
            reentrantLock.lock();
            try {
                if (!fileLruCache.isTrimPending) {
                    fileLruCache.isTrimPending = true;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        public final void run() {
                            FileLruCache.m199postTrim$lambda3$lambda2(FileLruCache.this);
                        }
                    });
                }
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw null;
        }
    }
}
