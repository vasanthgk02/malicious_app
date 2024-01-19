package org.apache.fontbox.util.autodetect;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.SystemUtils;

public class UnixFontDirFinder extends NativeFontDirFinder {
    public Map<String, String> getCommonTTFMapping() {
        HashMap outline88 = GeneratedOutlineSupport.outline88("TimesNewRoman,BoldItalic", "LiberationSerif-BoldItalic", "TimesNewRoman,Bold", "LiberationSerif-Bold");
        outline88.put("TimesNewRoman,Italic", "LiberationSerif-Italic");
        outline88.put("TimesNewRoman", "LiberationSerif");
        outline88.put("Arial,BoldItalic", "LiberationSans-BoldItalic");
        outline88.put("Arial,Italic", "LiberationSans-Italic");
        outline88.put("Arial,Bold", "LiberationSans-Bold");
        outline88.put("Arial", "LiberationSans");
        outline88.put("Courier,BoldItalic", "LiberationMono-BoldItalic");
        outline88.put("Courier,Italic", "LiberationMono-Italic");
        outline88.put("Courier,Bold", "LiberationMono-Bold");
        outline88.put("Courier", "LiberationMono");
        outline88.put("Symbol", "OpenSymbol");
        outline88.put("ZapfDingbats", "Dingbats");
        return Collections.unmodifiableMap(outline88);
    }

    public String[] getSearchableDirectories() {
        return new String[]{System.getProperty(SystemUtils.USER_HOME_KEY) + "/.fonts", "/usr/local/fonts", "/usr/local/share/fonts", "/usr/share/fonts", "/usr/X11R6/lib/X11/fonts"};
    }
}
