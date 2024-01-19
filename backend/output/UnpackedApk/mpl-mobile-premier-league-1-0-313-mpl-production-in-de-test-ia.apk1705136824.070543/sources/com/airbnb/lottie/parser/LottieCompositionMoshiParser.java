package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.userexperior.e.h;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;
import sfs2x.client.requests.FindRoomsRequest;
import sfs2x.client.requests.game.CreateSFSGameRequest;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

public class LottieCompositionMoshiParser {
    public static Options ASSETS_NAMES = Options.of("id", Values.LAYERS, "w", h.f3998a, "p", "u");
    public static final Options FONT_NAMES = Options.of("list");
    public static final Options MARKER_NAMES = Options.of("cm", "tm", "dr");
    public static final Options NAMES = Options.of("w", h.f3998a, CreateSFSGameRequest.KEY_INVITATION_PARAMS, JoinRoomInvitationRequest.KEY_OPTIONAL_PARAMS, FindRoomsRequest.KEY_FILTERED_ROOMS, "v", Values.LAYERS, "assets", "fonts", "chars", "markers");

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02a8, code lost:
        r11 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02c7, code lost:
        r14 = r3;
        r15 = r21;
        r8 = r22;
        r11 = r23;
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0127, code lost:
        r22 = r8;
        r30 = r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.LottieComposition parse(com.airbnb.lottie.parser.moshi.JsonReader r31) throws java.io.IOException {
        /*
            r0 = r31
            float r1 = com.airbnb.lottie.utils.Utils.dpScale()
            androidx.collection.LongSparseArray r2 = new androidx.collection.LongSparseArray
            r3 = 10
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            androidx.collection.SparseArrayCompat r9 = new androidx.collection.SparseArrayCompat
            r9.<init>()
            com.airbnb.lottie.LottieComposition r10 = new com.airbnb.lottie.LottieComposition
            r10.<init>()
            r31.beginObject()
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0039:
            boolean r17 = r31.hasNext()
            if (r17 == 0) goto L_0x02d1
            com.airbnb.lottie.parser.moshi.JsonReader$Options r12 = NAMES
            int r12 = r0.selectName(r12)
            r18 = 0
            switch(r12) {
                case 0: goto L_0x02b8;
                case 1: goto L_0x02ab;
                case 2: goto L_0x029c;
                case 3: goto L_0x0288;
                case 4: goto L_0x0275;
                case 5: goto L_0x0234;
                case 6: goto L_0x01eb;
                case 7: goto L_0x012d;
                case 8: goto L_0x00f0;
                case 9: goto L_0x00d2;
                case 10: goto L_0x005b;
                default: goto L_0x004a;
            }
        L_0x004a:
            r22 = r8
            r23 = r11
            r30 = r13
            r3 = r14
            r21 = r15
            r31.skipName()
            r31.skipValue()
            goto L_0x02c7
        L_0x005b:
            r31.beginArray()
        L_0x005e:
            boolean r12 = r31.hasNext()
            if (r12 == 0) goto L_0x00c9
            r31.beginObject()
            r12 = r18
            r21 = 0
            r22 = 0
        L_0x006d:
            boolean r20 = r31.hasNext()
            if (r20 == 0) goto L_0x00ae
            com.airbnb.lottie.parser.moshi.JsonReader$Options r3 = MARKER_NAMES
            int r3 = r0.selectName(r3)
            if (r3 == 0) goto L_0x00a3
            r23 = r11
            r11 = 1
            if (r3 == r11) goto L_0x0095
            r11 = 2
            if (r3 == r11) goto L_0x008a
            r31.skipName()
            r31.skipValue()
            goto L_0x00ab
        L_0x008a:
            r3 = r14
            r11 = r15
            double r14 = r31.nextDouble()
            float r14 = (float) r14
            r15 = r11
            r22 = r14
            goto L_0x009f
        L_0x0095:
            r3 = r14
            r11 = r15
            double r14 = r31.nextDouble()
            float r14 = (float) r14
            r15 = r11
            r21 = r14
        L_0x009f:
            r11 = r23
            r14 = r3
            goto L_0x006d
        L_0x00a3:
            r23 = r11
            r3 = r14
            r11 = r15
            java.lang.String r12 = r31.nextString()
        L_0x00ab:
            r11 = r23
            goto L_0x006d
        L_0x00ae:
            r23 = r11
            r3 = r14
            r11 = r15
            r31.endObject()
            com.airbnb.lottie.model.Marker r14 = new com.airbnb.lottie.model.Marker
            r15 = r21
            r21 = r11
            r11 = r22
            r14.<init>(r12, r15, r11)
            r8.add(r14)
            r14 = r3
            r15 = r21
            r11 = r23
            goto L_0x005e
        L_0x00c9:
            r23 = r11
            r3 = r14
            r21 = r15
            r31.endArray()
            goto L_0x0127
        L_0x00d2:
            r23 = r11
            r3 = r14
            r21 = r15
            r31.beginArray()
        L_0x00da:
            boolean r11 = r31.hasNext()
            if (r11 == 0) goto L_0x00ec
            com.airbnb.lottie.model.FontCharacter r11 = com.airbnb.lottie.parser.FontCharacterParser.parse(r0, r10)
            int r12 = r11.hashCode()
            r9.put(r12, r11)
            goto L_0x00da
        L_0x00ec:
            r31.endArray()
            goto L_0x0127
        L_0x00f0:
            r23 = r11
            r3 = r14
            r21 = r15
            r31.beginObject()
        L_0x00f8:
            boolean r11 = r31.hasNext()
            if (r11 == 0) goto L_0x0124
            com.airbnb.lottie.parser.moshi.JsonReader$Options r11 = FONT_NAMES
            int r11 = r0.selectName(r11)
            if (r11 == 0) goto L_0x010d
            r31.skipName()
            r31.skipValue()
            goto L_0x00f8
        L_0x010d:
            r31.beginArray()
        L_0x0110:
            boolean r11 = r31.hasNext()
            if (r11 == 0) goto L_0x0120
            com.airbnb.lottie.model.Font r11 = com.airbnb.lottie.parser.FontParser.parse(r31)
            java.lang.String r12 = r11.name
            r7.put(r12, r11)
            goto L_0x0110
        L_0x0120:
            r31.endArray()
            goto L_0x00f8
        L_0x0124:
            r31.endObject()
        L_0x0127:
            r22 = r8
            r30 = r13
            goto L_0x02c7
        L_0x012d:
            r23 = r11
            r3 = r14
            r21 = r15
            r31.beginArray()
        L_0x0135:
            boolean r11 = r31.hasNext()
            if (r11 == 0) goto L_0x01e2
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            androidx.collection.LongSparseArray r12 = new androidx.collection.LongSparseArray
            r14 = 10
            r12.<init>(r14)
            r31.beginObject()
            r15 = r18
            r28 = r15
            r29 = r28
            r25 = 0
            r26 = 0
        L_0x0154:
            boolean r19 = r31.hasNext()
            if (r19 == 0) goto L_0x01c1
            com.airbnb.lottie.parser.moshi.JsonReader$Options r14 = ASSETS_NAMES
            int r14 = r0.selectName(r14)
            if (r14 == 0) goto L_0x01b6
            r22 = r8
            r8 = 1
            if (r14 == r8) goto L_0x0192
            r8 = 2
            if (r14 == r8) goto L_0x018b
            r8 = 3
            if (r14 == r8) goto L_0x0186
            r8 = 4
            if (r14 == r8) goto L_0x0181
            r8 = 5
            if (r14 == r8) goto L_0x017c
            r31.skipName()
            r31.skipValue()
            r30 = r13
            goto L_0x01b1
        L_0x017c:
            java.lang.String r29 = r31.nextString()
            goto L_0x018f
        L_0x0181:
            java.lang.String r28 = r31.nextString()
            goto L_0x018f
        L_0x0186:
            int r26 = r31.nextInt()
            goto L_0x018f
        L_0x018b:
            int r25 = r31.nextInt()
        L_0x018f:
            r8 = r22
            goto L_0x01be
        L_0x0192:
            r31.beginArray()
        L_0x0195:
            boolean r8 = r31.hasNext()
            if (r8 == 0) goto L_0x01ac
            com.airbnb.lottie.model.layer.Layer r8 = com.airbnb.lottie.parser.LayerParser.parse(r0, r10)
            r30 = r13
            long r13 = r8.layerId
            r12.put(r13, r8)
            r11.add(r8)
            r13 = r30
            goto L_0x0195
        L_0x01ac:
            r30 = r13
            r31.endArray()
        L_0x01b1:
            r8 = r22
            r13 = r30
            goto L_0x01be
        L_0x01b6:
            r22 = r8
            r30 = r13
            java.lang.String r15 = r31.nextString()
        L_0x01be:
            r14 = 10
            goto L_0x0154
        L_0x01c1:
            r22 = r8
            r30 = r13
            r31.endObject()
            if (r28 == 0) goto L_0x01d9
            com.airbnb.lottie.LottieImageAsset r8 = new com.airbnb.lottie.LottieImageAsset
            r24 = r8
            r27 = r15
            r24.<init>(r25, r26, r27, r28, r29)
            java.lang.String r11 = r8.id
            r6.put(r11, r8)
            goto L_0x01dc
        L_0x01d9:
            r5.put(r15, r11)
        L_0x01dc:
            r8 = r22
            r13 = r30
            goto L_0x0135
        L_0x01e2:
            r22 = r8
            r30 = r13
            r31.endArray()
            goto L_0x02c7
        L_0x01eb:
            r22 = r8
            r23 = r11
            r30 = r13
            r3 = r14
            r21 = r15
            r31.beginArray()
            r8 = 0
        L_0x01f8:
            boolean r11 = r31.hasNext()
            if (r11 == 0) goto L_0x022f
            com.airbnb.lottie.model.layer.Layer r11 = com.airbnb.lottie.parser.LayerParser.parse(r0, r10)
            com.airbnb.lottie.model.layer.Layer$LayerType r12 = r11.layerType
            com.airbnb.lottie.model.layer.Layer$LayerType r13 = com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE
            if (r12 != r13) goto L_0x020a
            int r8 = r8 + 1
        L_0x020a:
            r4.add(r11)
            long r12 = r11.layerId
            r2.put(r12, r11)
            r11 = 4
            if (r8 <= r11) goto L_0x01f8
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "You have "
            r11.append(r12)
            r11.append(r8)
            java.lang.String r12 = " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers."
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.airbnb.lottie.utils.Logger.warning(r11)
            goto L_0x01f8
        L_0x022f:
            r31.endArray()
            goto L_0x02c7
        L_0x0234:
            r22 = r8
            r23 = r11
            r30 = r13
            r3 = r14
            r21 = r15
            java.lang.String r8 = r31.nextString()
            java.lang.String r11 = "\\."
            java.lang.String[] r8 = r8.split(r11)
            r11 = 0
            r12 = r8[r11]
            int r11 = java.lang.Integer.parseInt(r12)
            r12 = 1
            r13 = r8[r12]
            int r13 = java.lang.Integer.parseInt(r13)
            r14 = 2
            r8 = r8[r14]
            int r8 = java.lang.Integer.parseInt(r8)
            r14 = 4
            if (r11 >= r14) goto L_0x0260
            goto L_0x026c
        L_0x0260:
            if (r11 <= r14) goto L_0x0263
            goto L_0x026d
        L_0x0263:
            if (r13 >= r14) goto L_0x0266
            goto L_0x026c
        L_0x0266:
            if (r13 <= r14) goto L_0x0269
            goto L_0x026d
        L_0x0269:
            if (r8 < 0) goto L_0x026c
            goto L_0x026d
        L_0x026c:
            r12 = 0
        L_0x026d:
            if (r12 != 0) goto L_0x02c7
            java.lang.String r8 = "Lottie only supports bodymovin >= 4.4.0"
            r10.addWarning(r8)
            goto L_0x02c7
        L_0x0275:
            r22 = r8
            r23 = r11
            r30 = r13
            r3 = r14
            r21 = r15
            double r11 = r31.nextDouble()
            float r8 = (float) r11
            r16 = r8
            r8 = r22
            goto L_0x02a8
        L_0x0288:
            r22 = r8
            r30 = r13
            r3 = r14
            r21 = r15
            double r11 = r31.nextDouble()
            float r8 = (float) r11
            r11 = 1008981770(0x3c23d70a, float:0.01)
            float r11 = r8 - r11
            r8 = r22
            goto L_0x02c3
        L_0x029c:
            r22 = r8
            r23 = r11
            r30 = r13
            r3 = r14
            double r11 = r31.nextDouble()
            float r15 = (float) r11
        L_0x02a8:
            r11 = r23
            goto L_0x02c3
        L_0x02ab:
            r22 = r8
            r23 = r11
            r30 = r13
            r21 = r15
            int r14 = r31.nextInt()
            goto L_0x02c3
        L_0x02b8:
            r22 = r8
            r23 = r11
            r3 = r14
            r21 = r15
            int r13 = r31.nextInt()
        L_0x02c3:
            r3 = 10
            goto L_0x0039
        L_0x02c7:
            r14 = r3
            r15 = r21
            r8 = r22
            r11 = r23
            r13 = r30
            goto L_0x02c3
        L_0x02d1:
            r22 = r8
            r23 = r11
            r12 = r13
            r3 = r14
            r21 = r15
            float r0 = (float) r12
            float r0 = r0 * r1
            int r0 = (int) r0
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = (int) r3
            android.graphics.Rect r3 = new android.graphics.Rect
            r8 = 0
            r3.<init>(r8, r8, r0, r1)
            r10.bounds = r3
            r15 = r21
            r10.startFrame = r15
            r11 = r23
            r10.endFrame = r11
            r8 = r16
            r10.frameRate = r8
            r10.layers = r4
            r10.layerMap = r2
            r10.precomps = r5
            r10.images = r6
            r10.characters = r9
            r10.fonts = r7
            r0 = r22
            r10.markers = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.LottieCompositionMoshiParser.parse(com.airbnb.lottie.parser.moshi.JsonReader):com.airbnb.lottie.LottieComposition");
    }
}
