package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;

@DoNotStrip
public class UnknownCppException extends CppException {
    @DoNotStrip
    public UnknownCppException() {
        super(Constants.DOWNLOAD_STATUS_UNKNOWN);
    }

    @DoNotStrip
    public UnknownCppException(String str) {
        super(str);
    }
}
