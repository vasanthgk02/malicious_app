package com.netcore.android.utility;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.event.SMTEventId;
import com.netcore.android.event.e;
import com.netcore.android.f.d;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/netcore/android/utility/SMTUncaughtExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Ljava/lang/Thread;", "t", "", "e", "", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/netcore/android/f/d;", "b", "Lcom/netcore/android/f/d;", "getHandler", "()Lcom/netcore/android/f/d;", "handler", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTUncaughtExceptionHandler.kt */
public final class SMTUncaughtExceptionHandler implements UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1267a;

    /* renamed from: b  reason: collision with root package name */
    public final d f1268b;

    public void uncaughtException(Thread thread, Throwable th) {
        HashMap hashMap = new HashMap();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(" App crashed for ");
        outline73.append(thread != null ? thread.getName() : null);
        outline73.append(" and error is ");
        outline73.append(th);
        hashMap.put(SMTEventParamKeys.SMT_EVENT_CRASH_MESSAGE, outline73.toString());
        e.a(e.f1081f.b(this.f1267a), 82, SMTEventId.Companion.getEventName(82), hashMap, "system", false, 16, null);
        this.f1268b.uncaughtException(thread, th);
    }
}
