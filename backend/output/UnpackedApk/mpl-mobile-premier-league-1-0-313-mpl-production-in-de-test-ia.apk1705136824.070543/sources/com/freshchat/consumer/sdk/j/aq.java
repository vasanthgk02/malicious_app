package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.freshchat.consumer.sdk.R.attr;
import com.freshchat.consumer.sdk.b.c;
import java.lang.reflect.Field;

public class aq {
    public static int a(Context context, int i, int i2) {
        try {
            return aw.fa() ? context.getResources().getColor(i, context.getTheme()) : context.getResources().getColor(i);
        } catch (NotFoundException unused) {
            return i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (r3 == null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        r3.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r3 == null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r4, int r5, int r6, boolean r7) {
        /*
            r0 = 1
            r1 = -1
            r2 = 0
            r3 = 0
            if (r5 != 0) goto L_0x0013
            android.content.res.Resources$Theme r5 = r4.getTheme()     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
            int[] r0 = new int[r0]     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
            r0[r2] = r6     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r0)     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
            goto L_0x001b
        L_0x0013:
            int[] r0 = new int[r0]     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
            r0[r2] = r6     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
            android.content.res.TypedArray r5 = r4.obtainStyledAttributes(r5, r0)     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
        L_0x001b:
            r3 = r5
            if (r3 == 0) goto L_0x002b
            int r5 = r3.getIndexCount()     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
            if (r5 != 0) goto L_0x0025
            goto L_0x002b
        L_0x0025:
            int r4 = r3.getResourceId(r2, r1)     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
            r1 = r4
            goto L_0x0030
        L_0x002b:
            if (r7 == 0) goto L_0x0030
            k(r4, r6)     // Catch:{ Exception -> 0x003d, all -> 0x0036 }
        L_0x0030:
            if (r3 == 0) goto L_0x0041
        L_0x0032:
            r3.recycle()
            goto L_0x0041
        L_0x0036:
            r4 = move-exception
            if (r3 == 0) goto L_0x003c
            r3.recycle()
        L_0x003c:
            throw r4
        L_0x003d:
            if (r3 == 0) goto L_0x0041
            goto L_0x0032
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.aq.a(android.content.Context, int, int, boolean):int");
    }

    public static int a(Context context, int i, boolean z) {
        return a(context, 0, i, z);
    }

    public static TypedValue a(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        return typedValue;
    }

    public static Drawable getDrawable(Context context, int i) {
        if (context == null) {
            return null;
        }
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable != null && aw.eY()) {
            drawable.setAutoMirrored(true);
        }
        return drawable;
    }

    public static int j(Context context, int i) {
        return a(context, i, true);
    }

    public static final void k(Context context, final int i) {
        String l = l(context, i);
        if (!as.isEmpty(l)) {
            ai.e("FRESHCHAT", c.THEME_ATTRIBUTE_MISSING.toString().replace("{{resource_name}}", l));
        } else {
            new Thread(new Runnable() {
                public void run() {
                    for (Field field : attr.class.getFields()) {
                        try {
                            if (field.getInt(null) == i) {
                                ai.e("FRESHCHAT", c.THEME_ATTRIBUTE_MISSING.toString().replace("{{resource_name}}", field.getName()));
                            }
                        } catch (IllegalAccessException unused) {
                        }
                    }
                }
            }).start();
        }
    }

    public static String l(Context context, int i) {
        if (!(context == null || i <= 0 || context.getResources() == null)) {
            try {
                return context.getResources().getResourceEntryName(i);
            } catch (NotFoundException unused) {
            }
        }
        return "";
    }

    public static int o(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }
}
