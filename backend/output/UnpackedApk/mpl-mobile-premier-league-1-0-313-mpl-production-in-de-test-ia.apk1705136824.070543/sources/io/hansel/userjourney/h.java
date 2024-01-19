package io.hansel.userjourney;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.userjourney.prompts.h0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class h {

    public class a implements Comparator<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f5431a;

        public a(Context context) {
            this.f5431a = context;
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return h.this.a(this.f5431a, str, str2);
        }
    }

    public class b implements Comparator<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f5433a;

        public b(Context context) {
            this.f5433a = context;
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            int d2 = i.d(this.f5433a, str);
            int d3 = i.d(this.f5433a, str2);
            if (d2 == 0) {
                d2 = Integer.MAX_VALUE;
            }
            if (d3 == 0) {
                d3 = Integer.MAX_VALUE;
            }
            int compare = Integer.compare(d2, d3);
            return compare == 0 ? h.this.a(this.f5433a, str, str2) : compare;
        }
    }

    private int a(Context context, int i, int i2, List<String> list) {
        int size = list.size();
        while (i >= 0 && i2 < size && i <= i2) {
            int i3 = (i + i2) / 2;
            int d2 = i.d(context, list.get(i3));
            int i4 = -1;
            if (i3 > 0) {
                i4 = i.d(context, list.get(i3 - 1));
            }
            if (d2 == 0 && i4 > 0) {
                return i3;
            }
            if (d2 > 0) {
                i = i3 + 1;
            } else {
                i2 = i3 - 1;
            }
        }
        return size;
    }

    /* access modifiers changed from: private */
    public int a(Context context, String str, String str2) {
        return Integer.compare(i.g(context, str), i.g(context, str2));
    }

    private int a(Context context, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            int d2 = i.d(context, str);
            if (d2 > 0) {
                if (!i.c(context, str)) {
                    return i;
                }
            } else if (d2 == 0) {
                break;
            }
        }
        return -1;
    }

    private void a(Context context, String str) {
        int d2 = i.d(context, str);
        i.m(context, str);
        i.b(context, str, d2);
        i.k(context, str);
        i.l(context, str);
        i.j(context, str);
        i.i(context, str);
    }

    private void a(Context context, String str, CoreJSONObject coreJSONObject) {
        i.a(context, str, coreJSONObject);
    }

    private boolean c(Context context, String str) {
        try {
            return i.b(context, h0.b(str));
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, GeneratedOutlineSupport.outline50("Nudge Priority: Error reading eligibility of nudge ", str), LogGroup.PT);
            return false;
        }
    }

    private List<String> d(Context context, String str) {
        ArrayList arrayList = new ArrayList(i.f(context, str));
        Collections.sort(arrayList, new a(context));
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        r1 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            java.util.List r0 = r5.d(r6, r7)     // Catch:{ Exception -> 0x006c }
            java.lang.String r1 = "0"
            boolean r1 = r7.equals(r1)     // Catch:{ Exception -> 0x006c }
            r2 = 1
            if (r1 == 0) goto L_0x0021
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x006c }
        L_0x0011:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x006c }
            if (r1 == 0) goto L_0x0078
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x006c }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x006c }
            io.hansel.userjourney.i.a(r6, r1, r2)     // Catch:{ Exception -> 0x006c }
            goto L_0x0011
        L_0x0021:
            int r1 = r0.size()     // Catch:{ Exception -> 0x006c }
            r3 = 0
            if (r1 <= 0) goto L_0x0031
            java.lang.Object r1 = r0.get(r3)     // Catch:{ Exception -> 0x006c }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x006c }
            io.hansel.userjourney.i.a(r6, r1, r2)     // Catch:{ Exception -> 0x006c }
        L_0x0031:
            int r1 = r0.size()     // Catch:{ Exception -> 0x006c }
        L_0x0035:
            int r4 = r0.size()     // Catch:{ Exception -> 0x006c }
            if (r2 >= r4) goto L_0x005a
            java.lang.Object r4 = r0.get(r2)     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x006c }
            boolean r4 = r5.c(r6, r4)     // Catch:{ Exception -> 0x006c }
            if (r4 == 0) goto L_0x0059
            int r4 = r2 + -1
            java.lang.Object r4 = r0.get(r4)     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x006c }
            boolean r4 = io.hansel.userjourney.i.c(r6, r4)     // Catch:{ Exception -> 0x006c }
            if (r4 != 0) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            int r2 = r2 + 1
            goto L_0x0035
        L_0x0059:
            r1 = r2
        L_0x005a:
            int r2 = r0.size()     // Catch:{ Exception -> 0x006c }
            if (r1 >= r2) goto L_0x0078
            java.lang.Object r2 = r0.get(r1)     // Catch:{ Exception -> 0x006c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x006c }
            io.hansel.userjourney.i.a(r6, r2, r3)     // Catch:{ Exception -> 0x006c }
            int r1 = r1 + 1
            goto L_0x005a
        L_0x006c:
            r6 = move-exception
            java.lang.String r0 = "Nudge Priority: Error processing data for group "
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r0, r7)
            io.hansel.core.logger.LogGroup r0 = io.hansel.core.logger.LogGroup.PT
            io.hansel.core.logger.HSLLogger.printStackTrace(r6, r7, r0)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.h.f(android.content.Context, java.lang.String):void");
    }

    private void g(Context context, String str) {
        int d2 = i.d(context, str);
        if (d2 > 0) {
            List<String> d3 = d(context, String.valueOf(d2));
            int indexOf = d3.indexOf(str) + 1;
            if (indexOf < d3.size() && indexOf > 0) {
                i.a(context, d3.get(indexOf), true);
            }
        }
    }

    public void a(Context context) {
        try {
            Iterator it = new HashSet(i.a(context)).iterator();
            while (it.hasNext()) {
                f(context, (String) it.next());
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Nudge Priority: Error processing data", LogGroup.PT);
        }
    }

    public void a(Context context, CoreJSONObject coreJSONObject) {
        try {
            for (String next : coreJSONObject.keySet()) {
                a(context, next, coreJSONObject.optJSONObject(next));
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Nudge Priority: Error saving raw data.", LogGroup.PT);
        }
    }

    public List<String> b(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String b2 : list) {
                arrayList.add(h0.b(b2));
            }
            Collections.sort(arrayList, new b(context));
            int a2 = a(context, (List<String>) arrayList);
            if (a2 != -1) {
                int i = a2 + 1;
                if (i < arrayList.size()) {
                    arrayList.subList(i, a(context, i, arrayList.size() - 1, (List<String>) arrayList)).clear();
                }
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Nudge Priority: Error comparing priorities across groups.", LogGroup.PT);
        }
        return arrayList;
    }

    public void b(Context context, String str) {
        try {
            Iterator it = new HashSet(i.a(context, str)).iterator();
            while (it.hasNext()) {
                a(context, (String) it.next());
            }
            i.h(context, str);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, GeneratedOutlineSupport.outline50("Nudge Priority: Error clearing data for journey ", str), LogGroup.PT);
        }
    }

    public void b(Context context, String str, String str2) {
        try {
            String b2 = h0.b(str);
            i.a(context, str2, b2);
            CoreJSONObject optJSONObject = i.e(context, b2).optJSONObject("priority");
            if (optJSONObject == null) {
                optJSONObject = new CoreJSONObject();
            }
            int optInt = optJSONObject.optInt("grp", 0);
            int optInt2 = optJSONObject.optInt("idx", Integer.MAX_VALUE);
            i.a(context, optInt);
            i.c(context, b2, optInt);
            i.d(context, b2, optInt2);
            i.a(context, b2, optInt);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, GeneratedOutlineSupport.outline50("Nudge Priority: Error saving data for nudge ", str), LogGroup.PT);
        }
    }

    public void c(Context context, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String b2 = h0.b(it.next());
            if (!c(context, b2)) {
                it.remove();
                HSLLogger.d("Nudge " + b2 + " is ineligible for display as per set nudge priority in its group");
            }
        }
    }

    public void e(Context context, String str) {
        try {
            str = h0.b(str);
            i.b(context, str, true);
            g(context, str);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, GeneratedOutlineSupport.outline52("Nudge Priority: Error updating eligibility after nudge ", str, " was displayed"), LogGroup.PT);
        }
    }
}
