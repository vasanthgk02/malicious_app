package com.netcore.android.workmgr;

import android.content.Context;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Failure;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.e.b;
import com.netcore.android.e.b.a;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.utility.SMTCommonUtility;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/netcore/android/workmgr/InProgressEventWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "context", "", "", "eventIdArray", "", "a", "(Landroid/content/Context;[Ljava/lang/Integer;)V", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Landroidx/work/WorkerParameters;", "param", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: InProgressEventWorker.kt */
public final class InProgressEventWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public final String f1329a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InProgressEventWorker(Context context, WorkerParameters workerParameters) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(workerParameters, "param");
        super(context, workerParameters);
        String name = InProgressEventWorker.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "InProgressEventWorker::class.java.name");
        this.f1329a = name;
    }

    private final void a(Context context, Integer[] numArr) {
        a aVar = b.f1030c;
        aVar.b(new WeakReference(context)).a(numArr, "syncStatus", 4);
        aVar.b(new WeakReference(context)).c();
    }

    public Result doWork() {
        try {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            HashMap<String, String> d2 = b.f1030c.b(new WeakReference(applicationContext)).d(30);
            if (d2.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<Entry<String, String>> it = d2.entrySet().iterator();
                while (true) {
                    boolean z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry next = it.next();
                    String str = (String) next.getKey();
                    String optString = new JSONObject((String) next.getValue()).optString(SMTEventParamKeys.SMT_EVENT_TIME);
                    Intrinsics.checkNotNullExpressionValue(optString, "eventTimestamp");
                    if (optString.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        if (SMTCommonUtility.INSTANCE.checkDateDifferenceProgressEvent(System.currentTimeMillis(), Long.parseLong(optString))) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                            SMTLogger sMTLogger = SMTLogger.INSTANCE;
                            String str2 = this.f1329a;
                            sMTLogger.internal(str2, "Event in progress " + str + " status updated to failed");
                        } else {
                            SMTLogger.INSTANCE.internal(this.f1329a, "Timestamp is not greater then interval");
                        }
                    }
                }
                Object[] array = arrayList.toArray(new Integer[0]);
                if (array != null) {
                    a(applicationContext, (Integer[]) array);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            Success success = new Success();
            Intrinsics.checkNotNullExpressionValue(success, "Result.success()");
            return success;
        } catch (Exception e2) {
            SMTLogger.INSTANCE.e(this.f1329a, String.valueOf(e2.getMessage()));
            Failure failure = new Failure();
            Intrinsics.checkNotNullExpressionValue(failure, "Result.failure()");
            return failure;
        }
    }

    public final String getTAG() {
        return this.f1329a;
    }
}
