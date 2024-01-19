package com.mpl.androidapp.imagepicker;

import android.media.ExifInterface;
import android.os.Build.VERSION;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExifExtractor {
    public static WritableMap extract(String str) throws IOException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        List<String> basicAttributes = getBasicAttributes();
        if (VERSION.SDK_INT >= 23) {
            basicAttributes.addAll(getLevel23Attributes());
        }
        ExifInterface exifInterface = new ExifInterface(str);
        for (String next : basicAttributes) {
            writableNativeMap.putString(next, exifInterface.getAttribute(next));
        }
        return writableNativeMap;
    }

    public static List<String> getBasicAttributes() {
        return new ArrayList(Arrays.asList(new String[]{"FNumber", "DateTime", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "WhiteBalance"}));
    }

    public static List<String> getLevel23Attributes() {
        return new ArrayList(Arrays.asList(new String[]{"DateTimeDigitized", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal"}));
    }
}
