package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker", f = "DownloadProgressWorker.kt", l = {37}, m = "doWork")
/* compiled from: DownloadProgressWorker.kt */
public final class DownloadProgressWorker$doWork$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DownloadProgressWorker this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadProgressWorker$doWork$1(DownloadProgressWorker downloadProgressWorker, Continuation<? super DownloadProgressWorker$doWork$1> continuation) {
        // this.this$0 = downloadProgressWorker;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.doWork(this);
    }
}
