package com.getkeepsafe.relinker;

public final class SystemLibraryLoader implements ReLinker$LibraryLoader {
    public String mapLibraryName(String str) {
        if (!str.startsWith("lib") || !str.endsWith(".so")) {
            return System.mapLibraryName(str);
        }
        return str;
    }
}
