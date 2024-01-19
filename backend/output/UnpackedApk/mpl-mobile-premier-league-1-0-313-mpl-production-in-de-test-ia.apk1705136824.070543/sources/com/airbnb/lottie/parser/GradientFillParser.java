package com.airbnb.lottie.parser;

import android.graphics.Path.FillType;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.value.Keyframe;
import com.userexperior.utilities.k;
import java.io.IOException;
import java.util.Collections;
import sfs2x.client.requests.buddylist.GoOnlineRequest;

public class GradientFillParser {
    public static final Options GRADIENT_NAMES = Options.of("p", k.f4287a);
    public static final Options NAMES = Options.of("nm", "g", GoOnlineRequest.KEY_ONLINE, "t", "s", "e", "r", "hd");

    public static GradientFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue = null;
        FillType fillType = FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader.selectName(GRADIENT_NAMES);
                        if (selectName == 0) {
                            i = jsonReader.nextInt();
                        } else if (selectName != 1) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            animatableGradientColorValue = new AnimatableGradientColorValue(co.hyperverge.hypersnapsdk.c.k.parse(jsonReader, lottieComposition, new GradientColorParser(i)));
                        }
                    }
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
                    fillType = jsonReader.nextInt() == 1 ? FillType.WINDING : FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        GradientFill gradientFill = new GradientFill(str, gradientType, fillType, animatableGradientColorValue, animatableIntegerValue == null ? new AnimatableIntegerValue(Collections.singletonList(new Keyframe(Integer.valueOf(100)))) : animatableIntegerValue, animatablePointValue, animatablePointValue2, null, null, z);
        return gradientFill;
    }
}
