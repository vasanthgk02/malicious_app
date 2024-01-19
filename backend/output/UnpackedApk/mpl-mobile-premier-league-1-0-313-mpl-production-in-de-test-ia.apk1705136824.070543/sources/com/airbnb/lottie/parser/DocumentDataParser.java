package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.DocumentData.Justification;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.netcore.android.utility.f;
import java.io.IOException;

public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();
    public static final Options NAMES = Options.of("t", f.f1288a, "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    public Object parse(JsonReader jsonReader, float f2) throws IOException {
        Justification justification = Justification.CENTER;
        jsonReader.beginObject();
        Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f3 = 0.0f;
        int i = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f6 = 0.0f;
        boolean z = true;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    Justification justification3 = Justification.CENTER;
                    if (nextInt <= 2 && nextInt >= 0) {
                        justification2 = Justification.values()[nextInt];
                        break;
                    } else {
                        justification2 = Justification.CENTER;
                        break;
                    }
                case 4:
                    i = jsonReader.nextInt();
                    break;
                case 5:
                    f4 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    f5 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    i2 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 8:
                    i3 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 9:
                    f6 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        JsonReader jsonReader2 = jsonReader;
        jsonReader.endObject();
        DocumentData documentData = new DocumentData(str, str2, f3, justification2, i, f4, f5, i2, i3, f6, z);
        return documentData;
    }
}
