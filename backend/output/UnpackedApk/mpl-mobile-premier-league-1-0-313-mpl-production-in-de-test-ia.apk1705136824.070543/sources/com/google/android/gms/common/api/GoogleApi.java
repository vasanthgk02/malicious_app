package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zaaf;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.api.internal.zae;
import com.google.android.gms.common.api.internal.zag;
import com.google.android.gms.common.api.internal.zah;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class GoogleApi<O extends ApiOptions> implements HasApiKey<O> {
    public final GoogleApiManager zaa;
    public final Context zab;
    public final String zac;
    public final Api zad;
    public final ApiOptions zae;
    public final ApiKey zaf;
    public final Looper zag;
    public final int zah;
    @NotOnlyInitialized
    public final GoogleApiClient zai;
    public final StatusExceptionMapper zaj;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static class Settings {
        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zaa;
        public final Looper zab;

        @KeepForSdk
        /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
        public static class Builder {
            public StatusExceptionMapper zaa;
            public Looper zab;

            @KeepForSdk
            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, null, this.zab, null);
            }

            @KeepForSdk
            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zaa = statusExceptionMapper;
                return this;
            }
        }

        public Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper, zae zae) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    @KeepForSdk
    public GoogleApi(Activity activity, Api<O> api, O o, Settings settings) {
        this((Context) activity, activity, (Api) api, (ApiOptions) o, settings);
    }

    private final ApiMethodImpl zad(int i, ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        GoogleApiManager googleApiManager = this.zaa;
        if (googleApiManager != null) {
            zae zae2 = new zae(i, apiMethodImpl);
            Handler handler = googleApiManager.zat;
            handler.sendMessage(handler.obtainMessage(4, new zach(zae2, googleApiManager.zao.get(), this)));
            return apiMethodImpl;
        }
        throw null;
    }

    private final Task zae(int i, TaskApiCall taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GoogleApiManager googleApiManager = this.zaa;
        StatusExceptionMapper statusExceptionMapper = this.zaj;
        if (googleApiManager != null) {
            googleApiManager.zaL(taskCompletionSource, taskApiCall.zac, this);
            zag zag2 = new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
            Handler handler = googleApiManager.zat;
            handler.sendMessage(handler.obtainMessage(4, new zach(zag2, googleApiManager.zao.get(), this)));
            return taskCompletionSource.zza;
        }
        throw null;
    }

    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.common.internal.ClientSettings.Builder createClientSettingsBuilder() {
        /*
            r4 = this;
            com.google.android.gms.common.internal.ClientSettings$Builder r0 = new com.google.android.gms.common.internal.ClientSettings$Builder
            r0.<init>()
            com.google.android.gms.common.api.Api$ApiOptions r1 = r4.zae
            boolean r2 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
            r3 = 0
            if (r2 == 0) goto L_0x0022
            com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) r1
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r1.getGoogleSignInAccount()
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = r1.zaf
            if (r1 != 0) goto L_0x0019
            goto L_0x002e
        L_0x0019:
            android.accounts.Account r2 = new android.accounts.Account
            java.lang.String r3 = "com.google"
            r2.<init>(r1, r3)
            r3 = r2
            goto L_0x002e
        L_0x0022:
            com.google.android.gms.common.api.Api$ApiOptions r1 = r4.zae
            boolean r2 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions
            if (r2 == 0) goto L_0x002e
            com.google.android.gms.common.api.Api$ApiOptions$HasAccountOptions r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions) r1
            android.accounts.Account r3 = r1.getAccount()
        L_0x002e:
            r0.zaa = r3
            com.google.android.gms.common.api.Api$ApiOptions r1 = r4.zae
            boolean r2 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
            if (r2 == 0) goto L_0x0048
            com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) r1
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r1.getGoogleSignInAccount()
            if (r1 != 0) goto L_0x0043
            java.util.Set r1 = java.util.Collections.emptySet()
            goto L_0x004c
        L_0x0043:
            java.util.Set r1 = r1.getRequestedScopes()
            goto L_0x004c
        L_0x0048:
            java.util.Set r1 = java.util.Collections.emptySet()
        L_0x004c:
            androidx.collection.ArraySet r2 = r0.zab
            if (r2 != 0) goto L_0x0058
            androidx.collection.ArraySet r2 = new androidx.collection.ArraySet
            r3 = 0
            r2.<init>(r3)
            r0.zab = r2
        L_0x0058:
            androidx.collection.ArraySet r2 = r0.zab
            r2.addAll(r1)
            android.content.Context r1 = r4.zab
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.zad = r1
            android.content.Context r1 = r4.zab
            java.lang.String r1 = r1.getPackageName()
            r0.zac = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.createClientSettingsBuilder():com.google.android.gms.common.internal.ClientSettings$Builder");
    }

    @KeepForSdk
    public Task<Boolean> disconnectService() {
        GoogleApiManager googleApiManager = this.zaa;
        if (googleApiManager != null) {
            zaaf zaaf = new zaaf(getApiKey());
            Handler handler = googleApiManager.zat;
            handler.sendMessage(handler.obtainMessage(14, zaaf));
            return zaaf.zab.zza;
        }
        throw null;
    }

    @KeepForSdk
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t) {
        zad(2, t);
        return t;
    }

    @KeepForSdk
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T doRead(T t) {
        zad(0, t);
        return t;
    }

    @KeepForSdk
    @Deprecated
    public <A extends AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t, U u) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull(t.zaa.zac, "Listener has already been released.");
        Preconditions.checkNotNull(u.zaa, "Listener has already been released.");
        Preconditions.checkArgument(Objects.equal(t.zaa.zac, u.zaa), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zaq(this, t, u, zad.zaa);
    }

    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    @KeepForSdk
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T doWrite(T t) {
        zad(1, t);
        return t;
    }

    public final ApiKey<O> getApiKey() {
        return this.zaf;
    }

    @KeepForSdk
    public O getApiOptions() {
        return this.zae;
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return this.zab;
    }

    @KeepForSdk
    public String getContextAttributionTag() {
        return this.zac;
    }

    @KeepForSdk
    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    @KeepForSdk
    public Looper getLooper() {
        return this.zag;
    }

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l, String str) {
        return ListenerHolders.createListenerHolder(l, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    public final Client zab(Looper looper, zabq zabq) {
        ClientSettings build = createClientSettingsBuilder().build();
        AbstractClientBuilder abstractClientBuilder = this.zad.zaa;
        Preconditions.checkNotNull(abstractClientBuilder);
        Client buildClient = abstractClientBuilder.buildClient(this.zab, looper, build, this.zae, (ConnectionCallbacks) zabq, (OnConnectionFailedListener) zabq);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag == null || !(buildClient instanceof NonGmsServiceBrokerClient) || ((NonGmsServiceBrokerClient) buildClient) != null) {
            return buildClient;
        }
        throw null;
    }

    public final zact zac(Context context, Handler handler) {
        return new zact(context, handler, createClientSettingsBuilder().build());
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    @KeepForSdk
    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        // Builder builder = new Builder();
        // builder.setMapper(statusExceptionMapper);
        // Looper mainLooper = activity.getMainLooper();
        // Preconditions.checkNotNull(mainLooper, "Looper must not be null.");
        // builder.zab = mainLooper;
        this(activity, api, o, builder.build());
    }

    @KeepForSdk
    public <TResult, A extends AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zae(2, taskApiCall);
    }

    @KeepForSdk
    public <TResult, A extends AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return zae(0, taskApiCall);
    }

    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(ListenerKey<?> listenerKey, int i) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        GoogleApiManager googleApiManager = this.zaa;
        if (googleApiManager != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            googleApiManager.zaL(taskCompletionSource, i, this);
            zah zah2 = new zah(listenerKey, taskCompletionSource);
            Handler handler = googleApiManager.zat;
            handler.sendMessage(handler.obtainMessage(13, new zach(zah2, googleApiManager.zao.get(), this)));
            return taskCompletionSource.zza;
        }
        throw null;
    }

    @KeepForSdk
    public <TResult, A extends AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zae(1, taskApiCall);
    }

    public GoogleApi(Context context, Activity activity, Api api, ApiOptions apiOptions, Settings settings) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zab = context.getApplicationContext();
        String str = null;
        if (VERSION.SDK_INT >= 30) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.zac = str;
        this.zad = api;
        this.zae = apiOptions;
        this.zag = settings.zab;
        this.zaf = new ApiKey(api, apiOptions, str);
        this.zai = new zabv(this);
        GoogleApiManager zam = GoogleApiManager.zam(this.zab);
        this.zaa = zam;
        this.zah = zam.zan.getAndIncrement();
        this.zaj = settings.zaa;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            GoogleApiManager googleApiManager = this.zaa;
            ApiKey apiKey = this.zaf;
            LifecycleFragment fragment = LifecycleCallback.getFragment(new LifecycleActivity(activity));
            zaae zaae = (zaae) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
            zaae = zaae == null ? new zaae(fragment, googleApiManager, GoogleApiAvailability.zab) : zaae;
            Preconditions.checkNotNull(apiKey, "ApiKey cannot be null");
            zaae.zad.add(apiKey);
            googleApiManager.zaC(zaae);
        }
        Handler handler = this.zaa.zat;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    @KeepForSdk
    public <A extends AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.register.zaa.zac, "Listener has already been released.");
        Preconditions.checkNotNull(registrationMethods.zaa.zaa, "Listener has already been released.");
        return this.zaa.zaq(this, registrationMethods.register, registrationMethods.zaa, registrationMethods.zab);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        // Builder builder = new Builder();
        // Preconditions.checkNotNull(looper, "Looper must not be null.");
        // builder.zab = looper;
        // builder.setMapper(statusExceptionMapper);
        this(context, api, o, builder.build());
    }

    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        this(context, (Activity) null, (Api) api, (ApiOptions) o, settings);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        // Builder builder = new Builder();
        // builder.setMapper(statusExceptionMapper);
        this(context, api, o, builder.build());
    }
}
