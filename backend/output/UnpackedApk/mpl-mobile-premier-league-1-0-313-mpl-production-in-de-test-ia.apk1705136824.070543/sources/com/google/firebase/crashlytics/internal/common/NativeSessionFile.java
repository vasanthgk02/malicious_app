package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import java.io.InputStream;

public interface NativeSessionFile {
    File asFilePayload();

    String getReportsEndpointFilename();

    InputStream getStream();
}
