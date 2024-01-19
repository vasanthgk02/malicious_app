package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.userexperior.e.h;
import java.lang.ref.WeakReference;
import sfs2x.client.requests.buddylist.GoOnlineRequest;

public class KeyframeParser {
    public static Options INTERPOLATOR_NAMES = Options.of("x", "y");
    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static Options NAMES = Options.of("t", "s", "e", GoOnlineRequest.KEY_ONLINE, "i", h.f3998a, "to", "ti");
    public static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    public static Interpolator interpolatorFor(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        WeakReference weakReference;
        Interpolator interpolator2;
        Class<KeyframeParser> cls = KeyframeParser.class;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        float clamp = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
        pointF2.y = clamp;
        int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, clamp);
        synchronized (cls) {
            if (pathInterpolatorCache == null) {
                pathInterpolatorCache = new SparseArrayCompat<>();
            }
            interpolator = null;
            weakReference = (WeakReference) pathInterpolatorCache.get(hashFor, null);
        }
        if (weakReference != null) {
            interpolator = (Interpolator) weakReference.get();
        }
        if (weakReference == null || interpolator2 == null) {
            try {
                interpolator2 = new PathInterpolator(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e2) {
                if ("The Path cannot loop back on itself.".equals(e2.getMessage())) {
                    interpolator2 = new PathInterpolator(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    interpolator2 = new LinearInterpolator();
                }
            }
            try {
                WeakReference weakReference2 = new WeakReference(interpolator2);
                synchronized (cls) {
                    pathInterpolatorCache.put(hashFor, weakReference2);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x015c, code lost:
        r14 = r24;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.airbnb.lottie.value.Keyframe<T> parse(com.airbnb.lottie.parser.moshi.JsonReader r19, com.airbnb.lottie.LottieComposition r20, float r21, com.airbnb.lottie.parser.ValueParser<T> r22, boolean r23, boolean r24) throws java.io.IOException {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r4 = 1
            if (r23 == 0) goto L_0x01ec
            if (r24 == 0) goto L_0x01ec
            r19.beginObject()
            r3 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x001b:
            boolean r17 = r19.hasNext()
            if (r17 == 0) goto L_0x018f
            com.airbnb.lottie.parser.moshi.JsonReader$Options r6 = NAMES
            int r6 = r0.selectName(r6)
            switch(r6) {
                case 0: goto L_0x017f;
                case 1: goto L_0x0174;
                case 2: goto L_0x0167;
                case 3: goto L_0x00e3;
                case 4: goto L_0x0049;
                case 5: goto L_0x003f;
                case 6: goto L_0x003a;
                case 7: goto L_0x0035;
                default: goto L_0x002a;
            }
        L_0x002a:
            r18 = r7
            r24 = r14
            r23 = r15
            r19.skipValue()
            goto L_0x0188
        L_0x0035:
            android.graphics.PointF r7 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r0, r1)
            goto L_0x001b
        L_0x003a:
            android.graphics.PointF r15 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r0, r1)
            goto L_0x001b
        L_0x003f:
            int r6 = r19.nextInt()
            if (r6 != r4) goto L_0x0047
            r8 = 1
            goto L_0x001b
        L_0x0047:
            r8 = 0
            goto L_0x001b
        L_0x0049:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r6 = r19.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r6 != r4) goto L_0x00d6
            r19.beginObject()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0058:
            boolean r18 = r19.hasNext()
            if (r18 == 0) goto L_0x00bf
            r23 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$Options r15 = INTERPOLATOR_NAMES
            int r15 = r0.selectName(r15)
            if (r15 == 0) goto L_0x0093
            r18 = r7
            r7 = 1
            if (r15 == r7) goto L_0x0071
            r19.skipValue()
            goto L_0x0090
        L_0x0071:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r19.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r6 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r6) goto L_0x0080
            double r6 = r19.nextDouble()
            float r4 = (float) r6
            r6 = r4
            goto L_0x0090
        L_0x0080:
            r19.beginArray()
            double r6 = r19.nextDouble()
            float r4 = (float) r6
            double r6 = r19.nextDouble()
            float r6 = (float) r6
            r19.endArray()
        L_0x0090:
            r24 = r14
            goto L_0x00b8
        L_0x0093:
            r18 = r7
            com.airbnb.lottie.parser.moshi.JsonReader$Token r3 = r19.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r3 != r5) goto L_0x00a6
            r24 = r14
            double r14 = r19.nextDouble()
            float r3 = (float) r14
            r5 = r3
            goto L_0x00b8
        L_0x00a6:
            r24 = r14
            r19.beginArray()
            double r14 = r19.nextDouble()
            float r3 = (float) r14
            double r14 = r19.nextDouble()
            float r5 = (float) r14
            r19.endArray()
        L_0x00b8:
            r15 = r23
            r14 = r24
            r7 = r18
            goto L_0x0058
        L_0x00bf:
            r18 = r7
            r24 = r14
            r23 = r15
            android.graphics.PointF r7 = new android.graphics.PointF
            r7.<init>(r3, r4)
            android.graphics.PointF r3 = new android.graphics.PointF
            r3.<init>(r5, r6)
            r19.endObject()
            r5 = r3
            r3 = r7
            goto L_0x015c
        L_0x00d6:
            r18 = r7
            r24 = r14
            r23 = r15
            android.graphics.PointF r4 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r0, r1)
            r11 = r4
            goto L_0x0188
        L_0x00e3:
            r18 = r7
            r24 = r14
            r23 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r19.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r6 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r6) goto L_0x015f
            r19.beginObject()
            r4 = 0
            r6 = 0
            r7 = 0
            r12 = 0
        L_0x00f8:
            boolean r13 = r19.hasNext()
            if (r13 == 0) goto L_0x014d
            com.airbnb.lottie.parser.moshi.JsonReader$Options r13 = INTERPOLATOR_NAMES
            int r13 = r0.selectName(r13)
            if (r13 == 0) goto L_0x012d
            r14 = 1
            if (r13 == r14) goto L_0x010d
            r19.skipValue()
            goto L_0x00f8
        L_0x010d:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r6 = r19.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r12 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r6 != r12) goto L_0x011c
            double r12 = r19.nextDouble()
            float r12 = (float) r12
            r6 = r12
            goto L_0x00f8
        L_0x011c:
            r19.beginArray()
            double r12 = r19.nextDouble()
            float r6 = (float) r12
            double r12 = r19.nextDouble()
            float r12 = (float) r12
            r19.endArray()
            goto L_0x00f8
        L_0x012d:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r19.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r7 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r7) goto L_0x013c
            double r13 = r19.nextDouble()
            float r7 = (float) r13
            r4 = r7
            goto L_0x00f8
        L_0x013c:
            r19.beginArray()
            double r13 = r19.nextDouble()
            float r4 = (float) r13
            double r13 = r19.nextDouble()
            float r7 = (float) r13
            r19.endArray()
            goto L_0x00f8
        L_0x014d:
            android.graphics.PointF r13 = new android.graphics.PointF
            r13.<init>(r4, r6)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r7, r12)
            r19.endObject()
            r12 = r13
            r13 = r4
        L_0x015c:
            r14 = r24
            goto L_0x0188
        L_0x015f:
            android.graphics.PointF r4 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r0, r1)
            r14 = r24
            r9 = r4
            goto L_0x0188
        L_0x0167:
            r18 = r7
            r24 = r14
            r23 = r15
            java.lang.Object r4 = r2.parse(r0, r1)
            r16 = r4
            goto L_0x0188
        L_0x0174:
            r18 = r7
            r24 = r14
            r23 = r15
            java.lang.Object r10 = r2.parse(r0, r1)
            goto L_0x0188
        L_0x017f:
            r18 = r7
            r23 = r15
            double r6 = r19.nextDouble()
            float r14 = (float) r6
        L_0x0188:
            r15 = r23
            r7 = r18
            r4 = 1
            goto L_0x001b
        L_0x018f:
            r18 = r7
            r24 = r14
            r23 = r15
            r19.endObject()
            if (r8 == 0) goto L_0x019f
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
            r16 = r10
            goto L_0x01c0
        L_0x019f:
            if (r9 == 0) goto L_0x01a8
            if (r11 == 0) goto L_0x01a8
            android.view.animation.Interpolator r0 = interpolatorFor(r9, r11)
            goto L_0x01c0
        L_0x01a8:
            if (r12 == 0) goto L_0x01be
            if (r13 == 0) goto L_0x01be
            if (r3 == 0) goto L_0x01be
            if (r5 == 0) goto L_0x01be
            android.view.animation.Interpolator r0 = interpolatorFor(r12, r3)
            android.view.animation.Interpolator r1 = interpolatorFor(r13, r5)
            r12 = r0
            r13 = r1
            r11 = r16
            r0 = 0
            goto L_0x01c4
        L_0x01be:
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
        L_0x01c0:
            r11 = r16
            r12 = 0
            r13 = 0
        L_0x01c4:
            if (r12 == 0) goto L_0x01d6
            if (r13 == 0) goto L_0x01d6
            com.airbnb.lottie.value.Keyframe r0 = new com.airbnb.lottie.value.Keyframe
            r15 = 0
            r8 = r0
            r9 = r20
            r14 = r24
            r6 = r23
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x01e5
        L_0x01d6:
            r6 = r23
            com.airbnb.lottie.value.Keyframe r1 = new com.airbnb.lottie.value.Keyframe
            r14 = 0
            r8 = r1
            r9 = r20
            r12 = r0
            r13 = r24
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0 = r1
        L_0x01e5:
            r0.pathCp1 = r6
            r7 = r18
            r0.pathCp2 = r7
            return r0
        L_0x01ec:
            if (r23 == 0) goto L_0x026a
            r19.beginObject()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r13 = 0
            r17 = 0
        L_0x01fa:
            boolean r8 = r19.hasNext()
            if (r8 == 0) goto L_0x0244
            com.airbnb.lottie.parser.moshi.JsonReader$Options r8 = NAMES
            int r8 = r0.selectName(r8)
            r9 = 1065353216(0x3f800000, float:1.0)
            switch(r8) {
                case 0: goto L_0x023d;
                case 1: goto L_0x0237;
                case 2: goto L_0x0231;
                case 3: goto L_0x022b;
                case 4: goto L_0x0225;
                case 5: goto L_0x021a;
                case 6: goto L_0x0215;
                case 7: goto L_0x0210;
                default: goto L_0x020b;
            }
        L_0x020b:
            r8 = 1
            r19.skipValue()
            goto L_0x01fa
        L_0x0210:
            android.graphics.PointF r5 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r0, r1)
            goto L_0x01fa
        L_0x0215:
            android.graphics.PointF r4 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r0, r1)
            goto L_0x01fa
        L_0x021a:
            int r7 = r19.nextInt()
            r8 = 1
            if (r7 != r8) goto L_0x0223
            r7 = 1
            goto L_0x01fa
        L_0x0223:
            r7 = 0
            goto L_0x01fa
        L_0x0225:
            r8 = 1
            android.graphics.PointF r3 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r0, r9)
            goto L_0x01fa
        L_0x022b:
            r8 = 1
            android.graphics.PointF r6 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r0, r9)
            goto L_0x01fa
        L_0x0231:
            r8 = 1
            java.lang.Object r17 = r2.parse(r0, r1)
            goto L_0x01fa
        L_0x0237:
            r8 = 1
            java.lang.Object r10 = r2.parse(r0, r1)
            goto L_0x01fa
        L_0x023d:
            r8 = 1
            double r11 = r19.nextDouble()
            float r13 = (float) r11
            goto L_0x01fa
        L_0x0244:
            r19.endObject()
            if (r7 == 0) goto L_0x024e
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
            r12 = r0
            r11 = r10
            goto L_0x025c
        L_0x024e:
            if (r6 == 0) goto L_0x0257
            if (r3 == 0) goto L_0x0257
            android.view.animation.Interpolator r0 = interpolatorFor(r6, r3)
            goto L_0x0259
        L_0x0257:
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
        L_0x0259:
            r12 = r0
            r11 = r17
        L_0x025c:
            com.airbnb.lottie.value.Keyframe r0 = new com.airbnb.lottie.value.Keyframe
            r14 = 0
            r8 = r0
            r9 = r20
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0.pathCp1 = r4
            r0.pathCp2 = r5
            return r0
        L_0x026a:
            java.lang.Object r0 = r2.parse(r0, r1)
            com.airbnb.lottie.value.Keyframe r1 = new com.airbnb.lottie.value.Keyframe
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition, float, com.airbnb.lottie.parser.ValueParser, boolean, boolean):com.airbnb.lottie.value.Keyframe");
    }
}
