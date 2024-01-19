package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader.Options;

public class ContentModelParser {
    public static Options NAMES = Options.of("ty", "d");

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0093, code lost:
        if (r2.equals("gs") != false) goto L_0x00bf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.model.content.ContentModel parse(com.airbnb.lottie.parser.moshi.JsonReader r6, com.airbnb.lottie.LottieComposition r7) throws java.io.IOException {
        /*
            r6.beginObject()
            r0 = 2
            r1 = 2
        L_0x0005:
            boolean r2 = r6.hasNext()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0028
            com.airbnb.lottie.parser.moshi.JsonReader$Options r2 = NAMES
            int r2 = r6.selectName(r2)
            if (r2 == 0) goto L_0x0023
            if (r2 == r4) goto L_0x001e
            r6.skipName()
            r6.skipValue()
            goto L_0x0005
        L_0x001e:
            int r1 = r6.nextInt()
            goto L_0x0005
        L_0x0023:
            java.lang.String r2 = r6.nextString()
            goto L_0x0029
        L_0x0028:
            r2 = r3
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            return r3
        L_0x002c:
            int r5 = r2.hashCode()
            switch(r5) {
                case 3239: goto L_0x00b4;
                case 3270: goto L_0x00aa;
                case 3295: goto L_0x00a0;
                case 3307: goto L_0x0096;
                case 3308: goto L_0x008d;
                case 3488: goto L_0x0082;
                case 3633: goto L_0x0077;
                case 3646: goto L_0x006c;
                case 3669: goto L_0x0062;
                case 3679: goto L_0x0057;
                case 3681: goto L_0x004c;
                case 3705: goto L_0x0040;
                case 3710: goto L_0x0035;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x00be
        L_0x0035:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 5
            goto L_0x00bf
        L_0x0040:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 9
            goto L_0x00bf
        L_0x004c:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 1
            goto L_0x00bf
        L_0x0057:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 10
            goto L_0x00bf
        L_0x0062:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 6
            goto L_0x00bf
        L_0x006c:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 12
            goto L_0x00bf
        L_0x0077:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 8
            goto L_0x00bf
        L_0x0082:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 11
            goto L_0x00bf
        L_0x008d:
            java.lang.String r4 = "gs"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x00be
            goto L_0x00bf
        L_0x0096:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 0
            goto L_0x00bf
        L_0x00a0:
            java.lang.String r0 = "gf"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 4
            goto L_0x00bf
        L_0x00aa:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 3
            goto L_0x00bf
        L_0x00b4:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00be
            r0 = 7
            goto L_0x00bf
        L_0x00be:
            r0 = -1
        L_0x00bf:
            switch(r0) {
                case 0: goto L_0x0118;
                case 1: goto L_0x0113;
                case 2: goto L_0x010e;
                case 3: goto L_0x0109;
                case 4: goto L_0x0104;
                case 5: goto L_0x00ff;
                case 6: goto L_0x00fa;
                case 7: goto L_0x00f5;
                case 8: goto L_0x00f0;
                case 9: goto L_0x00eb;
                case 10: goto L_0x00e6;
                case 11: goto L_0x00dc;
                case 12: goto L_0x00d7;
                default: goto L_0x00c2;
            }
        L_0x00c2:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unknown shape type "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            com.airbnb.lottie.utils.Logger.warning(r7)
            goto L_0x011c
        L_0x00d7:
            com.airbnb.lottie.model.content.Repeater r3 = com.airbnb.lottie.parser.RepeaterParser.parse(r6, r7)
            goto L_0x011c
        L_0x00dc:
            com.airbnb.lottie.model.content.MergePaths r3 = com.airbnb.lottie.parser.MergePathsParser.parse(r6)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r7.addWarning(r0)
            goto L_0x011c
        L_0x00e6:
            com.airbnb.lottie.model.content.PolystarShape r3 = com.airbnb.lottie.parser.PolystarShapeParser.parse(r6, r7)
            goto L_0x011c
        L_0x00eb:
            com.airbnb.lottie.model.content.ShapeTrimPath r3 = com.airbnb.lottie.parser.ShapeTrimPathParser.parse(r6, r7)
            goto L_0x011c
        L_0x00f0:
            com.airbnb.lottie.model.content.RectangleShape r3 = com.airbnb.lottie.parser.RectangleShapeParser.parse(r6, r7)
            goto L_0x011c
        L_0x00f5:
            com.airbnb.lottie.model.content.CircleShape r3 = com.airbnb.lottie.parser.CircleShapeParser.parse(r6, r7, r1)
            goto L_0x011c
        L_0x00fa:
            com.airbnb.lottie.model.content.ShapePath r3 = com.airbnb.lottie.parser.ShapePathParser.parse(r6, r7)
            goto L_0x011c
        L_0x00ff:
            com.airbnb.lottie.model.animatable.AnimatableTransform r3 = com.airbnb.lottie.parser.AnimatableTransformParser.parse(r6, r7)
            goto L_0x011c
        L_0x0104:
            com.airbnb.lottie.model.content.GradientFill r3 = com.airbnb.lottie.parser.GradientFillParser.parse(r6, r7)
            goto L_0x011c
        L_0x0109:
            com.airbnb.lottie.model.content.ShapeFill r3 = com.airbnb.lottie.parser.ShapeFillParser.parse(r6, r7)
            goto L_0x011c
        L_0x010e:
            com.airbnb.lottie.model.content.GradientStroke r3 = com.airbnb.lottie.parser.GradientStrokeParser.parse(r6, r7)
            goto L_0x011c
        L_0x0113:
            com.airbnb.lottie.model.content.ShapeStroke r3 = com.airbnb.lottie.parser.ShapeStrokeParser.parse(r6, r7)
            goto L_0x011c
        L_0x0118:
            com.airbnb.lottie.model.content.ShapeGroup r3 = com.airbnb.lottie.parser.ShapeGroupParser.parse(r6, r7)
        L_0x011c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0126
            r6.skipValue()
            goto L_0x011c
        L_0x0126:
            r6.endObject()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ContentModelParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ContentModel");
    }
}
