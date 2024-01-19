package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public class JsonUtils {
    public static final Options POINT_NAMES = Options.of("x", "y");

    public static int jsonToColor(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(InvitationReply.EXPIRED, nextDouble, nextDouble2, nextDouble3);
    }

    public static PointF jsonToPoint(JsonReader jsonReader, float f2) throws IOException {
        int ordinal = jsonReader.peek().ordinal();
        if (ordinal == 0) {
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.peek() != Token.END_ARRAY) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return new PointF(nextDouble * f2, nextDouble2 * f2);
        } else if (ordinal == 2) {
            jsonReader.beginObject();
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(POINT_NAMES);
                if (selectName == 0) {
                    f3 = valueFromObject(jsonReader);
                } else if (selectName != 1) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    f4 = valueFromObject(jsonReader);
                }
            }
            jsonReader.endObject();
            return new PointF(f3 * f2, f4 * f2);
        } else if (ordinal == 6) {
            float nextDouble3 = (float) jsonReader.nextDouble();
            float nextDouble4 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return new PointF(nextDouble3 * f2, nextDouble4 * f2);
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown point starts with ");
            outline73.append(jsonReader.peek());
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    public static List<PointF> jsonToPoints(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(jsonToPoint(jsonReader, f2));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static float valueFromObject(JsonReader jsonReader) throws IOException {
        Token peek = jsonReader.peek();
        int ordinal = peek.ordinal();
        if (ordinal == 0) {
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return nextDouble;
        } else if (ordinal == 6) {
            return (float) jsonReader.nextDouble();
        } else {
            throw new IllegalArgumentException("Unknown value for token of type " + peek);
        }
    }
}
