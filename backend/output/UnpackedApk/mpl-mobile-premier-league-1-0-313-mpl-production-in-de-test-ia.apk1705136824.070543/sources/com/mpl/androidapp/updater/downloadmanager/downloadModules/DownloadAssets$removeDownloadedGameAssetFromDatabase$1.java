package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets", f = "DownloadAssets.kt", l = {203}, m = "removeDownloadedGameAssetFromDatabase")
/* compiled from: DownloadAssets.kt */
public final class DownloadAssets$removeDownloadedGameAssetFromDatabase$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DownloadAssets this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadAssets$removeDownloadedGameAssetFromDatabase$1(DownloadAssets downloadAssets, Continuation<? super DownloadAssets$removeDownloadedGameAssetFromDatabase$1> continuation) {
        // this.this$0 = downloadAssets;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.removeDownloadedGameAssetFromDatabase(null, this);
    }
}
