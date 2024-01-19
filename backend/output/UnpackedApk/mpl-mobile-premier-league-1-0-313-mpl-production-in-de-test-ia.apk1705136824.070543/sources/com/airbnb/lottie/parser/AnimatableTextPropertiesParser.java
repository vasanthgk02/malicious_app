package com.airbnb.lottie.parser;

import co.hyperverge.hypersnapsdk.c.k;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import java.io.IOException;

public class AnimatableTextPropertiesParser {
    public static Options ANIMATABLE_PROPERTIES_NAMES = Options.of("fc", "sc", "sw", "t");
    public static Options PROPERTIES_NAMES = Options.of("a");

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(PROPERTIES_NAMES) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginObject();
                AnimatableColorValue animatableColorValue = null;
                AnimatableColorValue animatableColorValue2 = null;
                AnimatableFloatValue animatableFloatValue = null;
                AnimatableFloatValue animatableFloatValue2 = null;
                while (jsonReader.hasNext()) {
                    int selectName = jsonReader.selectName(ANIMATABLE_PROPERTIES_NAMES);
                    if (selectName == 0) {
                        animatableColorValue = k.parseColor(jsonReader, lottieComposition);
                    } else if (selectName == 1) {
                        animatableColorValue2 = k.parseColor(jsonReader, lottieComposition);
                    } else if (selectName == 2) {
                        animatableFloatValue = k.parseFloat(jsonReader, lottieComposition);
                    } else if (selectName != 3) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        animatableFloatValue2 = k.parseFloat(jsonReader, lottieComposition);
                    }
                }
                jsonReader.endObject();
                animatableTextProperties = new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
            }
        }
        jsonReader.endObject();
        return animatableTextProperties == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties;
    }
}
