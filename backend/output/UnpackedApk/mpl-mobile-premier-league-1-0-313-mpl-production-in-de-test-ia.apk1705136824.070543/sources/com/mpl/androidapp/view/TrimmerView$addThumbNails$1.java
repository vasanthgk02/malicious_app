package com.mpl.androidapp.view;

import android.media.MediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.view.TrimmerView$addThumbNails$1", f = "TrimmerView.kt", l = {154}, m = "invokeSuspend")
/* compiled from: TrimmerView.kt */
public final class TrimmerView$addThumbNails$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ long $interval;
    public final /* synthetic */ MediaMetadataRetriever $metaDataRetriever;
    public final /* synthetic */ int $thumbNailWidth;
    public final /* synthetic */ int $totalThumbNails;
    public int I$0;
    public int I$1;
    public int label;
    public final /* synthetic */ TrimmerView this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TrimmerView$addThumbNails$1(int i, TrimmerView trimmerView, MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, Continuation<? super TrimmerView$addThumbNails$1> continuation) {
        // this.$totalThumbNails = i;
        // this.this$0 = trimmerView;
        // this.$metaDataRetriever = mediaMetadataRetriever;
        // this.$interval = j;
        // this.$thumbNailWidth = i2;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrimmerView$addThumbNails$1 trimmerView$addThumbNails$1 = new TrimmerView$addThumbNails$1(this.$totalThumbNails, this.this$0, this.$metaDataRetriever, this.$interval, this.$thumbNailWidth, continuation);
        return trimmerView$addThumbNails$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrimmerView$addThumbNails$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r12.label
            java.lang.String r2 = "TrimmerView"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 != r4) goto L_0x0016
            int r1 = r12.I$1
            int r5 = r12.I$0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            r13 = r12
            goto L_0x0099
        L_0x0016:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001e:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            r13 = 0
            r1 = 0
            r13 = r12
        L_0x0024:
            int r5 = r13.$totalThumbNails
            if (r1 >= r5) goto L_0x00ae
            int r5 = r1 + 1
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.String r7 = "ThumbNail loading started for index "
            java.lang.String r8 = ", Thread -> "
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline74(r7, r1, r8)
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            java.lang.String r8 = r8.getName()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6[r3] = r7
            com.mpl.androidapp.utils.MLogger.d(r2, r6)
            com.mpl.androidapp.view.TrimmerView r6 = r13.this$0
            android.content.Context r6 = r6.getContext()
            com.bumptech.glide.RequestManager r6 = com.bumptech.glide.Glide.with(r6)
            android.media.MediaMetadataRetriever r7 = r13.$metaDataRetriever
            long r8 = (long) r1
            long r10 = r13.$interval
            long r8 = r8 * r10
            r10 = 5000(0x1388, double:2.4703E-320)
            long r8 = r8 - r10
            r10 = 2
            android.graphics.Bitmap r7 = r7.getFrameAtTime(r8, r10)
            com.bumptech.glide.RequestBuilder r6 = r6.load(r7)
            int r7 = r13.$thumbNailWidth
            com.mpl.androidapp.view.TrimmerView r8 = r13.this$0
            int r8 = r8.getHeight()
            com.bumptech.glide.request.BaseRequestOptions r6 = r6.override(r7, r8)
            com.bumptech.glide.RequestBuilder r6 = (com.bumptech.glide.RequestBuilder) r6
            com.bumptech.glide.request.BaseRequestOptions r6 = r6.centerCrop()
            java.lang.String r7 = "with(context)\n          …            .centerCrop()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.bumptech.glide.RequestBuilder r6 = (com.bumptech.glide.RequestBuilder) r6
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            com.mpl.androidapp.view.TrimmerView$addThumbNails$1$1 r8 = new com.mpl.androidapp.view.TrimmerView$addThumbNails$1$1
            com.mpl.androidapp.view.TrimmerView r9 = r13.this$0
            int r10 = r13.$thumbNailWidth
            r11 = 0
            r8.<init>(r9, r10, r6, r11)
            r13.I$0 = r5
            r13.I$1 = r1
            r13.label = r4
            java.lang.Object r6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.withContext(r7, r8, r13)
            if (r6 != r0) goto L_0x0099
            return r0
        L_0x0099:
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r1)
            java.lang.String r1 = "ThumbNail loading ended for index "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r7)
            r6[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r2, r6)
            r1 = r5
            goto L_0x0024
        L_0x00ae:
            android.media.MediaMetadataRetriever r13 = r13.$metaDataRetriever
            r13.release()
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.view.TrimmerView$addThumbNails$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
