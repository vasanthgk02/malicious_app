package com.google.firebase.heartbeatinfo;

import a.a.a.a.d.b;
import android.content.Context;
import android.util.Base64OutputStream;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    public static final ThreadFactory THREAD_FACTORY = $$Lambda$DefaultHeartBeatController$CnLCJSq5925dlLZbnQvX7WTMdI.INSTANCE;
    public final Context applicationContext;
    public final Executor backgroundExecutor;
    public final Set<HeartBeatConsumer> consumers;
    public final Provider<HeartBeatInfoStorage> storageProvider;
    public final Provider<UserAgentPublisher> userAgentProvider;

    public DefaultHeartBeatController(Context context, String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider) {
        $$Lambda$DefaultHeartBeatController$B19OqvkuPHzfgPo3kTW3oTbwEsE r0 = new Provider(context, str) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object get() {
                return DefaultHeartBeatController.lambda$new$3(this.f$0, this.f$1);
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        this.storageProvider = r0;
        this.consumers = set;
        this.backgroundExecutor = threadPoolExecutor;
        this.userAgentProvider = provider;
        this.applicationContext = context;
    }

    public static Component<DefaultHeartBeatController> component() {
        Builder builder = new Builder(DefaultHeartBeatController.class, new Class[]{HeartBeatController.class, HeartBeatInfo.class}, null);
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(new Dependency(HeartBeatConsumer.class, 2, 0));
        builder.add(Dependency.requiredProvider(UserAgentPublisher.class));
        builder.factory($$Lambda$DefaultHeartBeatController$G3lOcqNnXJ_U82Fa2yWdMaNW8H4.INSTANCE);
        return builder.build();
    }

    public static /* synthetic */ DefaultHeartBeatController lambda$component$4(ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), componentContainer.setOf(HeartBeatConsumer.class), componentContainer.getProvider(UserAgentPublisher.class));
    }

    public static /* synthetic */ HeartBeatInfoStorage lambda$new$3(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        return new Thread(runnable, "heartbeat-information-executor");
    }

    public synchronized HeartBeat getHeartBeatCode(String str) {
        boolean shouldSendSdkHeartBeat;
        long currentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = (HeartBeatInfoStorage) this.storageProvider.get();
        synchronized (heartBeatInfoStorage) {
            shouldSendSdkHeartBeat = heartBeatInfoStorage.shouldSendSdkHeartBeat("fire-global", currentTimeMillis);
        }
        if (shouldSendSdkHeartBeat) {
            synchronized (heartBeatInfoStorage) {
                String formattedDate = heartBeatInfoStorage.getFormattedDate(System.currentTimeMillis());
                heartBeatInfoStorage.firebaseSharedPreferences.edit().putString("last-used-date", formattedDate).commit();
                heartBeatInfoStorage.removeStoredDate(formattedDate);
            }
            return HeartBeat.GLOBAL;
        }
        return HeartBeat.NONE;
    }

    public Task<String> getHeartBeatsHeader() {
        if (!b.isUserUnlocked(this.applicationContext)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.backgroundExecutor, new Callable() {
            public final Object call() {
                return DefaultHeartBeatController.this.lambda$getHeartBeatsHeader$2$DefaultHeartBeatController();
            }
        });
    }

    public String lambda$getHeartBeatsHeader$2$DefaultHeartBeatController() throws Exception {
        GZIPOutputStream gZIPOutputStream;
        String byteArrayOutputStream;
        synchronized (this) {
            HeartBeatInfoStorage heartBeatInfoStorage = (HeartBeatInfoStorage) this.storageProvider.get();
            List<HeartBeatResult> allHeartBeats = heartBeatInfoStorage.getAllHeartBeats();
            heartBeatInfoStorage.deleteAllHeartBeats();
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                ArrayList arrayList = (ArrayList) allHeartBeats;
                if (i < arrayList.size()) {
                    HeartBeatResult heartBeatResult = (HeartBeatResult) arrayList.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", ((AutoValue_HeartBeatResult) heartBeatResult).userAgent);
                    jSONObject.put("dates", new JSONArray(((AutoValue_HeartBeatResult) heartBeatResult).usedDates));
                    jSONArray.put(jSONObject);
                    i++;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("heartbeats", jSONArray);
                    jSONObject2.put("version", "2");
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
                    } catch (Throwable th) {
                        try {
                            base64OutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
        }
        return byteArrayOutputStream;
        throw th;
    }

    public /* synthetic */ Void lambda$registerHeartBeat$1$DefaultHeartBeatController() throws Exception {
        synchronized (this) {
            ((HeartBeatInfoStorage) this.storageProvider.get()).storeHeartBeat(System.currentTimeMillis(), ((UserAgentPublisher) this.userAgentProvider.get()).getUserAgent());
        }
        return null;
    }

    public Task<Void> registerHeartBeat() {
        if (this.consumers.size() <= 0) {
            return Tasks.forResult(null);
        }
        if (!b.isUserUnlocked(this.applicationContext)) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.backgroundExecutor, new Callable() {
            public final Object call() {
                return DefaultHeartBeatController.this.lambda$registerHeartBeat$1$DefaultHeartBeatController();
            }
        });
    }
}
