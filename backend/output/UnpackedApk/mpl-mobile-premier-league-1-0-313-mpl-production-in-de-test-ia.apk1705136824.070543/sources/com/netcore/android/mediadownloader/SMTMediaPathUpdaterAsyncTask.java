package com.netcore.android.mediadownloader;

import android.content.Context;
import android.os.AsyncTask;
import com.netcore.android.mediadownloader.SMTMediaDownloadManager.DownloadStatus;
import com.netcore.android.notification.models.SMTNotificationData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0005\u001a\u00020\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0003\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTMediaPathUpdaterAsyncTask;", "Landroid/os/AsyncTask;", "", "", "p0", "doInBackground", "([Lkotlin/Unit;)V", "Lcom/netcore/android/notification/models/SMTNotificationData;", "notification", "Lcom/netcore/android/notification/models/SMTNotificationData;", "getNotification", "()Lcom/netcore/android/notification/models/SMTNotificationData;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "context", "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/netcore/android/notification/models/SMTNotificationData;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTMediaPathUpdaterAsyncTask.kt */
public final class SMTMediaPathUpdaterAsyncTask extends AsyncTask<Unit, Unit, Unit> {
    public final WeakReference<Context> context;
    public final SMTNotificationData notification;

    public SMTMediaPathUpdaterAsyncTask(WeakReference<Context> weakReference, SMTNotificationData sMTNotificationData) {
        Intrinsics.checkNotNullParameter(weakReference, "context");
        Intrinsics.checkNotNullParameter(sMTNotificationData, "notification");
        this.context = weakReference;
        this.notification = sMTNotificationData;
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        doInBackground((Unit[]) objArr);
        return Unit.INSTANCE;
    }

    public final WeakReference<Context> getContext() {
        return this.context;
    }

    public final SMTNotificationData getNotification() {
        return this.notification;
    }

    public void doInBackground(Unit... unitArr) {
        Intrinsics.checkNotNullParameter(unitArr, "p0");
        if (this.notification.getMIsForInbox()) {
            this.notification.getMDownloadStatus();
            DownloadStatus.COMPLETED.getValue();
        }
    }
}
