package com.facebook.internal;

import android.content.Intent;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/AppCall;", "", "requestCode", "", "callId", "Ljava/util/UUID;", "(ILjava/util/UUID;)V", "getCallId", "()Ljava/util/UUID;", "getRequestCode", "()I", "setRequestCode", "(I)V", "requestIntent", "Landroid/content/Intent;", "getRequestIntent", "()Landroid/content/Intent;", "setRequestIntent", "(Landroid/content/Intent;)V", "setPending", "", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppCall.kt */
public final class AppCall {
    public static final Companion Companion = new Companion(null);
    public static AppCall currentPendingCall;
    public final UUID callId;
    public int requestCode;
    public Intent requestIntent;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/AppCall$Companion;", "", "()V", "<set-?>", "Lcom/facebook/internal/AppCall;", "currentPendingCall", "getCurrentPendingCall", "()Lcom/facebook/internal/AppCall;", "finishPendingCall", "callId", "Ljava/util/UUID;", "requestCode", "", "setCurrentPendingCall", "", "appCall", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppCall.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AppCall getCurrentPendingCall() {
            Class<AppCall> cls = AppCall.class;
            AppCall appCall = null;
            if (CrashShieldHandler.isObjectCrashing(cls)) {
                return appCall;
            }
            try {
                return AppCall.currentPendingCall;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return appCall;
            }
        }

        public final synchronized boolean setCurrentPendingCall(AppCall appCall) {
            AppCall currentPendingCall;
            currentPendingCall = getCurrentPendingCall();
            Class<AppCall> cls = AppCall.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    AppCall.currentPendingCall = appCall;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
            return currentPendingCall != null;
        }
    }

    public AppCall(int i, UUID uuid, int i2) {
        UUID uuid2;
        if ((i2 & 2) != 0) {
            uuid2 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuid2, "randomUUID()");
        } else {
            uuid2 = null;
        }
        Intrinsics.checkNotNullParameter(uuid2, "callId");
        this.requestCode = i;
        this.callId = uuid2;
    }

    public final UUID getCallId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.callId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int getRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.requestCode;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public final Intent getRequestIntent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.requestIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean setPending() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Companion.setCurrentPendingCall(this);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public final void setRequestIntent(Intent intent) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.requestIntent = intent;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
