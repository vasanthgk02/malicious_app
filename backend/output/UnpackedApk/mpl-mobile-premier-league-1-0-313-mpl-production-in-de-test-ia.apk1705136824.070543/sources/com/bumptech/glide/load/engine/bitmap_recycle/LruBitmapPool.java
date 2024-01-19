package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
    public static final Config DEFAULT_CONFIG = Config.ARGB_8888;
    public final Set<Config> allowedConfigs;
    public long currentSize;
    public int evictions;
    public int hits;
    public final long initialMaxSize;
    public long maxSize;
    public int misses;
    public int puts;
    public final LruPoolStrategy strategy;
    public final BitmapTracker tracker;

    public interface BitmapTracker {
    }

    public static final class NullBitmapTracker implements BitmapTracker {
    }

    public LruBitmapPool(long j) {
        SizeConfigStrategy sizeConfigStrategy = new SizeConfigStrategy();
        HashSet hashSet = new HashSet(Arrays.asList(Config.values()));
        hashSet.add(null);
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        Set<Config> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.initialMaxSize = j;
        this.maxSize = j;
        this.strategy = sizeConfigStrategy;
        this.allowedConfigs = unmodifiableSet;
        this.tracker = new NullBitmapTracker();
    }

    public void clearMemory() {
        boolean isLoggable = Log.isLoggable("LruBitmapPool", 3);
        trimToSize(0);
    }

    public final void dump() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            dumpUnchecked();
        }
    }

    public final void dumpUnchecked() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Hits=");
        outline73.append(this.hits);
        outline73.append(", misses=");
        outline73.append(this.misses);
        outline73.append(", puts=");
        outline73.append(this.puts);
        outline73.append(", evictions=");
        outline73.append(this.evictions);
        outline73.append(", currentSize=");
        outline73.append(this.currentSize);
        outline73.append(", maxSize=");
        outline73.append(this.maxSize);
        outline73.append("\nStrategy=");
        outline73.append(this.strategy);
        outline73.toString();
    }

    public Bitmap get(int i, int i2, Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull != null) {
            dirtyOrNull.eraseColor(0);
            return dirtyOrNull;
        }
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    public Bitmap getDirty(int i, int i2, Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull != null) {
            return dirtyOrNull;
        }
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    public final synchronized Bitmap getDirtyOrNull(int i, int i2, Config config) {
        Bitmap bitmap;
        if (VERSION.SDK_INT >= 26) {
            if (config == Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
        }
        bitmap = this.strategy.get(i, i2, config != null ? config : DEFAULT_CONFIG);
        if (bitmap == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                this.strategy.logBitmap(i, i2, config);
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= (long) this.strategy.getSize(bitmap);
            if (((NullBitmapTracker) this.tracker) != null) {
                bitmap.setHasAlpha(true);
                bitmap.setPremultiplied(true);
            } else {
                throw null;
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            this.strategy.logBitmap(i, i2, config);
        }
        dump();
        return bitmap;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void put(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (!bitmap.isRecycled()) {
            if (bitmap.isMutable() && ((long) this.strategy.getSize(bitmap)) <= this.maxSize) {
                if (this.allowedConfigs.contains(bitmap.getConfig())) {
                    int size = this.strategy.getSize(bitmap);
                    this.strategy.put(bitmap);
                    if (((NullBitmapTracker) this.tracker) != null) {
                        this.puts++;
                        this.currentSize += (long) size;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            this.strategy.logBitmap(bitmap);
                        }
                        dump();
                        trimToSize(this.maxSize);
                        return;
                    }
                    throw null;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.strategy.logBitmap(bitmap);
                bitmap.isMutable();
                this.allowedConfigs.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } else {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
    }

    public synchronized void setSizeMultiplier(float f2) {
        long round = (long) Math.round(((float) this.initialMaxSize) * f2);
        this.maxSize = round;
        trimToSize(round);
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        boolean isLoggable = Log.isLoggable("LruBitmapPool", 3);
        if (i >= 40 || (VERSION.SDK_INT >= 23 && i >= 20)) {
            Log.isLoggable("LruBitmapPool", 3);
            trimToSize(0);
        } else if (i >= 20 || i == 15) {
            trimToSize(this.maxSize / 2);
        }
    }

    public final synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    dumpUnchecked();
                }
                this.currentSize = 0;
                return;
            } else if (((NullBitmapTracker) this.tracker) != null) {
                this.currentSize -= (long) this.strategy.getSize(removeLast);
                this.evictions++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    this.strategy.logBitmap(removeLast);
                }
                dump();
                removeLast.recycle();
            } else {
                throw null;
            }
        }
    }
}
