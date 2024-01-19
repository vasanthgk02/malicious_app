package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sfs2x.client.requests.buddylist.GoOnlineRequest;

public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();
    public static final Options NAMES = Options.of("c", "v", "i", GoOnlineRequest.KEY_ONLINE);

    public Object parse(JsonReader jsonReader, float f2) throws IOException {
        if (jsonReader.peek() == Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List list2 = null;
        List list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                z = jsonReader.nextBoolean();
            } else if (selectName == 1) {
                list = JsonUtils.jsonToPoints(jsonReader, f2);
            } else if (selectName == 2) {
                list2 = JsonUtils.jsonToPoints(jsonReader, f2);
            } else if (selectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                list3 = JsonUtils.jsonToPoints(jsonReader, f2);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i2), (PointF) list3.get(i2)), MiscUtils.addPoints(pointF2, (PointF) list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i3), (PointF) list3.get(i3)), MiscUtils.addPoints(pointF3, (PointF) list2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z, arrayList);
        }
    }
}
