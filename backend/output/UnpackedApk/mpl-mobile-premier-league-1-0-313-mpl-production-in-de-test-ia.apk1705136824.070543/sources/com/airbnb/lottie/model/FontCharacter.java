package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public class FontCharacter {
    public final char character;
    public final String fontFamily;
    public final List<ShapeGroup> shapes;
    public final String style;
    public final double width;

    public FontCharacter(List<ShapeGroup> list, char c2, double d2, double d3, String str, String str2) {
        this.shapes = list;
        this.character = c2;
        this.width = d3;
        this.style = str;
        this.fontFamily = str2;
    }

    public static int hashFor(char c2, String str, String str2) {
        return str2.hashCode() + GeneratedOutlineSupport.outline11(str, (c2 + 0) * 31, 31);
    }

    public int hashCode() {
        return hashFor(this.character, this.fontFamily, this.style);
    }
}
