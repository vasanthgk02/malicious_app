package com.mpl.androidapp.utils.encryptedPrefs;

import android.app.Application;
import android.content.Context;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences.PrefKeyEncryptionScheme;
import androidx.security.crypto.EncryptedSharedPreferences.PrefValueEncryptionScheme;
import androidx.security.crypto.MasterKey;
import androidx.security.crypto.MasterKey.Builder;
import androidx.security.crypto.MasterKey.KeyScheme;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.utils.encryptedPrefs.MEncryptedPrefs$init$1", f = "MEncryptedPrefs.kt", l = {}, m = "invokeSuspend")
/* compiled from: MEncryptedPrefs.kt */
public final class MEncryptedPrefs$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public int label;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MEncryptedPrefs$init$1(Context context, Continuation<? super MEncryptedPrefs$init$1> continuation) {
        // this.$context = context;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MEncryptedPrefs$init$1(this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MEncryptedPrefs$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                if (this.$context == null || !(this.$context instanceof Application)) {
                    throw new RuntimeException("Context is null OR Provide Application Context");
                }
                Builder builder = new Builder(this.$context);
                builder.setKeyScheme(KeyScheme.AES256_GCM);
                MasterKey build = builder.build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder(context)\n       …                 .build()");
                MEncryptedPrefs mEncryptedPrefs = MEncryptedPrefs.INSTANCE;
                MEncryptedPrefs.sharedPreferences = EncryptedSharedPreferences.create(((Application) this.$context).getApplicationContext(), "mpl_secret_prefs", build, PrefKeyEncryptionScheme.AES256_SIV, PrefValueEncryptionScheme.AES256_GCM);
                return Unit.INSTANCE;
            } catch (Exception e2) {
                e2.printStackTrace();
                MLogger.e("Encrypted Preferences", Unit.INSTANCE);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
