package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import java.io.File;

public class SessionFilesProvider implements NativeSessionFileProvider {
    public final SessionFiles sessionFiles;

    public SessionFilesProvider(SessionFiles sessionFiles2) {
        this.sessionFiles = sessionFiles2;
    }

    public File getAppFile() {
        return this.sessionFiles.app;
    }

    public File getBinaryImagesFile() {
        return this.sessionFiles.binaryImages;
    }

    public File getDeviceFile() {
        return this.sessionFiles.device;
    }

    public File getMetadataFile() {
        return this.sessionFiles.metadata;
    }

    public File getMinidumpFile() {
        return this.sessionFiles.minidump;
    }

    public File getOsFile() {
        return this.sessionFiles.os;
    }

    public File getSessionFile() {
        return this.sessionFiles.session;
    }
}
