package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.value.Keyframe;
import com.userexperior.utilities.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import sfs2x.client.requests.buddylist.GoOnlineRequest;

public class GradientStrokeParser {
    public static final Options DASH_PATTERN_NAMES = Options.of("n", "v");
    public static final Options GRADIENT_NAMES = Options.of("p", k.f4287a);
    public static Options NAMES = Options.of("nm", "g", GoOnlineRequest.KEY_ONLINE, "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    public static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        JsonReader jsonReader2 = jsonReader;
        LottieComposition lottieComposition2 = lottieComposition;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        LineCapType lineCapType = null;
        LineJoinType lineJoinType = null;
        float f2 = 0.0f;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        AnimatableIntegerValue animatableIntegerValue = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader2.selectName(GRADIENT_NAMES);
                        if (selectName != 0) {
                            AnimatableGradientColorValue animatableGradientColorValue2 = animatableGradientColorValue;
                            if (selectName != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                                animatableGradientColorValue = animatableGradientColorValue2;
                            } else {
                                animatableGradientColorValue = new AnimatableGradientColorValue(co.hyperverge.hypersnapsdk.c.k.parse(jsonReader2, lottieComposition2, new GradientColorParser(i)));
                            }
                        } else {
                            AnimatableGradientColorValue animatableGradientColorValue3 = animatableGradientColorValue;
                            i = jsonReader.nextInt();
                        }
                    }
                    AnimatableGradientColorValue animatableGradientColorValue4 = animatableGradientColorValue;
                    jsonReader.endObject();
                    break;
                case 2:
                    animatableIntegerValue = co.hyperverge.hypersnapsdk.c.k.parseInteger(jsonReader, lottieComposition);
                    break;
                case 3:
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    animatablePointValue = co.hyperverge.hypersnapsdk.c.k.parsePoint(jsonReader, lottieComposition);
                    break;
                case 5:
                    animatablePointValue2 = co.hyperverge.hypersnapsdk.c.k.parsePoint(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue = co.hyperverge.hypersnapsdk.c.k.parseFloat(jsonReader, lottieComposition);
                    break;
                case 7:
                    lineCapType = LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case 8:
                    lineJoinType = LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case 9:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z = jsonReader.nextBoolean();
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        AnimatableFloatValue animatableFloatValue3 = null;
                        String str2 = null;
                        while (jsonReader.hasNext()) {
                            int selectName2 = jsonReader2.selectName(DASH_PATTERN_NAMES);
                            if (selectName2 != 0) {
                                AnimatableFloatValue animatableFloatValue4 = animatableFloatValue2;
                                if (selectName2 != 1) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                } else {
                                    animatableFloatValue3 = co.hyperverge.hypersnapsdk.c.k.parseFloat(jsonReader, lottieComposition);
                                }
                                animatableFloatValue2 = animatableFloatValue4;
                            } else {
                                AnimatableFloatValue animatableFloatValue5 = animatableFloatValue2;
                                str2 = jsonReader.nextString();
                            }
                        }
                        AnimatableFloatValue animatableFloatValue6 = animatableFloatValue2;
                        jsonReader.endObject();
                        String str3 = str2;
                        if (str3.equals(GoOnlineRequest.KEY_ONLINE)) {
                            animatableFloatValue2 = animatableFloatValue3;
                        } else {
                            if (str3.equals("d") || str3.equals("g")) {
                                lottieComposition2.hasDashPattern = true;
                                arrayList.add(animatableFloatValue3);
                            }
                            animatableFloatValue2 = animatableFloatValue6;
                        }
                    }
                    AnimatableFloatValue animatableFloatValue7 = animatableFloatValue2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue7;
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(Integer.valueOf(100))));
        }
        GradientStroke gradientStroke = new GradientStroke(str, gradientType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f2, arrayList, animatableFloatValue2, z);
        return gradientStroke;
    }
}
