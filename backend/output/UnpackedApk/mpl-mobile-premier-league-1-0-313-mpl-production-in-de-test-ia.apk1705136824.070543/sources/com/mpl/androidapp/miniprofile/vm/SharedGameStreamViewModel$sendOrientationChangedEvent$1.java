package com.mpl.androidapp.miniprofile.vm;

import com.mpl.androidapp.miniprofile.ct.C.OrientationChanged;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel$sendOrientationChangedEvent$1", f = "SharedGameStreamViewModel.kt", l = {}, m = "invokeSuspend")
/* compiled from: SharedGameStreamViewModel.kt */
public final class SharedGameStreamViewModel$sendOrientationChangedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $chatShowed;
    public int label;
    public final /* synthetic */ SharedGameStreamViewModel this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SharedGameStreamViewModel$sendOrientationChangedEvent$1(SharedGameStreamViewModel sharedGameStreamViewModel, boolean z, Continuation<? super SharedGameStreamViewModel$sendOrientationChangedEvent$1> continuation) {
        // this.this$0 = sharedGameStreamViewModel;
        // this.$chatShowed = z;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SharedGameStreamViewModel$sendOrientationChangedEvent$1(this.this$0, this.$chatShowed, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SharedGameStreamViewModel$sendOrientationChangedEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            HashMap hashMap = new HashMap();
            hashMap.put(OrientationChanged.PROPERTY_FROM_ORIENTATION, this.this$0.getOrientation(this.$chatShowed));
            hashMap.put(OrientationChanged.PROPERTY_TO_ORIENTATION, this.this$0.getOrientation(!this.$chatShowed));
            hashMap.put("TriggerMode", OrientationChanged.TRIGGER_MODE_MANUAL);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
