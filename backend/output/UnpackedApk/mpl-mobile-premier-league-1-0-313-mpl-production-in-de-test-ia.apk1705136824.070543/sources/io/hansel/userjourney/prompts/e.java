package io.hansel.userjourney.prompts;

import io.hansel.R;

public enum e {
    STAR(R.drawable.hansel_star_border),
    STAR_FILL(R.drawable.hansel_star_fill),
    HEART(R.drawable.hansel_heart_border),
    HEART_FILL(R.drawable.hansel_heart_fill),
    THUMB(R.drawable.hansel_thumbsup_border),
    THUMB_FILL(R.drawable.hansel_thumbsup_fill),
    HOTSPOT_CIRCLE_1(R.drawable.hansel_hotspot_circle1),
    HOTSPOT_CIRCLE_2(R.drawable.hansel_hotspot_circle2),
    HOTSPOT_QUESTION(R.drawable.hansel_hotspot_question),
    HOTSPOT_STAR(R.drawable.hansel_hotspot_star);
    

    /* renamed from: a  reason: collision with root package name */
    public int f5532a;

    /* access modifiers changed from: public */
    e(int i) {
        this.f5532a = i;
    }

    public static int a(String str) {
        e b2 = b(str);
        if (b2 == null) {
            return 0;
        }
        return b2.f5532a;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.hansel.userjourney.prompts.e b(java.lang.String r1) {
        /*
            r1.hashCode()
            int r0 = r1.hashCode()
            switch(r0) {
                case -1498360702: goto L_0x0088;
                case -1498360701: goto L_0x007d;
                case -1334926607: goto L_0x0071;
                case -1165870106: goto L_0x0066;
                case -892484167: goto L_0x005a;
                case 3540562: goto L_0x004e;
                case 99151942: goto L_0x0043;
                case 689179074: goto L_0x0038;
                case 795738797: goto L_0x002a;
                case 1330755224: goto L_0x001b;
                case 2146814800: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0093
        L_0x000c:
            java.lang.String r0 = "star_fill"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0017
            goto L_0x0093
        L_0x0017:
            r1 = 10
            goto L_0x0094
        L_0x001b:
            java.lang.String r0 = "thumbup_f"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0026
            goto L_0x0093
        L_0x0026:
            r1 = 9
            goto L_0x0094
        L_0x002a:
            java.lang.String r0 = "heart_f"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0034
            goto L_0x0093
        L_0x0034:
            r1 = 8
            goto L_0x0094
        L_0x0038:
            java.lang.String r0 = "hotspot_star"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0041
            goto L_0x0093
        L_0x0041:
            r1 = 7
            goto L_0x0094
        L_0x0043:
            java.lang.String r0 = "heart"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x004c
            goto L_0x0093
        L_0x004c:
            r1 = 6
            goto L_0x0094
        L_0x004e:
            java.lang.String r0 = "star"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            goto L_0x0093
        L_0x0058:
            r1 = 5
            goto L_0x0094
        L_0x005a:
            java.lang.String r0 = "star_f"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0064
            goto L_0x0093
        L_0x0064:
            r1 = 4
            goto L_0x0094
        L_0x0066:
            java.lang.String r0 = "question"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x006f
            goto L_0x0093
        L_0x006f:
            r1 = 3
            goto L_0x0094
        L_0x0071:
            java.lang.String r0 = "thumbup"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x007b
            goto L_0x0093
        L_0x007b:
            r1 = 2
            goto L_0x0094
        L_0x007d:
            java.lang.String r0 = "circle_2"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0086
            goto L_0x0093
        L_0x0086:
            r1 = 1
            goto L_0x0094
        L_0x0088:
            java.lang.String r0 = "circle_1"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r1 = 0
            goto L_0x0094
        L_0x0093:
            r1 = -1
        L_0x0094:
            switch(r1) {
                case 0: goto L_0x00b4;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00ae;
                case 3: goto L_0x00ab;
                case 4: goto L_0x00a8;
                case 5: goto L_0x00a5;
                case 6: goto L_0x00a2;
                case 7: goto L_0x009f;
                case 8: goto L_0x009c;
                case 9: goto L_0x0099;
                case 10: goto L_0x00a8;
                default: goto L_0x0097;
            }
        L_0x0097:
            r1 = 0
            return r1
        L_0x0099:
            io.hansel.userjourney.prompts.e r1 = THUMB_FILL
            return r1
        L_0x009c:
            io.hansel.userjourney.prompts.e r1 = HEART_FILL
            return r1
        L_0x009f:
            io.hansel.userjourney.prompts.e r1 = HOTSPOT_STAR
            return r1
        L_0x00a2:
            io.hansel.userjourney.prompts.e r1 = HEART
            return r1
        L_0x00a5:
            io.hansel.userjourney.prompts.e r1 = STAR
            return r1
        L_0x00a8:
            io.hansel.userjourney.prompts.e r1 = STAR_FILL
            return r1
        L_0x00ab:
            io.hansel.userjourney.prompts.e r1 = HOTSPOT_QUESTION
            return r1
        L_0x00ae:
            io.hansel.userjourney.prompts.e r1 = THUMB
            return r1
        L_0x00b1:
            io.hansel.userjourney.prompts.e r1 = HOTSPOT_CIRCLE_2
            return r1
        L_0x00b4:
            io.hansel.userjourney.prompts.e r1 = HOTSPOT_CIRCLE_1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.e.b(java.lang.String):io.hansel.userjourney.prompts.e");
    }
}
