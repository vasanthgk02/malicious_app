package androidx.appcompat.widget;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class ResourceManagerInternal {
    public static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    public static final Mode DEFAULT_MODE = Mode.SRC_IN;
    public static ResourceManagerInternal INSTANCE;
    public SimpleArrayMap<String, InflateDelegate> mDelegates;
    public final WeakHashMap<Context, LongSparseArray<WeakReference<ConstantState>>> mDrawableCaches = new WeakHashMap<>(0);
    public boolean mHasCheckedVectorDrawableSetup;
    public ResourceManagerHooks mHooks;
    public SparseArrayCompat<String> mKnownDrawableIdTags;
    public WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    public TypedValue mTypedValue;

    public static class AsldcInflateDelegate implements InflateDelegate {
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class AvdcInflateDelegate implements InflateDelegate {
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                Resources resources = context.getResources();
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context, null, null);
                animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
                return animatedVectorDrawableCompat;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }
    }

    public static class DrawableDelegate implements InflateDelegate {
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    public interface InflateDelegate {
        Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    public interface ResourceManagerHooks {
    }

    public static class VdcInflateDelegate implements InflateDelegate {
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            try {
                if (INSTANCE == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    INSTANCE = resourceManagerInternal2;
                    installDefaultInflateDelegates(resourceManagerInternal2);
                }
                resourceManagerInternal = INSTANCE;
            }
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
            if (colorFilterLruCache != null) {
                int i2 = (i + 31) * 31;
                porterDuffColorFilter = (PorterDuffColorFilter) colorFilterLruCache.get(Integer.valueOf(mode.hashCode() + i2));
                if (porterDuffColorFilter == null) {
                    porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                    ColorFilterLruCache colorFilterLruCache2 = COLOR_FILTER_CACHE;
                    if (colorFilterLruCache2 != null) {
                        PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) colorFilterLruCache2.put(Integer.valueOf(mode.hashCode() + i2), porterDuffColorFilter);
                    } else {
                        throw null;
                    }
                }
            } else {
                throw null;
            }
        }
        return porterDuffColorFilter;
    }

    public static void installDefaultInflateDelegates(ResourceManagerInternal resourceManagerInternal) {
        if (VERSION.SDK_INT < 24) {
            resourceManagerInternal.addDelegate("vector", new VdcInflateDelegate());
            resourceManagerInternal.addDelegate("animated-vector", new AvdcInflateDelegate());
            resourceManagerInternal.addDelegate("animated-selector", new AsldcInflateDelegate());
            resourceManagerInternal.addDelegate("drawable", new DrawableDelegate());
        }
    }

    public final void addDelegate(String str, InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new SimpleArrayMap<>();
        }
        this.mDelegates.put(str, inflateDelegate);
    }

    public final synchronized boolean addDrawableToCache(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray(10);
            this.mDrawableCaches.put(context, longSparseArray);
        }
        longSparseArray.put(j, new WeakReference(constantState));
        return true;
    }

    public final Drawable createDrawableIfNeeded(Context context, int i) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable cachedDrawable = getCachedDrawable(context, j);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        LayerDrawable layerDrawable = null;
        if (resourceManagerHooks != null) {
            AnonymousClass1 r1 = (AnonymousClass1) resourceManagerHooks;
            if (i == R$drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{getDrawable(context, R$drawable.abc_cab_background_internal_bg), getDrawable(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i == R$drawable.abc_ratingbar_material) {
                layerDrawable = r1.getRatingBarLayerDrawable(this, context, R$dimen.abc_star_big);
            } else if (i == R$drawable.abc_ratingbar_indicator_material) {
                layerDrawable = r1.getRatingBarLayerDrawable(this, context, R$dimen.abc_star_medium);
            } else if (i == R$drawable.abc_ratingbar_small_material) {
                layerDrawable = r1.getRatingBarLayerDrawable(this, context, R$dimen.abc_star_small);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, j, layerDrawable);
        }
        return layerDrawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable getCachedDrawable(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.mDrawableCaches     // Catch:{ all -> 0x0041 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0041 }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x0041 }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.get(r5, r1)     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x003f
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0041 }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0041 }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x0041 }
            monitor-exit(r3)
            return r4
        L_0x0028:
            long[] r4 = r0.mKeys     // Catch:{ all -> 0x0041 }
            int r2 = r0.mSize     // Catch:{ all -> 0x0041 }
            int r4 = androidx.collection.ContainerHelpers.binarySearch(r4, r2, r5)     // Catch:{ all -> 0x0041 }
            if (r4 < 0) goto L_0x003f
            java.lang.Object[] r5 = r0.mValues     // Catch:{ all -> 0x0041 }
            r6 = r5[r4]     // Catch:{ all -> 0x0041 }
            java.lang.Object r2 = androidx.collection.LongSparseArray.DELETED     // Catch:{ all -> 0x0041 }
            if (r6 == r2) goto L_0x003f
            r5[r4] = r2     // Catch:{ all -> 0x0041 }
            r4 = 1
            r0.mGarbage = r4     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r3)
            return r1
        L_0x0041:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.getCachedDrawable(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public synchronized Drawable getDrawable(Context context, int i) {
        try {
        }
        return getDrawable(context, i, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.content.res.ColorStateList getTintList(android.content.Context r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.SparseArrayCompat<android.content.res.ColorStateList>> r0 = r3.mTintLists     // Catch:{ all -> 0x004b }
            r1 = 0
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x004b }
            androidx.collection.SparseArrayCompat r0 = (androidx.collection.SparseArrayCompat) r0     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.get(r5, r1)     // Catch:{ all -> 0x004b }
            android.content.res.ColorStateList r0 = (android.content.res.ColorStateList) r0     // Catch:{ all -> 0x004b }
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 != 0) goto L_0x004d
            androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks r0 = r3.mHooks     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x001d
            goto L_0x0025
        L_0x001d:
            androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks r0 = r3.mHooks     // Catch:{ all -> 0x004b }
            androidx.appcompat.widget.AppCompatDrawableManager$1 r0 = (androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1) r0
            android.content.res.ColorStateList r1 = r0.getTintListForDrawableRes(r4, r5)     // Catch:{ all -> 0x004b }
        L_0x0025:
            if (r1 == 0) goto L_0x0049
            java.util.WeakHashMap<android.content.Context, androidx.collection.SparseArrayCompat<android.content.res.ColorStateList>> r0 = r3.mTintLists     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0032
            java.util.WeakHashMap r0 = new java.util.WeakHashMap     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            r3.mTintLists = r0     // Catch:{ all -> 0x004b }
        L_0x0032:
            java.util.WeakHashMap<android.content.Context, androidx.collection.SparseArrayCompat<android.content.res.ColorStateList>> r0 = r3.mTintLists     // Catch:{ all -> 0x004b }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x004b }
            androidx.collection.SparseArrayCompat r0 = (androidx.collection.SparseArrayCompat) r0     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0046
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            java.util.WeakHashMap<android.content.Context, androidx.collection.SparseArrayCompat<android.content.res.ColorStateList>> r2 = r3.mTintLists     // Catch:{ all -> 0x004b }
            r2.put(r4, r0)     // Catch:{ all -> 0x004b }
        L_0x0046:
            r0.append(r5, r1)     // Catch:{ all -> 0x004b }
        L_0x0049:
            r0 = r1
            goto L_0x004d
        L_0x004b:
            r4 = move-exception
            goto L_0x004f
        L_0x004d:
            monitor-exit(r3)
            return r0
        L_0x004f:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.getTintList(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A[Catch:{ Exception -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1 A[Catch:{ Exception -> 0x009f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable loadDrawableFromDelegates(android.content.Context r11, int r12) {
        /*
            r10 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r0 = r10.mDelegates
            r1 = 0
            if (r0 == 0) goto L_0x00b1
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b1
            androidx.collection.SparseArrayCompat<java.lang.String> r0 = r10.mKnownDrawableIdTags
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.get(r12, r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r3 = r10.mDelegates
            java.lang.Object r0 = r3.getOrDefault(r0, r1)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.mKnownDrawableIdTags = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.mTypedValue
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.mTypedValue = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.mTypedValue
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            int r4 = r0.assetCookie
            long r4 = (long) r4
            r6 = 32
            long r4 = r4 << r6
            int r6 = r0.data
            long r6 = (long) r6
            long r4 = r4 | r6
            android.graphics.drawable.Drawable r6 = r10.getCachedDrawable(r11, r4)
            if (r6 == 0) goto L_0x0055
            return r6
        L_0x0055:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00a9
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00a9
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x009f }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x009f }
        L_0x006d:
            int r8 = r1.next()     // Catch:{ Exception -> 0x009f }
            r9 = 2
            if (r8 == r9) goto L_0x0077
            if (r8 == r3) goto L_0x0077
            goto L_0x006d
        L_0x0077:
            if (r8 != r9) goto L_0x00a1
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x009f }
            androidx.collection.SparseArrayCompat<java.lang.String> r8 = r10.mKnownDrawableIdTags     // Catch:{ Exception -> 0x009f }
            r8.append(r12, r3)     // Catch:{ Exception -> 0x009f }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r8 = r10.mDelegates     // Catch:{ Exception -> 0x009f }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x009f }
            androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate r3 = (androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate) r3     // Catch:{ Exception -> 0x009f }
            if (r3 == 0) goto L_0x0094
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x009f }
            android.graphics.drawable.Drawable r6 = r3.createFromXmlInner(r11, r1, r7, r8)     // Catch:{ Exception -> 0x009f }
        L_0x0094:
            if (r6 == 0) goto L_0x00a9
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x009f }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x009f }
            r10.addDrawableToCache(r11, r4, r6)     // Catch:{ Exception -> 0x009f }
            goto L_0x00a9
        L_0x009f:
            goto L_0x00a9
        L_0x00a1:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x009f }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x009f }
            throw r11     // Catch:{ Exception -> 0x009f }
        L_0x00a9:
            if (r6 != 0) goto L_0x00b0
            androidx.collection.SparseArrayCompat<java.lang.String> r11 = r10.mKnownDrawableIdTags
            r11.append(r12, r2)
        L_0x00b0:
            return r6
        L_0x00b1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.loadDrawableFromDelegates(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    public final Drawable tintDrawable(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList tintList = getTintList(context, i);
        Mode mode = null;
        if (tintList != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable wrap = b.wrap(drawable);
            wrap.setTintList(tintList);
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if (resourceManagerHooks != null) {
                AnonymousClass1 r10 = (AnonymousClass1) resourceManagerHooks;
                if (i == R$drawable.abc_switch_thumb_material) {
                    mode = Mode.MULTIPLY;
                }
            }
            if (mode == null) {
                return wrap;
            }
            wrap.setTintMode(mode);
            return wrap;
        }
        ResourceManagerHooks resourceManagerHooks2 = this.mHooks;
        if (resourceManagerHooks2 != null) {
            AnonymousClass1 r0 = (AnonymousClass1) resourceManagerHooks2;
            if (r0 != null) {
                boolean z2 = true;
                if (i == R$drawable.abc_seekbar_track_material) {
                    LayerDrawable layerDrawable = (LayerDrawable) drawable;
                    r0.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                    r0.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                    r0.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                } else if (i == R$drawable.abc_ratingbar_material || i == R$drawable.abc_ratingbar_indicator_material || i == R$drawable.abc_ratingbar_small_material) {
                    LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                    r0.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                    r0.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                    r0.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                } else {
                    z2 = false;
                }
                if (z2) {
                    return drawable;
                }
            } else {
                throw null;
            }
        }
        if (tintDrawableUsingColorFilter(context, i, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean tintDrawableUsingColorFilter(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
        /*
            r7 = this;
            androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks r0 = r7.mHooks
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x006f
            androidx.appcompat.widget.AppCompatDrawableManager$1 r0 = (androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1) r0
            if (r0 == 0) goto L_0x006d
            android.graphics.PorterDuff$Mode r3 = androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE
            int[] r4 = r0.COLORFILTER_TINT_COLOR_CONTROL_NORMAL
            boolean r4 = r0.arrayContains(r4, r9)
            r5 = 16842801(0x1010031, float:2.3693695E-38)
            r6 = -1
            if (r4 == 0) goto L_0x001b
            int r5 = androidx.appcompat.R$attr.colorControlNormal
            goto L_0x0044
        L_0x001b:
            int[] r4 = r0.COLORFILTER_COLOR_CONTROL_ACTIVATED
            boolean r4 = r0.arrayContains(r4, r9)
            if (r4 == 0) goto L_0x0026
            int r5 = androidx.appcompat.R$attr.colorControlActivated
            goto L_0x0044
        L_0x0026:
            int[] r4 = r0.COLORFILTER_COLOR_BACKGROUND_MULTIPLY
            boolean r0 = r0.arrayContains(r4, r9)
            if (r0 == 0) goto L_0x0031
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x0044
        L_0x0031:
            int r0 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
            if (r9 != r0) goto L_0x0040
            r9 = 16842800(0x1010030, float:2.3693693E-38)
            r0 = 1109603123(0x42233333, float:40.8)
            int r0 = java.lang.Math.round(r0)
            goto L_0x0046
        L_0x0040:
            int r0 = androidx.appcompat.R$drawable.abc_dialog_material_background
            if (r9 != r0) goto L_0x0048
        L_0x0044:
            r9 = r5
            r0 = -1
        L_0x0046:
            r4 = 1
            goto L_0x004b
        L_0x0048:
            r9 = 0
            r0 = -1
            r4 = 0
        L_0x004b:
            if (r4 == 0) goto L_0x0069
            boolean r4 = androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r10)
            if (r4 == 0) goto L_0x0057
            android.graphics.drawable.Drawable r10 = r10.mutate()
        L_0x0057:
            int r8 = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(r8, r9)
            android.graphics.PorterDuffColorFilter r8 = androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(r8, r3)
            r10.setColorFilter(r8)
            if (r0 == r6) goto L_0x0067
            r10.setAlpha(r0)
        L_0x0067:
            r8 = 1
            goto L_0x006a
        L_0x0069:
            r8 = 0
        L_0x006a:
            if (r8 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006d:
            r8 = 0
            throw r8
        L_0x006f:
            r1 = 0
        L_0x0070:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.tintDrawableUsingColorFilter(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r0 != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.drawable.Drawable getDrawable(android.content.Context r5, int r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.mHasCheckedVectorDrawableSetup     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0006
            goto L_0x002a
        L_0x0006:
            r0 = 1
            r4.mHasCheckedVectorDrawableSetup = r0     // Catch:{ all -> 0x0047 }
            int r1 = androidx.appcompat.resources.R$drawable.abc_vector_test     // Catch:{ all -> 0x0047 }
            android.graphics.drawable.Drawable r1 = r4.getDrawable(r5, r1)     // Catch:{ all -> 0x0047 }
            r2 = 0
            if (r1 == 0) goto L_0x0049
            boolean r3 = r1 instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat     // Catch:{ all -> 0x0047 }
            if (r3 != 0) goto L_0x0028
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = "android.graphics.drawable.VectorDrawable"
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0049
        L_0x002a:
            android.graphics.drawable.Drawable r0 = r4.loadDrawableFromDelegates(r5, r6)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0034
            android.graphics.drawable.Drawable r0 = r4.createDrawableIfNeeded(r5, r6)     // Catch:{ all -> 0x0047 }
        L_0x0034:
            if (r0 != 0) goto L_0x003a
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r5, r6)     // Catch:{ all -> 0x0047 }
        L_0x003a:
            if (r0 == 0) goto L_0x0040
            android.graphics.drawable.Drawable r0 = r4.tintDrawable(r5, r6, r7, r0)     // Catch:{ all -> 0x0047 }
        L_0x0040:
            if (r0 == 0) goto L_0x0045
            androidx.appcompat.widget.DrawableUtils.fixDrawable(r0)     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r4)
            return r0
        L_0x0047:
            r5 = move-exception
            goto L_0x0053
        L_0x0049:
            r4.mHasCheckedVectorDrawableSetup = r2     // Catch:{ all -> 0x0047 }
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0047 }
            java.lang.String r6 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r5.<init>(r6)     // Catch:{ all -> 0x0047 }
            throw r5     // Catch:{ all -> 0x0047 }
        L_0x0053:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.getDrawable(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (!DrawableUtils.canSafelyMutateDrawable(drawable) || drawable.mutate() == drawable) {
            if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                ColorStateList colorStateList = tintInfo.mHasTintList ? tintInfo.mTintList : null;
                Mode mode = tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE;
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }
}
