package io.hansel.userjourney.prompts;

import android.view.View;
import com.paynimo.android.payment.PaymentActivity;
import com.userexperior.e.h;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.userjourney.n;
import io.hansel.userjourney.q;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public class k {
    public o0 A;
    public n0 B;
    public g0 C;
    public j0 D;
    public IMessageBroker E;
    public WeakReference<View> F;
    public d0 G;
    public boolean H;
    public long I;
    public String J = "anchorView";
    public String K = "decorView";
    public String L = "anchorPointOnScreenX";
    public String M = "anchorPointOnScreenY";
    public boolean N;

    /* renamed from: a  reason: collision with root package name */
    public final l f5562a;

    /* renamed from: b  reason: collision with root package name */
    public d0 f5563b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f5564c;

    /* renamed from: d  reason: collision with root package name */
    public int f5565d;

    /* renamed from: e  reason: collision with root package name */
    public int f5566e;

    /* renamed from: f  reason: collision with root package name */
    public int f5567f;
    public double g;
    public double h;
    public int i;
    public int j;
    public a k;
    public p l;
    public o m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public CoreJSONObject u;
    public f v;
    public u w;
    public WeakReference<View> x;
    public int y;
    public int z;

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cb, code lost:
        if (r7.equals("circle_1") == false) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0036, code lost:
        r0 = io.hansel.userjourney.prompts.g0.f5545c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0044, code lost:
        if (r10.equals(r0.name().toLowerCase()) != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0156, code lost:
        if (r8.equals("pillTop") == false) goto L_0x0158;
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0158 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k(java.lang.String r6, java.lang.String r7, java.lang.String r8, io.hansel.core.json.CoreJSONObject r9, java.lang.String r10) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            r5.f5563b = r0
            java.lang.String r1 = "anchorView"
            r5.J = r1
            java.lang.String r1 = "decorView"
            r5.K = r1
            java.lang.String r1 = "anchorPointOnScreenX"
            r5.L = r1
            java.lang.String r1 = "anchorPointOnScreenY"
            r5.M = r1
            r1 = 0
            r5.N = r1
            r5.l = r0
            io.hansel.userjourney.prompts.u r0 = io.hansel.userjourney.prompts.u.NONE
            r5.w = r0
            io.hansel.userjourney.prompts.g0 r0 = io.hansel.userjourney.prompts.g0.NORMAL
            r5.C = r0
            io.hansel.userjourney.prompts.g0 r0 = io.hansel.userjourney.prompts.g0.PERSISTENT
            java.lang.String r2 = r0.name()
            java.lang.String r2 = r2.toLowerCase()
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x0036
        L_0x0033:
            r5.C = r0
            goto L_0x0047
        L_0x0036:
            io.hansel.userjourney.prompts.g0 r0 = io.hansel.userjourney.prompts.g0.INVISIBLE
            java.lang.String r2 = r0.name()
            java.lang.String r2 = r2.toLowerCase()
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0047
            goto L_0x0033
        L_0x0047:
            r6.hashCode()
            int r10 = r6.hashCode()
            r0 = -1
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r10) {
                case -1140076541: goto L_0x0079;
                case -919958188: goto L_0x006d;
                case 114586: goto L_0x0061;
                case 1099603663: goto L_0x0056;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x0085
        L_0x0056:
            java.lang.String r10 = "hotspot"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x005f
            goto L_0x0085
        L_0x005f:
            r6 = 3
            goto L_0x0086
        L_0x0061:
            java.lang.String r10 = "tag"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x006b
            goto L_0x0085
        L_0x006b:
            r6 = 2
            goto L_0x0086
        L_0x006d:
            java.lang.String r10 = "spotlight"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x0077
            goto L_0x0085
        L_0x0077:
            r6 = 1
            goto L_0x0086
        L_0x0079:
            java.lang.String r10 = "tooltip"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r6 = 0
            goto L_0x0086
        L_0x0085:
            r6 = -1
        L_0x0086:
            if (r6 == 0) goto L_0x016b
            if (r6 == r4) goto L_0x0104
            if (r6 == r3) goto L_0x00e4
            if (r6 == r2) goto L_0x0094
            io.hansel.userjourney.prompts.l r6 = io.hansel.userjourney.prompts.l.NONE
            r5.f5562a = r6
            goto L_0x0177
        L_0x0094:
            io.hansel.userjourney.prompts.l r6 = io.hansel.userjourney.prompts.l.HOTSPOT
            r5.f5562a = r6
            r7.hashCode()
            int r6 = r7.hashCode()
            switch(r6) {
                case -1498360702: goto L_0x00c5;
                case -1498360701: goto L_0x00ba;
                case -1165870106: goto L_0x00af;
                case 3540562: goto L_0x00a3;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            goto L_0x00cd
        L_0x00a3:
            java.lang.String r6 = "star"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x00ad
            goto L_0x00cd
        L_0x00ad:
            r1 = 3
            goto L_0x00ce
        L_0x00af:
            java.lang.String r6 = "question"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x00b8
            goto L_0x00cd
        L_0x00b8:
            r1 = 2
            goto L_0x00ce
        L_0x00ba:
            java.lang.String r6 = "circle_2"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x00c3
            goto L_0x00cd
        L_0x00c3:
            r1 = 1
            goto L_0x00ce
        L_0x00c5:
            java.lang.String r6 = "circle_1"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x00ce
        L_0x00cd:
            r1 = -1
        L_0x00ce:
            if (r1 == 0) goto L_0x00de
            if (r1 == r4) goto L_0x00de
            if (r1 == r3) goto L_0x00db
            if (r1 == r2) goto L_0x00d8
            goto L_0x0177
        L_0x00d8:
            io.hansel.userjourney.prompts.p r6 = io.hansel.userjourney.prompts.p.HOTSPOT_STAR
            goto L_0x00e0
        L_0x00db:
            io.hansel.userjourney.prompts.p r6 = io.hansel.userjourney.prompts.p.HOTSPOT_QUESTION
            goto L_0x00e0
        L_0x00de:
            io.hansel.userjourney.prompts.p r6 = io.hansel.userjourney.prompts.p.HOTSPOT_OTHER
        L_0x00e0:
            r5.l = r6
            goto L_0x0177
        L_0x00e4:
            io.hansel.userjourney.prompts.l r6 = io.hansel.userjourney.prompts.l.TAG
            r5.f5562a = r6
            java.lang.String r6 = "position"
            java.lang.String r7 = ""
            java.lang.String r6 = r9.optString(r6, r7)
            io.hansel.userjourney.prompts.o0 r6 = r5.b(r6)
            r5.A = r6
            java.lang.String r6 = "align"
            java.lang.String r6 = r9.optString(r6, r7)
            io.hansel.userjourney.prompts.n0 r6 = r5.a(r6)
            r5.B = r6
            goto L_0x0177
        L_0x0104:
            io.hansel.userjourney.prompts.l r6 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            r5.f5562a = r6
            r7.hashCode()
            java.lang.String r6 = "circle"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x0120
            java.lang.String r6 = "square"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x011d
            goto L_0x0124
        L_0x011d:
            io.hansel.userjourney.prompts.p r6 = io.hansel.userjourney.prompts.p.SPOTLIGHT_RECTANGLE
            goto L_0x0122
        L_0x0120:
            io.hansel.userjourney.prompts.p r6 = io.hansel.userjourney.prompts.p.SPOTLIGHT_CIRCLE
        L_0x0122:
            r5.l = r6
        L_0x0124:
            r8.hashCode()
            int r6 = r8.hashCode()
            switch(r6) {
                case -569700004: goto L_0x0150;
                case 108704142: goto L_0x0145;
                case 110066619: goto L_0x013a;
                case 1262844100: goto L_0x012f;
                default: goto L_0x012e;
            }
        L_0x012e:
            goto L_0x0158
        L_0x012f:
            java.lang.String r6 = "pillBottom"
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L_0x0138
            goto L_0x0158
        L_0x0138:
            r1 = 3
            goto L_0x0159
        L_0x013a:
            java.lang.String r6 = "fullscreen"
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L_0x0143
            goto L_0x0158
        L_0x0143:
            r1 = 2
            goto L_0x0159
        L_0x0145:
            java.lang.String r6 = "round"
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L_0x014e
            goto L_0x0158
        L_0x014e:
            r1 = 1
            goto L_0x0159
        L_0x0150:
            java.lang.String r6 = "pillTop"
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L_0x0159
        L_0x0158:
            r1 = -1
        L_0x0159:
            if (r1 == 0) goto L_0x0168
            if (r1 == r4) goto L_0x0165
            if (r1 == r3) goto L_0x0173
            if (r1 == r2) goto L_0x0162
            goto L_0x0177
        L_0x0162:
            io.hansel.userjourney.prompts.o r6 = io.hansel.userjourney.prompts.o.PILLBOTTOM
            goto L_0x0175
        L_0x0165:
            io.hansel.userjourney.prompts.o r6 = io.hansel.userjourney.prompts.o.ROUND
            goto L_0x0175
        L_0x0168:
            io.hansel.userjourney.prompts.o r6 = io.hansel.userjourney.prompts.o.PILLTOP
            goto L_0x0175
        L_0x016b:
            io.hansel.userjourney.prompts.l r6 = io.hansel.userjourney.prompts.l.TOOLTIP
            r5.f5562a = r6
            io.hansel.userjourney.prompts.p r6 = io.hansel.userjourney.prompts.p.SPOTLIGHT_RECTANGLE
            r5.l = r6
        L_0x0173:
            io.hansel.userjourney.prompts.o r6 = io.hansel.userjourney.prompts.o.FULLSCREEN
        L_0x0175:
            r5.m = r6
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.k.<init>(java.lang.String, java.lang.String, java.lang.String, io.hansel.core.json.CoreJSONObject, java.lang.String):void");
    }

    private void N() {
        try {
            CoreJSONObject coreJSONObject = new CoreJSONObject();
            q.a((View) this.x.get(), coreJSONObject);
            a(coreJSONObject);
        } catch (Exception unused) {
            HSLLogger.e("anchorView is null");
            a(new CoreJSONObject());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.hansel.userjourney.prompts.k a(android.app.Activity r14, io.hansel.core.json.CoreJSONObject r15, io.hansel.userjourney.prompts.f r16, java.lang.String r17, io.hansel.core.module.IMessageBroker r18) {
        /*
            r1 = r15
            java.lang.String r0 = "delay"
            r2 = 0
            long r2 = r15.optLong(r0, r2)
            java.lang.String r0 = "changes"
            io.hansel.core.json.CoreJSONObject r0 = r15.optJSONObject(r0)
            r4 = 0
            java.lang.String r5 = "prompt"
            io.hansel.core.json.CoreJSONObject r5 = r0.getJSONObject(r5)     // Catch:{ CoreJSONException -> 0x001f }
            java.lang.String r0 = "props"
            io.hansel.core.json.CoreJSONObject r0 = r5.getJSONObject(r0)     // Catch:{ CoreJSONException -> 0x001d }
            goto L_0x0025
        L_0x001d:
            r0 = move-exception
            goto L_0x0021
        L_0x001f:
            r0 = move-exception
            r5 = r4
        L_0x0021:
            r0.printStackTrace()
            r0 = r5
        L_0x0025:
            r5 = 1
            java.lang.String r6 = "backdropStyle"
            java.lang.String r7 = "fullscreen"
            java.lang.String r9 = r0.optString(r6, r7)
            java.lang.String r12 = "nudge_props"
            boolean r6 = r0.has(r12)
            if (r6 == 0) goto L_0x004f
            io.hansel.core.json.CoreJSONObject r4 = r0.optJSONObject(r12)
            java.lang.String r5 = "style"
            java.lang.String r6 = "square"
            java.lang.String r5 = r4.optString(r5, r6)
            r6 = 4
            java.lang.String r7 = "spotlightOuterCircleScale"
            int r4 = r4.optInt(r7, r6)
            r8 = r5
            r5 = r4
            goto L_0x0050
        L_0x004f:
            r8 = r4
        L_0x0050:
            io.hansel.userjourney.prompts.k r4 = new io.hansel.userjourney.prompts.k
            java.lang.String r6 = "nudge_type"
            java.lang.String r13 = ""
            java.lang.String r7 = r0.optString(r6, r13)
            r6 = r4
            r10 = r0
            r11 = r17
            r6.<init>(r7, r8, r9, r10, r11)
            java.lang.String r6 = "pos_x"
            r7 = 0
            double r9 = r0.optDouble(r6, r7)
            r4.a(r9)
            java.lang.String r6 = "pos_y"
            double r6 = r0.optDouble(r6, r7)
            r4.b(r6)
            io.hansel.core.json.CoreJSONObject r6 = r0.optJSONObject(r12)
            r4.b(r6)
            java.lang.String r6 = "element_identifier"
            java.lang.String r6 = r0.optString(r6, r13)
            r4.c(r6)
            java.lang.String r6 = "screen"
            java.lang.String r6 = r0.optString(r6, r13)
            r4.d(r6)
            r6 = r16
            r4.a(r6)
            r4.c(r5)
            java.lang.String r5 = "nudgePosition"
            java.lang.String r6 = "auto"
            java.lang.String r0 = r0.optString(r5, r6)
            java.lang.String r0 = r0.toUpperCase()
            io.hansel.userjourney.prompts.d0 r0 = io.hansel.userjourney.prompts.d0.valueOf(r0)
            r4.b(r0)
            r5 = r18
            r4.E = r5
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            android.view.Window r5 = r14.getWindow()
            android.view.View r5 = r5.getDecorView()
            r0.<init>(r5)
            r4.F = r0
            java.lang.String r0 = "excludeNudgeFrequency"
            java.lang.String r0 = r15.optString(r0)
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            r4.a(r0)
            r4.a(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.k.a(android.app.Activity, io.hansel.core.json.CoreJSONObject, io.hansel.userjourney.prompts.f, java.lang.String, io.hansel.core.module.IMessageBroker):io.hansel.userjourney.prompts.k");
    }

    private n0 a(String str) {
        if (str == null) {
            return n0.ALIGN_WITH_VIEW;
        }
        str.hashCode();
        return !str.equals("IN") ? !str.equals("OUT") ? n0.ALIGN_WITH_VIEW : n0.OUTSIDE_VIEW : n0.INSIDE_VIEW;
    }

    private void a(CoreJSONObject coreJSONObject) {
        this.p = coreJSONObject.optInt("x", -1);
        this.q = coreJSONObject.optInt("y", -1);
        this.r = coreJSONObject.optInt("w", -1);
        this.s = coreJSONObject.optInt(h.f3998a, -1);
    }

    private o0 b(String str) {
        if (str == null) {
            return o0.TOP_CENTER;
        }
        str.hashCode();
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 2113) {
            if (hashCode != 2122) {
                if (hashCode != 2128) {
                    if (hashCode != 2454) {
                        if (hashCode != 2463) {
                            if (hashCode != 2469) {
                                if (hashCode != 2680) {
                                    if (hashCode == 2686 && str.equals(StandardStructureTypes.TR)) {
                                        c2 = 7;
                                    }
                                } else if (str.equals("TL")) {
                                    c2 = 6;
                                }
                            } else if (str.equals("MR")) {
                                c2 = 5;
                            }
                        } else if (str.equals("ML")) {
                            c2 = 4;
                        }
                    } else if (str.equals(PaymentActivity.CARD_I_AUTHORITY_MC)) {
                        c2 = 3;
                    }
                } else if (str.equals("BR")) {
                    c2 = 2;
                }
            } else if (str.equals("BL")) {
                c2 = 1;
            }
        } else if (str.equals("BC")) {
            c2 = 0;
        }
        switch (c2) {
            case 0:
                return o0.BOTTOM_CENTER;
            case 1:
                return o0.BOTTOM_LEFT;
            case 2:
                return o0.BOTTOM_RIGHT;
            case 3:
                return o0.MIDDLE_CENTER;
            case 4:
                return o0.MIDDLE_LEFT;
            case 5:
                return o0.MIDDLE_RIGHT;
            case 6:
                return o0.TOP_LEFT;
            case 7:
                return o0.TOP_RIGHT;
            default:
                return o0.TOP_CENTER;
        }
    }

    public j0 A() {
        return this.D;
    }

    public o B() {
        return this.m;
    }

    public p C() {
        return this.l;
    }

    public n0 D() {
        return this.B;
    }

    public o0 E() {
        return this.A;
    }

    public l F() {
        return this.f5562a;
    }

    public d0 G() {
        return this.G;
    }

    public boolean H() {
        if (!M()) {
            return true;
        }
        int d2 = d();
        int e2 = e();
        if (d2 < 0 || d2 > A().b()) {
            HSLLogger.d("anchor point X outside", LogGroup.PT);
            return false;
        } else if (e2 < 0 || e2 > A().a()) {
            HSLLogger.w("anchor point Y outside", LogGroup.PT);
            return false;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(this.J, c());
            hashMap.put(this.K, m());
            hashMap.put(this.L, Integer.valueOf(d2));
            hashMap.put(this.M, Integer.valueOf(f()));
            HSLLogger.d("The value of anchorPointOnScreenX is " + d2 + " and the value of anchorPointOnScreenY is " + f());
            return ((Boolean) this.E.returnEventData(EventsConstants.ANCHOR_POINT_VISIBLE.name(), hashMap)).booleanValue();
        }
    }

    public boolean I() {
        return this.H;
    }

    public boolean J() {
        return this.C == g0.INVISIBLE;
    }

    public boolean K() {
        return this.C == g0.NORMAL;
    }

    public boolean L() {
        return this.C == g0.PERSISTENT && this.f5562a == l.TAG;
    }

    public boolean M() {
        return (this.C == g0.NORMAL && this.f5562a == l.NONE) ? false : true;
    }

    public void O() {
        int i2;
        if (M()) {
            N();
            HSLLogger.d("Entered the method calculateAnchorPoint");
            HSLLogger.d("anchorPoints The position and size of the view are " + this.p + CMap.SPACE + this.q + CMap.SPACE + this.r + CMap.SPACE + this.s);
            int i3 = 0;
            b a2 = h0.a((this.r / 2) + this.p, (this.s / 2) + this.q, this.D.b(), this.D.a());
            StringBuilder sb = new StringBuilder();
            sb.append("AnchorViewCenterPositionQuadrant is ");
            sb.append(a2);
            HSLLogger.d(sb.toString());
            o0 E2 = E();
            if (F() == l.TAG) {
                i2 = (E2 == o0.BOTTOM_CENTER || E2 == o0.BOTTOM_LEFT || E2 == o0.BOTTOM_RIGHT) ? (this.q + this.s) - 1 : (E2 == o0.MIDDLE_CENTER || E2 == o0.MIDDLE_LEFT || E2 == o0.MIDDLE_RIGHT) ? this.q + (this.s / 2) : this.q + 1;
                int ordinal = a2.ordinal();
                b bVar = b.TOP_LEFT;
                b bVar2 = b.BOTTOM_LEFT;
                if ((ordinal & 2) == a2.ordinal()) {
                    i3 = this.p + 1;
                } else {
                    int ordinal2 = a2.ordinal();
                    b bVar3 = b.TOP_RIGHT;
                    b bVar4 = b.BOTTOM_RIGHT;
                    if ((ordinal2 & 3) == a2.ordinal()) {
                        i3 = (this.p + this.r) - 1;
                    }
                }
            } else if (F() == l.SPOTLIGHT) {
                i3 = this.p + (this.r / 2);
                i2 = (this.s / 2) + this.q;
            } else {
                i3 = this.p + ((int) ((u() * ((double) this.r)) / 100.0d));
                i2 = this.q + ((int) ((v() * ((double) this.s)) / 100.0d));
            }
            if (this.q < 0 && !L()) {
                i2 -= this.q;
            }
            HSLLogger.d("anchorPoints The anchor point is " + i3 + CMap.SPACE + i2);
            a(i3);
            b(i2);
            b(this.D.b(), this.D.a());
            a b2 = b();
            HSLLogger.d("anchorPoints The anchorPointPositionQuadrant is " + b2);
        }
    }

    public double a(int i2, int i3) {
        int i4;
        int i5;
        int i6 = (i2 / 2) + this.f5566e;
        int i7 = (i() / 2) + j();
        int a2 = n.a(this.r, this.s, 10, C() == p.SPOTLIGHT_CIRCLE);
        d0 y2 = y();
        d0 d0Var = d0.BOTTOM;
        if (y2 == d0Var) {
            i4 = this.f5567f;
            i5 = (a2 / 2) + (h() / 2) + k();
        } else {
            i4 = (i3 / 2) + this.f5567f;
            i5 = ((h() / 2) + k()) - (a2 / 2);
        }
        int i8 = i7 - i6;
        if (i8 == 0) {
            return 0.0d;
        }
        return this.f5563b == d0Var ? i8 > 0 ? 90.0d - Math.toDegrees(Math.atan((double) (((float) (i4 - i5)) / ((float) i8)))) : Math.toDegrees(Math.atan((double) (((float) (i6 - i7)) / ((float) (i4 - i5))))) * -1.0d : i7 > i6 ? Math.toDegrees(Math.atan((double) (((float) i8) / ((float) (i5 - i4))))) * -1.0d : Math.toDegrees(Math.atan((double) (((float) (i6 - i7)) / ((float) (i5 - i4)))));
    }

    public void a(double d2) {
        this.g = d2;
    }

    public void a(int i2) {
        this.y = this.j;
        this.j = i2;
    }

    public void a(long j2) {
        this.I = j2;
    }

    public void a(View view) {
        this.x = new WeakReference<>(view);
    }

    public void a(d0 d0Var) {
        this.f5563b = d0Var;
    }

    public void a(f fVar) {
        this.v = fVar;
    }

    public void a(j0 j0Var) {
        this.D = j0Var;
    }

    public void a(u uVar) {
        this.w = uVar;
    }

    public void a(boolean z2) {
        this.H = z2;
    }

    public boolean a() {
        return (this.j == this.y && this.i == this.z) ? false : true;
    }

    public a b() {
        return this.k;
    }

    public void b(double d2) {
        this.h = d2;
    }

    public void b(int i2) {
        this.z = this.i;
        this.i = i2;
    }

    public void b(int i2, int i3) {
        int d2 = d();
        double d3 = ((double) i2) / 2.0d;
        this.k = ((double) e()) < ((double) i3) / 2.0d ? ((double) d2) < d3 ? a.TOP_LEFT : a.TOP_RIGHT : ((double) d2) < d3 ? a.BOTTOM_LEFT : a.BOTTOM_RIGHT;
    }

    public void b(CoreJSONObject coreJSONObject) {
        this.u = coreJSONObject;
    }

    public void b(d0 d0Var) {
        this.G = d0Var;
    }

    public void b(boolean z2) {
        this.N = z2;
    }

    public View c() {
        WeakReference<View> weakReference = this.x;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public void c(int i2) {
        this.t = i2;
    }

    public void c(String str) {
        this.n = str;
    }

    public int d() {
        return this.j;
    }

    public void d(int i2) {
        this.f5565d = i2;
    }

    public void d(String str) {
        this.o = str;
    }

    public int e() {
        return this.i;
    }

    public void e(int i2) {
        this.f5564c = i2;
    }

    public int f() {
        return this.i;
    }

    public void f(int i2) {
        this.f5566e = i2;
    }

    public u g() {
        return this.w;
    }

    public void g(int i2) {
        this.f5567f = i2;
    }

    public int h() {
        return this.s;
    }

    public void h(int i2) {
    }

    public int i() {
        return this.r;
    }

    public int j() {
        return this.p;
    }

    public int k() {
        return this.q;
    }

    public int l() {
        return this.t;
    }

    public View m() {
        WeakReference<View> weakReference = this.F;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public long n() {
        return this.I;
    }

    public f o() {
        return this.v;
    }

    public String p() {
        return this.n;
    }

    public boolean q() {
        return this.N;
    }

    public CoreJSONObject r() {
        return this.u;
    }

    public int s() {
        return this.f5565d;
    }

    public int t() {
        return this.f5564c;
    }

    public double u() {
        return this.g;
    }

    public double v() {
        return this.h;
    }

    public int w() {
        return this.f5566e;
    }

    public int x() {
        return this.f5567f;
    }

    public d0 y() {
        return this.f5563b;
    }

    public String z() {
        return this.o;
    }
}
