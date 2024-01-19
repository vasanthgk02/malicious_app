package com.google.android.gms.tasks;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    @KeepForSdk
    public native void nativeOnComplete(long j, Object obj, boolean z, boolean z2, String str);

    @KeepForSdk
    public void onComplete(Task<Object> task) {
        String str;
        Object obj;
        if (task.isSuccessful()) {
            obj = task.getResult();
            str = null;
        } else {
            if (!((zzw) task).zzd) {
                Exception exception = task.getException();
                if (exception != null) {
                    str = exception.getMessage();
                    obj = null;
                }
            }
            obj = null;
            str = null;
        }
        nativeOnComplete(0, obj, task.isSuccessful(), ((zzw) task).zzd, str);
    }
}
