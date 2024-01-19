package com.mpl.androidapp.utils;

import com.mpl.androidapp.kotlin.util.logfile.WriteLogFile;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.utils.MTimber$writeToFile$1", f = "MTimber.kt", l = {}, m = "invokeSuspend")
/* compiled from: MTimber.kt */
public final class MTimber$writeToFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Object[] $params;
    public final /* synthetic */ String $tag;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MTimber$writeToFile$1(String str, Object[] objArr, Continuation<? super MTimber$writeToFile$1> continuation) {
        // this.$tag = str;
        // this.$params = objArr;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MTimber$writeToFile$1 mTimber$writeToFile$1 = new MTimber$writeToFile$1(this.$tag, this.$params, continuation);
        mTimber$writeToFile$1.L$0 = obj;
        return mTimber$writeToFile$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MTimber$writeToFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            TypeUtilsKt.ensureActive(((CoroutineScope) this.L$0).getCoroutineContext());
            WriteLogFile writeLogFile = WriteLogFile.INSTANCE;
            MTimber mTimber = MTimber.INSTANCE;
            String stringPlus = Intrinsics.stringPlus("MTimber --> ", this.$tag);
            Object[] objArr = this.$params;
            writeLogFile.writeLog(mTimber.timberLog(stringPlus, Arrays.copyOf(objArr, objArr.length)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
