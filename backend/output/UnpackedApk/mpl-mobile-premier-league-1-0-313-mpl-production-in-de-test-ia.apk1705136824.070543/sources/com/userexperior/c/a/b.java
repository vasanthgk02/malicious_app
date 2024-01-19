package com.userexperior.c.a;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.razorpay.AnalyticsConstants;
import com.userexperior.a.a.a.c;
import com.userexperior.c.b.b.e;
import com.userexperior.c.b.b.g;
import com.userexperior.c.c.a;
import com.userexperior.models.recording.enums.h;
import com.userexperior.models.recording.f;
import com.userexperior.utilities.l;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f3801a = b.class.getSimpleName();
    @c(a = "eventList")

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f3802b;
    @c(a = "imagesToBeGenerated")

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f3803c;
    @c(a = "rtl")

    /* renamed from: d  reason: collision with root package name */
    public final List<e> f3804d;
    @c(a = "hasExceptionOccurred")

    /* renamed from: e  reason: collision with root package name */
    public boolean f3805e;
    @c(a = "userDevice")

    /* renamed from: f  reason: collision with root package name */
    public a f3806f;
    @c(a = "userProperties")
    public HashMap<String, Object> g;
    @c(a = "recordingDetails")
    public com.userexperior.c.c.b h;
    @c(a = "crashLog")
    public String i;
    @c(a = "cr")
    public String j;
    @c(a = "set")
    public long k;
    @c(a = "lin")
    public int l;
    @c(a = "asi")
    public String m;
    @c(a = "tpId")
    public String n;
    @c(a = "stb")
    public String o;
    @c(a = "crt")
    public String p;
    @c(a = "anrt")
    public String q;
    @c(a = "isHELA")
    public boolean r;
    @c(a = "wjb")
    public boolean s;
    @c(a = "rageTap")
    public boolean t;
    @c(a = "sst")
    public long u;
    @c(a = "sysAppLaunch")
    public d v;
    @c(a = "tfi")
    public long w;
    public int x;

    public b() {
        this.f3802b = new LinkedList();
        this.f3804d = new LinkedList();
        this.f3805e = false;
        this.f3806f = null;
        this.i = AnalyticsConstants.NOT_AVAILABLE;
        this.j = AnalyticsConstants.NOT_AVAILABLE;
        this.k = 0;
        this.u = 0;
        this.w = 0;
        this.l = 0;
        this.m = "";
        this.p = AnalyticsConstants.NOT_AVAILABLE;
        this.q = AnalyticsConstants.NOT_AVAILABLE;
        this.f3803c = new ArrayList();
        this.r = false;
        this.s = false;
        this.t = false;
        this.v = null;
    }

    public b(Parcel parcel) {
        this.f3802b = parcel.createTypedArrayList(a.CREATOR);
        this.f3804d = parcel.createTypedArrayList(e.CREATOR);
        boolean z = false;
        this.f3805e = parcel.readByte() == 1;
        this.f3806f = (a) parcel.readParcelable(a.class.getClassLoader());
        this.h = (com.userexperior.c.c.b) parcel.readParcelable(com.userexperior.c.c.b.class.getClassLoader());
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readLong();
        this.u = parcel.readLong();
        this.w = parcel.readLong();
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.f3803c = parcel.readArrayList(Integer.class.getClassLoader());
        this.r = parcel.readByte() == 1;
        this.s = parcel.readByte() == 1;
        this.t = parcel.readByte() == 1 ? true : z;
        this.g = (HashMap) parcel.readParcelable(HashMap.class.getClassLoader());
        this.v = (d) parcel.readParcelable(d.class.getClassLoader());
    }

    private void a(List<a> list) {
        if (list != null && !list.isEmpty()) {
            for (a next : list) {
                if (!(next == null || next.f3796b == null)) {
                    this.f3802b.add(next);
                    if (!this.r && next.f3796b == h.ERROR) {
                        this.r = true;
                    }
                    if (!this.t && next.f3796b == h.DOUBLE_TAP) {
                        this.t = true;
                    }
                    if (next.f3795a == com.userexperior.models.recording.enums.a.USER && this.w == 0) {
                        this.w = next.f3800f;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01d3, code lost:
        if (r6 == r1) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01d7, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01e8, code lost:
        if (r6 != r1) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01f5, code lost:
        if (r6 > r1) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0202, code lost:
        if (r6 < r1) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x020f, code lost:
        if (r6 >= r1) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x021c, code lost:
        if (r6 <= r1) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02c2, code lost:
        if (r10 == r1) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02c6, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02d5, code lost:
        if (r10 != r1) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02e2, code lost:
        if (r10 > r1) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02ef, code lost:
        if (r10 < r1) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x02fc, code lost:
        if (r10 >= r1) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0309, code lost:
        if (r10 <= r1) goto L_0x02c4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x047d  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0350 A[EDGE_INSN: B:352:0x0350->B:203:0x0350 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0350 A[EDGE_INSN: B:355:0x0350->B:203:0x0350 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x034a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.userexperior.c.b.b r31) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.TreeMap r3 = new java.util.TreeMap
            java.util.Comparator r4 = java.lang.String.CASE_INSENSITIVE_ORDER
            r3.<init>(r4)
            java.util.List<com.userexperior.c.a.a> r4 = r0.f3802b
            r5 = 0
            if (r4 == 0) goto L_0x0084
            java.util.Iterator r4 = r4.iterator()
        L_0x0019:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0084
            java.lang.Object r6 = r4.next()
            com.userexperior.c.a.a r6 = (com.userexperior.c.a.a) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.lang.String r7 = r6.g
            if (r7 == 0) goto L_0x0037
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0037
            java.lang.String r7 = r6.g
            goto L_0x004a
        L_0x0037:
            java.lang.String r7 = r6.f3798d
            if (r7 == 0) goto L_0x0044
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0044
            java.lang.String r7 = r6.f3798d
            goto L_0x004a
        L_0x0044:
            java.lang.String r7 = r6.f3797c
            if (r7 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r7 = r5
        L_0x004a:
            if (r7 == 0) goto L_0x0055
            boolean r8 = r2.containsKey(r7)
            if (r8 != 0) goto L_0x0055
            r2.put(r7, r7)
        L_0x0055:
            java.lang.String r7 = r6.f3798d
            if (r7 == 0) goto L_0x0019
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r6.f3799e
            if (r7 == 0) goto L_0x0019
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0019
            java.lang.String r7 = r6.f3798d
            boolean r7 = r3.containsKey(r7)
            if (r7 == 0) goto L_0x0074
            java.lang.String r7 = r6.f3798d
            java.lang.Object r7 = r3.get(r7)
            java.util.List r7 = (java.util.List) r7
            goto L_0x0079
        L_0x0074:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x0079:
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r6.f3799e
            r7.add(r8)
            java.lang.String r6 = r6.f3798d
            r3.put(r6, r7)
            goto L_0x0019
        L_0x0084:
            if (r1 == 0) goto L_0x0088
            java.util.List<com.userexperior.c.b.b.c> r5 = r1.f3839e
        L_0x0088:
            r4 = 0
            if (r5 == 0) goto L_0x0559
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x0559
            java.util.Iterator r5 = r5.iterator()
            r6 = 1
            r7 = 1
        L_0x0097:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0556
            java.lang.Object r8 = r5.next()
            com.userexperior.c.b.b.c r8 = (com.userexperior.c.b.b.c) r8
            if (r8 == 0) goto L_0x0549
            java.lang.String r9 = r8.f3845a
            java.lang.String r10 = "is"
            boolean r9 = r9.equals(r10)
            java.lang.String r11 = "isnot"
            if (r9 == 0) goto L_0x0506
            if (r6 != 0) goto L_0x00b4
            return r4
        L_0x00b4:
            java.util.List<com.userexperior.c.b.a.b> r9 = r8.f3847c
            java.util.List<java.lang.String> r8 = r8.f3846b
            java.util.Iterator r8 = r8.iterator()
        L_0x00bc:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x00df
            java.lang.Object r6 = r8.next()
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00dd
            boolean r6 = r2.containsKey(r6)
            if (r6 == 0) goto L_0x00dd
            if (r9 == 0) goto L_0x00db
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L_0x00d9
            goto L_0x00db
        L_0x00d9:
            r6 = 1
            goto L_0x00bc
        L_0x00db:
            r6 = 1
            goto L_0x0097
        L_0x00dd:
            r6 = 0
            goto L_0x00bc
        L_0x00df:
            java.util.List<com.userexperior.c.a.a> r8 = r0.f3802b
            if (r8 == 0) goto L_0x04f7
            java.util.Iterator r8 = r8.iterator()
        L_0x00e7:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x04f7
            java.lang.Object r12 = r8.next()
            com.userexperior.c.a.a r12 = (com.userexperior.c.a.a) r12
            com.userexperior.models.recording.enums.h r13 = r12.f3796b
            com.userexperior.models.recording.enums.h r14 = com.userexperior.models.recording.enums.h.EVENT
            if (r13 != r14) goto L_0x04d3
            if (r9 == 0) goto L_0x04d3
            boolean r13 = r9.isEmpty()
            if (r13 != 0) goto L_0x04d3
            boolean r13 = r3.isEmpty()
            if (r13 != 0) goto L_0x04e0
            java.util.Iterator r13 = r9.iterator()
        L_0x010b:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x04d3
            java.lang.Object r14 = r13.next()
            com.userexperior.c.b.a.b r14 = (com.userexperior.c.b.a.b) r14
            java.lang.String r15 = r14.f3831d
            int r4 = r15.hashCode()
            r1 = -1034364087(0xffffffffc258db49, float:-54.214146)
            r16 = -1
            if (r4 == r1) goto L_0x0144
            r1 = 3076014(0x2eefae, float:4.310414E-39)
            if (r4 == r1) goto L_0x013a
            r1 = 3556653(0x36452d, float:4.983932E-39)
            if (r4 == r1) goto L_0x012f
            goto L_0x014e
        L_0x012f:
            java.lang.String r1 = "text"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x014e
            r1 = 0
            goto L_0x014f
        L_0x013a:
            java.lang.String r1 = "date"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x014e
            r1 = 2
            goto L_0x014f
        L_0x0144:
            java.lang.String r1 = "number"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x014e
            r1 = 1
            goto L_0x014f
        L_0x014e:
            r1 = -1
        L_0x014f:
            if (r1 == 0) goto L_0x0365
            java.lang.String r4 = "range"
            java.lang.String r15 = "le"
            java.lang.String r0 = "ge"
            r18 = r5
            java.lang.String r5 = "lt"
            r19 = r8
            java.lang.String r8 = "gt"
            r20 = r9
            java.lang.String r9 = "neq"
            r21 = r13
            java.lang.String r13 = "eq"
            r22 = r2
            r2 = 1
            if (r1 == r2) goto L_0x027a
            r2 = 2
            if (r1 == r2) goto L_0x0173
            r23 = r7
            goto L_0x0274
        L_0x0173:
            r1 = 0
            if (r6 != 0) goto L_0x0177
            return r1
        L_0x0177:
            java.util.List<java.lang.String> r2 = r14.f3830c
            java.lang.Object r2 = r2.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Date r1 = com.userexperior.e.h.c(r2)
            long r1 = r1.getTime()
            r23 = r7
            java.lang.String r7 = r12.f3798d
            java.lang.Object r7 = r3.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x0274
            java.util.Iterator r7 = r7.iterator()
        L_0x0197:
            boolean r16 = r7.hasNext()
            if (r16 == 0) goto L_0x0272
            java.lang.Object r16 = r7.next()
            r17 = r6
            r6 = r16
            java.util.Map r6 = (java.util.Map) r6
            r16 = r7
            java.lang.String r7 = r14.f3828a
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = com.userexperior.e.h.d(r7)
            if (r7 == 0) goto L_0x026c
            java.lang.String r7 = r14.f3828a
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = (java.lang.String) r6
            java.util.Date r6 = com.userexperior.e.h.c(r6)
            long r6 = r6.getTime()
            r24 = r10
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x01de
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 != 0) goto L_0x01d7
        L_0x01d5:
            r6 = 1
            goto L_0x01d8
        L_0x01d7:
            r6 = 0
        L_0x01d8:
            r25 = r1
            r27 = r11
            goto L_0x0260
        L_0x01de:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x01eb
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 == 0) goto L_0x01d7
            goto L_0x01d5
        L_0x01eb:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r8)
            if (r10 == 0) goto L_0x01f8
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 <= 0) goto L_0x01d7
            goto L_0x01d5
        L_0x01f8:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x0205
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x01d7
            goto L_0x01d5
        L_0x0205:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0212
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 < 0) goto L_0x01d7
            goto L_0x01d5
        L_0x0212:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x021f
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 > 0) goto L_0x01d7
            goto L_0x01d5
        L_0x021f:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x025a
            java.util.List<java.lang.String> r10 = r14.f3830c
            r25 = r1
            r1 = 0
            java.lang.Object r2 = r10.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Date r1 = com.userexperior.e.h.c(r2)
            long r1 = r1.getTime()
            java.util.List<java.lang.String> r10 = r14.f3830c
            r27 = r11
            r11 = 1
            java.lang.Object r10 = r10.get(r11)
            java.lang.String r10 = (java.lang.String) r10
            java.util.Date r10 = com.userexperior.e.h.c(r10)
            long r10 = r10.getTime()
            int r17 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r17 < 0) goto L_0x0257
            int r1 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0257
            r1 = 1
            goto L_0x0258
        L_0x0257:
            r1 = 0
        L_0x0258:
            r6 = r1
            goto L_0x0260
        L_0x025a:
            r25 = r1
            r27 = r11
            r6 = r17
        L_0x0260:
            if (r6 != 0) goto L_0x0350
            r7 = r16
            r10 = r24
            r1 = r25
            r11 = r27
            goto L_0x0197
        L_0x026c:
            r7 = r16
            r6 = r17
            goto L_0x0197
        L_0x0272:
            r17 = r6
        L_0x0274:
            r24 = r10
            r27 = r11
            goto L_0x0350
        L_0x027a:
            r23 = r7
            r24 = r10
            r27 = r11
            r1 = 0
            if (r6 != 0) goto L_0x0284
            return r1
        L_0x0284:
            java.util.List<java.lang.String> r2 = r14.f3830c
            java.lang.Object r2 = r2.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            double r1 = java.lang.Double.parseDouble(r2)
            java.lang.String r7 = r12.f3798d
            java.lang.Object r7 = r3.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x0350
            java.util.Iterator r7 = r7.iterator()
        L_0x029e:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x034e
            java.lang.Object r10 = r7.next()
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r11 = r14.f3828a     // Catch:{ Exception -> 0x0344 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x0344 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0344 }
            double r10 = java.lang.Double.parseDouble(r10)     // Catch:{ Exception -> 0x0344 }
            r16 = r6
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x02cb
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x02c6
        L_0x02c4:
            r6 = 1
            goto L_0x02c7
        L_0x02c6:
            r6 = 0
        L_0x02c7:
            r17 = r0
            goto L_0x0341
        L_0x02cb:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02d8
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x02c6
            goto L_0x02c4
        L_0x02d8:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x02e5
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x02c6
            goto L_0x02c4
        L_0x02e5:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x02f2
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x02c6
            goto L_0x02c4
        L_0x02f2:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x02ff
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 < 0) goto L_0x02c6
            goto L_0x02c4
        L_0x02ff:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x030c
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x02c6
            goto L_0x02c4
        L_0x030c:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x033d
            java.util.List<java.lang.String> r6 = r14.f3830c
            r17 = r0
            r0 = 0
            java.lang.Object r6 = r6.get(r0)
            java.lang.String r6 = (java.lang.String) r6
            double r25 = java.lang.Double.parseDouble(r6)
            java.util.List<java.lang.String> r0 = r14.f3830c
            r6 = 1
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            double r28 = java.lang.Double.parseDouble(r0)
            int r0 = (r10 > r25 ? 1 : (r10 == r25 ? 0 : -1))
            if (r0 < 0) goto L_0x033a
            int r0 = (r10 > r28 ? 1 : (r10 == r28 ? 0 : -1))
            if (r0 > 0) goto L_0x033a
            r0 = 1
            goto L_0x033b
        L_0x033a:
            r0 = 0
        L_0x033b:
            r6 = r0
            goto L_0x0341
        L_0x033d:
            r17 = r0
            r6 = r16
        L_0x0341:
            if (r6 != 0) goto L_0x0350
            goto L_0x034a
        L_0x0344:
            r17 = r0
            r16 = r6
            r6 = r16
        L_0x034a:
            r0 = r17
            goto L_0x029e
        L_0x034e:
            r16 = r6
        L_0x0350:
            r0 = r30
            r5 = r18
            r8 = r19
            r9 = r20
            r13 = r21
            r2 = r22
            r7 = r23
            r10 = r24
            r11 = r27
        L_0x0362:
            r4 = 0
            goto L_0x010b
        L_0x0365:
            r22 = r2
            r18 = r5
            r23 = r7
            r19 = r8
            r20 = r9
            r24 = r10
            r27 = r11
            r21 = r13
            java.lang.String r0 = r14.f3829b
            int r1 = r0.hashCode()
            r2 = 3370(0xd2a, float:4.722E-42)
            if (r1 == r2) goto L_0x03ab
            r2 = 3321751(0x32af97, float:4.654765E-39)
            if (r1 == r2) goto L_0x039a
            r2 = 100504937(0x5fd9569, float:2.384689E-35)
            if (r1 == r2) goto L_0x038e
            r2 = r24
            r1 = r27
            goto L_0x03b7
        L_0x038e:
            r1 = r27
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x03a8
            r2 = r24
            r0 = 1
            goto L_0x03b8
        L_0x039a:
            r1 = r27
            java.lang.String r2 = "like"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x03a8
            r2 = r24
            r0 = 2
            goto L_0x03b8
        L_0x03a8:
            r2 = r24
            goto L_0x03b7
        L_0x03ab:
            r2 = r24
            r1 = r27
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x03b7
            r0 = 0
            goto L_0x03b8
        L_0x03b7:
            r0 = -1
        L_0x03b8:
            if (r0 == 0) goto L_0x047d
            r4 = 1
            if (r0 == r4) goto L_0x0427
            r4 = 2
            if (r0 == r4) goto L_0x03c1
            goto L_0x0415
        L_0x03c1:
            if (r6 != 0) goto L_0x03c5
            r0 = 0
            return r0
        L_0x03c5:
            java.util.List<java.lang.String> r0 = r14.f3830c
            java.util.Iterator r0 = r0.iterator()
        L_0x03cb:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0415
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r12.f3798d
            java.lang.Object r5 = r3.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x03cb
            java.util.Iterator r5 = r5.iterator()
        L_0x03e5:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x03cb
            java.lang.Object r6 = r5.next()
            java.util.Map r6 = (java.util.Map) r6
            if (r4 == 0) goto L_0x0469
            java.lang.String r7 = r14.f3828a
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x0469
            java.lang.String r7 = r14.f3828a
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r7 = r4.toLowerCase()
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x0469
            r6 = 1
            goto L_0x03e5
        L_0x0415:
            r0 = r30
            r11 = r1
            r10 = r2
            r5 = r18
            r8 = r19
            r9 = r20
            r13 = r21
            r2 = r22
            r7 = r23
            goto L_0x0362
        L_0x0427:
            if (r6 != 0) goto L_0x042b
            r0 = 0
            return r0
        L_0x042b:
            java.util.List<java.lang.String> r0 = r14.f3830c
            java.util.Iterator r0 = r0.iterator()
        L_0x0431:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0415
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r12.f3798d
            java.lang.Object r5 = r3.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0431
            java.util.Iterator r5 = r5.iterator()
        L_0x044b:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0431
            java.lang.Object r6 = r5.next()
            java.util.Map r6 = (java.util.Map) r6
            if (r4 == 0) goto L_0x0469
            java.lang.String r7 = r14.f3828a
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x0469
            boolean r6 = r6.containsValue(r4)
            if (r6 != 0) goto L_0x0469
            r6 = 1
            goto L_0x044b
        L_0x0469:
            r0 = r30
            r11 = r1
            r10 = r2
            r5 = r18
            r8 = r19
            r9 = r20
            r13 = r21
            r2 = r22
            r7 = r23
            r4 = 0
            r6 = 0
            goto L_0x010b
        L_0x047d:
            if (r6 != 0) goto L_0x0481
            r0 = 0
            return r0
        L_0x0481:
            java.util.List<java.lang.String> r0 = r14.f3830c
            java.util.Iterator r0 = r0.iterator()
        L_0x0487:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0415
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r12.f3798d
            java.lang.Object r5 = r3.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0487
            java.util.Iterator r5 = r5.iterator()
        L_0x04a1:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0487
            java.lang.Object r6 = r5.next()
            java.util.Map r6 = (java.util.Map) r6
            if (r4 == 0) goto L_0x04d1
            java.lang.String r7 = r14.f3828a
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x04d1
            boolean r6 = r6.containsValue(r4)
            if (r6 == 0) goto L_0x04d1
            r0 = r30
            r11 = r1
            r10 = r2
            r5 = r18
            r8 = r19
            r9 = r20
            r13 = r21
            r2 = r22
            r7 = r23
            r4 = 0
            r6 = 1
            goto L_0x010b
        L_0x04d1:
            r6 = 0
            goto L_0x04a1
        L_0x04d3:
            r22 = r2
            r18 = r5
            r23 = r7
            r19 = r8
            r20 = r9
            r2 = r10
            r1 = r11
            goto L_0x04e6
        L_0x04e0:
            r22 = r2
            r0 = r30
            goto L_0x00e7
        L_0x04e6:
            r0 = r30
            r11 = r1
            r10 = r2
            r5 = r18
            r8 = r19
            r9 = r20
            r2 = r22
            r7 = r23
            r4 = 0
            goto L_0x00e7
        L_0x04f7:
            r22 = r2
            r18 = r5
            r23 = r7
            r0 = r30
            r5 = r18
            r2 = r22
            r7 = r23
            goto L_0x0553
        L_0x0506:
            r22 = r2
            r18 = r5
            r23 = r7
            r1 = r11
            java.lang.String r0 = r8.f3845a
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0546
            if (r23 != 0) goto L_0x0519
            r0 = 0
            return r0
        L_0x0519:
            java.util.List<java.lang.String> r0 = r8.f3846b
            java.util.Iterator r0 = r0.iterator()
            r7 = r23
        L_0x0521:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0543
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = r22
            if (r1 == 0) goto L_0x053b
            boolean r1 = r2.containsKey(r1)
            if (r1 != 0) goto L_0x053b
            r22 = r2
            r7 = 1
            goto L_0x0521
        L_0x053b:
            r0 = r30
            r5 = r18
            r4 = 0
            r7 = 0
            goto L_0x0097
        L_0x0543:
            r2 = r22
            goto L_0x054f
        L_0x0546:
            r2 = r22
            goto L_0x054d
        L_0x0549:
            r18 = r5
            r23 = r7
        L_0x054d:
            r7 = r23
        L_0x054f:
            r0 = r30
            r5 = r18
        L_0x0553:
            r4 = 0
            goto L_0x0097
        L_0x0556:
            r23 = r7
            goto L_0x055b
        L_0x0559:
            r6 = 1
            r7 = 1
        L_0x055b:
            if (r6 == 0) goto L_0x0561
            if (r7 == 0) goto L_0x0561
            r0 = 1
            return r0
        L_0x0561:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.c.a.b.a(com.userexperior.c.b.b):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0150, code lost:
        if (r7 >= r11) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0159, code lost:
        if (r7 < r11) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0162, code lost:
        if (r7 > r11) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x016b, code lost:
        if (r7 == r11) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0147, code lost:
        if (r7 <= r11) goto L_0x016d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.userexperior.c.b.b r18, java.lang.String r19) {
        /*
            r0 = r18
            if (r0 == 0) goto L_0x0007
            java.util.List<com.userexperior.c.b.b.b> r0 = r0.g
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            r1 = 1
            if (r0 == 0) goto L_0x0176
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0176
            android.content.Context r2 = com.userexperior.utilities.a.a()
            r3 = r19
            com.userexperior.models.recording.f r2 = com.userexperior.utilities.l.c(r2, r3)
            r3 = 0
            if (r2 == 0) goto L_0x0175
            com.userexperior.c.a.d r2 = r2.y
            if (r2 != 0) goto L_0x0023
            return r3
        L_0x0023:
            java.util.Iterator r0 = r0.iterator()
            r4 = 1
        L_0x0028:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0173
            java.lang.Object r5 = r0.next()
            com.userexperior.c.b.b.b r5 = (com.userexperior.c.b.b.b) r5
            if (r4 != 0) goto L_0x0037
            return r3
        L_0x0037:
            com.userexperior.c.b.a.c r6 = r5.f3844b
            java.util.List<java.lang.String> r7 = r5.f3843a
            java.util.Iterator r7 = r7.iterator()
        L_0x003f:
            boolean r8 = r7.hasNext()
            java.lang.String r9 = "All"
            java.lang.String r10 = "Hot & Cold"
            if (r8 == 0) goto L_0x006a
            java.lang.Object r4 = r7.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r8 = r2.f3812a
            boolean r8 = r8.equalsIgnoreCase(r4)
            if (r8 != 0) goto L_0x0066
            boolean r8 = r4.equalsIgnoreCase(r10)
            if (r8 != 0) goto L_0x0066
            boolean r4 = r4.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r4 = 0
            goto L_0x003f
        L_0x0066:
            r4 = 1
            if (r6 != 0) goto L_0x003f
            goto L_0x0028
        L_0x006a:
            java.util.List<java.lang.String> r5 = r5.f3843a
            java.util.Iterator r5 = r5.iterator()
        L_0x0070:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0028
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            if (r6 == 0) goto L_0x0070
            java.lang.String r8 = r2.f3812a
            boolean r8 = r8.equalsIgnoreCase(r7)
            if (r8 != 0) goto L_0x0092
            boolean r8 = r7.equalsIgnoreCase(r10)
            if (r8 != 0) goto L_0x0092
            boolean r7 = r7.equalsIgnoreCase(r9)
            if (r7 == 0) goto L_0x0070
        L_0x0092:
            long r7 = r2.f3813b
            java.lang.String r11 = r6.f3833b
            double r11 = java.lang.Double.parseDouble(r11)
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r11 = r11 * r13
            long r11 = (long) r11
            r15 = 0
            int r17 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x0070
            java.lang.String r15 = r6.f3832a
            r16 = -1
            int r13 = r15.hashCode()
            r14 = 3244(0xcac, float:4.546E-42)
            r3 = 2
            if (r13 == r14) goto L_0x00fd
            r14 = 3294(0xcde, float:4.616E-42)
            if (r13 == r14) goto L_0x00f3
            r14 = 3309(0xced, float:4.637E-42)
            if (r13 == r14) goto L_0x00e9
            r14 = 3449(0xd79, float:4.833E-42)
            if (r13 == r14) goto L_0x00df
            r14 = 3464(0xd88, float:4.854E-42)
            if (r13 == r14) goto L_0x00d5
            r14 = 108280125(0x674393d, float:4.5933352E-35)
            if (r13 == r14) goto L_0x00cb
            goto L_0x0107
        L_0x00cb:
            java.lang.String r13 = "range"
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0107
            r13 = 5
            goto L_0x0108
        L_0x00d5:
            java.lang.String r13 = "lt"
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0107
            r13 = 2
            goto L_0x0108
        L_0x00df:
            java.lang.String r13 = "le"
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0107
            r13 = 4
            goto L_0x0108
        L_0x00e9:
            java.lang.String r13 = "gt"
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0107
            r13 = 1
            goto L_0x0108
        L_0x00f3:
            java.lang.String r13 = "ge"
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0107
            r13 = 3
            goto L_0x0108
        L_0x00fd:
            java.lang.String r13 = "eq"
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0107
            r13 = 0
            goto L_0x0108
        L_0x0107:
            r13 = -1
        L_0x0108:
            if (r13 == 0) goto L_0x0165
            if (r13 == r1) goto L_0x015c
            if (r13 == r3) goto L_0x0153
            r3 = 3
            if (r13 == r3) goto L_0x014a
            r3 = 4
            if (r13 == r3) goto L_0x0141
            r3 = 5
            if (r13 == r3) goto L_0x011a
            r3 = 0
            goto L_0x0070
        L_0x011a:
            if (r4 != 0) goto L_0x011e
            r3 = 0
            return r3
        L_0x011e:
            java.lang.String r3 = r6.f3833b
            double r3 = java.lang.Double.parseDouble(r3)
            r11 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r3 = r3 * r11
            long r3 = (long) r3
            java.lang.String r13 = r6.f3834c
            double r13 = java.lang.Double.parseDouble(r13)
            double r13 = r13 * r11
            long r11 = (long) r13
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 < 0) goto L_0x013f
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 > 0) goto L_0x013f
            r3 = 0
            goto L_0x016d
        L_0x013f:
            r3 = 0
            goto L_0x0170
        L_0x0141:
            r3 = 0
            if (r4 != 0) goto L_0x0145
            return r3
        L_0x0145:
            int r4 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r4 > 0) goto L_0x0170
            goto L_0x016d
        L_0x014a:
            r3 = 0
            if (r4 != 0) goto L_0x014e
            return r3
        L_0x014e:
            int r4 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r4 < 0) goto L_0x0170
            goto L_0x016d
        L_0x0153:
            r3 = 0
            if (r4 != 0) goto L_0x0157
            return r3
        L_0x0157:
            int r4 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r4 >= 0) goto L_0x0170
            goto L_0x016d
        L_0x015c:
            r3 = 0
            if (r4 != 0) goto L_0x0160
            return r3
        L_0x0160:
            int r4 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r4 <= 0) goto L_0x0170
            goto L_0x016d
        L_0x0165:
            r3 = 0
            if (r4 != 0) goto L_0x0169
            return r3
        L_0x0169:
            int r4 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x0170
        L_0x016d:
            r4 = 1
            goto L_0x0070
        L_0x0170:
            r4 = 0
            goto L_0x0070
        L_0x0173:
            r1 = r4
            goto L_0x0176
        L_0x0175:
            return r3
        L_0x0176:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.c.a.b.a(com.userexperior.c.b.b, java.lang.String):boolean");
    }

    private boolean a(List<a> list, f fVar) {
        Level level;
        String str;
        boolean z;
        Context a2 = com.userexperior.utilities.a.a();
        com.userexperior.c.b.a e2 = l.e(a2);
        String str2 = fVar.f4087d;
        if (str2 == null || !str2.equals("2") || fVar.k || fVar.l) {
            if (list != null && !list.isEmpty()) {
                for (a next : list) {
                    if (!(next == null || next.f3796b == null)) {
                        this.f3802b.add(next);
                        if (!this.r && next.f3796b == h.ERROR) {
                            this.r = true;
                        }
                        if (!this.t && next.f3796b == h.DOUBLE_TAP) {
                            this.t = true;
                        }
                        if (next.f3796b == h.DOUBLE_TAP) {
                            this.x++;
                        }
                        if (next.f3795a == com.userexperior.models.recording.enums.a.USER && this.w == 0) {
                            this.w = next.f3800f;
                        }
                    }
                }
                if (!fVar.k && !fVar.l) {
                    e eVar = null;
                    com.userexperior.c.b.b bVar = e2 != null ? e2.g : null;
                    if (f(bVar) && e(bVar) && d(bVar) && a(bVar) && b(bVar) && c(bVar) && g(bVar)) {
                        if (bVar != null) {
                            eVar = bVar.i;
                        }
                        if (eVar != null && eVar.f3851a.equals("exists")) {
                            if (this.t) {
                                com.userexperior.c.b.a.a aVar = eVar.f3852b;
                                if (aVar != null) {
                                    String str3 = aVar.f3826a;
                                    char c2 = 65535;
                                    int hashCode = str3.hashCode();
                                    if (hashCode != 3244) {
                                        if (hashCode != 3294) {
                                            if (hashCode != 3309) {
                                                if (hashCode != 3449) {
                                                    if (hashCode == 3464 && str3.equals("lt")) {
                                                        c2 = 2;
                                                    }
                                                } else if (str3.equals("le")) {
                                                    c2 = 4;
                                                }
                                            } else if (str3.equals("gt")) {
                                                c2 = 1;
                                            }
                                        } else if (str3.equals("ge")) {
                                            c2 = 3;
                                        }
                                    } else if (str3.equals("eq")) {
                                        c2 = 0;
                                    }
                                    if (c2 == 0) {
                                    }
                                }
                            }
                            z = false;
                            if (z && a(bVar, fVar.r)) {
                                return true;
                            }
                        }
                        z = true;
                        return true;
                    }
                    com.userexperior.e.h.b(new File(fVar.f4086c));
                    l.d(a2, fVar.r);
                    level = Level.INFO;
                    str = "Rule based R conditions did not match!";
                }
            }
            return true;
        }
        com.userexperior.e.h.b(new File(fVar.f4086c));
        l.d(a2, fVar.r);
        level = Level.INFO;
        str = "U for Crash/Anr condition did not match!";
        com.userexperior.utilities.b.a(level, str);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01c2, code lost:
        if (r6 == r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01c6, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01d7, code lost:
        if (r6 != r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01e4, code lost:
        if (r6 > r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01f1, code lost:
        if (r6 < r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01fe, code lost:
        if (r6 >= r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x020b, code lost:
        if (r6 <= r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02b1, code lost:
        if (r10 == r1) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02b5, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02c4, code lost:
        if (r10 != r1) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02d1, code lost:
        if (r10 > r1) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02de, code lost:
        if (r10 < r1) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02eb, code lost:
        if (r10 >= r1) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02f8, code lost:
        if (r10 <= r1) goto L_0x02b3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x033f A[EDGE_INSN: B:345:0x033f->B:196:0x033f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x033f A[EDGE_INSN: B:349:0x033f->B:196:0x033f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0339 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.userexperior.c.b.b r31) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.TreeMap r3 = new java.util.TreeMap
            java.util.Comparator r4 = java.lang.String.CASE_INSENSITIVE_ORDER
            r3.<init>(r4)
            java.util.List<com.userexperior.c.a.a> r4 = r0.f3802b
            r5 = 0
            if (r4 == 0) goto L_0x0073
            java.util.Iterator r4 = r4.iterator()
        L_0x0019:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0073
            java.lang.Object r6 = r4.next()
            com.userexperior.c.a.a r6 = (com.userexperior.c.a.a) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.userexperior.models.recording.enums.h r7 = r6.f3796b
            com.userexperior.models.recording.enums.h r8 = com.userexperior.models.recording.enums.h.MSG
            if (r7 != r8) goto L_0x0038
            java.lang.String r7 = r6.f3797c
            if (r7 == 0) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            java.lang.String r7 = r6.f3798d
            goto L_0x0039
        L_0x0038:
            r7 = r5
        L_0x0039:
            if (r7 == 0) goto L_0x0044
            boolean r8 = r2.containsKey(r7)
            if (r8 != 0) goto L_0x0044
            r2.put(r7, r7)
        L_0x0044:
            java.lang.String r7 = r6.f3798d
            if (r7 == 0) goto L_0x0019
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r6.f3799e
            if (r7 == 0) goto L_0x0019
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0019
            java.lang.String r7 = r6.f3798d
            boolean r7 = r3.containsKey(r7)
            if (r7 == 0) goto L_0x0063
            java.lang.String r7 = r6.f3798d
            java.lang.Object r7 = r3.get(r7)
            java.util.List r7 = (java.util.List) r7
            goto L_0x0068
        L_0x0063:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x0068:
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r6.f3799e
            r7.add(r8)
            java.lang.String r6 = r6.f3798d
            r3.put(r6, r7)
            goto L_0x0019
        L_0x0073:
            if (r1 == 0) goto L_0x0077
            java.util.List<com.userexperior.c.b.b.d> r5 = r1.f3838d
        L_0x0077:
            r4 = 0
            if (r5 == 0) goto L_0x0548
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x0548
            java.util.Iterator r5 = r5.iterator()
            r6 = 1
            r7 = 1
        L_0x0086:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0545
            java.lang.Object r8 = r5.next()
            com.userexperior.c.b.b.d r8 = (com.userexperior.c.b.b.d) r8
            if (r8 == 0) goto L_0x0538
            java.lang.String r9 = r8.f3848a
            java.lang.String r10 = "is"
            boolean r9 = r9.equals(r10)
            java.lang.String r11 = "isnot"
            if (r9 == 0) goto L_0x04f5
            if (r6 != 0) goto L_0x00a3
            return r4
        L_0x00a3:
            java.util.List<com.userexperior.c.b.a.b> r9 = r8.f3850c
            java.util.List<java.lang.String> r8 = r8.f3849b
            java.util.Iterator r8 = r8.iterator()
        L_0x00ab:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x00ce
            java.lang.Object r6 = r8.next()
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00cc
            boolean r6 = r2.containsKey(r6)
            if (r6 == 0) goto L_0x00cc
            if (r9 == 0) goto L_0x00ca
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L_0x00c8
            goto L_0x00ca
        L_0x00c8:
            r6 = 1
            goto L_0x00ab
        L_0x00ca:
            r6 = 1
            goto L_0x0086
        L_0x00cc:
            r6 = 0
            goto L_0x00ab
        L_0x00ce:
            java.util.List<com.userexperior.c.a.a> r8 = r0.f3802b
            if (r8 == 0) goto L_0x04e6
            java.util.Iterator r8 = r8.iterator()
        L_0x00d6:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x04e6
            java.lang.Object r12 = r8.next()
            com.userexperior.c.a.a r12 = (com.userexperior.c.a.a) r12
            com.userexperior.models.recording.enums.h r13 = r12.f3796b
            com.userexperior.models.recording.enums.h r14 = com.userexperior.models.recording.enums.h.MSG
            if (r13 != r14) goto L_0x04c2
            if (r9 == 0) goto L_0x04c2
            boolean r13 = r9.isEmpty()
            if (r13 != 0) goto L_0x04c2
            boolean r13 = r3.isEmpty()
            if (r13 != 0) goto L_0x04cf
            java.util.Iterator r13 = r9.iterator()
        L_0x00fa:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x04c2
            java.lang.Object r14 = r13.next()
            com.userexperior.c.b.a.b r14 = (com.userexperior.c.b.a.b) r14
            java.lang.String r15 = r14.f3831d
            int r4 = r15.hashCode()
            r1 = -1034364087(0xffffffffc258db49, float:-54.214146)
            r16 = -1
            if (r4 == r1) goto L_0x0133
            r1 = 3076014(0x2eefae, float:4.310414E-39)
            if (r4 == r1) goto L_0x0129
            r1 = 3556653(0x36452d, float:4.983932E-39)
            if (r4 == r1) goto L_0x011e
            goto L_0x013d
        L_0x011e:
            java.lang.String r1 = "text"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x013d
            r1 = 0
            goto L_0x013e
        L_0x0129:
            java.lang.String r1 = "date"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x013d
            r1 = 2
            goto L_0x013e
        L_0x0133:
            java.lang.String r1 = "number"
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x013d
            r1 = 1
            goto L_0x013e
        L_0x013d:
            r1 = -1
        L_0x013e:
            if (r1 == 0) goto L_0x0354
            java.lang.String r4 = "range"
            java.lang.String r15 = "le"
            java.lang.String r0 = "ge"
            r18 = r5
            java.lang.String r5 = "lt"
            r19 = r8
            java.lang.String r8 = "gt"
            r20 = r9
            java.lang.String r9 = "neq"
            r21 = r13
            java.lang.String r13 = "eq"
            r22 = r2
            r2 = 1
            if (r1 == r2) goto L_0x0269
            r2 = 2
            if (r1 == r2) goto L_0x0162
            r23 = r7
            goto L_0x0263
        L_0x0162:
            r1 = 0
            if (r6 != 0) goto L_0x0166
            return r1
        L_0x0166:
            java.util.List<java.lang.String> r2 = r14.f3830c
            java.lang.Object r2 = r2.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Date r1 = com.userexperior.e.h.c(r2)
            long r1 = r1.getTime()
            r23 = r7
            java.lang.String r7 = r12.f3798d
            java.lang.Object r7 = r3.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x0263
            java.util.Iterator r7 = r7.iterator()
        L_0x0186:
            boolean r16 = r7.hasNext()
            if (r16 == 0) goto L_0x0261
            java.lang.Object r16 = r7.next()
            r17 = r6
            r6 = r16
            java.util.Map r6 = (java.util.Map) r6
            r16 = r7
            java.lang.String r7 = r14.f3828a
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = com.userexperior.e.h.d(r7)
            if (r7 == 0) goto L_0x025b
            java.lang.String r7 = r14.f3828a
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = (java.lang.String) r6
            java.util.Date r6 = com.userexperior.e.h.c(r6)
            long r6 = r6.getTime()
            r24 = r10
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x01cd
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 != 0) goto L_0x01c6
        L_0x01c4:
            r6 = 1
            goto L_0x01c7
        L_0x01c6:
            r6 = 0
        L_0x01c7:
            r25 = r1
            r27 = r11
            goto L_0x024f
        L_0x01cd:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x01da
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 == 0) goto L_0x01c6
            goto L_0x01c4
        L_0x01da:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r8)
            if (r10 == 0) goto L_0x01e7
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 <= 0) goto L_0x01c6
            goto L_0x01c4
        L_0x01e7:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x01f4
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x01c6
            goto L_0x01c4
        L_0x01f4:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0201
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 < 0) goto L_0x01c6
            goto L_0x01c4
        L_0x0201:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x020e
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 > 0) goto L_0x01c6
            goto L_0x01c4
        L_0x020e:
            java.lang.String r10 = r14.f3829b
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x0249
            java.util.List<java.lang.String> r10 = r14.f3830c
            r25 = r1
            r1 = 0
            java.lang.Object r2 = r10.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Date r1 = com.userexperior.e.h.c(r2)
            long r1 = r1.getTime()
            java.util.List<java.lang.String> r10 = r14.f3830c
            r27 = r11
            r11 = 1
            java.lang.Object r10 = r10.get(r11)
            java.lang.String r10 = (java.lang.String) r10
            java.util.Date r10 = com.userexperior.e.h.c(r10)
            long r10 = r10.getTime()
            int r17 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r17 < 0) goto L_0x0246
            int r1 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0246
            r1 = 1
            goto L_0x0247
        L_0x0246:
            r1 = 0
        L_0x0247:
            r6 = r1
            goto L_0x024f
        L_0x0249:
            r25 = r1
            r27 = r11
            r6 = r17
        L_0x024f:
            if (r6 != 0) goto L_0x033f
            r7 = r16
            r10 = r24
            r1 = r25
            r11 = r27
            goto L_0x0186
        L_0x025b:
            r7 = r16
            r6 = r17
            goto L_0x0186
        L_0x0261:
            r17 = r6
        L_0x0263:
            r24 = r10
            r27 = r11
            goto L_0x033f
        L_0x0269:
            r23 = r7
            r24 = r10
            r27 = r11
            r1 = 0
            if (r6 != 0) goto L_0x0273
            return r1
        L_0x0273:
            java.util.List<java.lang.String> r2 = r14.f3830c
            java.lang.Object r2 = r2.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            double r1 = java.lang.Double.parseDouble(r2)
            java.lang.String r7 = r12.f3798d
            java.lang.Object r7 = r3.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x033f
            java.util.Iterator r7 = r7.iterator()
        L_0x028d:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x033d
            java.lang.Object r10 = r7.next()
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r11 = r14.f3828a     // Catch:{ Exception -> 0x0333 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x0333 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0333 }
            double r10 = java.lang.Double.parseDouble(r10)     // Catch:{ Exception -> 0x0333 }
            r16 = r6
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x02ba
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x02b5
        L_0x02b3:
            r6 = 1
            goto L_0x02b6
        L_0x02b5:
            r6 = 0
        L_0x02b6:
            r17 = r0
            goto L_0x0330
        L_0x02ba:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02c7
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x02b5
            goto L_0x02b3
        L_0x02c7:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x02d4
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x02b5
            goto L_0x02b3
        L_0x02d4:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x02e1
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x02b5
            goto L_0x02b3
        L_0x02e1:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x02ee
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 < 0) goto L_0x02b5
            goto L_0x02b3
        L_0x02ee:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x02fb
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x02b5
            goto L_0x02b3
        L_0x02fb:
            java.lang.String r6 = r14.f3829b
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x032c
            java.util.List<java.lang.String> r6 = r14.f3830c
            r17 = r0
            r0 = 0
            java.lang.Object r6 = r6.get(r0)
            java.lang.String r6 = (java.lang.String) r6
            double r25 = java.lang.Double.parseDouble(r6)
            java.util.List<java.lang.String> r0 = r14.f3830c
            r6 = 1
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            double r28 = java.lang.Double.parseDouble(r0)
            int r0 = (r10 > r25 ? 1 : (r10 == r25 ? 0 : -1))
            if (r0 < 0) goto L_0x0329
            int r0 = (r10 > r28 ? 1 : (r10 == r28 ? 0 : -1))
            if (r0 > 0) goto L_0x0329
            r0 = 1
            goto L_0x032a
        L_0x0329:
            r0 = 0
        L_0x032a:
            r6 = r0
            goto L_0x0330
        L_0x032c:
            r17 = r0
            r6 = r16
        L_0x0330:
            if (r6 != 0) goto L_0x033f
            goto L_0x0339
        L_0x0333:
            r17 = r0
            r16 = r6
            r6 = r16
        L_0x0339:
            r0 = r17
            goto L_0x028d
        L_0x033d:
            r16 = r6
        L_0x033f:
            r0 = r30
            r5 = r18
            r8 = r19
            r9 = r20
            r13 = r21
            r2 = r22
            r7 = r23
            r10 = r24
            r11 = r27
        L_0x0351:
            r4 = 0
            goto L_0x00fa
        L_0x0354:
            r22 = r2
            r18 = r5
            r23 = r7
            r19 = r8
            r20 = r9
            r24 = r10
            r27 = r11
            r21 = r13
            java.lang.String r0 = r14.f3829b
            int r1 = r0.hashCode()
            r2 = 3370(0xd2a, float:4.722E-42)
            if (r1 == r2) goto L_0x039a
            r2 = 3321751(0x32af97, float:4.654765E-39)
            if (r1 == r2) goto L_0x0389
            r2 = 100504937(0x5fd9569, float:2.384689E-35)
            if (r1 == r2) goto L_0x037d
            r2 = r24
            r1 = r27
            goto L_0x03a6
        L_0x037d:
            r1 = r27
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0397
            r2 = r24
            r0 = 1
            goto L_0x03a7
        L_0x0389:
            r1 = r27
            java.lang.String r2 = "like"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0397
            r2 = r24
            r0 = 2
            goto L_0x03a7
        L_0x0397:
            r2 = r24
            goto L_0x03a6
        L_0x039a:
            r2 = r24
            r1 = r27
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x03a6
            r0 = 0
            goto L_0x03a7
        L_0x03a6:
            r0 = -1
        L_0x03a7:
            if (r0 == 0) goto L_0x046c
            r4 = 1
            if (r0 == r4) goto L_0x0416
            r4 = 2
            if (r0 == r4) goto L_0x03b0
            goto L_0x0404
        L_0x03b0:
            if (r6 != 0) goto L_0x03b4
            r0 = 0
            return r0
        L_0x03b4:
            java.util.List<java.lang.String> r0 = r14.f3830c
            java.util.Iterator r0 = r0.iterator()
        L_0x03ba:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0404
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r12.f3798d
            java.lang.Object r5 = r3.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x03ba
            java.util.Iterator r5 = r5.iterator()
        L_0x03d4:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x03ba
            java.lang.Object r6 = r5.next()
            java.util.Map r6 = (java.util.Map) r6
            if (r4 == 0) goto L_0x0458
            java.lang.String r7 = r14.f3828a
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x0458
            java.lang.String r7 = r14.f3828a
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r7 = r4.toLowerCase()
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x0458
            r6 = 1
            goto L_0x03d4
        L_0x0404:
            r0 = r30
            r11 = r1
            r10 = r2
            r5 = r18
            r8 = r19
            r9 = r20
            r13 = r21
            r2 = r22
            r7 = r23
            goto L_0x0351
        L_0x0416:
            if (r6 != 0) goto L_0x041a
            r0 = 0
            return r0
        L_0x041a:
            java.util.List<java.lang.String> r0 = r14.f3830c
            java.util.Iterator r0 = r0.iterator()
        L_0x0420:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0404
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r12.f3798d
            java.lang.Object r5 = r3.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0420
            java.util.Iterator r5 = r5.iterator()
        L_0x043a:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0420
            java.lang.Object r6 = r5.next()
            java.util.Map r6 = (java.util.Map) r6
            if (r4 == 0) goto L_0x0458
            java.lang.String r7 = r14.f3828a
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x0458
            boolean r6 = r6.containsValue(r4)
            if (r6 != 0) goto L_0x0458
            r6 = 1
            goto L_0x043a
        L_0x0458:
            r0 = r30
            r11 = r1
            r10 = r2
            r5 = r18
            r8 = r19
            r9 = r20
            r13 = r21
            r2 = r22
            r7 = r23
            r4 = 0
            r6 = 0
            goto L_0x00fa
        L_0x046c:
            if (r6 != 0) goto L_0x0470
            r0 = 0
            return r0
        L_0x0470:
            java.util.List<java.lang.String> r0 = r14.f3830c
            java.util.Iterator r0 = r0.iterator()
        L_0x0476:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0404
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r12.f3798d
            java.lang.Object r5 = r3.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0476
            java.util.Iterator r5 = r5.iterator()
        L_0x0490:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0476
            java.lang.Object r6 = r5.next()
            java.util.Map r6 = (java.util.Map) r6
            if (r4 == 0) goto L_0x04c0
            java.lang.String r7 = r14.f3828a
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x04c0
            boolean r6 = r6.containsValue(r4)
            if (r6 == 0) goto L_0x04c0
            r0 = r30
            r11 = r1
            r10 = r2
            r5 = r18
            r8 = r19
            r9 = r20
            r13 = r21
            r2 = r22
            r7 = r23
            r4 = 0
            r6 = 1
            goto L_0x00fa
        L_0x04c0:
            r6 = 0
            goto L_0x0490
        L_0x04c2:
            r22 = r2
            r18 = r5
            r23 = r7
            r19 = r8
            r20 = r9
            r2 = r10
            r1 = r11
            goto L_0x04d5
        L_0x04cf:
            r22 = r2
            r0 = r30
            goto L_0x00d6
        L_0x04d5:
            r0 = r30
            r11 = r1
            r10 = r2
            r5 = r18
            r8 = r19
            r9 = r20
            r2 = r22
            r7 = r23
            r4 = 0
            goto L_0x00d6
        L_0x04e6:
            r22 = r2
            r18 = r5
            r23 = r7
            r0 = r30
            r5 = r18
            r2 = r22
            r7 = r23
            goto L_0x0542
        L_0x04f5:
            r22 = r2
            r18 = r5
            r23 = r7
            r1 = r11
            java.lang.String r0 = r8.f3848a
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0535
            if (r23 != 0) goto L_0x0508
            r0 = 0
            return r0
        L_0x0508:
            java.util.List<java.lang.String> r0 = r8.f3849b
            java.util.Iterator r0 = r0.iterator()
            r7 = r23
        L_0x0510:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0532
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = r22
            if (r1 == 0) goto L_0x052a
            boolean r1 = r2.containsKey(r1)
            if (r1 != 0) goto L_0x052a
            r22 = r2
            r7 = 1
            goto L_0x0510
        L_0x052a:
            r0 = r30
            r5 = r18
            r4 = 0
            r7 = 0
            goto L_0x0086
        L_0x0532:
            r2 = r22
            goto L_0x053e
        L_0x0535:
            r2 = r22
            goto L_0x053c
        L_0x0538:
            r18 = r5
            r23 = r7
        L_0x053c:
            r7 = r23
        L_0x053e:
            r0 = r30
            r5 = r18
        L_0x0542:
            r4 = 0
            goto L_0x0086
        L_0x0545:
            r23 = r7
            goto L_0x054a
        L_0x0548:
            r6 = 1
            r7 = 1
        L_0x054a:
            if (r6 == 0) goto L_0x0550
            if (r7 == 0) goto L_0x0550
            r0 = 1
            return r0
        L_0x0550:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.c.a.b.b(com.userexperior.c.b.b):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0016, code lost:
        continue;
     */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0016 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(com.userexperior.c.b.b r21) {
        /*
            r20 = this;
            r0 = r21
            if (r0 == 0) goto L_0x0007
            java.util.List<com.userexperior.c.b.b.i> r0 = r0.h
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            r1 = 1
            if (r0 == 0) goto L_0x02a4
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x02a4
            java.util.Iterator r0 = r0.iterator()
        L_0x0015:
            r3 = 1
        L_0x0016:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x02a0
            java.lang.Object r4 = r0.next()
            com.userexperior.c.b.b.i r4 = (com.userexperior.c.b.b.i) r4
            r5 = r20
            if (r4 == 0) goto L_0x029d
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r5.g
            if (r6 == 0) goto L_0x029b
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0032
            goto L_0x029b
        L_0x0032:
            java.lang.String r7 = r4.f3862d
            int r8 = r7.hashCode()
            r9 = -1034364087(0xffffffffc258db49, float:-54.214146)
            r11 = 2
            if (r8 == r9) goto L_0x005e
            r9 = 3076014(0x2eefae, float:4.310414E-39)
            if (r8 == r9) goto L_0x0054
            r9 = 3556653(0x36452d, float:4.983932E-39)
            if (r8 == r9) goto L_0x0049
            goto L_0x0068
        L_0x0049:
            java.lang.String r8 = "text"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0068
            r7 = 0
            goto L_0x0069
        L_0x0054:
            java.lang.String r8 = "date"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0068
            r7 = 2
            goto L_0x0069
        L_0x005e:
            java.lang.String r8 = "number"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0068
            r7 = 1
            goto L_0x0069
        L_0x0068:
            r7 = -1
        L_0x0069:
            if (r7 == 0) goto L_0x022e
            java.lang.String r14 = "range"
            java.lang.String r15 = "neq"
            java.lang.String r8 = "lt"
            java.lang.String r9 = "le"
            java.lang.String r10 = "gt"
            java.lang.String r12 = "ge"
            java.lang.String r13 = "eq"
            r2 = 3244(0xcac, float:4.546E-42)
            if (r7 == r1) goto L_0x0165
            if (r7 == r11) goto L_0x0081
        L_0x007f:
            goto L_0x029d
        L_0x0081:
            r7 = 0
            if (r3 != 0) goto L_0x0085
            return r7
        L_0x0085:
            r16 = 0
            java.util.List<java.lang.String> r11 = r4.f3861c
            java.lang.Object r11 = r11.get(r7)
            java.lang.String r11 = (java.lang.String) r11
            java.util.Date r7 = com.userexperior.e.h.c(r11)
            long r18 = r7.getTime()
            java.lang.String r7 = r4.f3859a
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x00b1
            java.lang.String r7 = r4.f3859a
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = r6.toString()
            java.util.Date r6 = com.userexperior.e.h.c(r6)
            long r16 = r6.getTime()
        L_0x00b1:
            java.lang.String r6 = r4.f3860b
            int r7 = r6.hashCode()
            if (r7 == r2) goto L_0x0104
            r2 = 3294(0xcde, float:4.616E-42)
            if (r7 == r2) goto L_0x00fc
            r2 = 3309(0xced, float:4.637E-42)
            if (r7 == r2) goto L_0x00f4
            r2 = 3449(0xd79, float:4.833E-42)
            if (r7 == r2) goto L_0x00ec
            r2 = 3464(0xd88, float:4.854E-42)
            if (r7 == r2) goto L_0x00e4
            r2 = 108954(0x1a99a, float:1.52677E-40)
            if (r7 == r2) goto L_0x00dc
            r2 = 108280125(0x674393d, float:4.5933352E-35)
            if (r7 == r2) goto L_0x00d4
            goto L_0x010c
        L_0x00d4:
            boolean r2 = r6.equals(r14)
            if (r2 == 0) goto L_0x010c
            r10 = 6
            goto L_0x010d
        L_0x00dc:
            boolean r2 = r6.equals(r15)
            if (r2 == 0) goto L_0x010c
            r10 = 1
            goto L_0x010d
        L_0x00e4:
            boolean r2 = r6.equals(r8)
            if (r2 == 0) goto L_0x010c
            r10 = 3
            goto L_0x010d
        L_0x00ec:
            boolean r2 = r6.equals(r9)
            if (r2 == 0) goto L_0x010c
            r10 = 5
            goto L_0x010d
        L_0x00f4:
            boolean r2 = r6.equals(r10)
            if (r2 == 0) goto L_0x010c
            r10 = 2
            goto L_0x010d
        L_0x00fc:
            boolean r2 = r6.equals(r12)
            if (r2 == 0) goto L_0x010c
            r10 = 4
            goto L_0x010d
        L_0x0104:
            boolean r2 = r6.equals(r13)
            if (r2 == 0) goto L_0x010c
            r10 = 0
            goto L_0x010d
        L_0x010c:
            r10 = -1
        L_0x010d:
            switch(r10) {
                case 0: goto L_0x015f;
                case 1: goto L_0x0159;
                case 2: goto L_0x0153;
                case 3: goto L_0x014d;
                case 4: goto L_0x0147;
                case 5: goto L_0x0141;
                case 6: goto L_0x0112;
                default: goto L_0x0110;
            }
        L_0x0110:
            goto L_0x007f
        L_0x0112:
            java.util.List<java.lang.String> r2 = r4.f3861c
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Date r2 = com.userexperior.e.h.c(r2)
            long r2 = r2.getTime()
            java.util.List<java.lang.String> r4 = r4.f3861c
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            java.util.Date r4 = com.userexperior.e.h.c(r4)
            long r6 = r4.getTime()
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x013e
            int r2 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x013e
            r3 = 1
            goto L_0x029d
        L_0x013e:
            r3 = 0
            goto L_0x029d
        L_0x0141:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 > 0) goto L_0x0298
            goto L_0x0260
        L_0x0147:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 < 0) goto L_0x0298
            goto L_0x0260
        L_0x014d:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x0298
            goto L_0x0260
        L_0x0153:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 <= 0) goto L_0x0298
            goto L_0x0260
        L_0x0159:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0298
            goto L_0x0260
        L_0x015f:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0298
            goto L_0x0260
        L_0x0165:
            r7 = 0
            if (r3 != 0) goto L_0x0169
            return r7
        L_0x0169:
            r16 = 0
            java.util.List<java.lang.String> r11 = r4.f3861c
            java.lang.Object r11 = r11.get(r7)
            java.lang.String r11 = (java.lang.String) r11
            double r18 = java.lang.Double.parseDouble(r11)
            java.lang.String r7 = r4.f3859a
            boolean r7 = r6.containsKey(r7)
            if (r7 == 0) goto L_0x018d
            java.lang.String r7 = r4.f3859a
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = r6.toString()
            double r16 = java.lang.Double.parseDouble(r6)
        L_0x018d:
            java.lang.String r6 = r4.f3860b
            int r7 = r6.hashCode()
            if (r7 == r2) goto L_0x01e0
            r2 = 3294(0xcde, float:4.616E-42)
            if (r7 == r2) goto L_0x01d8
            r2 = 3309(0xced, float:4.637E-42)
            if (r7 == r2) goto L_0x01d0
            r2 = 3449(0xd79, float:4.833E-42)
            if (r7 == r2) goto L_0x01c8
            r2 = 3464(0xd88, float:4.854E-42)
            if (r7 == r2) goto L_0x01c0
            r2 = 108954(0x1a99a, float:1.52677E-40)
            if (r7 == r2) goto L_0x01b8
            r2 = 108280125(0x674393d, float:4.5933352E-35)
            if (r7 == r2) goto L_0x01b0
            goto L_0x01e8
        L_0x01b0:
            boolean r2 = r6.equals(r14)
            if (r2 == 0) goto L_0x01e8
            r10 = 6
            goto L_0x01e9
        L_0x01b8:
            boolean r2 = r6.equals(r15)
            if (r2 == 0) goto L_0x01e8
            r10 = 1
            goto L_0x01e9
        L_0x01c0:
            boolean r2 = r6.equals(r8)
            if (r2 == 0) goto L_0x01e8
            r10 = 3
            goto L_0x01e9
        L_0x01c8:
            boolean r2 = r6.equals(r9)
            if (r2 == 0) goto L_0x01e8
            r10 = 5
            goto L_0x01e9
        L_0x01d0:
            boolean r2 = r6.equals(r10)
            if (r2 == 0) goto L_0x01e8
            r10 = 2
            goto L_0x01e9
        L_0x01d8:
            boolean r2 = r6.equals(r12)
            if (r2 == 0) goto L_0x01e8
            r10 = 4
            goto L_0x01e9
        L_0x01e0:
            boolean r2 = r6.equals(r13)
            if (r2 == 0) goto L_0x01e8
            r10 = 0
            goto L_0x01e9
        L_0x01e8:
            r10 = -1
        L_0x01e9:
            switch(r10) {
                case 0: goto L_0x0229;
                case 1: goto L_0x0224;
                case 2: goto L_0x021f;
                case 3: goto L_0x021a;
                case 4: goto L_0x0215;
                case 5: goto L_0x0210;
                case 6: goto L_0x01ee;
                default: goto L_0x01ec;
            }
        L_0x01ec:
            goto L_0x0016
        L_0x01ee:
            java.util.List<java.lang.String> r2 = r4.f3861c
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            double r2 = java.lang.Double.parseDouble(r2)
            java.util.List<java.lang.String> r4 = r4.f3861c
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            double r6 = java.lang.Double.parseDouble(r4)
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0298
            int r2 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x0298
            goto L_0x0260
        L_0x0210:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 > 0) goto L_0x0298
            goto L_0x0260
        L_0x0215:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 < 0) goto L_0x0298
            goto L_0x0260
        L_0x021a:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x0298
            goto L_0x0260
        L_0x021f:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 <= 0) goto L_0x0298
            goto L_0x0260
        L_0x0224:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0298
            goto L_0x0260
        L_0x0229:
            int r2 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0298
            goto L_0x0260
        L_0x022e:
            java.lang.String r2 = r4.f3860b
            java.lang.String r7 = "is"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0264
            if (r3 != 0) goto L_0x023c
            r2 = 0
            return r2
        L_0x023c:
            java.util.List<java.lang.String> r2 = r4.f3861c
            java.util.Iterator r2 = r2.iterator()
        L_0x0242:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0016
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0262
            java.lang.String r7 = r4.f3859a
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = r7.toString()
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x0262
        L_0x0260:
            goto L_0x0015
        L_0x0262:
            r3 = 0
            goto L_0x0242
        L_0x0264:
            java.lang.String r2 = r4.f3860b
            java.lang.String r7 = "isnot"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x029d
            if (r3 != 0) goto L_0x0272
            r2 = 0
            return r2
        L_0x0272:
            java.util.List<java.lang.String> r2 = r4.f3861c
            java.util.Iterator r2 = r2.iterator()
        L_0x0278:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0016
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0298
            java.lang.String r7 = r4.f3859a
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = r7.toString()
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0298
            r3 = 1
            goto L_0x0278
        L_0x0298:
            r3 = 0
            goto L_0x0016
        L_0x029b:
            r2 = 0
            return r2
        L_0x029d:
            r2 = 0
            goto L_0x0016
        L_0x02a0:
            r5 = r20
            r2 = 0
            goto L_0x02a8
        L_0x02a4:
            r5 = r20
            r2 = 0
            r3 = 1
        L_0x02a8:
            if (r3 == 0) goto L_0x02ab
            return r1
        L_0x02ab:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.c.a.b.c(com.userexperior.c.b.b):boolean");
    }

    private boolean d(com.userexperior.c.b.b bVar) {
        boolean z;
        boolean z2;
        Object obj;
        List<g> list = bVar != null ? bVar.f3837c : null;
        HashMap hashMap = new HashMap();
        List<a> list2 = this.f3802b;
        if (list2 != null) {
            for (a next : list2) {
                if (next.f3796b == h.TAG) {
                    obj = next.f3797c;
                    if (obj == null) {
                        obj = null;
                    }
                    String str = next.f3798d;
                    if (str != null) {
                        obj = str;
                    }
                } else {
                    obj = null;
                }
                if (obj != null && !hashMap.containsKey(obj)) {
                    hashMap.put(obj, obj);
                }
            }
        }
        if (list != null && !list.isEmpty()) {
            z2 = true;
            z = true;
            for (g gVar : list) {
                if (gVar != null) {
                    if (!gVar.f3855a.equals("is")) {
                        if (gVar.f3855a.equals("isnot")) {
                            if (z) {
                                Iterator<String> it = gVar.f3856b.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String next2 = it.next();
                                    if (next2 == null || hashMap.containsKey(next2)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                }
                            } else {
                                return false;
                            }
                        } else {
                            continue;
                        }
                    } else if (z2) {
                        Iterator<String> it2 = gVar.f3856b.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            String next3 = it2.next();
                            if (next3 != null && hashMap.containsKey(next3)) {
                                z2 = true;
                                break;
                            }
                            z2 = false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        } else {
            z2 = true;
            z = true;
        }
        return z2 && z;
    }

    public static boolean e(com.userexperior.c.b.b bVar) {
        boolean z;
        boolean z2;
        Context a2 = com.userexperior.utilities.a.a();
        String i2 = l.i(a2);
        if (i2 == null) {
            i2 = l.g(a2);
        }
        List<com.userexperior.c.b.b.h> list = null;
        if (bVar != null) {
            list = bVar.f3835a;
        }
        if (list == null || list.isEmpty() || i2 == null) {
            z2 = true;
            z = true;
        } else {
            z2 = true;
            z = true;
            for (com.userexperior.c.b.b.h next : list) {
                if (next != null) {
                    if (next.f3857a.equals("is")) {
                        Iterator<String> it = next.f3858b.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            String next2 = it.next();
                            if (next2 != null && next2.equals(i2)) {
                                z2 = true;
                                break;
                            }
                        }
                    } else if (next.f3857a.equals("isnot")) {
                        Iterator<String> it2 = next.f3858b.iterator();
                        boolean z3 = false;
                        while (true) {
                            if (!it2.hasNext()) {
                                z = z3;
                                break;
                            }
                            String next3 = it2.next();
                            if (next3 == null || next3.equals(i2)) {
                                z = false;
                            } else {
                                z3 = true;
                            }
                        }
                        z = false;
                    }
                }
            }
        }
        return z2 && z;
    }

    private boolean f(com.userexperior.c.b.b bVar) {
        boolean z;
        boolean z2;
        HashMap hashMap = new HashMap();
        List<a> list = this.f3802b;
        if (list != null) {
            for (a aVar : list) {
                String str = aVar.i;
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, str);
                }
            }
        }
        List<com.userexperior.c.b.b.f> list2 = null;
        if (bVar != null) {
            list2 = bVar.f3836b;
        }
        if (list2 != null && !list2.isEmpty()) {
            z2 = true;
            z = true;
            for (com.userexperior.c.b.b.f next : list2) {
                if (next != null) {
                    if (!next.f3853a.equals("is")) {
                        if (next.f3853a.equals("isnot")) {
                            if (z) {
                                Iterator<String> it = next.f3854b.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String next2 = it.next();
                                    if (next2 == null || hashMap.containsKey(next2)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                }
                            } else {
                                return false;
                            }
                        } else {
                            continue;
                        }
                    } else if (z2) {
                        Iterator<String> it2 = next.f3854b.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            String next3 = it2.next();
                            if (next3 != null && hashMap.containsKey(next3)) {
                                z2 = true;
                                break;
                            }
                            z2 = false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        } else {
            z2 = true;
            z = true;
        }
        return z2 && z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x015b, code lost:
        if (r9 >= r11) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0164, code lost:
        if (r9 < r11) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x016d, code lost:
        if (r9 > r11) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0172, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x017b, code lost:
        if (r9 == r11) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0149, code lost:
        if (r9 <= r11) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0152, code lost:
        if (r9 <= r11) goto L_0x016f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(com.userexperior.c.b.b r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.List<com.userexperior.c.a.e> r4 = r0.f3804d
            if (r4 == 0) goto L_0x0039
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0039
            java.util.List<com.userexperior.c.a.e> r4 = r0.f3804d
            java.util.Iterator r4 = r4.iterator()
        L_0x001e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0039
            java.lang.Object r5 = r4.next()
            com.userexperior.c.a.e r5 = (com.userexperior.c.a.e) r5
            java.lang.String r6 = r5.f3815a
            r2.put(r6, r6)
            int r5 = r5.f3816b
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.put(r6, r5)
            goto L_0x001e
        L_0x0039:
            r4 = 0
            if (r1 == 0) goto L_0x003e
            java.util.List<com.userexperior.c.b.b.a> r4 = r1.f3840f
        L_0x003e:
            r1 = 1
            if (r4 == 0) goto L_0x0186
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x0186
            java.util.List<com.userexperior.c.a.e> r5 = r0.f3804d
            r6 = 0
            if (r5 == 0) goto L_0x0185
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0054
            goto L_0x0185
        L_0x0054:
            java.util.Iterator r4 = r4.iterator()
            r5 = 1
        L_0x0059:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x0183
            java.lang.Object r7 = r4.next()
            com.userexperior.c.b.b.a r7 = (com.userexperior.c.b.b.a) r7
            if (r5 != 0) goto L_0x0068
            return r6
        L_0x0068:
            com.userexperior.c.b.a.c r8 = r7.f3842b
            java.util.List<java.lang.String> r9 = r7.f3841a
            java.util.Iterator r9 = r9.iterator()
        L_0x0070:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x008a
            java.lang.Object r5 = r9.next()
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0088
            boolean r5 = r2.containsKey(r5)
            if (r5 == 0) goto L_0x0088
            r5 = 1
            if (r8 != 0) goto L_0x0070
            goto L_0x0059
        L_0x0088:
            r5 = 0
            goto L_0x0070
        L_0x008a:
            java.util.List<java.lang.String> r7 = r7.f3841a
            java.util.Iterator r7 = r7.iterator()
        L_0x0090:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0059
            java.lang.Object r9 = r7.next()
            java.lang.String r9 = (java.lang.String) r9
            if (r8 == 0) goto L_0x0180
            boolean r10 = r3.containsKey(r9)
            if (r10 == 0) goto L_0x0180
            java.lang.Object r9 = r3.get(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            long r9 = (long) r9
            java.lang.String r11 = r8.f3833b
            long r11 = java.lang.Long.parseLong(r11)
            r13 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r13
            r13 = 0
            int r15 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x0180
            java.lang.String r13 = r8.f3832a
            int r15 = r13.hashCode()
            r14 = 3244(0xcac, float:4.546E-42)
            r6 = 2
            if (r15 == r14) goto L_0x0112
            r14 = 3294(0xcde, float:4.616E-42)
            if (r15 == r14) goto L_0x0108
            r14 = 3309(0xced, float:4.637E-42)
            if (r15 == r14) goto L_0x00fe
            r14 = 3449(0xd79, float:4.833E-42)
            if (r15 == r14) goto L_0x00f4
            r14 = 3464(0xd88, float:4.854E-42)
            if (r15 == r14) goto L_0x00ea
            r14 = 108280125(0x674393d, float:4.5933352E-35)
            if (r15 == r14) goto L_0x00e0
            goto L_0x011c
        L_0x00e0:
            java.lang.String r14 = "range"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x011c
            r14 = 5
            goto L_0x011d
        L_0x00ea:
            java.lang.String r14 = "lt"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x011c
            r14 = 2
            goto L_0x011d
        L_0x00f4:
            java.lang.String r14 = "le"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x011c
            r14 = 4
            goto L_0x011d
        L_0x00fe:
            java.lang.String r14 = "gt"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x011c
            r14 = 1
            goto L_0x011d
        L_0x0108:
            java.lang.String r14 = "ge"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x011c
            r14 = 3
            goto L_0x011d
        L_0x0112:
            java.lang.String r14 = "eq"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x011c
            r14 = 0
            goto L_0x011d
        L_0x011c:
            r14 = -1
        L_0x011d:
            if (r14 == 0) goto L_0x0175
            if (r14 == r1) goto L_0x0167
            if (r14 == r6) goto L_0x015e
            r6 = 3
            if (r14 == r6) goto L_0x0155
            r6 = 4
            if (r14 == r6) goto L_0x014c
            r6 = 5
            if (r14 == r6) goto L_0x012d
            goto L_0x0180
        L_0x012d:
            if (r5 != 0) goto L_0x0131
            r5 = 0
            return r5
        L_0x0131:
            java.lang.String r5 = r8.f3833b
            int r5 = java.lang.Integer.parseInt(r5)
            int r5 = r5 * 1000
            long r5 = (long) r5
            java.lang.String r11 = r8.f3834c
            int r11 = java.lang.Integer.parseInt(r11)
            int r11 = r11 * 1000
            long r11 = (long) r11
            int r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r13 < 0) goto L_0x017f
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 > 0) goto L_0x017f
            goto L_0x017d
        L_0x014c:
            r6 = 0
            if (r5 != 0) goto L_0x0150
            return r6
        L_0x0150:
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 > 0) goto L_0x0172
            goto L_0x016f
        L_0x0155:
            r6 = 0
            if (r5 != 0) goto L_0x0159
            return r6
        L_0x0159:
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x0172
            goto L_0x016f
        L_0x015e:
            r6 = 0
            if (r5 != 0) goto L_0x0162
            return r6
        L_0x0162:
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 >= 0) goto L_0x0172
            goto L_0x016f
        L_0x0167:
            r6 = 0
            if (r5 != 0) goto L_0x016b
            return r6
        L_0x016b:
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x0172
        L_0x016f:
            r5 = 1
            goto L_0x0090
        L_0x0172:
            r5 = 0
            goto L_0x0090
        L_0x0175:
            r6 = 0
            if (r5 != 0) goto L_0x0179
            return r6
        L_0x0179:
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x017f
        L_0x017d:
            r5 = 1
            goto L_0x0180
        L_0x017f:
            r5 = 0
        L_0x0180:
            r6 = 0
            goto L_0x0090
        L_0x0183:
            r1 = r5
            goto L_0x0186
        L_0x0185:
            r1 = 0
        L_0x0186:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.c.a.b.g(com.userexperior.c.b.b):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0200 A[EDGE_INSN: B:107:0x0200->B:99:0x0200 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010f A[SYNTHETIC, Splitter:B:53:0x010f] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013e A[SYNTHETIC, Splitter:B:62:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014f A[SYNTHETIC, Splitter:B:69:0x014f] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01d4  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x00f0=Splitter:B:50:0x00f0, B:59:0x011f=Splitter:B:59:0x011f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(android.content.Context r11, java.lang.String r12, com.userexperior.models.recording.f r13) {
        /*
            r10 = this;
            com.userexperior.a.a.h r0 = new com.userexperior.a.a.h
            r0.<init>()
            r1 = 1
            r0.f3753c = r1
            r1 = 0
            r0.f3751a = r1
            com.userexperior.a.a.f r0 = r0.a()
            if (r12 != 0) goto L_0x0025
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r2 = com.userexperior.utilities.j.i(r11)
            r12.append(r2)
            java.lang.String r2 = java.io.File.separator
            java.lang.String r3 = "events.json"
            java.lang.String r12 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r12, r2, r3)
        L_0x0025:
            r2 = 0
            if (r13 == 0) goto L_0x0270
            java.lang.String r3 = "UserExperior"
            java.lang.String r4 = "ex : ECR - getECR2 finally: "
            if (r12 == 0) goto L_0x016d
            com.userexperior.c.a.b$2 r5 = new com.userexperior.c.a.b$2     // Catch:{ FileNotFoundException -> 0x011d, Exception -> 0x00ee, all -> 0x00ec }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x011d, Exception -> 0x00ee, all -> 0x00ec }
            java.lang.reflect.Type r5 = r5.f3726b     // Catch:{ FileNotFoundException -> 0x011d, Exception -> 0x00ee, all -> 0x00ec }
            java.io.FileReader r6 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x011d, Exception -> 0x00ee, all -> 0x00ec }
            java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x011d, Exception -> 0x00ee, all -> 0x00ec }
            r7.<init>(r12)     // Catch:{ FileNotFoundException -> 0x011d, Exception -> 0x00ee, all -> 0x00ec }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x011d, Exception -> 0x00ee, all -> 0x00ec }
            com.userexperior.c.a.b$3 r7 = new com.userexperior.c.a.b$3     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.lang.reflect.Type r7 = r7.f3726b     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.lang.Object r7 = r0.a(r6, r7)     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            if (r7 == 0) goto L_0x0061
            boolean r7 = r7.isEmpty()     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            if (r7 != 0) goto L_0x0061
            java.util.HashMap<java.lang.String, com.userexperior.c.a.e> r7 = r13.v     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            if (r7 == 0) goto L_0x0061
            java.util.List<com.userexperior.c.a.e> r8 = r10.f3804d     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.util.Collection r7 = r7.values()     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            r8.addAll(r7)     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
        L_0x0061:
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r13.u     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            if (r7 == 0) goto L_0x0068
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r13.u     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            goto L_0x0085
        L_0x0068:
            android.content.SharedPreferences r7 = r11.getSharedPreferences(r3, r1)     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.lang.String r8 = "userProp"
            java.lang.String r7 = r7.getString(r8, r2)     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            com.userexperior.a.a.f r8 = new com.userexperior.a.a.f     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            com.userexperior.utilities.l$1 r9 = new com.userexperior.utilities.l$1     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.lang.reflect.Type r9 = r9.f3726b     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.lang.Object r7 = r8.a(r7, r9)     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.util.HashMap r7 = (java.util.HashMap) r7     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
        L_0x0085:
            r10.g = r7     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.lang.String r7 = r13.f4087d     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.io.FileReader r8 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            java.io.File r9 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            r9.<init>(r12)     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            r8.<init>(r9)     // Catch:{ FileNotFoundException -> 0x00ea, Exception -> 0x00e8 }
            boolean r6 = r13.s     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            if (r6 != 0) goto L_0x00d3
            if (r7 == 0) goto L_0x00d3
            java.lang.String r6 = "4"
            boolean r6 = r7.equals(r6)     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            if (r6 != 0) goto L_0x00a9
            java.lang.String r6 = "2"
            boolean r6 = r7.equals(r6)     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            if (r6 == 0) goto L_0x00d3
        L_0x00a9:
            java.lang.Object r5 = r0.a(r8, r5)     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            java.util.List r5 = (java.util.List) r5     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            boolean r5 = r10.a(r5, r13)     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            if (r5 != 0) goto L_0x016e
            r8.close()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x00d2
        L_0x00b9:
            r11 = move-exception
            java.util.logging.Level r12 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r4)
            java.lang.String r0 = r11.getMessage()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            com.userexperior.utilities.b.a(r12, r13)
            r11.printStackTrace()
        L_0x00d2:
            return r2
        L_0x00d3:
            java.lang.Object r5 = r0.a(r8, r5)     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            java.util.List r5 = (java.util.List) r5     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            r10.a(r5)     // Catch:{ FileNotFoundException -> 0x00e5, Exception -> 0x00e2, all -> 0x00de }
            goto L_0x016e
        L_0x00de:
            r11 = move-exception
            r2 = r8
            goto L_0x014d
        L_0x00e2:
            r5 = move-exception
            r6 = r8
            goto L_0x00f0
        L_0x00e5:
            r5 = move-exception
            r6 = r8
            goto L_0x011f
        L_0x00e8:
            r5 = move-exception
            goto L_0x00f0
        L_0x00ea:
            r5 = move-exception
            goto L_0x011f
        L_0x00ec:
            r11 = move-exception
            goto L_0x014d
        L_0x00ee:
            r5 = move-exception
            r6 = r2
        L_0x00f0:
            java.util.logging.Level r7 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            java.lang.String r9 = "ex : ECR - getECR2 EX: "
            r8.<init>(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r5.getMessage()     // Catch:{ all -> 0x014b }
            r8.append(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x014b }
            com.userexperior.utilities.b.a(r7, r8)     // Catch:{ all -> 0x014b }
            r5.getMessage()     // Catch:{ all -> 0x014b }
            r5.printStackTrace()     // Catch:{ all -> 0x014b }
            if (r6 == 0) goto L_0x018d
            r6.close()     // Catch:{ IOException -> 0x0114 }
            goto L_0x018d
        L_0x0114:
            r5 = move-exception
            java.util.logging.Level r6 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            goto L_0x017c
        L_0x011d:
            r5 = move-exception
            r6 = r2
        L_0x011f:
            java.util.logging.Level r7 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            java.lang.String r9 = "ex : ECR - getECR2 FNFE: "
            r8.<init>(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r5.getMessage()     // Catch:{ all -> 0x014b }
            r8.append(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x014b }
            com.userexperior.utilities.b.a(r7, r8)     // Catch:{ all -> 0x014b }
            r5.printStackTrace()     // Catch:{ all -> 0x014b }
            r5.getMessage()     // Catch:{ all -> 0x014b }
            if (r6 == 0) goto L_0x018d
            r6.close()     // Catch:{ IOException -> 0x0142 }
            goto L_0x018d
        L_0x0142:
            r5 = move-exception
            java.util.logging.Level r6 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            goto L_0x017c
        L_0x014b:
            r11 = move-exception
            r2 = r6
        L_0x014d:
            if (r2 == 0) goto L_0x016c
            r2.close()     // Catch:{ IOException -> 0x0153 }
            goto L_0x016c
        L_0x0153:
            r12 = move-exception
            java.util.logging.Level r13 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.String r1 = r12.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.userexperior.utilities.b.a(r13, r0)
            r12.printStackTrace()
        L_0x016c:
            throw r11
        L_0x016d:
            r8 = r2
        L_0x016e:
            if (r8 == 0) goto L_0x018d
            r8.close()     // Catch:{ IOException -> 0x0174 }
            goto L_0x018d
        L_0x0174:
            r5 = move-exception
            java.util.logging.Level r6 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
        L_0x017c:
            java.lang.String r4 = r5.getMessage()
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            com.userexperior.utilities.b.a(r6, r4)
            r5.printStackTrace()
        L_0x018d:
            boolean r4 = r13.k
            r10.f3805e = r4
            com.userexperior.c.c.a r4 = r13.t
            if (r4 == 0) goto L_0x0196
            goto L_0x019f
        L_0x0196:
            com.userexperior.c.c.a r4 = new com.userexperior.c.c.a
            r4.<init>()
            com.userexperior.c.c.a r4 = r4.a(r11)
        L_0x019f:
            r10.f3806f = r4
            com.userexperior.models.recording.enums.g r4 = com.userexperior.utilities.j.h(r11)
            com.userexperior.models.recording.enums.e r5 = com.userexperior.utilities.j.g(r11)
            com.userexperior.c.c.b r6 = new com.userexperior.c.c.b
            java.lang.String r7 = "webp"
            r6.<init>(r4, r5, r7)
            r10.h = r6
            java.lang.String r4 = r13.o
            if (r4 == 0) goto L_0x01ba
            r10.i = r4
            goto L_0x01be
        L_0x01ba:
            java.lang.String r5 = "NA"
            r10.i = r5
        L_0x01be:
            java.util.List<com.userexperior.c.a.a> r5 = r10.f3802b
            if (r5 == 0) goto L_0x0200
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0200
            java.util.List<com.userexperior.c.a.a> r5 = r10.f3802b
            java.util.Iterator r5 = r5.iterator()
        L_0x01ce:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0200
            java.lang.Object r6 = r5.next()
            com.userexperior.c.a.a r6 = (com.userexperior.c.a.a) r6
            com.userexperior.models.recording.enums.h r6 = r6.f3796b
            com.userexperior.models.recording.enums.h r7 = com.userexperior.models.recording.enums.h.EXCEPTION
            if (r6 != r7) goto L_0x01ce
            if (r4 != 0) goto L_0x01ce
            java.io.File r4 = new java.io.File
            java.lang.String r5 = r13.f4086c
            r4.<init>(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.getName()
            r5.append(r4)
            java.lang.String r4 = ".log"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r10.i = r4
        L_0x0200:
            java.lang.String r4 = r13.j
            r10.j = r4
            long r4 = r13.f4089f
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x021e
            java.io.File r4 = new java.io.File
            r4.<init>(r12)
            java.util.Date r12 = new java.util.Date
            long r4 = r4.lastModified()
            r12.<init>(r4)
            long r4 = r12.getTime()
        L_0x021e:
            r10.k = r4
            long r4 = r13.g
            r10.u = r4
            long r4 = r13.h
            int r12 = (int) r4
            r10.l = r12
            java.lang.String r12 = r13.f4084a
            r10.m = r12
            java.lang.String r12 = r13.w
            r10.n = r12
            java.lang.String r12 = r13.x
            r10.o = r12
            boolean r12 = r13.s
            r10.s = r12
            java.lang.String r12 = r13.m
            r10.p = r12
            java.lang.String r12 = r13.n
            r10.q = r12
            android.content.SharedPreferences r11 = r11.getSharedPreferences(r3, r1)
            java.lang.String r12 = "__ue_paused_image_list"
            java.lang.String r11 = r11.getString(r12, r2)
            com.userexperior.a.a.f r12 = new com.userexperior.a.a.f
            r12.<init>()
            com.userexperior.utilities.l$3 r1 = new com.userexperior.utilities.l$3
            r1.<init>()
            java.lang.reflect.Type r1 = r1.f3726b
            java.lang.Object r11 = r12.a(r11, r1)
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            r10.f3803c = r11
            com.userexperior.c.a.d r11 = r13.y
            r10.v = r11
            java.lang.String r11 = r0.a(r10)
            java.lang.String r12 = "\\\\"
            java.lang.String r13 = "\\"
            java.lang.String r11 = r11.replace(r12, r13)
            return r11
        L_0x0270:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.c.a.b.a(android.content.Context, java.lang.String, com.userexperior.models.recording.f):java.lang.String");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f3802b);
        parcel.writeTypedList(this.f3804d);
        parcel.writeByte(this.f3805e ? (byte) 1 : 0);
        parcel.writeByte(this.r ? (byte) 1 : 0);
        parcel.writeByte(this.s ? (byte) 1 : 0);
        parcel.writeByte(this.t ? (byte) 1 : 0);
        parcel.writeParcelable(this.f3806f, i2);
        parcel.writeParcelable(this.h, i2);
        String str = this.i;
        String str2 = AnalyticsConstants.NOT_AVAILABLE;
        if (str == null) {
            str = str2;
        }
        parcel.writeString(str);
        String str3 = this.j;
        if (str3 == null) {
            str3 = str2;
        }
        parcel.writeString(str3);
        parcel.writeLong(this.k);
        parcel.writeLong(this.u);
        parcel.writeLong(this.w);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        String str4 = this.p;
        if (str4 == null) {
            str4 = str2;
        }
        parcel.writeString(str4);
        String str5 = this.q;
        if (str5 != null) {
            str2 = str5;
        }
        parcel.writeString(str2);
        parcel.writeList(this.f3803c);
        parcel.writeParcelable(this.v, i2);
    }
}
