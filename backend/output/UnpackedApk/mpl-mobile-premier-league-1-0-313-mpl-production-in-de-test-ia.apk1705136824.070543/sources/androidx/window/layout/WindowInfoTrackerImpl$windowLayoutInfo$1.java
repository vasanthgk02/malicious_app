package androidx.window.layout;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/WindowLayoutInfo;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
/* compiled from: WindowInfoTrackerImpl.kt */
public final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements Function2<FlowCollector<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Activity $activity;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, Continuation<? super WindowInfoTrackerImpl$windowLayoutInfo$1> continuation) {
        // this.this$0 = windowInfoTrackerImpl;
        // this.$activity = activity;
        super(2, continuation);
    }

    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m7invokeSuspend$lambda0(Channel channel, WindowLayoutInfo windowLayoutInfo) {
        Intrinsics.checkNotNullExpressionValue(windowLayoutInfo, "info");
        channel.m989trySendJP2dKIU(windowLayoutInfo);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, continuation);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    public Object invoke(Object obj, Object obj2) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, (Continuation) obj2);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = (FlowCollector) obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073 A[Catch:{ all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A[Catch:{ all -> 0x009f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003b
            if (r1 == r3) goto L_0x0026
            if (r1 != r2) goto L_0x001e
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)     // Catch:{ all -> 0x0039 }
            r10 = r5
            r5 = r1
            goto L_0x0063
        L_0x001e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0026:
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)     // Catch:{ all -> 0x0039 }
            r6 = r5
            r5 = r1
            r1 = r9
            goto L_0x0076
        L_0x0039:
            r10 = move-exception
            goto L_0x00a1
        L_0x003b:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            r1 = 10
            kotlinx.coroutines.channels.BufferOverflow r4 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
            r5 = 0
            r6 = 4
            kotlinx.coroutines.channels.Channel r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.Channel$default(r1, r4, r5, r6)
            androidx.window.layout.-$$Lambda$IcHzfpaG6TwVM1ApO1xrJUaq72s r4 = new androidx.window.layout.-$$Lambda$IcHzfpaG6TwVM1ApO1xrJUaq72s
            r4.<init>()
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.WindowBackend r5 = r5.windowBackend
            android.app.Activity r6 = r9.$activity
            androidx.window.layout.-$$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo r7 = androidx.window.layout.$$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE
            r5.registerLayoutChangeCallback(r6, r7, r4)
            kotlinx.coroutines.channels.AbstractChannel r1 = (kotlinx.coroutines.channels.AbstractChannel) r1     // Catch:{ all -> 0x0039 }
            kotlinx.coroutines.channels.AbstractChannel$Itr r5 = new kotlinx.coroutines.channels.AbstractChannel$Itr     // Catch:{ all -> 0x0039 }
            r5.<init>(r1)     // Catch:{ all -> 0x0039 }
        L_0x0063:
            r1 = r9
        L_0x0064:
            r1.L$0 = r10     // Catch:{ all -> 0x009f }
            r1.L$1 = r4     // Catch:{ all -> 0x009f }
            r1.L$2 = r5     // Catch:{ all -> 0x009f }
            r1.label = r3     // Catch:{ all -> 0x009f }
            java.lang.Object r6 = r5.hasNext(r1)     // Catch:{ all -> 0x009f }
            if (r6 != r0) goto L_0x0073
            return r0
        L_0x0073:
            r8 = r6
            r6 = r10
            r10 = r8
        L_0x0076:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x009f }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x009f }
            if (r10 == 0) goto L_0x0095
            java.lang.Object r10 = r5.next()     // Catch:{ all -> 0x009f }
            androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.layout.WindowLayoutInfo) r10     // Catch:{ all -> 0x009f }
            r1.L$0 = r6     // Catch:{ all -> 0x009f }
            r1.L$1 = r4     // Catch:{ all -> 0x009f }
            r1.L$2 = r5     // Catch:{ all -> 0x009f }
            r1.label = r2     // Catch:{ all -> 0x009f }
            java.lang.Object r10 = r6.emit(r10, r1)     // Catch:{ all -> 0x009f }
            if (r10 != r0) goto L_0x0093
            return r0
        L_0x0093:
            r10 = r6
            goto L_0x0064
        L_0x0095:
            androidx.window.layout.WindowInfoTrackerImpl r10 = r1.this$0
            androidx.window.layout.WindowBackend r10 = r10.windowBackend
            r10.unregisterLayoutChangeCallback(r4)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x009f:
            r10 = move-exception
            goto L_0x00a2
        L_0x00a1:
            r1 = r9
        L_0x00a2:
            androidx.window.layout.WindowInfoTrackerImpl r0 = r1.this$0
            androidx.window.layout.WindowBackend r0 = r0.windowBackend
            r0.unregisterLayoutChangeCallback(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
