package com.airbnb.lottie.parser;

import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer.LayerType;
import com.airbnb.lottie.model.layer.Layer.MatteType;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.userexperior.e.h;
import java.util.Collections;
import java.util.List;
import sfs2x.client.requests.HandshakeRequest;
import sfs2x.client.requests.game.CreateSFSGameRequest;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

public class LayerParser {
    public static final Options EFFECTS_NAMES = Options.of("nm");
    public static final Options NAMES = Options.of("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", h.f3998a, CreateSFSGameRequest.KEY_INVITATION_PARAMS, JoinRoomInvitationRequest.KEY_OPTIONAL_PARAMS, "tm", HandshakeRequest.KEY_CLIENT_TYPE, "hd");
    public static final Options TEXT_NAMES = Options.of("d", "a");

    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0367, code lost:
        r14 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0369, code lost:
        r6 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x036b, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00b2, code lost:
        r38 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015e, code lost:
        r38 = r6;
        r40 = r14;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.model.layer.Layer parse(com.airbnb.lottie.parser.moshi.JsonReader r42, com.airbnb.lottie.LottieComposition r43) throws java.io.IOException {
        /*
            r0 = r42
            r7 = r43
            com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.NONE
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r42.beginObject()
            r2 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r9 = java.lang.Float.valueOf(r2)
            r11 = 0
            java.lang.Float r12 = java.lang.Float.valueOf(r11)
            r4 = 0
            java.lang.String r5 = "UNSET"
            r13 = 0
            r15 = -1
            r30 = r1
            r17 = r15
            r1 = 0
            r2 = 0
            r6 = 0
            r16 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 1065353216(0x3f800000, float:1.0)
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r14 = r13
            r13 = r5
        L_0x004a:
            boolean r5 = r42.hasNext()
            if (r5 == 0) goto L_0x036f
            com.airbnb.lottie.parser.moshi.JsonReader$Options r5 = NAMES
            int r5 = r0.selectName(r5)
            r11 = 1
            switch(r5) {
                case 0: goto L_0x035e;
                case 1: goto L_0x0355;
                case 2: goto L_0x034c;
                case 3: goto L_0x0333;
                case 4: goto L_0x0327;
                case 5: goto L_0x0314;
                case 6: goto L_0x0301;
                case 7: goto L_0x02f3;
                case 8: goto L_0x02e9;
                case 9: goto L_0x02a0;
                case 10: goto L_0x0164;
                case 11: goto L_0x0148;
                case 12: goto L_0x0100;
                case 13: goto L_0x00b6;
                case 14: goto L_0x00ab;
                case 15: goto L_0x00a3;
                case 16: goto L_0x0094;
                case 17: goto L_0x0085;
                case 18: goto L_0x007f;
                case 19: goto L_0x0078;
                case 20: goto L_0x0072;
                case 21: goto L_0x006c;
                case 22: goto L_0x0066;
                default: goto L_0x005a;
            }
        L_0x005a:
            r38 = r6
            r40 = r14
            r42.skipName()
            r42.skipValue()
            goto L_0x0367
        L_0x0066:
            boolean r32 = r42.nextBoolean()
            goto L_0x036b
        L_0x006c:
            java.lang.String r6 = r42.nextString()
            goto L_0x036b
        L_0x0072:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r31 = co.hyperverge.hypersnapsdk.c.k.parseFloat(r0, r7, r4)
            goto L_0x036b
        L_0x0078:
            double r2 = r42.nextDouble()
            float r2 = (float) r2
            goto L_0x036b
        L_0x007f:
            double r4 = r42.nextDouble()
            float r1 = (float) r4
            goto L_0x00b2
        L_0x0085:
            int r3 = r42.nextInt()
            float r3 = (float) r3
            float r4 = com.airbnb.lottie.utils.Utils.dpScale()
            float r4 = r4 * r3
            int r3 = (int) r4
            r27 = r3
            goto L_0x00b2
        L_0x0094:
            int r3 = r42.nextInt()
            float r3 = (float) r3
            float r4 = com.airbnb.lottie.utils.Utils.dpScale()
            float r4 = r4 * r3
            int r3 = (int) r4
            r26 = r3
            goto L_0x00b2
        L_0x00a3:
            double r3 = r42.nextDouble()
            float r3 = (float) r3
            r25 = r3
            goto L_0x00b2
        L_0x00ab:
            double r3 = r42.nextDouble()
            float r3 = (float) r3
            r24 = r3
        L_0x00b2:
            r38 = r6
            goto L_0x0369
        L_0x00b6:
            r42.beginArray()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x00be:
            boolean r4 = r42.hasNext()
            if (r4 == 0) goto L_0x00e8
            r42.beginObject()
        L_0x00c7:
            boolean r4 = r42.hasNext()
            if (r4 == 0) goto L_0x00e4
            com.airbnb.lottie.parser.moshi.JsonReader$Options r4 = EFFECTS_NAMES
            int r4 = r0.selectName(r4)
            if (r4 == 0) goto L_0x00dc
            r42.skipName()
            r42.skipValue()
            goto L_0x00c7
        L_0x00dc:
            java.lang.String r4 = r42.nextString()
            r3.add(r4)
            goto L_0x00c7
        L_0x00e4:
            r42.endObject()
            goto L_0x00be
        L_0x00e8:
            r42.endArray()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r7.addWarning(r3)
            goto L_0x015e
        L_0x0100:
            r42.beginObject()
        L_0x0103:
            boolean r3 = r42.hasNext()
            if (r3 == 0) goto L_0x0143
            com.airbnb.lottie.parser.moshi.JsonReader$Options r3 = TEXT_NAMES
            int r3 = r0.selectName(r3)
            if (r3 == 0) goto L_0x0135
            if (r3 == r11) goto L_0x011a
            r42.skipName()
            r42.skipValue()
            goto L_0x0103
        L_0x011a:
            r42.beginArray()
            boolean r3 = r42.hasNext()
            if (r3 == 0) goto L_0x0127
            com.airbnb.lottie.model.animatable.AnimatableTextProperties r29 = com.airbnb.lottie.parser.AnimatableTextPropertiesParser.parse(r42, r43)
        L_0x0127:
            boolean r3 = r42.hasNext()
            if (r3 == 0) goto L_0x0131
            r42.skipValue()
            goto L_0x0127
        L_0x0131:
            r42.endArray()
            goto L_0x0103
        L_0x0135:
            com.airbnb.lottie.model.animatable.AnimatableTextFrame r3 = new com.airbnb.lottie.model.animatable.AnimatableTextFrame
            com.airbnb.lottie.parser.DocumentDataParser r4 = com.airbnb.lottie.parser.DocumentDataParser.INSTANCE
            java.util.List r4 = co.hyperverge.hypersnapsdk.c.k.parse(r0, r7, r4)
            r3.<init>(r4)
            r28 = r3
            goto L_0x0103
        L_0x0143:
            r42.endObject()
            goto L_0x00b2
        L_0x0148:
            r42.beginArray()
        L_0x014b:
            boolean r3 = r42.hasNext()
            if (r3 == 0) goto L_0x015b
            com.airbnb.lottie.model.content.ContentModel r3 = com.airbnb.lottie.parser.ContentModelParser.parse(r42, r43)
            if (r3 == 0) goto L_0x014b
            r8.add(r3)
            goto L_0x014b
        L_0x015b:
            r42.endArray()
        L_0x015e:
            r38 = r6
            r40 = r14
            goto L_0x0367
        L_0x0164:
            r42.beginArray()
        L_0x0167:
            boolean r4 = r42.hasNext()
            if (r4 == 0) goto L_0x028e
            r42.beginObject()
            r4 = 0
            r5 = 0
            r35 = 0
            r36 = 0
        L_0x0176:
            boolean r37 = r42.hasNext()
            if (r37 == 0) goto L_0x0276
            java.lang.String r3 = r42.nextName()
            int r11 = r3.hashCode()
            r38 = r6
            r6 = 111(0x6f, float:1.56E-43)
            r39 = -1
            r40 = r14
            r14 = 2
            if (r11 == r6) goto L_0x01bc
            r6 = 3588(0xe04, float:5.028E-42)
            if (r11 == r6) goto L_0x01b2
            r6 = 104433(0x197f1, float:1.46342E-40)
            if (r11 == r6) goto L_0x01a8
            r6 = 3357091(0x3339a3, float:4.704286E-39)
            if (r11 == r6) goto L_0x019e
            goto L_0x01c6
        L_0x019e:
            java.lang.String r6 = "mode"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x01c6
            r6 = 0
            goto L_0x01c7
        L_0x01a8:
            java.lang.String r6 = "inv"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x01c6
            r6 = 3
            goto L_0x01c7
        L_0x01b2:
            java.lang.String r6 = "pt"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x01c6
            r6 = 1
            goto L_0x01c7
        L_0x01bc:
            java.lang.String r6 = "o"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x01c6
            r6 = 2
            goto L_0x01c7
        L_0x01c6:
            r6 = -1
        L_0x01c7:
            if (r6 == 0) goto L_0x01f6
            r11 = 1
            if (r6 == r11) goto L_0x01e2
            if (r6 == r14) goto L_0x01dc
            r3 = 3
            if (r6 == r3) goto L_0x01d6
            r42.skipValue()
            goto L_0x026f
        L_0x01d6:
            boolean r5 = r42.nextBoolean()
            goto L_0x026f
        L_0x01dc:
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r4 = co.hyperverge.hypersnapsdk.c.k.parseInteger(r42, r43)
            goto L_0x026f
        L_0x01e2:
            com.airbnb.lottie.model.animatable.AnimatableShapeValue r3 = new com.airbnb.lottie.model.animatable.AnimatableShapeValue
            float r6 = com.airbnb.lottie.utils.Utils.dpScale()
            com.airbnb.lottie.parser.ShapeDataParser r11 = com.airbnb.lottie.parser.ShapeDataParser.INSTANCE
            r15 = 0
            java.util.List r6 = com.airbnb.lottie.parser.KeyframesParser.parse(r0, r7, r6, r11, r15)
            r3.<init>(r6)
            r36 = r3
            goto L_0x026f
        L_0x01f6:
            r15 = 0
            java.lang.String r6 = r42.nextString()
            int r11 = r6.hashCode()
            r15 = 97
            if (r11 == r15) goto L_0x022e
            r15 = 105(0x69, float:1.47E-43)
            if (r11 == r15) goto L_0x0224
            r15 = 110(0x6e, float:1.54E-43)
            if (r11 == r15) goto L_0x021a
            r15 = 115(0x73, float:1.61E-43)
            if (r11 == r15) goto L_0x0210
            goto L_0x0238
        L_0x0210:
            java.lang.String r11 = "s"
            boolean r6 = r6.equals(r11)
            if (r6 == 0) goto L_0x0238
            r6 = 1
            goto L_0x0239
        L_0x021a:
            java.lang.String r11 = "n"
            boolean r6 = r6.equals(r11)
            if (r6 == 0) goto L_0x0238
            r6 = 2
            goto L_0x0239
        L_0x0224:
            java.lang.String r11 = "i"
            boolean r6 = r6.equals(r11)
            if (r6 == 0) goto L_0x0238
            r6 = 3
            goto L_0x0239
        L_0x022e:
            java.lang.String r11 = "a"
            boolean r6 = r6.equals(r11)
            if (r6 == 0) goto L_0x0238
            r6 = 0
            goto L_0x0239
        L_0x0238:
            r6 = -1
        L_0x0239:
            if (r6 == 0) goto L_0x026d
            r11 = 1
            if (r6 == r11) goto L_0x026a
            if (r6 == r14) goto L_0x0267
            r11 = 3
            if (r6 == r11) goto L_0x025f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = "Unknown mask mode "
            r6.append(r11)
            r6.append(r3)
            java.lang.String r3 = ". Defaulting to Add."
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            com.airbnb.lottie.utils.Logger.warning(r3)
            com.airbnb.lottie.model.content.Mask$MaskMode r35 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD
            goto L_0x026f
        L_0x025f:
            java.lang.String r3 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r7.addWarning(r3)
            com.airbnb.lottie.model.content.Mask$MaskMode r35 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT
            goto L_0x026f
        L_0x0267:
            com.airbnb.lottie.model.content.Mask$MaskMode r35 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE
            goto L_0x026f
        L_0x026a:
            com.airbnb.lottie.model.content.Mask$MaskMode r35 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT
            goto L_0x026f
        L_0x026d:
            com.airbnb.lottie.model.content.Mask$MaskMode r35 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD
        L_0x026f:
            r6 = r38
            r14 = r40
            r11 = 1
            goto L_0x0176
        L_0x0276:
            r38 = r6
            r40 = r14
            r42.endObject()
            com.airbnb.lottie.model.content.Mask r3 = new com.airbnb.lottie.model.content.Mask
            r6 = r35
            r11 = r36
            r3.<init>(r6, r11, r4, r5)
            r10.add(r3)
            r6 = r38
            r11 = 1
            goto L_0x0167
        L_0x028e:
            r38 = r6
            r40 = r14
            int r3 = r10.size()
            int r4 = r7.maskAndMatteCount
            int r4 = r4 + r3
            r7.maskAndMatteCount = r4
            r42.endArray()
            goto L_0x0367
        L_0x02a0:
            r38 = r6
            r40 = r14
            int r3 = r42.nextInt()
            com.airbnb.lottie.model.layer.Layer$MatteType[] r4 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
            int r4 = r4.length
            if (r3 < r4) goto L_0x02c5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unsupported matte type: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r7.addWarning(r3)
            goto L_0x0367
        L_0x02c5:
            com.airbnb.lottie.model.layer.Layer$MatteType[] r4 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
            r30 = r4[r3]
            int r3 = r30.ordinal()
            r4 = 3
            if (r3 == r4) goto L_0x02dc
            r4 = 4
            if (r3 == r4) goto L_0x02d6
            goto L_0x02e1
        L_0x02d6:
            java.lang.String r3 = "Unsupported matte type: Luma Inverted"
            r7.addWarning(r3)
            goto L_0x02e1
        L_0x02dc:
            java.lang.String r3 = "Unsupported matte type: Luma"
            r7.addWarning(r3)
        L_0x02e1:
            int r3 = r7.maskAndMatteCount
            r4 = 1
            int r3 = r3 + r4
            r7.maskAndMatteCount = r3
            goto L_0x0367
        L_0x02e9:
            r38 = r6
            r40 = r14
            com.airbnb.lottie.model.animatable.AnimatableTransform r20 = com.airbnb.lottie.parser.AnimatableTransformParser.parse(r42, r43)
            goto L_0x0369
        L_0x02f3:
            r38 = r6
            r40 = r14
            java.lang.String r3 = r42.nextString()
            int r23 = android.graphics.Color.parseColor(r3)
            goto L_0x0369
        L_0x0301:
            r38 = r6
            r40 = r14
            int r3 = r42.nextInt()
            float r3 = (float) r3
            float r4 = com.airbnb.lottie.utils.Utils.dpScale()
            float r4 = r4 * r3
            int r3 = (int) r4
            r22 = r3
            goto L_0x0369
        L_0x0314:
            r38 = r6
            r40 = r14
            int r3 = r42.nextInt()
            float r3 = (float) r3
            float r4 = com.airbnb.lottie.utils.Utils.dpScale()
            float r4 = r4 * r3
            int r3 = (int) r4
            r21 = r3
            goto L_0x0369
        L_0x0327:
            r38 = r6
            r40 = r14
            int r3 = r42.nextInt()
            long r3 = (long) r3
            r17 = r3
            goto L_0x0369
        L_0x0333:
            r38 = r6
            r40 = r14
            int r3 = r42.nextInt()
            com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN
            r5 = 6
            if (r3 >= r5) goto L_0x0349
            com.airbnb.lottie.model.layer.Layer$LayerType[] r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
            r3 = r4[r3]
            r16 = r3
            goto L_0x0367
        L_0x0349:
            r16 = r4
            goto L_0x0367
        L_0x034c:
            r38 = r6
            r40 = r14
            java.lang.String r19 = r42.nextString()
            goto L_0x0369
        L_0x0355:
            r38 = r6
            int r3 = r42.nextInt()
            long r3 = (long) r3
            r14 = r3
            goto L_0x0369
        L_0x035e:
            r38 = r6
            r40 = r14
            java.lang.String r13 = r42.nextString()
            goto L_0x0369
        L_0x0367:
            r14 = r40
        L_0x0369:
            r6 = r38
        L_0x036b:
            r4 = 0
            r11 = 0
            goto L_0x004a
        L_0x036f:
            r38 = r6
            r40 = r14
            r42.endObject()
            float r11 = r1 / r24
            float r14 = r2 / r24
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r0 = 0
            int r1 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x03a1
            com.airbnb.lottie.value.Keyframe r6 = new com.airbnb.lottie.value.Keyframe
            r4 = 0
            r5 = 0
            java.lang.Float r33 = java.lang.Float.valueOf(r11)
            r0 = r6
            r1 = r43
            r2 = r12
            r3 = r12
            r35 = r8
            r34 = r10
            r10 = r38
            r8 = r6
            r6 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r15.add(r8)
            goto L_0x03a7
        L_0x03a1:
            r35 = r8
            r34 = r10
            r10 = r38
        L_0x03a7:
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x03ad
            goto L_0x03b0
        L_0x03ad:
            float r0 = r7.endFrame
            r14 = r0
        L_0x03b0:
            com.airbnb.lottie.value.Keyframe r8 = new com.airbnb.lottie.value.Keyframe
            r33 = 0
            java.lang.Float r6 = java.lang.Float.valueOf(r14)
            r4 = 0
            r0 = r8
            r1 = r43
            r2 = r9
            r3 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r15.add(r8)
            com.airbnb.lottie.value.Keyframe r8 = new com.airbnb.lottie.value.Keyframe
            r0 = 2139095039(0x7f7fffff, float:3.4028235E38)
            java.lang.Float r6 = java.lang.Float.valueOf(r0)
            r0 = r8
            r2 = r12
            r3 = r12
            r4 = r33
            r5 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r15.add(r8)
            java.lang.String r0 = ".ai"
            boolean r0 = r13.endsWith(r0)
            if (r0 != 0) goto L_0x03ea
            java.lang.String r0 = "ai"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x03ef
        L_0x03ea:
            java.lang.String r0 = "Convert your Illustrator layers to shape layers."
            r7.addWarning(r0)
        L_0x03ef:
            com.airbnb.lottie.model.layer.Layer r33 = new com.airbnb.lottie.model.layer.Layer
            r0 = r33
            r1 = r35
            r2 = r43
            r3 = r13
            r4 = r40
            r6 = r16
            r7 = r17
            r9 = r19
            r10 = r34
            r11 = r20
            r12 = r21
            r13 = r22
            r14 = r23
            r21 = r15
            r15 = r24
            r16 = r25
            r17 = r26
            r18 = r27
            r19 = r28
            r20 = r29
            r22 = r30
            r23 = r31
            r24 = r32
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.LayerParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.layer.Layer");
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect rect = lottieComposition.bounds;
        List emptyList = Collections.emptyList();
        LayerType layerType = LayerType.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        AnimatableTransform animatableTransform = new AnimatableTransform(null, null, null, null, null, null, null, null, null);
        Layer layer = new Layer(emptyList, lottieComposition, "__container", -1, layerType, -1, null, emptyList2, animatableTransform, 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), MatteType.NONE, null, false);
        return layer;
    }
}
