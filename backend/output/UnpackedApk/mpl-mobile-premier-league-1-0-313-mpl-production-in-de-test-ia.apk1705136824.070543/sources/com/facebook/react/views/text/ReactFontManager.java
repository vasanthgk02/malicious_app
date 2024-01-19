package com.facebook.react.views.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class ReactFontManager {
    public static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    public static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    public static ReactFontManager sReactFontManagerInstance;
    public final Map<String, Typeface> mCustomTypefaceCache = new HashMap();
    public final Map<String, FontFamily> mFontCache = new HashMap();

    public static class FontFamily {
        public SparseArray<Typeface> mTypefaceSparseArray = new SparseArray<>(4);

        public FontFamily() {
        }

        public FontFamily(AnonymousClass1 r2) {
        }
    }
}
