package com.shield.android.b;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.internal.appset.zzr;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/shield/android/collector/AppSetIDCollector;", "Lcom/shield/android/collector/ShieldDataCollector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "client", "Lcom/google/android/gms/appset/AppSetIdClient;", "getClient", "()Lcom/google/android/gms/appset/AppSetIdClient;", "setClient", "(Lcom/google/android/gms/appset/AppSetIdClient;)V", "idKey", "", "scopeKey", "task", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/appset/AppSetIdInfo;", "getTask", "()Lcom/google/android/gms/tasks/Task;", "setTask", "(Lcom/google/android/gms/tasks/Task;)V", "getData", "shieldsdk_fraudRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public Task<AppSetIdInfo> f1506b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1507c = "scope";

    /* renamed from: d  reason: collision with root package name */
    public final String f1508d = "id";

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        zzr zzr = new zzr(context.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(zzr, "getClient(context.applicationContext)");
        Task<AppSetIdInfo> appSetIdInfo = zzr.getAppSetIdInfo();
        Intrinsics.checkNotNullExpressionValue(appSetIdInfo, "client.appSetIdInfo");
        this.f1506b = appSetIdInfo;
    }

    public static final void a(JSONObject jSONObject, a aVar, CountDownLatch countDownLatch, Task task) {
        Intrinsics.checkNotNullParameter(jSONObject, "$appSetIDJson");
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        Intrinsics.checkNotNullParameter(task, "it");
        try {
            AppSetIdInfo appSetIdInfo = (AppSetIdInfo) task.getResult();
            int i = appSetIdInfo.zzb;
            String str = appSetIdInfo.zza;
            Intrinsics.checkNotNullExpressionValue(str, "appSetIdInfo.id");
            jSONObject.put(aVar.f1507c, i);
            jSONObject.put(aVar.f1508d, str);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }
}
