package com.facebook.login;

import android.net.Uri;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/DeviceLoginManager;", "Lcom/facebook/login/LoginManager;", "()V", "deviceAuthTargetUserId", "", "getDeviceAuthTargetUserId", "()Ljava/lang/String;", "setDeviceAuthTargetUserId", "(Ljava/lang/String;)V", "deviceRedirectUri", "Landroid/net/Uri;", "getDeviceRedirectUri", "()Landroid/net/Uri;", "setDeviceRedirectUri", "(Landroid/net/Uri;)V", "createLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "permissions", "", "Companion", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DeviceLoginManager.kt */
public final class DeviceLoginManager extends LoginManager {
    public static final Companion Companion = new Companion(null);
    public static final Lazy<DeviceLoginManager> instance$delegate = TweetUtils.lazy((Function0<? extends T>) DeviceLoginManager$Companion$instance$2.INSTANCE);
    public Uri deviceRedirectUri;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/login/DeviceLoginManager$Companion;", "", "()V", "instance", "Lcom/facebook/login/DeviceLoginManager;", "getInstance", "()Lcom/facebook/login/DeviceLoginManager;", "instance$delegate", "Lkotlin/Lazy;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceLoginManager.kt */
    public static final class Companion {
        static {
            Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), DefaultSettingsSpiCall.INSTANCE_PARAM, "getInstance()Lcom/facebook/login/DeviceLoginManager;"));
        }

        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        Class<DeviceLoginManager> cls = DeviceLoginManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return instance$delegate;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
