package com.netcore.android.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.d;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.netcore.android.utility.SMTCommonUtility;
import com.netcore.android.utility.e;
import com.userexperior.models.recording.enums.UeCustomType;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/netcore/android/notification/SMTBootPNReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTBootPNReceiver.kt */
public final class SMTBootPNReceiver extends BroadcastReceiver {
    public final String TAG = SMTBootPNReceiver.class.getSimpleName();

    public final String getTAG() {
        return this.TAG;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            try {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.TAG;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.d(str, "On Boot Receiver called");
                d.f1022f.b(context).b();
                Companion companion = SMTPreferenceHelper.Companion;
                companion.getAppPreferenceInstance(context, null).setArray("Registred_GeoFences", new ArrayList());
                boolean z = companion.getAppPreferenceInstance(context, null).getBoolean(SMTPreferenceConstants.IS_GEOFECE_ENABLED);
                if (z) {
                    SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
                    if (!sMTCommonUtility.shouldCheckPermission$smartech_release() || sMTCommonUtility.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY)) {
                        new e(context, new SMTBootPNReceiver$onReceive$1(this, context, z)).a();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
