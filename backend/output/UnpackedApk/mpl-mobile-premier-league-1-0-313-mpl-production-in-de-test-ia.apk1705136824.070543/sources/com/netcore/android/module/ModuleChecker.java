package com.netcore.android.module;

import com.netcore.android.smartechbase.communication.SMTAppInboxInterface;
import com.netcore.android.smartechbase.communication.SmartechPushInterface;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/netcore/android/module/ModuleChecker;", "", "Lcom/netcore/android/smartechbase/communication/SmartechPushInterface;", "getSmartechPush", "()Lcom/netcore/android/smartechbase/communication/SmartechPushInterface;", "Lcom/netcore/android/smartechbase/communication/SMTAppInboxInterface;", "getSmartechAppInbox", "()Lcom/netcore/android/smartechbase/communication/SMTAppInboxInterface;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: ModuleChecker.kt */
public final class ModuleChecker {
    public static final ModuleChecker INSTANCE = new ModuleChecker();

    public final SMTAppInboxInterface getSmartechAppInbox() {
        try {
            Object newInstance = Class.forName(SMTModuleConstant.Companion.getSMARTECH_APP_INBOX_MODULE()).newInstance();
            if (newInstance != null) {
                return (SMTAppInboxInterface) newInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.netcore.android.smartechbase.communication.SMTAppInboxInterface");
        } catch (Exception unused) {
            return null;
        }
    }

    public final SmartechPushInterface getSmartechPush() {
        try {
            Object newInstance = Class.forName(SMTModuleConstant.Companion.getSMARTECH_PUSH_INTERFACE()).newInstance();
            if (newInstance != null) {
                return (SmartechPushInterface) newInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.netcore.android.smartechbase.communication.SmartechPushInterface");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
