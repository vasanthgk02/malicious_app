package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/Download;", "", "download", "", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadAssets.kt */
public interface Download {
    Object download(DownloadTaskParams downloadTaskParams, Continuation<? super Unit> continuation);
}
