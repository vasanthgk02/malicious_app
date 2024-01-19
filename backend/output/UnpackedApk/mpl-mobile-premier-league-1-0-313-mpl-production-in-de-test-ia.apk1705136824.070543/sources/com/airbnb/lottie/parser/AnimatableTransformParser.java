package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.userexperior.utilities.k;
import sfs2x.client.requests.buddylist.GoOnlineRequest;

public class AnimatableTransformParser {
    public static final Options ANIMATABLE_NAMES = Options.of(k.f4287a);
    public static final Options NAMES = Options.of("a", "p", "s", "rz", "r", GoOnlineRequest.KEY_ONLINE, "so", "eo", "sk", "sa");

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        r5 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r0, r8, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        if (r5.keyframes.isEmpty() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        r4 = r5.keyframes;
        r9 = r1;
        r10 = r5;
        r26 = r6;
        r18 = r13;
        r13 = r7;
        r1 = new com.airbnb.lottie.value.Keyframe(r28, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f), null, 0.0f, java.lang.Float.valueOf(r8.endFrame));
        r4.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009b, code lost:
        r10 = r5;
        r26 = r6;
        r18 = r13;
        r13 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ac, code lost:
        if (r10.keyframes.get(0).startValue != null) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ae, code lost:
        r9 = r10.keyframes;
        r1 = new com.airbnb.lottie.value.Keyframe(r28, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f), null, 0.0f, java.lang.Float.valueOf(r8.endFrame));
        r9.set(0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d2, code lost:
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d3, code lost:
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0114, code lost:
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0115, code lost:
        r13 = r18;
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01c0, code lost:
        if ((r0.scaleX == 1.0f && r0.scaleY == 1.0f) != false) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x020e, code lost:
        if (((java.lang.Float) r12.keyframes.get(0).startValue).floatValue() == 0.0f) goto L_0x0216;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.model.animatable.AnimatableTransform parse(com.airbnb.lottie.parser.moshi.JsonReader r27, com.airbnb.lottie.LottieComposition r28) throws java.io.IOException {
        /*
            r0 = r27
            r8 = r28
            com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = r27.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r2 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            r10 = 0
            if (r1 != r2) goto L_0x000f
            r11 = 1
            goto L_0x0010
        L_0x000f:
            r11 = 0
        L_0x0010:
            if (r11 == 0) goto L_0x0015
            r27.beginObject()
        L_0x0015:
            r1 = 0
            r6 = 0
            r7 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r21 = 0
            r22 = 0
            r23 = 0
        L_0x0021:
            boolean r2 = r27.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x011a
            com.airbnb.lottie.parser.moshi.JsonReader$Options r2 = NAMES
            int r2 = r0.selectName(r2)
            switch(r2) {
                case 0: goto L_0x00ee;
                case 1: goto L_0x00e5;
                case 2: goto L_0x00d6;
                case 3: goto L_0x0057;
                case 4: goto L_0x005c;
                case 5: goto L_0x0052;
                case 6: goto L_0x004d;
                case 7: goto L_0x0048;
                case 8: goto L_0x0043;
                case 9: goto L_0x003e;
                default: goto L_0x0031;
            }
        L_0x0031:
            r26 = r6
            r18 = r13
            r13 = r7
            r27.skipName()
            r27.skipValue()
            goto L_0x0115
        L_0x003e:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r13 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r0, r8, r10)
            goto L_0x0021
        L_0x0043:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r14 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r0, r8, r10)
            goto L_0x0021
        L_0x0048:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r23 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r0, r8, r10)
            goto L_0x0021
        L_0x004d:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r22 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r0, r8, r10)
            goto L_0x0021
        L_0x0052:
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r21 = co.hyperverge.hypersnapsdk.c.k.parseInteger(r27, r28)
            goto L_0x0021
        L_0x0057:
            java.lang.String r1 = "Lottie doesn't support 3D layers."
            r8.addWarning(r1)
        L_0x005c:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r5 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r0, r8, r10)
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r1 = r5.keyframes
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x009b
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r4 = r5.keyframes
            com.airbnb.lottie.value.Keyframe r2 = new com.airbnb.lottie.value.Keyframe
            java.lang.Float r16 = java.lang.Float.valueOf(r3)
            java.lang.Float r17 = java.lang.Float.valueOf(r3)
            r18 = 0
            r19 = 0
            float r1 = r8.endFrame
            java.lang.Float r20 = java.lang.Float.valueOf(r1)
            r1 = r2
            r3 = r2
            r2 = r28
            r9 = r3
            r3 = r16
            r12 = r4
            r4 = r17
            r10 = r5
            r5 = r18
            r26 = r6
            r6 = r19
            r18 = r13
            r13 = r7
            r7 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r12.add(r9)
            goto L_0x00d2
        L_0x009b:
            r10 = r5
            r26 = r6
            r18 = r13
            r13 = r7
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r1 = r10.keyframes
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.airbnb.lottie.value.Keyframe r1 = (com.airbnb.lottie.value.Keyframe) r1
            T r1 = r1.startValue
            if (r1 != 0) goto L_0x00d2
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r9 = r10.keyframes
            com.airbnb.lottie.value.Keyframe r12 = new com.airbnb.lottie.value.Keyframe
            java.lang.Float r4 = java.lang.Float.valueOf(r3)
            java.lang.Float r5 = java.lang.Float.valueOf(r3)
            r6 = 0
            r7 = 0
            float r1 = r8.endFrame
            java.lang.Float r19 = java.lang.Float.valueOf(r1)
            r1 = r12
            r2 = r28
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r1 = 0
            r9.set(r1, r12)
        L_0x00d2:
            r1 = r10
        L_0x00d3:
            r6 = r26
            goto L_0x0114
        L_0x00d6:
            r18 = r13
            r13 = r7
            com.airbnb.lottie.model.animatable.AnimatableScaleValue r6 = new com.airbnb.lottie.model.animatable.AnimatableScaleValue
            com.airbnb.lottie.parser.ScaleXYParser r2 = com.airbnb.lottie.parser.ScaleXYParser.INSTANCE
            java.util.List r2 = co.hyperverge.hypersnapsdk.c.k.parse(r0, r8, r2)
            r6.<init>(r2)
            goto L_0x0114
        L_0x00e5:
            r26 = r6
            r18 = r13
            com.airbnb.lottie.model.animatable.AnimatableValue r7 = com.airbnb.lottie.parser.AnimatablePathValueParser.parseSplitPath(r27, r28)
            goto L_0x0115
        L_0x00ee:
            r26 = r6
            r18 = r13
            r13 = r7
            r27.beginObject()
        L_0x00f6:
            boolean r2 = r27.hasNext()
            if (r2 == 0) goto L_0x0110
            com.airbnb.lottie.parser.moshi.JsonReader$Options r2 = ANIMATABLE_NAMES
            int r2 = r0.selectName(r2)
            if (r2 == 0) goto L_0x010b
            r27.skipName()
            r27.skipValue()
            goto L_0x00f6
        L_0x010b:
            com.airbnb.lottie.model.animatable.AnimatablePathValue r15 = com.airbnb.lottie.parser.AnimatablePathValueParser.parse(r27, r28)
            goto L_0x00f6
        L_0x0110:
            r27.endObject()
            goto L_0x00d3
        L_0x0114:
            r7 = r13
        L_0x0115:
            r13 = r18
            r10 = 0
            goto L_0x0021
        L_0x011a:
            r26 = r6
            r18 = r13
            r13 = r7
            if (r11 == 0) goto L_0x0124
            r27.endObject()
        L_0x0124:
            if (r15 == 0) goto L_0x0142
            boolean r0 = r15.isStatic()
            if (r0 == 0) goto L_0x0140
            java.util.List<com.airbnb.lottie.value.Keyframe<android.graphics.PointF>> r0 = r15.keyframes
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.startValue
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            boolean r0 = r0.equals(r3, r3)
            if (r0 == 0) goto L_0x0140
            goto L_0x0142
        L_0x0140:
            r0 = 0
            goto L_0x0143
        L_0x0142:
            r0 = 1
        L_0x0143:
            if (r0 == 0) goto L_0x0146
            r15 = 0
        L_0x0146:
            if (r13 == 0) goto L_0x016a
            boolean r0 = r13 instanceof com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue
            if (r0 != 0) goto L_0x0168
            boolean r0 = r13.isStatic()
            if (r0 == 0) goto L_0x0168
            java.util.List r0 = r13.getKeyframes()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.startValue
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            boolean r0 = r0.equals(r3, r3)
            if (r0 == 0) goto L_0x0168
            goto L_0x016a
        L_0x0168:
            r0 = 0
            goto L_0x016b
        L_0x016a:
            r0 = 1
        L_0x016b:
            if (r0 == 0) goto L_0x016e
            r13 = 0
        L_0x016e:
            if (r1 == 0) goto L_0x018e
            boolean r0 = r1.isStatic()
            if (r0 == 0) goto L_0x018c
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r0 = r1.keyframes
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.startValue
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x018c
            goto L_0x018e
        L_0x018c:
            r0 = 0
            goto L_0x018f
        L_0x018e:
            r0 = 1
        L_0x018f:
            if (r0 == 0) goto L_0x0196
            r6 = r26
            r20 = 0
            goto L_0x019a
        L_0x0196:
            r20 = r1
            r6 = r26
        L_0x019a:
            if (r6 == 0) goto L_0x01c5
            boolean r0 = r6.isStatic()
            if (r0 == 0) goto L_0x01c3
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r0 = r6.keyframes
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.startValue
            com.airbnb.lottie.value.ScaleXY r0 = (com.airbnb.lottie.value.ScaleXY) r0
            float r1 = r0.scaleX
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x01bf
            float r0 = r0.scaleY
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x01bf
            r0 = 1
            goto L_0x01c0
        L_0x01bf:
            r0 = 0
        L_0x01c0:
            if (r0 == 0) goto L_0x01c3
            goto L_0x01c5
        L_0x01c3:
            r0 = 0
            goto L_0x01c6
        L_0x01c5:
            r0 = 1
        L_0x01c6:
            if (r0 == 0) goto L_0x01cb
            r19 = 0
            goto L_0x01cd
        L_0x01cb:
            r19 = r6
        L_0x01cd:
            if (r14 == 0) goto L_0x01ed
            boolean r0 = r14.isStatic()
            if (r0 == 0) goto L_0x01eb
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r0 = r14.keyframes
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.startValue
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x01eb
            goto L_0x01ed
        L_0x01eb:
            r2 = 0
            goto L_0x01ee
        L_0x01ed:
            r2 = 1
        L_0x01ee:
            if (r2 == 0) goto L_0x01f1
            r14 = 0
        L_0x01f1:
            if (r18 == 0) goto L_0x0214
            boolean r0 = r18.isStatic()
            r12 = r18
            if (r0 == 0) goto L_0x0211
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r0 = r12.keyframes
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            T r0 = r0.startValue
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0212
            goto L_0x0216
        L_0x0211:
            r1 = 0
        L_0x0212:
            r9 = 0
            goto L_0x0217
        L_0x0214:
            r12 = r18
        L_0x0216:
            r9 = 1
        L_0x0217:
            if (r9 == 0) goto L_0x021c
            r25 = 0
            goto L_0x021e
        L_0x021c:
            r25 = r12
        L_0x021e:
            com.airbnb.lottie.model.animatable.AnimatableTransform r0 = new com.airbnb.lottie.model.animatable.AnimatableTransform
            r16 = r0
            r17 = r15
            r18 = r13
            r24 = r14
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.animatable.AnimatableTransform");
    }
}
