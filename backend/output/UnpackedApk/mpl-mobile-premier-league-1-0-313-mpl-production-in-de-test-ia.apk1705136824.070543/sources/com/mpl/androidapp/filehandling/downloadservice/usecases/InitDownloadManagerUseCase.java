package com.mpl.androidapp.filehandling.downloadservice.usecases;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.filehandling.downloadservice.models.CustomFileDownloadInput;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.DownloadSuccessful;
import com.mpl.androidapp.filehandling.downloadservice.utils.DownloadServiceCursorStatus;
import com.mpl.androidapp.filehandling.downloadservice.utils.DownloadServiceUtils;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Loading;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.NotNullVar;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\"\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010#J \u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u001c\u0010/\u001a\u00020,2\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000301H\u0002J4\u00102\u001a\u00020,2\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u0015H\u0002J,\u00107\u001a\u00020,2\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003012\u0006\u0010)\u001a\u00020*2\u0006\u00106\u001a\u00020\u0015H\u0002J&\u00108\u001a\u00020,2\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003012\b\u00109\u001a\u0004\u0018\u00010'H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/usecases/InitDownloadManagerUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Lcom/mpl/androidapp/filehandling/downloadservice/models/CustomFileDownloadInput;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/filehandling/downloadservice/states/GenericFileDownloadStates;", "context", "Landroid/content/Context;", "downloadManager", "Landroid/app/DownloadManager;", "downloadServiceCursorStatus", "Lcom/mpl/androidapp/filehandling/downloadservice/utils/DownloadServiceCursorStatus;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Landroid/app/DownloadManager;Lcom/mpl/androidapp/filehandling/downloadservice/utils/DownloadServiceCursorStatus;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "<set-?>", "", "downloadId", "getDownloadId", "()J", "setDownloadId", "(J)V", "downloadId$delegate", "Lkotlin/properties/ReadWriteProperty;", "getDownloadManager", "()Landroid/app/DownloadManager;", "setDownloadManager", "(Landroid/app/DownloadManager;)V", "execute", "parameters", "(Lcom/mpl/androidapp/filehandling/downloadservice/models/CustomFileDownloadInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepDownloadManager", "Landroid/app/DownloadManager$Request;", "urlToDownload", "", "fileName", "file", "Ljava/io/File;", "printDataBytesToLog", "", "cursor", "Landroid/database/Cursor;", "progressUseCase", "coroutine", "Lkotlinx/coroutines/CancellableContinuation;", "queryTheDownloadProcess", "query", "Landroid/app/DownloadManager$Query;", "fileDownloading", "downloadEnqueueId", "successfulUseCase", "unSuccessfulUseCase", "message", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InitDownloadManagerUseCase.kt */
public final class InitDownloadManagerUseCase extends SuspendUseCase<CustomFileDownloadInput, UseCaseResult<? extends GenericFileDownloadStates>> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(InitDownloadManagerUseCase.class, "downloadId", "getDownloadId()J", 0))};
    public Context context;
    public final CoroutineDispatcher dispatcher;
    public final ReadWriteProperty downloadId$delegate = new NotNullVar();
    public DownloadManager downloadManager;
    public final DownloadServiceCursorStatus downloadServiceCursorStatus;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InitDownloadManagerUseCase(Context context2, DownloadManager downloadManager2, DownloadServiceCursorStatus downloadServiceCursorStatus2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(downloadManager2, "downloadManager");
        // Intrinsics.checkNotNullParameter(downloadServiceCursorStatus2, "downloadServiceCursorStatus");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.downloadManager = downloadManager2;
        this.downloadServiceCursorStatus = downloadServiceCursorStatus2;
        this.dispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final Request prepDownloadManager(String str, String str2, File file) {
        if (DownloadUtils.INSTANCE.isDownloadManagerEqualOrAboveNougat()) {
            Request request = new Request(Uri.parse(str));
            request.setTitle(str2);
            request.setNotificationVisibility(2);
            request.setDestinationUri(Uri.fromFile(file));
            request.setRequiresCharging(false);
            request.setAllowedOverMetered(true);
            request.setAllowedOverRoaming(true);
            return request;
        }
        Request request2 = new Request(Uri.parse(str));
        request2.setTitle(str2);
        request2.setNotificationVisibility(2);
        request2.setDestinationUri(Uri.fromFile(file));
        request2.setAllowedOverMetered(true);
        request2.setAllowedOverRoaming(true);
        return request2;
    }

    private final void printDataBytesToLog(Cursor cursor) {
        this.downloadServiceCursorStatus.checkDownloadStatus(cursor);
        MLogger.d("DownloadOfAssets", GeneratedOutlineSupport.outline43("BYTES_DOWNLOADED-", cursor.getInt(cursor.getColumnIndex("bytes_so_far")), "<-AND->TOTAL_SIZE-", cursor.getInt(cursor.getColumnIndex("total_size"))));
    }

    private final void progressUseCase(CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation) {
        cancellableContinuation.resumeWith(Loading.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void queryTheDownloadProcess(CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, Query query, File file, long j) {
        boolean z;
        Object obj;
        String str;
        boolean z2 = true;
        while (z2) {
            Cursor prepCursor = DownloadServiceUtils.INSTANCE.prepCursor(this.downloadManager, query);
            if (prepCursor != null) {
                MLogger.d("DownloadOfAssets", "While ( downloading = true )");
                MLogger.d("DownloadOfAssets", "Download cursor opened");
                printDataBytesToLog(prepCursor);
                int i = prepCursor.getInt(prepCursor.getColumnIndex("status"));
                if (i == 1) {
                    str = Constants.DOWNLOAD_STATUS_PENDING;
                } else if (i == 2) {
                    str = Constants.DOWNLOAD_STATUS_RUNNING;
                } else if (i != 4) {
                    if (i == 8) {
                        successfulUseCase(cancellableContinuation, file, j);
                        obj = Constants.DOWNLOAD_STATUS_COMPLETED;
                    } else if (i != 16) {
                        obj = Constants.DOWNLOAD_STATUS_UNKNOWN;
                    } else {
                        unSuccessfulUseCase(cancellableContinuation, "Download Failed");
                        obj = Constants.DOWNLOAD_STATUS_FAILED;
                    }
                    z = false;
                    MLogger.d("DownloadOfAssets", Intrinsics.stringPlus("Download Manager download status:-> ", obj));
                    prepCursor.close();
                    MLogger.d("DownloadOfAssets", "Download cursor closed");
                    z2 = z;
                } else {
                    str = Constants.DOWNLOAD_STATUS_PAUSED;
                }
                Object obj2 = str;
                z = z2;
                obj = obj2;
                MLogger.d("DownloadOfAssets", Intrinsics.stringPlus("Download Manager download status:-> ", obj));
                prepCursor.close();
                MLogger.d("DownloadOfAssets", "Download cursor closed");
                z2 = z;
            }
        }
    }

    private final void successfulUseCase(CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, File file, long j) {
        cancellableContinuation.resumeWith(new Success(new DownloadSuccessful(file)));
    }

    /* access modifiers changed from: private */
    public final void unSuccessfulUseCase(CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, String str) {
        cancellableContinuation.resumeWith(TweetUtils.createFailure(new Exception(str)));
    }

    public final Context getContext() {
        return this.context;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final long getDownloadId() {
        return ((Number) this.downloadId$delegate.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final DownloadManager getDownloadManager() {
        return this.downloadManager;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setDownloadId(long j) {
        this.downloadId$delegate.setValue(this, $$delegatedProperties[0], Long.valueOf(j));
    }

    public final void setDownloadManager(DownloadManager downloadManager2) {
        Intrinsics.checkNotNullParameter(downloadManager2, "<set-?>");
        this.downloadManager = downloadManager2;
    }

    public Object execute(CustomFileDownloadInput customFileDownloadInput, Continuation<? super UseCaseResult<? extends GenericFileDownloadStates>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(getDispatcher()), null, null, new InitDownloadManagerUseCase$execute$2$1(customFileDownloadInput, this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }
}
