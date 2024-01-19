package org.apache.pdfbox.pdmodel.graphics.state;

public enum RenderingIntent {
    ABSOLUTE_COLORIMETRIC("AbsoluteColorimetric"),
    RELATIVE_COLORIMETRIC("RelativeColorimetric"),
    SATURATION("Saturation"),
    PERCEPTUAL("Perceptual");
    
    public final String value;

    /* access modifiers changed from: public */
    RenderingIntent(String str) {
        this.value = str;
    }

    public static RenderingIntent fromString(String str) {
        if (str.equals("AbsoluteColorimetric")) {
            return ABSOLUTE_COLORIMETRIC;
        }
        if (str.equals("RelativeColorimetric")) {
            return RELATIVE_COLORIMETRIC;
        }
        if (str.equals("Saturation")) {
            return SATURATION;
        }
        if (str.equals("Perceptual")) {
            return PERCEPTUAL;
        }
        throw new IllegalArgumentException(str);
    }

    public String stringValue() {
        return this.value;
    }
}
