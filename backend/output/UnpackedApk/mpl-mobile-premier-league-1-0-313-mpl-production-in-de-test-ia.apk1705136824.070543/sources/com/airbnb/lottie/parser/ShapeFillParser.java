package com.airbnb.lottie.parser;

import android.graphics.Path.FillType;
import co.hyperverge.hypersnapsdk.c.k;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;
import sfs2x.client.requests.buddylist.GoOnlineRequest;

public class ShapeFillParser {
    public static final Options NAMES = Options.of("nm", "c", GoOnlineRequest.KEY_ONLINE, "fillEnabled", "r", "hd");

    public static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue = null;
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableColorValue = k.parseColor(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableIntegerValue = k.parseInteger(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z = jsonReader.nextBoolean();
            } else if (selectName == 4) {
                i = jsonReader.nextInt();
            } else if (selectName != 5) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z2 = jsonReader.nextBoolean();
            }
        }
        ShapeFill shapeFill = new ShapeFill(str, z, i == 1 ? FillType.WINDING : FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue == null ? new AnimatableIntegerValue(Collections.singletonList(new Keyframe(Integer.valueOf(100)))) : animatableIntegerValue, z2);
        return shapeFill;
    }
}
