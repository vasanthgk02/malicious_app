package org.apache.fontbox.util.autodetect;

public class AndroidFontDirFinder extends NativeFontDirFinder {
    public String[] getSearchableDirectories() {
        return new String[]{"/system/fonts"};
    }
}
