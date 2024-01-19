package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources {
    public static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<>();
    public static final Object sColorStateCacheLock = new Object();
    public static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);

    public static class ColorStateListCacheEntry {
        public final Configuration configuration;
        public final ColorStateList value;

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration2) {
            this.value = colorStateList;
            this.configuration = configuration2;
        }
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        synchronized (sColorStateCacheLock) {
            SparseArray sparseArray = sColorStateCaches.get(context);
            colorStateList = null;
            if (sparseArray != null && sparseArray.size() > 0) {
                ColorStateListCacheEntry colorStateListCacheEntry = (ColorStateListCacheEntry) sparseArray.get(i);
                if (colorStateListCacheEntry != null) {
                    if (colorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                        colorStateList2 = colorStateListCacheEntry.value;
                    } else {
                        sparseArray.remove(i);
                    }
                }
            }
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        Resources resources = context.getResources();
        TypedValue typedValue = TL_TYPED_VALUE.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            TL_TYPED_VALUE.set(typedValue);
        }
        boolean z = true;
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            z = false;
        }
        if (!z) {
            Resources resources2 = context.getResources();
            try {
                colorStateList = ColorStateListInflaterCompat.createFromXml(resources2, resources2.getXml(i), context.getTheme());
            } catch (Exception unused) {
            }
        }
        if (colorStateList == null) {
            return ContextCompat.getColorStateList(context, i);
        }
        synchronized (sColorStateCacheLock) {
            SparseArray sparseArray2 = sColorStateCaches.get(context);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sColorStateCaches.put(context, sparseArray2);
            }
            sparseArray2.append(i, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
        }
        return colorStateList;
    }

    public static Drawable getDrawable(Context context, int i) {
        return ResourceManagerInternal.get().getDrawable(context, i);
    }
}
