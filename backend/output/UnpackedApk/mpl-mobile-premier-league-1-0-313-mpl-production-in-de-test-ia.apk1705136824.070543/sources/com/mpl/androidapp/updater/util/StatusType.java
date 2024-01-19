package com.mpl.androidapp.updater.util;

public enum StatusType {
    INTEGRITY_BUNDLE_RESOURCE_FAIL(1),
    DOWNLOADING(2),
    CRITICAL(3),
    INSTALL(4),
    CHECKING_UPDATE(5),
    DOWNLOADED_APK_INTEGRITY_FAIL(6),
    PROCEED(7),
    INTERNET_ABSENT(8),
    NO_STORAGE(9),
    INSTALLED_APK_INTEGRITY_FAIL(10),
    MIN_ROOT_VERSION_FAILED(11),
    INSTALL_APK_LOW_STORAGE(12),
    ROOT_STATUS(13),
    INIT_REACT(14),
    PLAY_STORE_DOWNLOAD_CRITICAL(15),
    REACT_BUNDLE_DOWNLOADED(16),
    BACKGROUND_API_CALL(17),
    GENERIC_CONNECTION_ERROR(18);
    
    public final int value;

    /* access modifiers changed from: public */
    StatusType(int i) {
        this.value = i;
    }

    public int intValue() {
        return this.value;
    }
}
