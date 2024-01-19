package co.hyperverge.crashguard.data.repo;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.Preferences.Key;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "co.hyperverge.crashguard.data.repo.PrefsRepo$get$1", f = "PrefsRepo.kt", l = {48}, m = "invokeSuspend")
/* compiled from: PrefsRepo.kt */
public final class PrefsRepo$get$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    public final /* synthetic */ Key<T> $key;
    public int label;
    public final /* synthetic */ PrefsRepo this$0;

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "exception", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "co.hyperverge.crashguard.data.repo.PrefsRepo$get$1$1", f = "PrefsRepo.kt", l = {45}, m = "invokeSuspend")
    /* renamed from: co.hyperverge.crashguard.data.repo.PrefsRepo$get$1$1  reason: invalid class name */
    /* compiled from: PrefsRepo.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object L$0;
        public /* synthetic */ Object L$1;
        public int label;

        public Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass1 r0 = new AnonymousClass1((Continuation) obj3);
            r0.L$0 = (FlowCollector) obj;
            r0.L$1 = (Throwable) obj2;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                TweetUtils.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                if (th instanceof IOException) {
                    MutablePreferences mutablePreferences = new MutablePreferences(null, true, 1);
                    this.L$0 = null;
                    this.label = 1;
                    if (flowCollector.emit(mutablePreferences, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    throw th;
                }
            } else if (i == 1) {
                TweetUtils.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrefsRepo$get$1(PrefsRepo prefsRepo, Key<T> key, Continuation<? super PrefsRepo$get$1> continuation) {
        // this.this$0 = prefsRepo;
        // this.$key = key;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrefsRepo$get$1(this.this$0, this.$key, continuation);
    }

    public Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        return new PrefsRepo$get$1(this.this$0, this.$key, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        Object obj2 = null;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 = new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(this.this$0.defaultDs.getData(), new AnonymousClass1(null));
            this.label = 1;
            obj = TypeUtilsKt.firstOrNull(flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Preferences preferences = (Preferences) obj;
        if (preferences != null) {
            Key<T> key = this.$key;
            Intrinsics.checkNotNullParameter(key, "key");
            obj2 = ((MutablePreferences) preferences).preferencesMap.get(key);
        }
        return obj2;
    }
}
