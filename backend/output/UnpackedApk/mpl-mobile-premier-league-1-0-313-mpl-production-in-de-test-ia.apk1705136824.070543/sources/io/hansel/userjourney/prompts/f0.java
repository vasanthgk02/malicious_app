package io.hansel.userjourney.prompts;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.widget.TextView;
import io.hansel.a.a;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.utils.HSLUtils;
import io.hansel.segments.c;
import io.hansel.userjourney.n;
import org.apache.fontbox.cmap.CMap;

public class f0 {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r12, java.lang.String r13, io.hansel.core.json.CoreJSONObject r14, io.hansel.segments.c r15) {
        /*
            java.lang.String r0 = "textVariables"
            boolean r1 = r14.has(r0)
            if (r1 == 0) goto L_0x000e
            io.hansel.core.json.CoreJSONObject r14 = r14.optJSONObject(r0)
            goto L_0x000f
        L_0x000e:
            r14 = 0
        L_0x000f:
            if (r14 == 0) goto L_0x00b6
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.Set r1 = r14.keySet()
            r0.<init>(r1)
            int r1 = r0.size()
            r2 = 0
        L_0x001f:
            if (r2 >= r1) goto L_0x00b6
            java.lang.Object r3 = r0.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            io.hansel.core.json.CoreJSONObject r4 = r14.optJSONObject(r3)
            java.lang.String r5 = "type"
            java.lang.String r6 = ""
            java.lang.String r5 = r4.optString(r5, r6)
            java.lang.String r7 = "name"
            java.lang.String r7 = r4.optString(r7)
            java.lang.String r8 = "vendor"
            java.lang.String r8 = r4.optString(r8)
            java.lang.String r9 = "eventName"
            java.lang.String r9 = r4.optString(r9)
            java.lang.String r10 = "propName"
            java.lang.String r10 = r4.optString(r10)
            java.lang.String r11 = "fallback"
            java.lang.String r4 = r4.optString(r11)
            if (r4 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r6 = r4
        L_0x0057:
            r5.hashCode()
            java.lang.String r4 = "profile"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x0082
            java.lang.String r4 = "event"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x006b
            goto L_0x008d
        L_0x006b:
            boolean r4 = io.hansel.core.utils.HSLUtils.isValueSet(r10)
            if (r4 == 0) goto L_0x008d
            boolean r4 = io.hansel.core.utils.HSLUtils.isSet(r9)
            if (r4 == 0) goto L_0x008d
            boolean r4 = io.hansel.core.utils.HSLUtils.isSet(r8)
            if (r4 == 0) goto L_0x008d
            java.lang.String r4 = r15.a(r12, r9, r8, r10)
            goto L_0x008e
        L_0x0082:
            boolean r4 = io.hansel.core.utils.HSLUtils.isValueSet(r7)
            if (r4 == 0) goto L_0x008d
            java.lang.String r4 = r15.a(r7)
            goto L_0x008e
        L_0x008d:
            r4 = r6
        L_0x008e:
            boolean r5 = io.hansel.core.utils.HSLUtils.isSet(r4)
            if (r5 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r6 = r4
        L_0x0096:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "{{"
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = "}}"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r13 = r13.replace(r3, r6)
            int r2 = r2 + 1
            goto L_0x001f
        L_0x00b6:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.f0.a(android.content.Context, java.lang.String, io.hansel.core.json.CoreJSONObject, io.hansel.segments.c):java.lang.String");
    }

    public static String a(String str) {
        return str.contains(" ") ? str.replaceAll(" ", CMap.SPACE) : str;
    }

    public static void a(Context context, TextView textView, int i) {
        if (a.b()) {
            textView.setTypeface(Typeface.create(HSLInternalUtils.getStringFromSharedPreferences(context, "app_def_font", ""), i));
        } else {
            textView.setTypeface(a.a(), i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A[Catch:{ all -> 0x006d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r4, android.widget.TextView r5, io.hansel.core.json.CoreJSONObject r6, java.lang.String r7, int r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "B"
            java.lang.String r1 = "R"
            java.lang.String r2 = "sans-serif"
            if (r9 != 0) goto L_0x000a
            java.lang.String r9 = "fontSize"
        L_0x000a:
            r3 = 0
            int r8 = r6.optInt(r9, r8)     // Catch:{ all -> 0x006d }
            java.lang.String r9 = "fontStyle"
            java.lang.String r9 = r6.optString(r9, r1)     // Catch:{ all -> 0x006d }
            java.lang.String r1 = "fontFamily"
            java.lang.String r6 = r6.optString(r1, r2)     // Catch:{ all -> 0x006d }
            java.lang.String r7 = a(r7)     // Catch:{ all -> 0x006d }
            r5.setText(r7)     // Catch:{ all -> 0x006d }
            float r7 = (float) r8     // Catch:{ all -> 0x006d }
            r5.setTextSize(r7)     // Catch:{ all -> 0x006d }
            boolean r7 = r9.contains(r0)     // Catch:{ all -> 0x006d }
            r8 = 1
            java.lang.String r1 = "I"
            if (r7 == 0) goto L_0x0037
            boolean r7 = r9.contains(r1)     // Catch:{ all -> 0x006d }
            if (r7 == 0) goto L_0x0037
            r7 = 3
            goto L_0x0048
        L_0x0037:
            boolean r7 = r9.contains(r0)     // Catch:{ all -> 0x006d }
            if (r7 == 0) goto L_0x003f
            r7 = 1
            goto L_0x0048
        L_0x003f:
            boolean r7 = r9.contains(r1)     // Catch:{ all -> 0x006d }
            if (r7 == 0) goto L_0x0047
            r7 = 2
            goto L_0x0048
        L_0x0047:
            r7 = 0
        L_0x0048:
            java.lang.String r0 = "U"
            boolean r9 = r9.contains(r0)     // Catch:{ all -> 0x006d }
            if (r9 == 0) goto L_0x0059
            int r9 = r5.getPaintFlags()     // Catch:{ all -> 0x006d }
            r9 = r9 | 8
            r5.setPaintFlags(r9)     // Catch:{ all -> 0x006d }
        L_0x0059:
            java.lang.String r9 = "app-default"
            boolean r9 = r9.equals(r6)     // Catch:{ all -> 0x006d }
            if (r9 == 0) goto L_0x0065
            a(r4, r5, r7)     // Catch:{ all -> 0x006d }
            goto L_0x006c
        L_0x0065:
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r6, r7)     // Catch:{ all -> 0x006d }
            r5.setTypeface(r4)     // Catch:{ all -> 0x006d }
        L_0x006c:
            return r8
        L_0x006d:
            r4 = move-exception
            io.hansel.core.logger.LogGroup r5 = io.hansel.core.logger.LogGroup.PT
            java.lang.String r6 = "Exception caught while setting text props."
            io.hansel.core.logger.HSLLogger.printStackTrace(r4, r6, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.f0.a(android.content.Context, android.widget.TextView, io.hansel.core.json.CoreJSONObject, java.lang.String, int, java.lang.String):boolean");
    }

    public static boolean a(Context context, TextView textView, CoreJSONObject coreJSONObject, boolean z, p0 p0Var, CoreJSONObject coreJSONObject2, c cVar) {
        String a2 = a(context, p0Var == p0.MULTICHOICE ? coreJSONObject2.optString("text", "") : coreJSONObject.optString("text", ""), coreJSONObject, cVar);
        if (!HSLUtils.isSet(a2) && z) {
            return false;
        }
        int a3 = n.a(coreJSONObject, (String) "textColor", n.c("#808080"));
        if (p0Var == p0.BTN_FILLED || p0Var == p0.BTN_FLAT) {
            int[][] iArr = {new int[]{16842910}, new int[0]};
            int[] iArr2 = new int[2];
            iArr2[0] = a3;
            if (p0Var == p0.BTN_FLAT) {
                a3 = n.a(coreJSONObject, (String) "textColor", 0.25f, n.c("#808080"));
            }
            iArr2[1] = a3;
            textView.setTextColor(new ColorStateList(iArr, iArr2));
        } else {
            textView.setTextColor(a3);
        }
        if (p0Var != p0.BTNX) {
            return a(context, textView, coreJSONObject, a2, 14, null);
        }
        return true;
    }
}
