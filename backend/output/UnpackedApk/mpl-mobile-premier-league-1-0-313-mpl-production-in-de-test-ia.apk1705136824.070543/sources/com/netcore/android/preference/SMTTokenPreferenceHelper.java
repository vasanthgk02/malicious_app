package com.netcore.android.preference;

import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.utility.SMTGWSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\"\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/netcore/android/preference/SMTTokenPreferenceHelper;", "", "", "initKeyNames", "()V", "", "oldPushTokenPreferenceKeyName", "Ljava/lang/String;", "getOldPushTokenPreferenceKeyName", "()Ljava/lang/String;", "setOldPushTokenPreferenceKeyName", "(Ljava/lang/String;)V", "currentTokenPreferenceKeyName", "getCurrentTokenPreferenceKeyName", "setCurrentTokenPreferenceKeyName", "Lcom/netcore/android/utility/SMTGWSource;", "gwSource", "Lcom/netcore/android/utility/SMTGWSource;", "currentPushTokenPreferenceKeyName", "getCurrentPushTokenPreferenceKeyName", "setCurrentPushTokenPreferenceKeyName", "oldTokenPreferenceKeyName", "getOldTokenPreferenceKeyName", "setOldTokenPreferenceKeyName", "<init>", "(Lcom/netcore/android/utility/SMTGWSource;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTTokenPreferenceHelper.kt */
public final class SMTTokenPreferenceHelper {
    public String currentPushTokenPreferenceKeyName;
    public String currentTokenPreferenceKeyName;
    public final SMTGWSource gwSource;
    public String oldPushTokenPreferenceKeyName;
    public String oldTokenPreferenceKeyName;

    public SMTTokenPreferenceHelper(SMTGWSource sMTGWSource) {
        Intrinsics.checkNotNullParameter(sMTGWSource, SMTEventParamKeys.SMT_GWSOURCE);
        this.gwSource = sMTGWSource;
        initKeyNames();
    }

    private final void initKeyNames() {
        int value = this.gwSource.getValue();
        if (value == SMTGWSource.FCM.getValue() || value == SMTGWSource.PUSH_AMP.getValue()) {
            this.currentPushTokenPreferenceKeyName = SMTPreferenceConstants.PUSH_TOKEN_CURRENT;
            this.currentTokenPreferenceKeyName = SMTPreferenceConstants.FCM_PUSH_TOKEN_CURRENT;
            this.oldPushTokenPreferenceKeyName = SMTPreferenceConstants.PUSH_TOKEN_OLD;
            this.oldTokenPreferenceKeyName = SMTPreferenceConstants.FCM_PUSH_TOKEN_OLD;
        } else if (value == SMTGWSource.XIAOMI.getValue()) {
            this.currentPushTokenPreferenceKeyName = SMTPreferenceConstants.XIAOMI_TOKEN_CURRENT;
            this.currentTokenPreferenceKeyName = SMTPreferenceConstants.XIAOMI_PUSH_TOKEN_CURRENT;
            this.oldPushTokenPreferenceKeyName = SMTPreferenceConstants.XIAOMI_TOKEN_OLD;
            this.oldTokenPreferenceKeyName = SMTPreferenceConstants.XIAOMI_PUSH_TOKEN_OLD;
        }
    }

    public final String getCurrentPushTokenPreferenceKeyName() {
        String str = this.currentPushTokenPreferenceKeyName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentPushTokenPreferenceKeyName");
        throw null;
    }

    public final String getCurrentTokenPreferenceKeyName() {
        String str = this.currentTokenPreferenceKeyName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentTokenPreferenceKeyName");
        throw null;
    }

    public final String getOldPushTokenPreferenceKeyName() {
        String str = this.oldPushTokenPreferenceKeyName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oldPushTokenPreferenceKeyName");
        throw null;
    }

    public final String getOldTokenPreferenceKeyName() {
        String str = this.oldTokenPreferenceKeyName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oldTokenPreferenceKeyName");
        throw null;
    }

    public final void setCurrentPushTokenPreferenceKeyName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentPushTokenPreferenceKeyName = str;
    }

    public final void setCurrentTokenPreferenceKeyName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentTokenPreferenceKeyName = str;
    }

    public final void setOldPushTokenPreferenceKeyName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oldPushTokenPreferenceKeyName = str;
    }

    public final void setOldTokenPreferenceKeyName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oldTokenPreferenceKeyName = str;
    }
}
