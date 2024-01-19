package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload", f = "QueryDownload.kt", l = {419, 422}, m = "copyAssetsCase")
/* compiled from: QueryDownload.kt */
public final class QueryDownload$copyAssetsCase$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ QueryDownload this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public QueryDownload$copyAssetsCase$1(QueryDownload queryDownload, Continuation<? super QueryDownload$copyAssetsCase$1> continuation) {
        // this.this$0 = queryDownload;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.copyAssetsCase(null, this);
    }
}
