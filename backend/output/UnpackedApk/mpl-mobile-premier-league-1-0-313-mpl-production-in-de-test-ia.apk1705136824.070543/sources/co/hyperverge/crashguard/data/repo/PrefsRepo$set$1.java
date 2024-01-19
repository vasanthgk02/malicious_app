package co.hyperverge.crashguard.data.repo;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.Preferences.Key;
import androidx.datastore.preferences.core.PreferencesKt$edit$2;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "co.hyperverge.crashguard.data.repo.PrefsRepo$set$1", f = "PrefsRepo.kt", l = {54}, m = "invokeSuspend")
/* compiled from: PrefsRepo.kt */
public final class PrefsRepo$set$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object> {
    public final /* synthetic */ Key<T> $key;
    public final /* synthetic */ T $value;
    public int label;
    public final /* synthetic */ PrefsRepo this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "co.hyperverge.crashguard.data.repo.PrefsRepo$set$1$1", f = "PrefsRepo.kt", l = {}, m = "invokeSuspend")
    /* renamed from: co.hyperverge.crashguard.data.repo.PrefsRepo$set$1$1  reason: invalid class name */
    /* compiled from: PrefsRepo.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object L$0;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(key, t, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public Object invoke(Object obj, Object obj2) {
            AnonymousClass1 r0 = new AnonymousClass1(key, t, (Continuation) obj2);
            r0.L$0 = (MutablePreferences) obj;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            TweetUtils.throwOnFailure(unit);
            ((MutablePreferences) r0.L$0).set(key, t);
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            TweetUtils.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).set(key, t);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrefsRepo$set$1(Key<T> key, T t, PrefsRepo prefsRepo, Continuation<? super PrefsRepo$set$1> continuation) {
        // this.$key = key;
        // this.$value = t;
        // this.this$0 = prefsRepo;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrefsRepo$set$1(this.$key, this.$value, this.this$0, continuation);
    }

    public Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        return new PrefsRepo$set$1(this.$key, this.$value, this.this$0, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            String str = PrefsRepo.TAG;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("set: key: ");
            outline73.append(this.$key.name);
            outline73.append(", value: ");
            outline73.append(this.$value);
            outline73.toString();
            DataStore<Preferences> dataStore = this.this$0.defaultDs;
            final Key<T> key = this.$key;
            final T t = this.$value;
            AnonymousClass1 r1 = new AnonymousClass1(null);
            this.label = 1;
            obj = dataStore.updateData(new PreferencesKt$edit$2(r1, null), this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
