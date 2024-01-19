package com.google.firebase.crashlytics.ndk;

import java.io.File;

public final class SessionFiles {
    public final File app;
    public final File binaryImages;
    public final File device;
    public final File metadata;
    public final File minidump;
    public final File os;
    public final File session;

    public static final class Builder {
        public File app;
        public File binaryImages;
        public File device;
        public File metadata;
        public File minidump;
        public File os;
        public File session;

        public Builder appFile(File file) {
            this.app = file;
            return this;
        }

        public Builder binaryImagesFile(File file) {
            this.binaryImages = file;
            return this;
        }

        public SessionFiles build() {
            return new SessionFiles(this);
        }

        public Builder deviceFile(File file) {
            this.device = file;
            return this;
        }

        public Builder metadataFile(File file) {
            this.metadata = file;
            return this;
        }

        public Builder minidumpFile(File file) {
            this.minidump = file;
            return this;
        }

        public Builder osFile(File file) {
            this.os = file;
            return this;
        }

        public Builder sessionFile(File file) {
            this.session = file;
            return this;
        }
    }

    public SessionFiles(Builder builder) {
        this.minidump = builder.minidump;
        this.binaryImages = builder.binaryImages;
        this.metadata = builder.metadata;
        this.session = builder.session;
        this.app = builder.app;
        this.device = builder.device;
        this.os = builder.os;
    }
}
