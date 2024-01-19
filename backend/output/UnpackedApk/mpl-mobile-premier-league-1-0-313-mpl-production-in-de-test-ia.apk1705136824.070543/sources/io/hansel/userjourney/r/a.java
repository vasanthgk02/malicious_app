package io.hansel.userjourney.r;

import android.content.Context;
import androidx.core.app.NotificationCompat.WearableExtender;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.segments.q;
import io.hansel.userjourney.models.g;
import io.hansel.userjourney.prompts.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<C0085a> f5722a = new ArrayList<>();

    /* renamed from: io.hansel.userjourney.r.a$a  reason: collision with other inner class name */
    public static abstract class C0085a {
    }

    public class b extends C0085a {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, Object> f5723a = new HashMap<>();

        public b(a aVar, CoreJSONObject coreJSONObject) {
            if (coreJSONObject == null) {
                HSLLogger.e("updateDeepConfigJson is null");
                return;
            }
            ArrayList arrayList = new ArrayList(coreJSONObject.keySet());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) arrayList.get(i);
                this.f5723a.put(str, coreJSONObject.optJSONObject(str).opt("v"));
            }
        }

        public HashMap<String, Object> a() {
            return this.f5723a;
        }
    }

    public class c extends C0085a {

        /* renamed from: a  reason: collision with root package name */
        public final String f5724a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, String> f5725b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f5726c = new HashMap<>();

        /* renamed from: d  reason: collision with root package name */
        public TreeSet<j> f5727d = new TreeSet<>();

        /* renamed from: e  reason: collision with root package name */
        public HashSet<String> f5728e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        public Set<String> f5729f = new HashSet();
        public g g;
        public HashMap<String, CoreJSONObject> h = new HashMap<>();

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0066, code lost:
            r0 = r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c(io.hansel.userjourney.r.a r9, android.content.Context r10, java.lang.String r11, io.hansel.core.json.CoreJSONObject r12) {
            /*
                r8 = this;
                r8.<init>()
                java.util.HashMap r9 = new java.util.HashMap
                r9.<init>()
                r8.f5725b = r9
                java.util.HashMap r9 = new java.util.HashMap
                r9.<init>()
                r8.f5726c = r9
                java.util.TreeSet r9 = new java.util.TreeSet
                r9.<init>()
                r8.f5727d = r9
                java.util.HashSet r9 = new java.util.HashSet
                r9.<init>()
                r8.f5728e = r9
                java.util.HashSet r9 = new java.util.HashSet
                r9.<init>()
                r8.f5729f = r9
                java.util.HashMap r9 = new java.util.HashMap
                r9.<init>()
                r8.h = r9
                r8.f5724a = r11
                if (r12 != 0) goto L_0x0038
                java.lang.String r9 = "updatePromptJson is null"
                io.hansel.core.logger.HSLLogger.e(r9)
                return
            L_0x0038:
                java.lang.String r9 = "trigger"
                io.hansel.core.json.CoreJSONObject r9 = r12.optJSONObject(r9)
                r0 = 0
                if (r9 == 0) goto L_0x0068
                java.lang.String r1 = "event_name"
                java.lang.String r1 = r9.optString(r1)
                java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
                java.lang.String r3 = "vendor"
                java.lang.String r9 = r9.optString(r3)
                r2.append(r9)
                java.lang.String r9 = r2.toString()
                java.util.HashMap<java.lang.String, java.lang.String> r2 = r8.f5726c
                r2.put(r11, r9)
                boolean r2 = io.hansel.ujmtracker.l.b(r1)
                if (r2 != 0) goto L_0x0066
                goto L_0x0069
            L_0x0066:
                r0 = r1
                goto L_0x0069
            L_0x0068:
                r9 = r0
            L_0x0069:
                r8.a(r11, r12)
                java.util.HashMap<java.lang.String, java.lang.String> r1 = r8.f5725b
                java.lang.String r2 = r12.toString()
                r1.put(r11, r2)
                java.lang.String r1 = "changes"
                io.hansel.core.json.CoreJSONObject r1 = r12.optJSONObject(r1)
                java.lang.String r2 = "prompt"
                boolean r3 = r1.has(r2)
                r4 = 0
                java.lang.String r6 = "props"
                if (r3 == 0) goto L_0x00aa
                io.hansel.core.json.CoreJSONObject r3 = r1.optJSONObject(r2)
                boolean r7 = r3.has(r6)
                if (r7 == 0) goto L_0x00aa
                io.hansel.core.json.CoreJSONObject r3 = r3.optJSONObject(r6)
                java.lang.String r7 = "priority"
                long r4 = r3.optLong(r7, r4)
                if (r0 == 0) goto L_0x00aa
                java.lang.String r0 = "element_identifier"
                java.lang.String r7 = ""
                java.lang.String r0 = r3.optString(r0, r7)
                java.util.HashSet<java.lang.String> r3 = r8.f5728e
                r3.add(r0)
            L_0x00aa:
                java.util.TreeSet<io.hansel.userjourney.prompts.j> r0 = r8.f5727d
                io.hansel.userjourney.prompts.j r3 = new io.hansel.userjourney.prompts.j
                r3.<init>(r11, r4, r9)
                r0.add(r3)
                java.lang.String r9 = "img1"
                boolean r0 = r1.has(r9)
                java.lang.String r3 = "Image URL empty for jHash:  "
                java.lang.String r4 = "url"
                if (r0 == 0) goto L_0x00f6
                io.hansel.core.json.CoreJSONObject r9 = r1.optJSONObject(r9)
                io.hansel.core.json.CoreJSONObject r9 = r9.getJSONObject(r6)     // Catch:{ Exception -> 0x00ee }
                java.lang.String r9 = r9.getString(r4)     // Catch:{ Exception -> 0x00ee }
                boolean r0 = io.hansel.core.utils.HSLUtils.isSet(r9)     // Catch:{ Exception -> 0x00ee }
                if (r0 == 0) goto L_0x00d9
                java.util.Set<java.lang.String> r0 = r8.f5729f     // Catch:{ Exception -> 0x00ee }
                r0.add(r9)     // Catch:{ Exception -> 0x00ee }
                goto L_0x00f6
            L_0x00d9:
                java.lang.Exception r9 = new java.lang.Exception     // Catch:{ Exception -> 0x00ee }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ee }
                r0.<init>()     // Catch:{ Exception -> 0x00ee }
                r0.append(r3)     // Catch:{ Exception -> 0x00ee }
                r0.append(r11)     // Catch:{ Exception -> 0x00ee }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00ee }
                r9.<init>(r0)     // Catch:{ Exception -> 0x00ee }
                throw r9     // Catch:{ Exception -> 0x00ee }
            L_0x00ee:
                r9 = move-exception
                java.lang.String r9 = r9.getMessage()
                io.hansel.core.logger.HSLLogger.d(r9)
            L_0x00f6:
                boolean r9 = r1.has(r2)
                if (r9 == 0) goto L_0x014f
                io.hansel.core.json.CoreJSONObject r9 = r1.optJSONObject(r2)
                boolean r9 = r9.has(r6)
                if (r9 == 0) goto L_0x014f
                io.hansel.core.json.CoreJSONObject r9 = r1.optJSONObject(r2)
                io.hansel.core.json.CoreJSONObject r9 = r9.optJSONObject(r6)
                java.lang.String r0 = "bgFill"
                boolean r9 = r9.has(r0)
                if (r9 == 0) goto L_0x014f
                io.hansel.core.json.CoreJSONObject r9 = r1.optJSONObject(r2)
                io.hansel.core.json.CoreJSONObject r9 = r9.optJSONObject(r6)
                io.hansel.core.json.CoreJSONObject r9 = r9.optJSONObject(r0)
                java.lang.String r9 = r9.getString(r4)     // Catch:{ Exception -> 0x0147 }
                boolean r0 = io.hansel.core.utils.HSLUtils.isSet(r9)     // Catch:{ Exception -> 0x0147 }
                if (r0 == 0) goto L_0x0132
                java.util.Set<java.lang.String> r0 = r8.f5729f     // Catch:{ Exception -> 0x0147 }
                r0.add(r9)     // Catch:{ Exception -> 0x0147 }
                goto L_0x014f
            L_0x0132:
                java.lang.Exception r9 = new java.lang.Exception     // Catch:{ Exception -> 0x0147 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0147 }
                r0.<init>()     // Catch:{ Exception -> 0x0147 }
                r0.append(r3)     // Catch:{ Exception -> 0x0147 }
                r0.append(r11)     // Catch:{ Exception -> 0x0147 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0147 }
                r9.<init>(r0)     // Catch:{ Exception -> 0x0147 }
                throw r9     // Catch:{ Exception -> 0x0147 }
            L_0x0147:
                r9 = move-exception
                java.lang.String r9 = r9.getMessage()
                io.hansel.core.logger.HSLLogger.d(r9)
            L_0x014f:
                java.lang.String r9 = "h_card"
                boolean r0 = r1.has(r9)
                if (r0 == 0) goto L_0x0192
                io.hansel.core.json.CoreJSONObject r9 = r1.optJSONObject(r9)
                io.hansel.core.json.CoreJSONObject r9 = r9.optJSONObject(r6)     // Catch:{ Exception -> 0x018e }
                java.lang.String r0 = "img2"
                io.hansel.core.json.CoreJSONObject r9 = r9.optJSONObject(r0)     // Catch:{ Exception -> 0x018e }
                io.hansel.core.json.CoreJSONObject r9 = r9.getJSONObject(r6)     // Catch:{ Exception -> 0x018e }
                java.lang.String r9 = r9.getString(r4)     // Catch:{ Exception -> 0x018e }
                boolean r0 = io.hansel.core.utils.HSLUtils.isSet(r9)     // Catch:{ Exception -> 0x018e }
                if (r0 == 0) goto L_0x0179
                java.util.Set<java.lang.String> r0 = r8.f5729f     // Catch:{ Exception -> 0x018e }
                r0.add(r9)     // Catch:{ Exception -> 0x018e }
                goto L_0x0192
            L_0x0179:
                java.lang.Exception r9 = new java.lang.Exception     // Catch:{ Exception -> 0x018e }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
                r0.<init>()     // Catch:{ Exception -> 0x018e }
                r0.append(r3)     // Catch:{ Exception -> 0x018e }
                r0.append(r11)     // Catch:{ Exception -> 0x018e }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x018e }
                r9.<init>(r0)     // Catch:{ Exception -> 0x018e }
                throw r9     // Catch:{ Exception -> 0x018e }
            L_0x018e:
                r9 = move-exception
                io.hansel.core.logger.HSLLogger.printStackTrace(r9)
            L_0x0192:
                r8.a(r10, r1)
                java.lang.String r9 = io.hansel.userjourney.prompts.h0.a(r11)
                io.hansel.userjourney.models.g r11 = new io.hansel.userjourney.models.g
                r11.<init>(r10, r12, r9)
                r8.g = r11
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.r.a.c.<init>(io.hansel.userjourney.r.a, android.content.Context, java.lang.String, io.hansel.core.json.CoreJSONObject):void");
        }

        private void a(Context context, CoreJSONObject coreJSONObject) {
            List asList = Arrays.asList(new String[]{"btn1", "btn2", "btn3", "label0", "label1", "label2", "label3", "npsInputLabel", "ratingInputLabel", "input1", "input2"});
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                try {
                    String str = (String) asList.get(i);
                    if (coreJSONObject.has(str)) {
                        io.hansel.segments.j.a(context, coreJSONObject.getJSONObject(str).optJSONObject("props"));
                    }
                } catch (Throwable th) {
                    HSLLogger.printStackTrace(th);
                }
            }
            if (coreJSONObject.has("multiChoice")) {
                try {
                    CoreJSONArray coreJSONArray = new CoreJSONArray(coreJSONObject.getString("options"));
                    int length = coreJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        io.hansel.segments.j.a(context, new CoreJSONObject(coreJSONArray.optString(i2)));
                    }
                } catch (Throwable unused) {
                }
            }
            int size2 = Arrays.asList(new String[]{"btn1", "btn2", "btn3"}).size();
            for (int i3 = 0; i3 < size2; i3++) {
                try {
                    String str2 = (String) asList.get(i3);
                    if (coreJSONObject.has(str2)) {
                        CoreJSONObject jSONObject = coreJSONObject.getJSONObject(str2).optJSONObject(WearableExtender.KEY_ACTIONS).optJSONArray("onClick").getJSONObject(0);
                        if (jSONObject.optString("type").equals("link")) {
                            io.hansel.segments.j.a(context, jSONObject);
                        }
                    }
                } catch (Throwable th2) {
                    HSLLogger.printStackTrace(th2);
                }
            }
            if (coreJSONObject.has("h_card")) {
                try {
                    CoreJSONObject jSONObject2 = coreJSONObject.getJSONObject("h_card");
                    if (jSONObject2.has("label4")) {
                        io.hansel.segments.j.a(context, jSONObject2.getJSONObject("label4").optJSONObject("props"));
                    }
                    if (jSONObject2.has("label6")) {
                        io.hansel.segments.j.a(context, jSONObject2.getJSONObject("label6").optJSONObject("props"));
                    }
                } catch (Throwable th3) {
                    HSLLogger.printStackTrace(th3);
                }
            }
        }

        private void a(String str, CoreJSONObject coreJSONObject) {
            CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("stop");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    CoreJSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && "event".equals(optJSONObject.optString("type"))) {
                        this.h.put(q.a(str, optJSONObject.optString("event_name"), optJSONObject.optString("vendor")), optJSONObject);
                    }
                }
            }
        }

        public Set<String> a() {
            return this.f5729f;
        }

        public TreeSet<j> b() {
            return this.f5727d;
        }

        public HashMap<String, String> c() {
            return this.f5726c;
        }

        public g d() {
            return this.g;
        }

        public String e() {
            return this.f5724a;
        }

        public HashMap<String, String> f() {
            return this.f5725b;
        }

        public HashSet<String> g() {
            return this.f5728e;
        }

        public HashMap<String, CoreJSONObject> h() {
            return this.h;
        }
    }

    public a(String str, String str2, CoreJSONObject coreJSONObject, Context context) {
        try {
            String optString = coreJSONObject.optString("lidx");
            String optString2 = coreJSONObject.optString("type", "");
            if ("experience".equals(optString2)) {
                CoreJSONArray jSONArray = coreJSONObject.getJSONArray("act_lst");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    C0085a a2 = a(jSONArray.optJSONObject(i));
                    if (a2 != null) {
                        this.f5722a.add(a2);
                    }
                }
            } else if ("prompt".equals(optString2)) {
                C0085a a3 = a(context, str, optString, coreJSONObject.getJSONArray("act_lst").optJSONObject(0));
                if (a3 != null) {
                    this.f5722a.add(a3);
                }
            }
            io.hansel.userjourney.g.a(str, str2, coreJSONObject.optJSONArray("s"), context);
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    private C0085a a(Context context, String str, String str2, CoreJSONObject coreJSONObject) {
        try {
            return new c(this, context, str + "___" + str2, coreJSONObject);
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            return null;
        }
    }

    private C0085a a(CoreJSONObject coreJSONObject) {
        try {
            ArrayList arrayList = new ArrayList(coreJSONObject.keySet());
            int size = arrayList.size();
            String str = "";
            for (int i = 0; i < size; i++) {
                str = (String) arrayList.get(i);
            }
            if ("upd_dc".equals(str)) {
                return new b(this, coreJSONObject.optJSONObject("upd_dc"));
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        return null;
    }

    public ArrayList<C0085a> a() {
        return this.f5722a;
    }
}
