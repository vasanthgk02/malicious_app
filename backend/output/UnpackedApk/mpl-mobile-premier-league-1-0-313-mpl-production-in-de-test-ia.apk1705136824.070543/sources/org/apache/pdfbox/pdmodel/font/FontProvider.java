package org.apache.pdfbox.pdmodel.font;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.fontbox.cff.CFFFont;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.type1.Type1Font;

public abstract class FontProvider {
    private Set<String> getPostScriptNames(String str) throws IOException {
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        hashSet.add(str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        return hashSet;
    }

    public abstract CFFFont getCFFFont(String str);

    public final Set<String> getNames(TrueTypeFont trueTypeFont) throws IOException {
        return getPostScriptNames(trueTypeFont.getName());
    }

    public abstract TrueTypeFont getTrueTypeFont(String str);

    public abstract Type1Font getType1Font(String str);

    public abstract String toDebugString();

    public final Set<String> getNames(Type1Font type1Font) throws IOException {
        return getPostScriptNames(type1Font.getName());
    }

    public final Set<String> getNames(CFFFont cFFFont) throws IOException {
        return getPostScriptNames(cFFFont.getName());
    }
}
