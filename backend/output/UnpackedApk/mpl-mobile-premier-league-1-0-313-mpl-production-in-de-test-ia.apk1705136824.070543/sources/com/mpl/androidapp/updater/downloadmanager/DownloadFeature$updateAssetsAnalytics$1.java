package com.mpl.androidapp.updater.downloadmanager;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.DownloadFeature", f = "DownloadFeature.kt", l = {137, 146}, m = "updateAssetsAnalytics")
/* compiled from: DownloadFeature.kt */
public final class DownloadFeature$updateAssetsAnalytics$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DownloadFeature this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadFeature$updateAssetsAnalytics$1(DownloadFeature downloadFeature, Continuation<? super DownloadFeature$updateAssetsAnalytics$1> continuation) {
        // this.this$0 = downloadFeature;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.updateAssetsAnalytics(false, null, null, this);
    }
}