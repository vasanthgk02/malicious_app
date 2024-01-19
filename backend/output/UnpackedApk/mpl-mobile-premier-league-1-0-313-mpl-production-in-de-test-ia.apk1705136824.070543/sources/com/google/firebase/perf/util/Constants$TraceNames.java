package com.google.firebase.perf.util;

public enum Constants$TraceNames {
    APP_START_TRACE_NAME("_as"),
    ON_CREATE_TRACE_NAME("_astui"),
    ON_START_TRACE_NAME("_astfd"),
    ON_RESUME_TRACE_NAME("_asti"),
    FOREGROUND_TRACE_NAME("_fs"),
    BACKGROUND_TRACE_NAME("_bs");
    
    public String mName;

    /* access modifiers changed from: public */
    Constants$TraceNames(String str) {
        this.mName = str;
    }

    public String toString() {
        return this.mName;
    }
}
