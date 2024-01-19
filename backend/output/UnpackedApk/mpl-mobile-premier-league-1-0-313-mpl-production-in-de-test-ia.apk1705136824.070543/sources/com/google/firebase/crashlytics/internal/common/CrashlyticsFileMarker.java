package com.google.firebase.crashlytics.internal.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

public class CrashlyticsFileMarker {
    public final FileStore fileStore;
    public final String markerName;

    public CrashlyticsFileMarker(String str, FileStore fileStore2) {
        this.markerName = str;
        this.fileStore = fileStore2;
    }

    private File getMarkerFile() {
        return this.fileStore.getCommonFile(this.markerName);
    }

    public boolean create() {
        try {
            return getMarkerFile().createNewFile();
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error creating marker: ");
            outline73.append(this.markerName);
            logger.e(outline73.toString(), e2);
            return false;
        }
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }
}
