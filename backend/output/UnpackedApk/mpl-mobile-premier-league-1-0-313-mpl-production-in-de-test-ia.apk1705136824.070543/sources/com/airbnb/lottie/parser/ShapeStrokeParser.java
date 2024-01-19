package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import sfs2x.client.requests.buddylist.GoOnlineRequest;

public class ShapeStrokeParser {
    public static final Options DASH_PATTERN_NAMES = Options.of("n", "v");
    public static Options NAMES = Options.of("nm", "c", "w", GoOnlineRequest.KEY_ONLINE, "lc", "lj", "ml", "hd", "d");

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.model.content.ShapeStroke parse(com.airbnb.lottie.parser.moshi.JsonReader r17, com.airbnb.lottie.LottieComposition r18) throws java.io.IOException {
        /*
            r0 = r17
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0011:
            boolean r13 = r17.hasNext()
            r14 = 100
            if (r13 == 0) goto L_0x0117
            com.airbnb.lottie.parser.moshi.JsonReader$Options r13 = NAMES
            int r13 = r0.selectName(r13)
            r15 = 1
            switch(r13) {
                case 0: goto L_0x010e;
                case 1: goto L_0x0105;
                case 2: goto L_0x00fc;
                case 3: goto L_0x00f3;
                case 4: goto L_0x00e2;
                case 5: goto L_0x00d1;
                case 6: goto L_0x00c7;
                case 7: goto L_0x00be;
                case 8: goto L_0x002a;
                default: goto L_0x0023;
            }
        L_0x0023:
            r1 = r18
            r2 = 0
            r17.skipValue()
            goto L_0x0011
        L_0x002a:
            r17.beginArray()
        L_0x002d:
            boolean r13 = r17.hasNext()
            if (r13 == 0) goto L_0x00a5
            r17.beginObject()
            r2 = 0
            r13 = 0
        L_0x0038:
            boolean r16 = r17.hasNext()
            if (r16 == 0) goto L_0x0059
            com.airbnb.lottie.parser.moshi.JsonReader$Options r1 = DASH_PATTERN_NAMES
            int r1 = r0.selectName(r1)
            if (r1 == 0) goto L_0x0054
            if (r1 == r15) goto L_0x004f
            r17.skipName()
            r17.skipValue()
            goto L_0x0038
        L_0x004f:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r2 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r17, r18)
            goto L_0x0038
        L_0x0054:
            java.lang.String r13 = r17.nextString()
            goto L_0x0038
        L_0x0059:
            r17.endObject()
            int r1 = r13.hashCode()
            r15 = 2
            if (r1 == r14) goto L_0x0080
            r14 = 103(0x67, float:1.44E-43)
            if (r1 == r14) goto L_0x0076
            r14 = 111(0x6f, float:1.56E-43)
            if (r1 == r14) goto L_0x006c
            goto L_0x008a
        L_0x006c:
            java.lang.String r1 = "o"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x008a
            r1 = 0
            goto L_0x008b
        L_0x0076:
            java.lang.String r1 = "g"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x008a
            r1 = 2
            goto L_0x008b
        L_0x0080:
            java.lang.String r1 = "d"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x008a
            r1 = 1
            goto L_0x008b
        L_0x008a:
            r1 = -1
        L_0x008b:
            if (r1 == 0) goto L_0x009d
            r13 = 1
            if (r1 == r13) goto L_0x0095
            if (r1 == r15) goto L_0x0095
            r1 = r18
            goto L_0x00a1
        L_0x0095:
            r1 = r18
            r1.hasDashPattern = r13
            r3.add(r2)
            goto L_0x00a1
        L_0x009d:
            r1 = r18
            r13 = 1
            r5 = r2
        L_0x00a1:
            r14 = 100
            r15 = 1
            goto L_0x002d
        L_0x00a5:
            r1 = r18
            r13 = 1
            r17.endArray()
            int r2 = r3.size()
            if (r2 != r13) goto L_0x00bb
            r2 = 0
            java.lang.Object r13 = r3.get(r2)
            r3.add(r13)
            goto L_0x0011
        L_0x00bb:
            r2 = 0
            goto L_0x0011
        L_0x00be:
            r1 = r18
            r2 = 0
            boolean r11 = r17.nextBoolean()
            goto L_0x0011
        L_0x00c7:
            r1 = r18
            r2 = 0
            double r13 = r17.nextDouble()
            float r10 = (float) r13
            goto L_0x0011
        L_0x00d1:
            r1 = r18
            r2 = 0
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r9 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r13 = r17.nextInt()
            r14 = 1
            int r13 = r13 - r14
            r9 = r9[r13]
            goto L_0x0011
        L_0x00e2:
            r1 = r18
            r2 = 0
            r14 = 1
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r8 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r13 = r17.nextInt()
            int r13 = r13 - r14
            r8 = r8[r13]
            goto L_0x0011
        L_0x00f3:
            r1 = r18
            r2 = 0
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r12 = co.hyperverge.hypersnapsdk.c.k.parseInteger(r17, r18)
            goto L_0x0011
        L_0x00fc:
            r1 = r18
            r2 = 0
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r7 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r17, r18)
            goto L_0x0011
        L_0x0105:
            r1 = r18
            r2 = 0
            com.airbnb.lottie.model.animatable.AnimatableColorValue r6 = co.hyperverge.hypersnapsdk.c.k.parseColor(r17, r18)
            goto L_0x0011
        L_0x010e:
            r1 = r18
            r2 = 0
            java.lang.String r4 = r17.nextString()
            goto L_0x0011
        L_0x0117:
            if (r12 != 0) goto L_0x012e
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r0 = new com.airbnb.lottie.model.animatable.AnimatableIntegerValue
            com.airbnb.lottie.value.Keyframe r1 = new com.airbnb.lottie.value.Keyframe
            r2 = 100
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.<init>(r2)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r0.<init>(r1)
            r12 = r0
        L_0x012e:
            com.airbnb.lottie.model.content.ShapeStroke r13 = new com.airbnb.lottie.model.content.ShapeStroke
            r0 = r13
            r1 = r4
            r2 = r5
            r4 = r6
            r5 = r12
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ShapeStrokeParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ShapeStroke");
    }
}
