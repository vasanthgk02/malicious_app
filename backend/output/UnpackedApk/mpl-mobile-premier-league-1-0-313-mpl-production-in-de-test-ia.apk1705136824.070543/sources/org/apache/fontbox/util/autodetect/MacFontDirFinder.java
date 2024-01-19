package org.apache.fontbox.util.autodetect;

import org.apache.commons.lang.SystemUtils;

public class MacFontDirFinder extends NativeFontDirFinder {
    public String[] getSearchableDirectories() {
        return new String[]{System.getProperty(SystemUtils.USER_HOME_KEY) + "/Library/Fonts/", "/Library/Fonts/", "/System/Library/Fonts/", "/Network/Library/Fonts/"};
    }
}
