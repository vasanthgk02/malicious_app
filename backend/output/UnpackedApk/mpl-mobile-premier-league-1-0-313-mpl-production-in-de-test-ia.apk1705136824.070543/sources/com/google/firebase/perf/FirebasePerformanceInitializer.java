package com.google.firebase.perf;

import com.google.firebase.perf.application.AppStateMonitor.AppColdStartCallback;

public final class FirebasePerformanceInitializer implements AppColdStartCallback {
    public void onAppColdStart() {
        FirebasePerformance.getInstance();
    }
}
