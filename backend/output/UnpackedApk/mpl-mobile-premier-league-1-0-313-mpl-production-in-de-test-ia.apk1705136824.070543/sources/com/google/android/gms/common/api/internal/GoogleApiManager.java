package com.google.android.gms.common.api.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.collection.ArraySet;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzj;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.perf.config.RemoteConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class GoogleApiManager implements Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    public static final Object zac = new Object();
    public static GoogleApiManager zad;
    public long zae = RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS;
    public long zaf = 120000;
    public long zag = MqttAsyncClient.DISCONNECT_TIMEOUT;
    public boolean zah = false;
    public TelemetryData zai;
    public TelemetryLoggingClient zaj;
    public final Context zak;
    public final GoogleApiAvailability zal;
    public final zal zam;
    public final AtomicInteger zan;
    public final AtomicInteger zao;
    public final Map zap;
    public zaae zaq;
    public final Set zar;
    public final Set zas;
    @NotOnlyInitialized
    public final Handler zat;
    public volatile boolean zau;

    @KeepForSdk
    public GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        boolean z = true;
        this.zan = new AtomicInteger(1);
        this.zao = new AtomicInteger(0);
        this.zap = new ConcurrentHashMap(5, 0.75f, 1);
        this.zaq = null;
        this.zar = new ArraySet(0);
        this.zas = new ArraySet(0);
        this.zau = true;
        this.zak = context;
        this.zat = new zau(looper, this);
        this.zal = googleApiAvailability;
        this.zam = new zal(googleApiAvailability);
        PackageManager packageManager = context.getPackageManager();
        if (DeviceProperties.zzi == null) {
            DeviceProperties.zzi = Boolean.valueOf((!PlatformVersion.isAtLeastO() || !packageManager.hasSystemFeature("android.hardware.type.automotive")) ? false : z);
        }
        if (DeviceProperties.zzi.booleanValue()) {
            this.zau = false;
        }
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(6));
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (zac) {
            GoogleApiManager googleApiManager = zad;
            if (googleApiManager != null) {
                googleApiManager.zao.incrementAndGet();
                Handler handler = googleApiManager.zat;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    public static Status zaH(ApiKey apiKey, ConnectionResult connectionResult) {
        Status status = new Status(1, 17, GeneratedOutlineSupport.outline53("API: ", apiKey.zab.zac, " is not available on this device. Connection failed with: ", String.valueOf(connectionResult)), connectionResult.zzc, connectionResult);
        return status;
    }

    public static GoogleApiManager zam(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            try {
                if (zad == null) {
                    zad = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.zab);
                }
                googleApiManager = zad;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    public final boolean handleMessage(Message message) {
        zabq zabq;
        Status status;
        long j = 300000;
        switch (message.what) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j = MqttAsyncClient.DISCONNECT_TIMEOUT;
                }
                this.zag = j;
                this.zat.removeMessages(12);
                for (ApiKey obtainMessage : this.zap.keySet()) {
                    Handler handler = this.zat;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.zag);
                }
                break;
            case 2:
                if (((zal) message.obj) != null) {
                    throw null;
                }
                throw null;
            case 3:
                for (zabq zabq2 : this.zap.values()) {
                    zabq2.zan();
                    zabq2.zao();
                }
                break;
            case 4:
            case 8:
            case 13:
                zach zach = (zach) message.obj;
                zabq zabq3 = (zabq) this.zap.get(zach.zac.getApiKey());
                if (zabq3 == null) {
                    zabq3 = zaI(zach.zac);
                }
                if (zabq3.zaz() && this.zao.get() != zach.zab) {
                    zach.zaa.zad(zaa);
                    zabq3.zav();
                    break;
                } else {
                    zabq3.zap(zach.zaa);
                    break;
                }
                break;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it = this.zap.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zabq = (zabq) it.next();
                        if (zabq.zah == i) {
                        }
                    } else {
                        zabq = null;
                    }
                }
                if (zabq != null) {
                    if (connectionResult.zzb != 13) {
                        Status zaH = zaH(zabq.zad, connectionResult);
                        Preconditions.checkHandlerThread(zabq.zaa.zat);
                        zabq.zaE(zaH, null, false);
                        break;
                    } else {
                        GoogleApiAvailability googleApiAvailability = this.zal;
                        int i2 = connectionResult.zzb;
                        if (googleApiAvailability != null) {
                            Status status2 = new Status(17, GeneratedOutlineSupport.outline53("Error resolution was canceled by the user, original error message: ", GooglePlayServicesUtilLight.getErrorString(i2), ": ", connectionResult.zzd));
                            Preconditions.checkHandlerThread(zabq.zaa.zat);
                            zabq.zaE(status2, null, false);
                            break;
                        } else {
                            throw null;
                        }
                    }
                } else {
                    Log.wtf("GoogleApiManager", GeneratedOutlineSupport.outline74("Could not find API instance ", i, " while trying to fail enqueued calls.").toString(), new Exception());
                    break;
                }
            case 6:
                if (this.zak.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.zak.getApplicationContext());
                    BackgroundDetector backgroundDetector = BackgroundDetector.zza;
                    zabl zabl = new zabl(this);
                    if (backgroundDetector != null) {
                        synchronized (BackgroundDetector.zza) {
                            backgroundDetector.zzd.add(zabl);
                        }
                        BackgroundDetector backgroundDetector2 = BackgroundDetector.zza;
                        if (!backgroundDetector2.zzc.get()) {
                            RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
                            ActivityManager.getMyMemoryState(runningAppProcessInfo);
                            if (!backgroundDetector2.zzc.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                                backgroundDetector2.zzb.set(true);
                            }
                        }
                        if (!backgroundDetector2.zzb.get()) {
                            this.zag = 300000;
                            break;
                        }
                    } else {
                        throw null;
                    }
                }
                break;
            case 7:
                zaI((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zap.containsKey(message.obj)) {
                    zabq zabq4 = (zabq) this.zap.get(message.obj);
                    Preconditions.checkHandlerThread(zabq4.zaa.zat);
                    if (zabq4.zaj) {
                        zabq4.zao();
                        break;
                    }
                }
                break;
            case 10:
                for (ApiKey remove : this.zas) {
                    zabq zabq5 = (zabq) this.zap.remove(remove);
                    if (zabq5 != null) {
                        zabq5.zav();
                    }
                }
                this.zas.clear();
                break;
            case 11:
                if (this.zap.containsKey(message.obj)) {
                    zabq zabq6 = (zabq) this.zap.get(message.obj);
                    Preconditions.checkHandlerThread(zabq6.zaa.zat);
                    if (zabq6.zaj) {
                        zabq6.zaK();
                        GoogleApiManager googleApiManager = zabq6.zaa;
                        if (googleApiManager.zal.isGooglePlayServicesAvailable(googleApiManager.zak) == 18) {
                            status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
                        } else {
                            status = new Status(22, "API failed to connect while resuming due to an unknown error.");
                        }
                        Preconditions.checkHandlerThread(zabq6.zaa.zat);
                        zabq6.zaE(status, null, false);
                        zabq6.zac.disconnect("Timing out connection while resuming.");
                        break;
                    }
                }
                break;
            case 12:
                if (this.zap.containsKey(message.obj)) {
                    ((zabq) this.zap.get(message.obj)).zaN(true);
                    break;
                }
                break;
            case 14:
                zaaf zaaf = (zaaf) message.obj;
                ApiKey apiKey = zaaf.zaa;
                if (this.zap.containsKey(apiKey)) {
                    boolean zaN = ((zabq) this.zap.get(apiKey)).zaN(false);
                    zaaf.zab.zza.zzb(Boolean.valueOf(zaN));
                    break;
                } else {
                    zaaf.zab.zza.zzb(Boolean.FALSE);
                    break;
                }
            case 15:
                zabs zabs = (zabs) message.obj;
                if (this.zap.containsKey(zabs.zaa)) {
                    zabq zabq7 = (zabq) this.zap.get(zabs.zaa);
                    if (zabq7.zak.contains(zabs) && !zabq7.zaj) {
                        if (zabq7.zac.isConnected()) {
                            zabq7.zaF();
                            break;
                        } else {
                            zabq7.zao();
                            break;
                        }
                    }
                }
                break;
            case 16:
                zabs zabs2 = (zabs) message.obj;
                if (this.zap.containsKey(zabs2.zaa)) {
                    zabq zabq8 = (zabq) this.zap.get(zabs2.zaa);
                    if (zabq8.zak.remove(zabs2)) {
                        zabq8.zaa.zat.removeMessages(15, zabs2);
                        zabq8.zaa.zat.removeMessages(16, zabs2);
                        Feature feature = zabs2.zab;
                        ArrayList arrayList = new ArrayList(zabq8.zab.size());
                        for (zai zai2 : zabq8.zab) {
                            if (zai2 instanceof zac) {
                                Feature[] zab2 = ((zac) zai2).zab(zabq8);
                                if (zab2 != null && ArrayUtils.contains((T[]) zab2, feature)) {
                                    arrayList.add(zai2);
                                }
                            }
                        }
                        int size = arrayList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            zai zai3 = (zai) arrayList.get(i3);
                            zabq8.zab.remove(zai3);
                            zai3.zae(new UnsupportedApiCallException(feature));
                        }
                        break;
                    }
                }
                break;
            case 17:
                zaK();
                break;
            case 18:
                zace zace = (zace) message.obj;
                if (zace.zac != 0) {
                    TelemetryData telemetryData = this.zai;
                    if (telemetryData != null) {
                        List list = telemetryData.zab;
                        if (telemetryData.zaa != zace.zab || (list != null && list.size() >= zace.zad)) {
                            this.zat.removeMessages(17);
                            zaK();
                        } else {
                            TelemetryData telemetryData2 = this.zai;
                            MethodInvocation methodInvocation = zace.zaa;
                            if (telemetryData2.zab == null) {
                                telemetryData2.zab = new ArrayList();
                            }
                            telemetryData2.zab.add(methodInvocation);
                        }
                    }
                    if (this.zai == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(zace.zaa);
                        this.zai = new TelemetryData(zace.zab, arrayList2);
                        Handler handler2 = this.zat;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), zace.zac);
                        break;
                    }
                } else {
                    TelemetryData telemetryData3 = new TelemetryData(zace.zab, Arrays.asList(new MethodInvocation[]{zace.zaa}));
                    if (this.zaj == null) {
                        this.zaj = new zao(this.zak, TelemetryLoggingOptions.zaa);
                    }
                    this.zaj.log(telemetryData3);
                    break;
                }
                break;
            case 19:
                this.zah = false;
                break;
            default:
                return false;
        }
        return true;
    }

    public final void zaC(zaae zaae) {
        synchronized (zac) {
            if (this.zaq != zaae) {
                this.zaq = zaae;
                this.zar.clear();
            }
            this.zar.addAll(zaae.zad);
        }
    }

    public final boolean zaF() {
        if (this.zah) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = RootTelemetryConfigManager.getInstance().zzc;
        if (rootTelemetryConfiguration != null && !rootTelemetryConfiguration.zzb) {
            return false;
        }
        int i = this.zam.zaa.get(203400000, -1);
        if (i == -1 || i == 0) {
            return true;
        }
        return false;
    }

    public final boolean zaG(ConnectionResult connectionResult, int i) {
        PendingIntent pendingIntent;
        GoogleApiAvailability googleApiAvailability = this.zal;
        Context context = this.zak;
        if (googleApiAvailability == null) {
            throw null;
        } else if (InstantApps.isInstantApp(context)) {
            return false;
        } else {
            if (connectionResult.hasResolution()) {
                pendingIntent = connectionResult.zzc;
            } else {
                pendingIntent = googleApiAvailability.getErrorResolutionPendingIntent(context, connectionResult.zzb, 0, null);
            }
            if (pendingIntent == null) {
                return false;
            }
            googleApiAvailability.zae(context, connectionResult.zzb, null, PendingIntent.getActivity(context, 0, GoogleApiActivity.zaa(context, pendingIntent, i, true), zap.zaa | 134217728));
            return true;
        }
    }

    public final zabq zaI(GoogleApi googleApi) {
        ApiKey apiKey = googleApi.getApiKey();
        zabq zabq = (zabq) this.zap.get(apiKey);
        if (zabq == null) {
            zabq = new zabq(this, googleApi);
            this.zap.put(apiKey, zabq);
        }
        if (zabq.zaz()) {
            this.zas.add(apiKey);
        }
        zabq.zao();
        return zabq;
    }

    public final void zaK() {
        TelemetryData telemetryData = this.zai;
        if (telemetryData != null) {
            if (telemetryData.zaa > 0 || zaF()) {
                if (this.zaj == null) {
                    this.zaj = new zao(this.zak, TelemetryLoggingOptions.zaa);
                }
                this.zaj.log(telemetryData);
            }
            this.zai = null;
        }
    }

    public final void zaL(TaskCompletionSource taskCompletionSource, int i, GoogleApi googleApi) {
        if (i != 0) {
            ApiKey apiKey = googleApi.getApiKey();
            zacd zacd = null;
            if (zaF()) {
                RootTelemetryConfiguration rootTelemetryConfiguration = RootTelemetryConfigManager.getInstance().zzc;
                boolean z = true;
                if (rootTelemetryConfiguration != null) {
                    if (rootTelemetryConfiguration.zzb) {
                        boolean z2 = rootTelemetryConfiguration.zzc;
                        zabq zabq = (zabq) this.zap.get(apiKey);
                        if (zabq != null) {
                            Client client = zabq.zac;
                            if (client instanceof BaseGmsClient) {
                                BaseGmsClient baseGmsClient = (BaseGmsClient) client;
                                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                                    ConnectionTelemetryConfiguration zab2 = zacd.zab(zabq, baseGmsClient, i);
                                    if (zab2 != null) {
                                        zabq.zam++;
                                        z = zab2.zzc;
                                    }
                                }
                            }
                        }
                        z = z2;
                    }
                }
                zacd = new zacd(this, i, apiKey, z ? System.currentTimeMillis() : 0, z ? SystemClock.elapsedRealtime() : 0);
            }
            if (zacd != null) {
                zzw zzw = taskCompletionSource.zza;
                Handler handler = this.zat;
                handler.getClass();
                zzw.zzb.zza(new zzj(new zabk(handler), zacd));
                zzw.zzi();
            }
        }
    }

    public final Task zaq(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaL(taskCompletionSource, registerListenerMethod.zad, googleApi);
        zaf zaf2 = new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(8, new zach(zaf2, this.zao.get(), googleApi)));
        return taskCompletionSource.zza;
    }

    public final void zaz(ConnectionResult connectionResult, int i) {
        if (!zaG(connectionResult, i)) {
            Handler handler = this.zat;
            handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
        }
    }
}
