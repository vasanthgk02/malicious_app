package androidx.core.content.res;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.graphics.TypefaceCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
    public static final Object sColorStateCacheLock = new Object();
    public static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    public static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    public static class ColorStateListCacheEntry {
        public final Configuration mConfiguration;
        public final ColorStateList mValue;

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration) {
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
        }
    }

    public static final class ColorStateListCacheKey {
        public final Resources mResources;
        public final Theme mTheme;

        public ColorStateListCacheKey(Resources resources, Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            if (!this.mResources.equals(colorStateListCacheKey.mResources) || !Objects.equals(this.mTheme, colorStateListCacheKey.mTheme)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mResources, this.mTheme});
        }
    }

    public static abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(final int i, Handler handler) {
            getHandler(handler).post(new Runnable() {
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            getHandler(handler).post(new Runnable() {
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    public static Typeface getCachedFont(Context context, int i) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, null, false, true);
    }

    public static int getColor(Resources resources, int i, Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 23) {
            return resources.getColor(i, theme);
        }
        return resources.getColor(i);
    }

    public static ColorStateList getColorStateList(Resources resources, int i, Theme theme) throws NotFoundException {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        if (VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i, theme);
        }
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        synchronized (sColorStateCacheLock) {
            try {
                SparseArray sparseArray = sColorStateCaches.get(colorStateListCacheKey);
                colorStateList = null;
                if (sparseArray != null && sparseArray.size() > 0) {
                    ColorStateListCacheEntry colorStateListCacheEntry = (ColorStateListCacheEntry) sparseArray.get(i);
                    if (colorStateListCacheEntry != null) {
                        if (colorStateListCacheEntry.mConfiguration.equals(colorStateListCacheKey.mResources.getConfiguration())) {
                            colorStateList2 = colorStateListCacheEntry.mValue;
                        } else {
                            sparseArray.remove(i);
                        }
                    }
                }
                colorStateList2 = null;
            }
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        TypedValue typedValue = sTempTypedValue.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            sTempTypedValue.set(typedValue);
        }
        boolean z = true;
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            z = false;
        }
        if (!z) {
            try {
                colorStateList = ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), theme);
            } catch (Exception unused) {
            }
        }
        if (colorStateList == null) {
            return resources.getColorStateList(i);
        }
        synchronized (sColorStateCacheLock) {
            try {
                SparseArray sparseArray2 = sColorStateCaches.get(colorStateListCacheKey);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    sColorStateCaches.put(colorStateListCacheKey, sparseArray2);
                }
                sparseArray2.append(i, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration()));
            }
        }
        return colorStateList;
    }

    public static Drawable getDrawable(Resources resources, int i, Theme theme) throws NotFoundException {
        return resources.getDrawable(i, theme);
    }

    public static Typeface getFont(Context context, int i) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface loadFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, Handler handler, boolean z, boolean z2) {
        int i3 = i;
        int i4 = i2;
        FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            if (charSequence2.startsWith("res/")) {
                Typeface typeface2 = (Typeface) TypefaceCompat.sTypefaceCache.get(TypefaceCompat.createResourceUid(resources, i, i4));
                if (typeface2 != null) {
                    if (fontCallback2 != null) {
                        fontCallback2.callbackSuccessAsync(typeface2, handler2);
                    }
                    typeface = typeface2;
                } else if (!z2) {
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            FontResourcesParserCompat$FamilyResourceEntry parse = b.parse(resources.getXml(i), resources);
                            if (parse != null) {
                                typeface = TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, i2, fontCallback, handler, z);
                            } else if (fontCallback2 != null) {
                                fontCallback2.callbackFailAsync(-3, handler2);
                            }
                        } else {
                            Context context2 = context;
                            Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i, charSequence2, i4);
                            if (fontCallback2 != null) {
                                if (createFromResourcesFontFile != null) {
                                    fontCallback2.callbackSuccessAsync(createFromResourcesFontFile, handler2);
                                } else {
                                    fontCallback2.callbackFailAsync(-3, handler2);
                                }
                            }
                            typeface = createFromResourcesFontFile;
                        }
                    } catch (IOException | XmlPullParserException unused) {
                        if (fontCallback2 != null) {
                            fontCallback2.callbackFailAsync(-3, handler2);
                        }
                    }
                }
            } else if (fontCallback2 != null) {
                fontCallback2.callbackFailAsync(-3, handler2);
            }
            if (typeface != null || fontCallback2 != null || z2) {
                return typeface;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Font resource ID #0x");
            outline73.append(Integer.toHexString(i));
            outline73.append(" could not be retrieved.");
            throw new NotFoundException(outline73.toString());
        }
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Resource \"");
        outline732.append(resources.getResourceName(i));
        outline732.append("\" (");
        outline732.append(Integer.toHexString(i));
        outline732.append(") is not a Font: ");
        outline732.append(typedValue);
        throw new NotFoundException(outline732.toString());
    }

    public static void getFont(Context context, int i, FontCallback fontCallback, Handler handler) throws NotFoundException {
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, null);
            return;
        }
        loadFont(context, i, new TypedValue(), 0, fontCallback, null, false, false);
    }

    public static Typeface getFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, fontCallback, null, true, false);
    }
}
