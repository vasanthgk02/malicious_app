package com.netcore.android.mediadownloader;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTThreadPoolManager;
import com.netcore.android.notification.SMTNotificationType;
import com.netcore.android.notification.models.SMTCarouselItemData;
import com.netcore.android.notification.models.SMTNotificationData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0003012B\u0007¢\u0006\u0004\b/\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J+\u0010\n\u001a\u00020\u00022\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J%\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager;", "", "", "handleDownloads", "()V", "handleCarouselNotifications", "Ljava/util/ArrayList;", "Lcom/netcore/android/notification/models/SMTCarouselItemData;", "Lkotlin/collections/ArrayList;", "mCarouselList", "removeUnFinishDownloadImage", "(Ljava/util/ArrayList;)V", "", "isAllorAnySuccess", "()Z", "isAllImagesDownloaded", "handleSingleImageNotifications", "Landroid/content/Context;", "context", "Lcom/netcore/android/notification/models/SMTNotificationData;", "notification", "Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$MediaDownloadListener;", "mediaDownloadListener", "downloadMedia", "(Landroid/content/Context;Lcom/netcore/android/notification/models/SMTNotificationData;Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$MediaDownloadListener;)V", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "mMediaDownloadListener", "Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$MediaDownloadListener;", "getMMediaDownloadListener", "()Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$MediaDownloadListener;", "setMMediaDownloadListener", "(Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$MediaDownloadListener;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "Lcom/netcore/android/notification/models/SMTNotificationData;", "getNotification", "()Lcom/netcore/android/notification/models/SMTNotificationData;", "setNotification", "(Lcom/netcore/android/notification/models/SMTNotificationData;)V", "<init>", "AsyncDownloadListener", "DownloadStatus", "MediaDownloadListener", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTMediaDownloadManager.kt */
public final class SMTMediaDownloadManager {
    public final String TAG;
    public Context mContext;
    public MediaDownloadListener mMediaDownloadListener;
    public SMTNotificationData notification;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$AsyncDownloadListener;", "", "", "onDownloadSuccess", "()V", "Lcom/netcore/android/notification/models/SMTCarouselItemData;", "carouselItem", "onCarouselDownloadSuccess", "(Lcom/netcore/android/notification/models/SMTCarouselItemData;)V", "onCarouselDownloadError", "onDownloadError", "<init>", "(Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTMediaDownloadManager.kt */
    public final class AsyncDownloadListener {
        public AsyncDownloadListener() {
        }

        public final void onCarouselDownloadError(SMTCarouselItemData sMTCarouselItemData) {
            Intrinsics.checkNotNullParameter(sMTCarouselItemData, "carouselItem");
            sMTCarouselItemData.setMDownloadStatus(DownloadStatus.FAILED.getValue());
            SMTMediaDownloadManager.this.handleCarouselNotifications();
        }

        public final void onCarouselDownloadSuccess(SMTCarouselItemData sMTCarouselItemData) {
            Intrinsics.checkNotNullParameter(sMTCarouselItemData, "carouselItem");
            sMTCarouselItemData.setMDownloadStatus(DownloadStatus.COMPLETED.getValue());
            SMTMediaDownloadManager.this.handleCarouselNotifications();
        }

        public final void onDownloadError() {
            SMTMediaDownloadManager.this.getNotification().setMDownloadStatus(DownloadStatus.FAILED.getValue());
            SMTMediaDownloadManager.this.getMMediaDownloadListener().onDownloadFailed(SMTMediaDownloadManager.this.getNotification());
        }

        public final void onDownloadSuccess() {
            SMTMediaDownloadManager.this.getNotification().setMDownloadStatus(DownloadStatus.COMPLETED.getValue());
            new SMTMediaPathUpdaterAsyncTask(new WeakReference(SMTMediaDownloadManager.this.getMContext()), SMTMediaDownloadManager.this.getNotification()).executeOnExecutor(SMTThreadPoolManager.INSTANCE.getIntance(), new Unit[0]);
            SMTMediaDownloadManager.this.getMMediaDownloadListener().onDownloadSuccess(SMTMediaDownloadManager.this.getNotification());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$DownloadStatus;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "PENDING", "IN_PROGRESS", "FAILED", "COMPLETED", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTMediaDownloadManager.kt */
    public enum DownloadStatus {
        PENDING(1),
        IN_PROGRESS(2),
        FAILED(3),
        COMPLETED(4);
        
        public final int value;

        /* access modifiers changed from: public */
        DownloadStatus(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTMediaDownloadManager$MediaDownloadListener;", "", "Lcom/netcore/android/notification/models/SMTNotificationData;", "notification", "", "onDownloadSuccess", "(Lcom/netcore/android/notification/models/SMTNotificationData;)V", "onDownloadFailed", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTMediaDownloadManager.kt */
    public interface MediaDownloadListener {
        void onDownloadFailed(SMTNotificationData sMTNotificationData);

        void onDownloadSuccess(SMTNotificationData sMTNotificationData);
    }

    public SMTMediaDownloadManager() {
        String simpleName = SMTMediaDownloadManager.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "SMTMediaDownloadManager::class.java.simpleName");
        this.TAG = simpleName;
    }

    /* access modifiers changed from: private */
    public final void handleCarouselNotifications() {
        SMTLogger.INSTANCE.d(this.TAG, "Handling carousel images download");
        if (!isAllImagesDownloaded()) {
            SMTNotificationData sMTNotificationData = this.notification;
            if (sMTNotificationData != null) {
                ArrayList<SMTCarouselItemData> mCarouselList = sMTNotificationData.getMCarouselList();
                if (mCarouselList != null) {
                    Iterator<SMTCarouselItemData> it = mCarouselList.iterator();
                    while (it.hasNext()) {
                        SMTCarouselItemData next = it.next();
                        if (next.getMDownloadStatus() == 0 || next.getMDownloadStatus() == DownloadStatus.PENDING.getValue()) {
                            SMTLogger sMTLogger = SMTLogger.INSTANCE;
                            String str = this.TAG;
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("calling carousel download ");
                            outline73.append(next.getImgUrl());
                            sMTLogger.d(str, outline73.toString());
                            next.setMDownloadStatus(DownloadStatus.IN_PROGRESS.getValue());
                            Context context = this.mContext;
                            if (context != null) {
                                WeakReference weakReference = new WeakReference(context);
                                Intrinsics.checkNotNullExpressionValue(next, "carouselItem");
                                new SMTCarouselDownloadAsyncTask(weakReference, next, new AsyncDownloadListener()).executeOnExecutor(SMTThreadPoolManager.INSTANCE.getIntance(), new Unit[0]);
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                throw null;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("notification");
            throw null;
        } else if (isAllorAnySuccess()) {
            SMTNotificationData sMTNotificationData2 = this.notification;
            if (sMTNotificationData2 != null) {
                sMTNotificationData2.setMDownloadStatus(DownloadStatus.COMPLETED.getValue());
                SMTNotificationData sMTNotificationData3 = this.notification;
                if (sMTNotificationData3 != null) {
                    removeUnFinishDownloadImage(sMTNotificationData3.getMCarouselList());
                    Context context2 = this.mContext;
                    if (context2 != null) {
                        WeakReference weakReference2 = new WeakReference(context2);
                        SMTNotificationData sMTNotificationData4 = this.notification;
                        if (sMTNotificationData4 != null) {
                            new SMTMediaPathUpdaterAsyncTask(weakReference2, sMTNotificationData4).executeOnExecutor(SMTThreadPoolManager.INSTANCE.getIntance(), new Unit[0]);
                            MediaDownloadListener mediaDownloadListener = this.mMediaDownloadListener;
                            if (mediaDownloadListener != null) {
                                SMTNotificationData sMTNotificationData5 = this.notification;
                                if (sMTNotificationData5 != null) {
                                    mediaDownloadListener.onDownloadSuccess(sMTNotificationData5);
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("notification");
                                    throw null;
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("mMediaDownloadListener");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("notification");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("notification");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
                throw null;
            }
        } else {
            SMTNotificationData sMTNotificationData6 = this.notification;
            if (sMTNotificationData6 != null) {
                removeUnFinishDownloadImage(sMTNotificationData6.getMCarouselList());
                MediaDownloadListener mediaDownloadListener2 = this.mMediaDownloadListener;
                if (mediaDownloadListener2 != null) {
                    SMTNotificationData sMTNotificationData7 = this.notification;
                    if (sMTNotificationData7 != null) {
                        mediaDownloadListener2.onDownloadFailed(sMTNotificationData7);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("notification");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaDownloadListener");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
                throw null;
            }
        }
    }

    private final void handleDownloads() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        sMTLogger.v(this.TAG, "handleDownloads get called");
        SMTNotificationData sMTNotificationData = this.notification;
        if (sMTNotificationData != null) {
            if (!Intrinsics.areEqual(sMTNotificationData.getMNotificationType(), SMTNotificationType.CAROUSEL_PORTRAIT.getType())) {
                SMTNotificationData sMTNotificationData2 = this.notification;
                if (sMTNotificationData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notification");
                    throw null;
                } else if (!Intrinsics.areEqual(sMTNotificationData2.getMNotificationType(), SMTNotificationType.CAROUSEL_LANDSCAPE.getType())) {
                    sMTLogger.v(this.TAG, "handleDownloads for single file");
                    handleSingleImageNotifications();
                    return;
                }
            }
            sMTLogger.v(this.TAG, "handleDownloads for carousel images");
            handleCarouselNotifications();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notification");
        throw null;
    }

    private final void handleSingleImageNotifications() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        sMTLogger.d(this.TAG, "Handling notification for single media");
        SMTNotificationData sMTNotificationData = this.notification;
        if (sMTNotificationData != null) {
            String mMediaUrl = sMTNotificationData.getMMediaUrl();
            if (!(mMediaUrl == null || mMediaUrl.length() == 0)) {
                SMTNotificationData sMTNotificationData2 = this.notification;
                if (sMTNotificationData2 != null) {
                    sMTNotificationData2.setMDownloadStatus(DownloadStatus.IN_PROGRESS.getValue());
                    Context context = this.mContext;
                    if (context != null) {
                        WeakReference weakReference = new WeakReference(context);
                        SMTNotificationData sMTNotificationData3 = this.notification;
                        if (sMTNotificationData3 != null) {
                            new SMTSingleMediaDownloadAsyncTask(weakReference, sMTNotificationData3, new AsyncDownloadListener()).executeOnExecutor(SMTThreadPoolManager.INSTANCE.getIntance(), new Unit[0]);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("notification");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("notification");
                    throw null;
                }
            } else {
                sMTLogger.d(this.TAG, "mediaurl is empty");
                SMTNotificationData sMTNotificationData4 = this.notification;
                if (sMTNotificationData4 != null) {
                    sMTNotificationData4.setMDownloadStatus(DownloadStatus.FAILED.getValue());
                    MediaDownloadListener mediaDownloadListener = this.mMediaDownloadListener;
                    if (mediaDownloadListener != null) {
                        SMTNotificationData sMTNotificationData5 = this.notification;
                        if (sMTNotificationData5 != null) {
                            mediaDownloadListener.onDownloadFailed(sMTNotificationData5);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("notification");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mMediaDownloadListener");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("notification");
                    throw null;
                }
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("notification");
            throw null;
        }
    }

    private final boolean isAllImagesDownloaded() {
        SMTLogger.INSTANCE.d(this.TAG, "Checking all images downloaded");
        SMTNotificationData sMTNotificationData = this.notification;
        if (sMTNotificationData != null) {
            if (!Intrinsics.areEqual(sMTNotificationData.getMNotificationType(), SMTNotificationType.CAROUSEL_LANDSCAPE.getType())) {
                SMTNotificationData sMTNotificationData2 = this.notification;
                if (sMTNotificationData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notification");
                    throw null;
                } else if (!Intrinsics.areEqual(sMTNotificationData2.getMNotificationType(), SMTNotificationType.CAROUSEL_PORTRAIT.getType())) {
                    SMTNotificationData sMTNotificationData3 = this.notification;
                    if (sMTNotificationData3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notification");
                        throw null;
                    } else if (sMTNotificationData3.getMDownloadStatus() == DownloadStatus.COMPLETED.getValue()) {
                        return true;
                    } else {
                        SMTNotificationData sMTNotificationData4 = this.notification;
                        if (sMTNotificationData4 != null) {
                            if (sMTNotificationData4.getMDownloadStatus() == DownloadStatus.FAILED.getValue()) {
                                return true;
                            }
                            return false;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("notification");
                        throw null;
                    }
                }
            }
            SMTNotificationData sMTNotificationData5 = this.notification;
            if (sMTNotificationData5 != null) {
                ArrayList<SMTCarouselItemData> mCarouselList = sMTNotificationData5.getMCarouselList();
                if (mCarouselList == null) {
                    return true;
                }
                Iterator<SMTCarouselItemData> it = mCarouselList.iterator();
                while (it.hasNext()) {
                    SMTCarouselItemData next = it.next();
                    if (!(next.getMDownloadStatus() == 0 || next.getMDownloadStatus() == DownloadStatus.PENDING.getValue())) {
                        if (next.getMDownloadStatus() == DownloadStatus.IN_PROGRESS.getValue()) {
                        }
                    }
                    return false;
                }
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException("notification");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notification");
        throw null;
    }

    private final boolean isAllorAnySuccess() {
        boolean z;
        SMTLogger.INSTANCE.d(this.TAG, "Checking if at least one image download succeeded");
        SMTNotificationData sMTNotificationData = this.notification;
        if (sMTNotificationData != null) {
            ArrayList<SMTCarouselItemData> mCarouselList = sMTNotificationData.getMCarouselList();
            if (mCarouselList != null) {
                Iterator<SMTCarouselItemData> it = mCarouselList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getMDownloadStatus() == DownloadStatus.COMPLETED.getValue()) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.TAG;
                sMTLogger.d(str, "Is At least one image downloaded : " + z);
                return z;
            }
            z = false;
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str2 = this.TAG;
            sMTLogger2.d(str2, "Is At least one image downloaded : " + z);
            return z;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notification");
        throw null;
    }

    private final void removeUnFinishDownloadImage(ArrayList<SMTCarouselItemData> arrayList) {
        if (arrayList != null) {
            Iterator<SMTCarouselItemData> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "it.iterator()");
            while (it.hasNext()) {
                if (it.next().getMDownloadStatus() != DownloadStatus.COMPLETED.getValue()) {
                    it.remove();
                }
            }
        }
    }

    public final void downloadMedia(Context context, SMTNotificationData sMTNotificationData, MediaDownloadListener mediaDownloadListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sMTNotificationData, "notification");
        Intrinsics.checkNotNullParameter(mediaDownloadListener, "mediaDownloadListener");
        this.notification = sMTNotificationData;
        this.mMediaDownloadListener = mediaDownloadListener;
        this.mContext = context;
        handleDownloads();
    }

    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        throw null;
    }

    public final MediaDownloadListener getMMediaDownloadListener() {
        MediaDownloadListener mediaDownloadListener = this.mMediaDownloadListener;
        if (mediaDownloadListener != null) {
            return mediaDownloadListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMediaDownloadListener");
        throw null;
    }

    public final SMTNotificationData getNotification() {
        SMTNotificationData sMTNotificationData = this.notification;
        if (sMTNotificationData != null) {
            return sMTNotificationData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notification");
        throw null;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMMediaDownloadListener(MediaDownloadListener mediaDownloadListener) {
        Intrinsics.checkNotNullParameter(mediaDownloadListener, "<set-?>");
        this.mMediaDownloadListener = mediaDownloadListener;
    }

    public final void setNotification(SMTNotificationData sMTNotificationData) {
        Intrinsics.checkNotNullParameter(sMTNotificationData, "<set-?>");
        this.notification = sMTNotificationData;
    }
}
