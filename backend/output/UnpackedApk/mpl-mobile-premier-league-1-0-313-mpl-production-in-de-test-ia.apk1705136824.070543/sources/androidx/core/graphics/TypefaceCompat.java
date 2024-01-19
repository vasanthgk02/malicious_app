package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import androidx.collection.LruCache;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.provider.FontsContractCompat$FontRequestCallback;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;

@SuppressLint({"NewApi"})
public class TypefaceCompat {
    public static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    public static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    public static class ResourcesCallbackAdapter extends FontsContractCompat$FontRequestCallback {
        public FontCallback mFontCallback;

        public ResourcesCallbackAdapter(FontCallback fontCallback) {
            this.mFontCallback = fontCallback;
        }

        public void onTypefaceRequestFailed(int i) {
            FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.onFontRetrievalFailed(i);
            }
        }

        public void onTypefaceRetrieved(Typeface typeface) {
            FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (i >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else {
            if (i >= 24) {
                if (TypefaceCompatApi24Impl.sAddFontWeightStyle != null) {
                    sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
                }
            }
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        }
    }

    public static Typeface create(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (r0.equals(r3) == false) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface createFromResourcesFamilyXml(android.content.Context r4, androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r5, android.content.res.Resources r6, int r7, int r8, androidx.core.content.res.ResourcesCompat.FontCallback r9, android.os.Handler r10, boolean r11) {
        /*
            boolean r0 = r5 instanceof androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry
            if (r0 == 0) goto L_0x005b
            androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry r5 = (androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry) r5
            java.lang.String r0 = r5.mSystemFontFamilyName
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0026
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0013
            goto L_0x0026
        L_0x0013:
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r2)
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r2)
            if (r0 == 0) goto L_0x0026
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r0 = r1
        L_0x0027:
            if (r0 == 0) goto L_0x002f
            if (r9 == 0) goto L_0x002e
            r9.callbackSuccessAsync(r0, r10)
        L_0x002e:
            return r0
        L_0x002f:
            if (r11 == 0) goto L_0x0036
            int r0 = r5.mStrategy
            if (r0 != 0) goto L_0x0039
            goto L_0x0038
        L_0x0036:
            if (r9 != 0) goto L_0x0039
        L_0x0038:
            r2 = 1
        L_0x0039:
            if (r11 == 0) goto L_0x003e
            int r11 = r5.mTimeoutMs
            goto L_0x003f
        L_0x003e:
            r11 = -1
        L_0x003f:
            android.os.Handler r10 = androidx.core.content.res.ResourcesCompat.FontCallback.getHandler(r10)
            androidx.core.graphics.TypefaceCompat$ResourcesCallbackAdapter r0 = new androidx.core.graphics.TypefaceCompat$ResourcesCallbackAdapter
            r0.<init>(r9)
            androidx.core.provider.FontRequest r5 = r5.mRequest
            androidx.core.provider.CallbackWithHandler r9 = new androidx.core.provider.CallbackWithHandler
            r9.<init>(r0, r10)
            if (r2 == 0) goto L_0x0056
            android.graphics.Typeface r4 = androidx.core.provider.FontRequestWorker.requestFontSync(r4, r5, r9, r8, r11)
            goto L_0x006f
        L_0x0056:
            android.graphics.Typeface r4 = androidx.core.provider.FontRequestWorker.requestFontAsync(r4, r5, r8, r1, r9)
            goto L_0x006f
        L_0x005b:
            androidx.core.graphics.TypefaceCompatBaseImpl r11 = sTypefaceCompatImpl
            androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry r5 = (androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry) r5
            android.graphics.Typeface r4 = r11.createFromFontFamilyFilesResourceEntry(r4, r5, r6, r8)
            if (r9 == 0) goto L_0x006f
            if (r4 == 0) goto L_0x006b
            r9.callbackSuccessAsync(r4, r10)
            goto L_0x006f
        L_0x006b:
            r5 = -3
            r9.callbackFailAsync(r5, r10)
        L_0x006f:
            if (r4 == 0) goto L_0x007a
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r5 = sTypefaceCache
            java.lang.String r6 = createResourceUid(r6, r7, r8)
            r5.put(r6, r4)
        L_0x007a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(android.content.Context, androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry, android.content.res.Resources, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, str, i2);
        if (createFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    public static String createResourceUid(Resources resources, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(resources.getResourcePackageName(i));
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(i);
        return GeneratedOutlineSupport.outline61(sb, Constants.ACCEPT_TIME_SEPARATOR_SERVER, i2);
    }
}
