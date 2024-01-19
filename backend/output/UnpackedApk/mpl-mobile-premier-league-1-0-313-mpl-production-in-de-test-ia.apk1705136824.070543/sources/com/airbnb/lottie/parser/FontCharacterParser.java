package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import java.io.IOException;
import java.util.ArrayList;

public class FontCharacterParser {
    public static final Options DATA_NAMES = Options.of("shapes");
    public static final Options NAMES = Options.of("ch", Response.SIZE, "w", "style", "fFamily", "data");

    public static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double d2 = 0.0d;
        String str = null;
        String str2 = null;
        double d3 = 0.0d;
        char c2 = 0;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                c2 = jsonReader.nextString().charAt(0);
            } else if (selectName == 1) {
                d2 = jsonReader.nextDouble();
            } else if (selectName == 2) {
                d3 = jsonReader.nextDouble();
            } else if (selectName == 3) {
                str = jsonReader.nextString();
            } else if (selectName == 4) {
                str2 = jsonReader.nextString();
            } else if (selectName != 5) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if (jsonReader.selectName(DATA_NAMES) != 0) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add((ShapeGroup) ContentModelParser.parse(jsonReader, lottieComposition));
                        }
                        jsonReader.endArray();
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        FontCharacter fontCharacter = new FontCharacter(arrayList, c2, d2, d3, str, str2);
        return fontCharacter;
    }
}