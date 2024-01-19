package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SizeConfigStrategy implements LruPoolStrategy {
    public static final Config[] ALPHA_8_IN_CONFIGS = {Config.ALPHA_8};
    public static final Config[] ARGB_4444_IN_CONFIGS = {Config.ARGB_4444};
    public static final Config[] ARGB_8888_IN_CONFIGS;
    public static final Config[] RGBA_F16_IN_CONFIGS;
    public static final Config[] RGB_565_IN_CONFIGS = {Config.RGB_565};
    public final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    public final KeyPool keyPool = new KeyPool();
    public final Map<Config, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$graphics$Bitmap$Config = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$Config     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$Config     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$Config     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Key implements Poolable {
        public Config config;
        public final KeyPool pool;
        public int size;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.size != key.size || !Util.bothNullOrEqual(this.config, key.config)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.size * 31;
            Config config2 = this.config;
            return i + (config2 != null ? config2.hashCode() : 0);
        }

        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.size, this.config);
        }
    }

    public static class KeyPool extends BaseKeyPool<Key> {
        public Poolable create() {
            return new Key(this);
        }

        public Key get(int i, Config config) {
            Key key = (Key) get();
            key.size = i;
            key.config = config;
            return key;
        }
    }

    static {
        Config[] configArr = {Config.ARGB_8888, null};
        if (VERSION.SDK_INT >= 26) {
            configArr = (Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Config.RGBA_F16;
        }
        ARGB_8888_IN_CONFIGS = configArr;
        RGBA_F16_IN_CONFIGS = configArr;
    }

    public static String getBitmapString(int i, Config config) {
        return "[" + i + "](" + config + ")";
    }

    public final void decrementBitmapOfSize(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num2 = (Integer) sizesForConfig.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            sizesForConfig.remove(num);
        } else {
            sizesForConfig.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public Bitmap get(int i, int i2, Config config) {
        Config[] configArr;
        int bitmapByteSize = Util.getBitmapByteSize(i, i2, config);
        Key key = (Key) this.keyPool.get();
        key.size = bitmapByteSize;
        key.config = config;
        int i3 = 0;
        if (VERSION.SDK_INT < 26 || !Config.RGBA_F16.equals(config)) {
            int i4 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
            if (i4 == 1) {
                configArr = ARGB_8888_IN_CONFIGS;
            } else if (i4 == 2) {
                configArr = RGB_565_IN_CONFIGS;
            } else if (i4 != 3) {
                configArr = i4 != 4 ? new Config[]{config} : ALPHA_8_IN_CONFIGS;
            } else {
                configArr = ARGB_4444_IN_CONFIGS;
            }
        } else {
            configArr = RGBA_F16_IN_CONFIGS;
        }
        int length = configArr.length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Config config2 = configArr[i3];
            Integer ceilingKey = getSizesForConfig(config2).ceilingKey(Integer.valueOf(bitmapByteSize));
            if (ceilingKey == null || ceilingKey.intValue() > bitmapByteSize * 8) {
                i3++;
            } else if (ceilingKey.intValue() != bitmapByteSize || (config2 != null ? !config2.equals(config) : config != null)) {
                this.keyPool.offer(key);
                key = this.keyPool.get(ceilingKey.intValue(), config2);
            }
        }
        Bitmap bitmap = (Bitmap) this.groupedMap.get(key);
        if (bitmap != null) {
            decrementBitmapOfSize(Integer.valueOf(key.size), bitmap);
            bitmap.reconfigure(i, i2, config);
        }
        return bitmap;
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    public final NavigableMap<Integer, Integer> getSizesForConfig(Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(config, treeMap);
        return treeMap;
    }

    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.groupedMap.put(key, bitmap);
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num = (Integer) sizesForConfig.get(Integer.valueOf(key.size));
        Integer valueOf = Integer.valueOf(key.size);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        sizesForConfig.put(valueOf, Integer.valueOf(i));
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.groupedMap.removeLast();
        if (bitmap != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SizeConfigStrategy{groupedMap=");
        outline73.append(this.groupedMap);
        outline73.append(", sortedSizes=(");
        for (Entry next : this.sortedSizes.entrySet()) {
            outline73.append(next.getKey());
            outline73.append('[');
            outline73.append(next.getValue());
            outline73.append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            outline73.replace(outline73.length() - 2, outline73.length(), "");
        }
        outline73.append(")}");
        return outline73.toString();
    }

    public String logBitmap(int i, int i2, Config config) {
        return getBitmapString(Util.getBitmapByteSize(i, i2, config), config);
    }
}
