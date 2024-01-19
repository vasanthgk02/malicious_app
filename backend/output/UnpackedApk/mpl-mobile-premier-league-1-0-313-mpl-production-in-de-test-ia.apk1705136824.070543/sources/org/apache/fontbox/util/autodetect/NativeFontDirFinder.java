package org.apache.fontbox.util.autodetect;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class NativeFontDirFinder implements FontDirFinder {
    public List<File> find() {
        ArrayList arrayList = new ArrayList();
        String[] searchableDirectories = getSearchableDirectories();
        if (searchableDirectories != null) {
            for (String file : searchableDirectories) {
                File file2 = new File(file);
                if (file2.exists() && file2.canRead()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public abstract String[] getSearchableDirectories();
}
