package org.apache.fontbox.util.autodetect;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class FontFileFinder {
    public FontDirFinder fontDirFinder = null;

    private boolean checkFontfile(File file) {
        String lowerCase = file.getName().toLowerCase();
        return lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf") || lowerCase.endsWith(".pfb") || lowerCase.endsWith(".ttc");
    }

    private FontDirFinder determineDirFinder() {
        if (System.getProperty("java.vendor").equals("The Android Project")) {
            return new AndroidFontDirFinder();
        }
        return new UnixFontDirFinder();
    }

    private void walk(File file, List<URI> list) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        if (!file2.getName().startsWith(".")) {
                            walk(file2, list);
                        }
                    } else if (checkFontfile(file2)) {
                        list.add(file2.toURI());
                    }
                }
            }
        }
    }

    public List<URI> find() {
        if (this.fontDirFinder == null) {
            this.fontDirFinder = determineDirFinder();
        }
        List<File> find = this.fontDirFinder.find();
        ArrayList arrayList = new ArrayList();
        for (File walk : find) {
            walk(walk, arrayList);
        }
        return arrayList;
    }

    public List<URI> find(String str) {
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            walk(file, arrayList);
        }
        return arrayList;
    }
}
