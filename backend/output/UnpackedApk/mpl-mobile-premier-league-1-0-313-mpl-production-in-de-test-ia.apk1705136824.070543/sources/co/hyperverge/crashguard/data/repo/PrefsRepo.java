package co.hyperverge.crashguard.data.repo;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.Preferences.Key;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J'\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\u0006\u0010\u0017\u001a\u0002H\u0014¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0004J'\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\u0006\u0010\u001b\u001a\u0002H\u0014¢\u0006\u0002\u0010\u001cR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lco/hyperverge/crashguard/data/repo/PrefsRepo;", "", "defaultDs", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Landroidx/datastore/core/DataStore;)V", "<set-?>", "", "sentryEndpointUrl", "getSentryEndpointUrl", "()Ljava/lang/String;", "setSentryEndpointUrl", "(Ljava/lang/String;)V", "sentryEndpointUrl$delegate", "Lco/hyperverge/crashguard/data/repo/PrefsDelegate;", "sentryKey", "getSentryKey", "setSentryKey", "sentryKey$delegate", "get", "T", "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "defaultValue", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)Ljava/lang/Object;", "reset", "set", "value", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)Landroidx/datastore/preferences/core/Preferences;", "Companion", "Keys", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PrefsRepo.kt */
public final class PrefsRepo {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    public static PrefsRepo INSTANCE;
    public static final String TAG;
    public final DataStore<Preferences> defaultDs;
    public final PrefsDelegate sentryEndpointUrl$delegate = new PrefsDelegate((Key) Keys.SENTRY_ENDPOINT_URL$delegate.getValue(), "");
    public final PrefsDelegate sentryKey$delegate;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lco/hyperverge/crashguard/data/repo/PrefsRepo$Companion;", "", "()V", "INSTANCE", "Lco/hyperverge/crashguard/data/repo/PrefsRepo;", "getINSTANCE", "()Lco/hyperverge/crashguard/data/repo/PrefsRepo;", "setINSTANCE", "(Lco/hyperverge/crashguard/data/repo/PrefsRepo;)V", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: PrefsRepo.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final PrefsRepo getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            PrefsRepo prefsRepo = PrefsRepo.INSTANCE;
            if (prefsRepo == null) {
                prefsRepo = new PrefsRepo((DataStore) PrefsRepoKt.defaultDs$delegate.getValue(context, PrefsRepoKt.$$delegatedProperties[0]), null);
                if (PrefsRepo.Companion != null) {
                    PrefsRepo.INSTANCE = prefsRepo;
                } else {
                    throw null;
                }
            }
            return prefsRepo;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lco/hyperverge/crashguard/data/repo/PrefsRepo$Keys;", "", "()V", "SENTRY_ENDPOINT_URL", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getSENTRY_ENDPOINT_URL", "()Landroidx/datastore/preferences/core/Preferences$Key;", "SENTRY_ENDPOINT_URL$delegate", "Lkotlin/Lazy;", "SENTRY_KEY", "getSENTRY_KEY", "SENTRY_KEY$delegate", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: PrefsRepo.kt */
    public static final class Keys {
        public static final Keys INSTANCE = null;
        public static final Lazy SENTRY_ENDPOINT_URL$delegate = TweetUtils.lazy((Function0<? extends T>) PrefsRepo$Keys$SENTRY_ENDPOINT_URL$2.INSTANCE);
        public static final Lazy SENTRY_KEY$delegate = TweetUtils.lazy((Function0<? extends T>) PrefsRepo$Keys$SENTRY_KEY$2.INSTANCE);
    }

    static {
        Class<PrefsRepo> cls = PrefsRepo.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "sentryEndpointUrl", "getSentryEndpointUrl()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "sentryKey", "getSentryKey()Ljava/lang/String;", 0))};
        TAG = Reflection.getOrCreateKotlinClass(cls).getQualifiedName();
    }

    public PrefsRepo(DataStore dataStore, DefaultConstructorMarker defaultConstructorMarker) {
        this.defaultDs = dataStore;
        Keys keys = Keys.INSTANCE;
        Keys keys2 = Keys.INSTANCE;
        this.sentryKey$delegate = new PrefsDelegate((Key) Keys.SENTRY_KEY$delegate.getValue(), "");
    }
}
