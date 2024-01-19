package com.google.firebase.messaging;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.cloudmessaging.zzr;
import com.google.android.gms.cloudmessaging.zzs;
import com.google.android.gms.cloudmessaging.zzt;
import com.google.android.gms.cloudmessaging.zzu;
import com.google.android.gms.cloudmessaging.zzv;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.AutoValue_InstallationTokenResult;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import io.hansel.core.base.utils.HSLInternalUtils;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

public class GmsRpc {
    public final FirebaseApp app;
    public final FirebaseInstallationsApi firebaseInstallations;
    public final Provider<HeartBeatInfo> heartbeatInfo;
    public final Metadata metadata;
    public final Rpc rpc;
    public final Provider<UserAgentPublisher> userAgentPublisher;

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        firebaseApp.checkNotDeleted();
        Rpc rpc2 = new Rpc(firebaseApp.applicationContext);
        this.app = firebaseApp;
        this.metadata = metadata2;
        this.rpc = rpc2;
        this.userAgentPublisher = provider;
        this.heartbeatInfo = provider2;
        this.firebaseInstallations = firebaseInstallationsApi;
    }

    public final Task<String> extractResponseWhenComplete(Task<Bundle> task) {
        return task.continueWith($$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE, new Continuation() {
            public final Object then(Task task) {
                return GmsRpc.this.lambda$extractResponseWhenComplete$0$GmsRpc(task);
            }
        });
    }

    public Task<String> getToken() {
        return extractResponseWhenComplete(startRpc(Metadata.getDefaultSenderId(this.app), "*", new Bundle()));
    }

    public String lambda$extractResponseWhenComplete$0$GmsRpc(Task task) throws Exception {
        Bundle bundle = (Bundle) task.getResult(IOException.class);
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string == null) {
                string = bundle.getString("unregistered");
                if (string == null) {
                    String string2 = bundle.getString("error");
                    if ("RST".equals(string2)) {
                        throw new IOException("INSTANCE_ID_RESET");
                    } else if (string2 != null) {
                        throw new IOException(string2);
                    } else {
                        "Unexpected response: " + bundle;
                        new Throwable();
                        throw new IOException("SERVICE_NOT_AVAILABLE");
                    }
                }
            }
            return string;
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public final void setDefaultAttributesToBundle(String str, String str2, Bundle bundle) throws ExecutionException, InterruptedException {
        int i;
        String str3;
        String str4;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        FirebaseApp firebaseApp = this.app;
        firebaseApp.checkNotDeleted();
        bundle.putString("gmp_app_id", firebaseApp.options.applicationId);
        Metadata metadata2 = this.metadata;
        synchronized (metadata2) {
            if (metadata2.gmsVersionCode == 0) {
                PackageInfo packageInfo = metadata2.getPackageInfo("com.google.android.gms");
                if (packageInfo != null) {
                    metadata2.gmsVersionCode = packageInfo.versionCode;
                }
            }
            i = metadata2.gmsVersionCode;
        }
        bundle.putString("gmsv", Integer.toString(i));
        bundle.putString(HSLInternalUtils.KEY_OLD_SDK_V, Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.metadata.getAppVersionCode());
        Metadata metadata3 = this.metadata;
        synchronized (metadata3) {
            if (metadata3.appVersionName == null) {
                metadata3.populateAppVersionInfo();
            }
            str3 = metadata3.appVersionName;
        }
        bundle.putString("app_ver_name", str3);
        FirebaseApp firebaseApp2 = this.app;
        firebaseApp2.checkNotDeleted();
        try {
            str4 = Base64.encodeToString(MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE).digest(firebaseApp2.name.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            str4 = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", str4);
        try {
            String str5 = ((AutoValue_InstallationTokenResult) ((InstallationTokenResult) Tasks.await(this.firebaseInstallations.getToken(false)))).token;
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("Goog-Firebase-Installations-Auth", str5);
            }
        } catch (InterruptedException | ExecutionException unused2) {
        }
        bundle.putString("appid", (String) Tasks.await(this.firebaseInstallations.getId()));
        bundle.putString("cliv", "fcm-23.0.2");
        HeartBeatInfo heartBeatInfo = (HeartBeatInfo) this.heartbeatInfo.get();
        UserAgentPublisher userAgentPublisher2 = (UserAgentPublisher) this.userAgentPublisher.get();
        if (heartBeatInfo != null && userAgentPublisher2 != null) {
            HeartBeat heartBeatCode = heartBeatInfo.getHeartBeatCode("fire-iid");
            if (heartBeatCode != HeartBeat.NONE) {
                bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
                bundle.putString("Firebase-Client", userAgentPublisher2.getUserAgent());
            }
        }
    }

    public final Task<Bundle> startRpc(String str, String str2, Bundle bundle) {
        int i;
        Task<Bundle> task;
        int i2;
        PackageInfo packageInfo;
        try {
            setDefaultAttributesToBundle(str, str2, bundle);
            Rpc rpc2 = this.rpc;
            zzt zzt = rpc2.zzg;
            synchronized (zzt) {
                if (zzt.zzb == 0) {
                    try {
                        packageInfo = Wrappers.packageManager(zzt.zza).zza.getPackageManager().getPackageInfo("com.google.android.gms", 0);
                    } catch (NameNotFoundException e2) {
                        String.valueOf(e2).length();
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        zzt.zzb = packageInfo.versionCode;
                    }
                }
                i = zzt.zzb;
            }
            if (i >= 12000000) {
                zzs zzb = zzs.zzb(rpc2.zzf);
                synchronized (zzb) {
                    i2 = zzb.zze;
                    zzb.zze = i2 + 1;
                }
                task = zzb.zzg(new zzr(i2, bundle)).continueWith(Rpc.zzc, zzv.zza);
            } else if (rpc2.zzg.zzb() != 0) {
                task = rpc2.zze(bundle).continueWithTask(Rpc.zzc, new zzu(rpc2, bundle));
            } else {
                task = Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            return task;
        } catch (InterruptedException | ExecutionException e3) {
            return Tasks.forException(e3);
        }
    }
}
