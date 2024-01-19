package com.netcore.android.mediadownloader;

import android.content.Context;
import android.os.AsyncTask;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.mediadownloader.SMTMediaDownloadManager.AsyncDownloadListener;
import com.netcore.android.mediadownloader.SMTMediaDownloadManager.DownloadStatus;
import com.netcore.android.notification.SMTNotificationType;
import com.netcore.android.notification.models.SMTCarouselItemData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0019\u001a\u00060\u0017R\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\t\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u000eR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0019\u001a\u00060\u0017R\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTCarouselDownloadAsyncTask;", "Landroid/os/AsyncTask;", "", "Lcom/netcore/android/notification/models/SMTCarouselItemData;", "carouselItem", "Landroid/content/Context;", "context", "downloadMedia", "(Lcom/netcore/android/notification/models/SMTCarouselItemData;Landroid/content/Context;)V", "", "p0", "doInBackground", "([Lkotlin/Unit;)Lcom/netcore/android/notification/models/SMTCarouselItemData;", "onPostExecute", "(Lcom/netcore/android/notification/models/SMTCarouselItemData;)V", "Lcom/netcore/android/notification/models/SMTCarouselItemData;", "getCarouselItem", "()Lcom/netcore/android/notification/models/SMTCarouselItemData;", "setCarouselItem", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;", "Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager;", "listener", "Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;", "getListener", "()Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/netcore/android/notification/models/SMTCarouselItemData;Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTCarouselDownloadAsyncTask.kt */
public final class SMTCarouselDownloadAsyncTask extends AsyncTask<Unit, Unit, SMTCarouselItemData> {
    public SMTCarouselItemData carouselItem;
    public final WeakReference<Context> context;
    public final AsyncDownloadListener listener;

    public SMTCarouselDownloadAsyncTask(WeakReference<Context> weakReference, SMTCarouselItemData sMTCarouselItemData, AsyncDownloadListener asyncDownloadListener) {
        Intrinsics.checkNotNullParameter(weakReference, "context");
        Intrinsics.checkNotNullParameter(sMTCarouselItemData, "carouselItem");
        Intrinsics.checkNotNullParameter(asyncDownloadListener, "listener");
        this.context = weakReference;
        this.carouselItem = sMTCarouselItemData;
        this.listener = asyncDownloadListener;
    }

    private final void downloadMedia(SMTCarouselItemData sMTCarouselItemData, Context context2) {
        SMTImageDownloader sMTImageDownloader = new SMTImageDownloader(context2, sMTCarouselItemData.getImgUrl(), SMTNotificationType.CAROUSEL.getType(), false, 8, null);
        String download = sMTImageDownloader.download();
        if (download == null || download.length() == 0) {
            sMTCarouselItemData.getMDownloadStatus();
            DownloadStatus.FAILED.getValue();
            return;
        }
        sMTCarouselItemData.setMMediaLocalPath(download);
    }

    public final SMTCarouselItemData getCarouselItem() {
        return this.carouselItem;
    }

    public final WeakReference<Context> getContext() {
        return this.context;
    }

    public final AsyncDownloadListener getListener() {
        return this.listener;
    }

    public final void setCarouselItem(SMTCarouselItemData sMTCarouselItemData) {
        Intrinsics.checkNotNullParameter(sMTCarouselItemData, "<set-?>");
        this.carouselItem = sMTCarouselItemData;
    }

    public SMTCarouselItemData doInBackground(Unit... unitArr) {
        Intrinsics.checkNotNullParameter(unitArr, "p0");
        SMTLogger.INSTANCE.d("CarouselDownloadAsyncTask", "Async started to download carousel notifications");
        Context context2 = (Context) this.context.get();
        if (context2 != null) {
            SMTCarouselItemData sMTCarouselItemData = this.carouselItem;
            Intrinsics.checkNotNullExpressionValue(context2, "it");
            downloadMedia(sMTCarouselItemData, context2);
        }
        return this.carouselItem;
    }

    public void onPostExecute(SMTCarouselItemData sMTCarouselItemData) {
        Intrinsics.checkNotNullParameter(sMTCarouselItemData, "carouselItem");
        super.onPostExecute(sMTCarouselItemData);
        String mMediaLocalPath = sMTCarouselItemData.getMMediaLocalPath();
        if (!(mMediaLocalPath == null || mMediaLocalPath.length() == 0)) {
            this.listener.onCarouselDownloadSuccess(sMTCarouselItemData);
        } else {
            this.listener.onCarouselDownloadError(sMTCarouselItemData);
        }
    }
}
