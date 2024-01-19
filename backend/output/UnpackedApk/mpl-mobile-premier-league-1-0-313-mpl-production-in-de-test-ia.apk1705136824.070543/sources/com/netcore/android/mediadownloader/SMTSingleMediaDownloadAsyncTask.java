package com.netcore.android.mediadownloader;

import android.content.Context;
import android.os.AsyncTask;
import com.netcore.android.mediadownloader.SMTMediaDownloadManager.AsyncDownloadListener;
import com.netcore.android.mediadownloader.SMTMediaDownloadManager.DownloadStatus;
import com.netcore.android.notification.SMTNotificationType;
import com.netcore.android.notification.models.SMTNotificationData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0018\u001a\u00060\u0016R\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\t\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u00060\u0016R\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTSingleMediaDownloadAsyncTask;", "Landroid/os/AsyncTask;", "", "Lcom/netcore/android/notification/models/SMTNotificationData;", "notification", "Landroid/content/Context;", "context", "downloadMedia", "(Lcom/netcore/android/notification/models/SMTNotificationData;Landroid/content/Context;)V", "", "p0", "doInBackground", "([Lkotlin/Unit;)Lcom/netcore/android/notification/models/SMTNotificationData;", "onPostExecute", "(Lcom/netcore/android/notification/models/SMTNotificationData;)V", "Lcom/netcore/android/notification/models/SMTNotificationData;", "getNotification", "()Lcom/netcore/android/notification/models/SMTNotificationData;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;", "Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager;", "listener", "Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;", "getListener", "()Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/netcore/android/notification/models/SMTNotificationData;Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTSingleMediaDownloadAsyncTask.kt */
public final class SMTSingleMediaDownloadAsyncTask extends AsyncTask<Unit, Unit, SMTNotificationData> {
    public final WeakReference<Context> context;
    public final AsyncDownloadListener listener;
    public final SMTNotificationData notification;

    public SMTSingleMediaDownloadAsyncTask(WeakReference<Context> weakReference, SMTNotificationData sMTNotificationData, AsyncDownloadListener asyncDownloadListener) {
        Intrinsics.checkNotNullParameter(weakReference, "context");
        Intrinsics.checkNotNullParameter(sMTNotificationData, "notification");
        Intrinsics.checkNotNullParameter(asyncDownloadListener, "listener");
        this.context = weakReference;
        this.notification = sMTNotificationData;
        this.listener = asyncDownloadListener;
    }

    private final void downloadMedia(SMTNotificationData sMTNotificationData, Context context2) {
        String str;
        String str2 = "";
        if (Intrinsics.areEqual(sMTNotificationData.getMNotificationType(), SMTNotificationType.BIG_IMAGE.getType())) {
            String mMediaUrl = sMTNotificationData.getMMediaUrl();
            String mNotificationType = sMTNotificationData.getMNotificationType();
            if (mNotificationType != null) {
                str2 = mNotificationType;
            }
            str = new SMTImageDownloader(context2, mMediaUrl, str2, sMTNotificationData.getMIsForInbox()).download();
        } else {
            String mMediaUrl2 = sMTNotificationData.getMMediaUrl();
            String mNotificationType2 = sMTNotificationData.getMNotificationType();
            if (mNotificationType2 != null) {
                str2 = mNotificationType2;
            }
            str = new SMTFileDownloader(context2, mMediaUrl2, str2, sMTNotificationData.getMIsForInbox()).download();
        }
        sMTNotificationData.setMDownloadStatus(DownloadStatus.FAILED.getValue());
        if (str != null) {
            sMTNotificationData.setMMediaLocalPath(str);
            sMTNotificationData.setMDownloadStatus(DownloadStatus.COMPLETED.getValue());
        }
    }

    public final WeakReference<Context> getContext() {
        return this.context;
    }

    public final AsyncDownloadListener getListener() {
        return this.listener;
    }

    public final SMTNotificationData getNotification() {
        return this.notification;
    }

    public SMTNotificationData doInBackground(Unit... unitArr) {
        Intrinsics.checkNotNullParameter(unitArr, "p0");
        if (this.context.get() != null) {
            SMTNotificationData sMTNotificationData = this.notification;
            Object obj = this.context.get();
            Intrinsics.checkNotNull(obj);
            Intrinsics.checkNotNullExpressionValue(obj, "context.get()!!");
            downloadMedia(sMTNotificationData, (Context) obj);
        }
        return this.notification;
    }

    public void onPostExecute(SMTNotificationData sMTNotificationData) {
        Intrinsics.checkNotNullParameter(sMTNotificationData, "notification");
        super.onPostExecute(sMTNotificationData);
        if (sMTNotificationData.getMDownloadStatus() == DownloadStatus.COMPLETED.getValue()) {
            this.listener.onDownloadSuccess();
        } else {
            this.listener.onDownloadError();
        }
    }
}
