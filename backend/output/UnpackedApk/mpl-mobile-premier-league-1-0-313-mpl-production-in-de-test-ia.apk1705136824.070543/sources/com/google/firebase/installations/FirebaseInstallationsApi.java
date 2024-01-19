package com.google.firebase.installations;

import com.google.android.gms.tasks.Task;

public interface FirebaseInstallationsApi {
    Task<String> getId();

    Task<InstallationTokenResult> getToken(boolean z);
}
