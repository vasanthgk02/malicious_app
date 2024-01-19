package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import java.io.IOException;

public class PointFParser implements ValueParser<PointF> {
    public static final PointFParser INSTANCE = new PointFParser();

    public Object parse(JsonReader jsonReader, float f2) throws IOException {
        Token peek = jsonReader.peek();
        if (peek == Token.BEGIN_ARRAY) {
            return JsonUtils.jsonToPoint(jsonReader, f2);
        }
        if (peek == Token.BEGIN_OBJECT) {
            return JsonUtils.jsonToPoint(jsonReader, f2);
        }
        if (peek == Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
    }
}
