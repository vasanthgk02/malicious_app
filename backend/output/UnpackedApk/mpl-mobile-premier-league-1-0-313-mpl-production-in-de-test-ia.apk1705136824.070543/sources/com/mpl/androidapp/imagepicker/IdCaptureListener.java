package com.mpl.androidapp.imagepicker;

public interface IdCaptureListener {
    void onError(String str);

    void onIdCaptureFail(String str);

    void onIdCaptureSuccess(String str);
}
