package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import sfs2x.client.entities.invitation.InvitationReply;

public class GradientColorParser implements ValueParser<GradientColor> {
    public int colorPoints;

    public GradientColorParser(int i) {
        this.colorPoints = i;
    }

    public Object parse(JsonReader jsonReader, float f2) throws IOException {
        double d2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = jsonReader.peek() == Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = arrayList.size() / 4;
        }
        int i2 = this.colorPoints;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.colorPoints * 4; i5++) {
            int i6 = i5 / 4;
            double floatValue = (double) ((Float) arrayList.get(i5)).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) floatValue;
            } else if (i7 == 1) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i7 == 2) {
                i4 = (int) (floatValue * 255.0d);
            } else if (i7 == 3) {
                iArr[i6] = Color.argb(InvitationReply.EXPIRED, i3, i4, (int) (floatValue * 255.0d));
            }
        }
        GradientColor gradientColor = new GradientColor(fArr, iArr);
        int i8 = this.colorPoints * 4;
        if (arrayList.size() > i8) {
            int size = (arrayList.size() - i8) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i9 = 0;
            while (i8 < arrayList.size()) {
                if (i8 % 2 == 0) {
                    dArr[i9] = (double) ((Float) arrayList.get(i8)).floatValue();
                } else {
                    dArr2[i9] = (double) ((Float) arrayList.get(i8)).floatValue();
                    i9++;
                }
                i8++;
            }
            while (true) {
                int[] iArr2 = gradientColor.colors;
                if (i >= iArr2.length) {
                    break;
                }
                int i10 = iArr2[i];
                double d3 = (double) gradientColor.positions[i];
                int i11 = 1;
                while (true) {
                    if (i11 >= size) {
                        d2 = dArr2[size - 1];
                        break;
                    }
                    int i12 = i11 - 1;
                    double d4 = dArr[i12];
                    double d5 = dArr[i11];
                    if (dArr[i11] >= d3) {
                        double clamp = MiscUtils.clamp((d3 - d4) / (d5 - d4), 0.0d, 1.0d);
                        double d6 = dArr2[i12];
                        d2 = ((dArr2[i11] - d6) * clamp) + d6;
                        break;
                    }
                    i11++;
                }
                gradientColor.colors[i] = Color.argb((int) (d2 * 255.0d), Color.red(i10), Color.green(i10), Color.blue(i10));
                i++;
            }
        }
        return gradientColor;
    }
}
