package com.netcore.android.notification;

import android.content.Context;
import android.location.Location;
import com.netcore.android.f.b;
import com.netcore.android.geofence.f;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.netcore.android.utility.g;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/netcore/android/notification/SMTBootPNReceiver$onReceive$1", "Lcom/netcore/android/f/b;", "Landroid/location/Location;", "location", "", "onLocationFetchSuccess", "(Landroid/location/Location;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onLocationFetchFailed", "(Ljava/lang/Exception;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTBootPNReceiver.kt */
public final class SMTBootPNReceiver$onReceive$1 implements b {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $isGeoFenceEnabled;
    public final /* synthetic */ SMTBootPNReceiver this$0;

    public SMTBootPNReceiver$onReceive$1(SMTBootPNReceiver sMTBootPNReceiver, Context context, boolean z) {
        this.this$0 = sMTBootPNReceiver;
        this.$context = context;
        this.$isGeoFenceEnabled = z;
    }

    public void onLocationFetchFailed(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        this.this$0.getTAG();
        exc.getMessage();
    }

    public void onLocationFetchSuccess(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        f.f1141f.b(new WeakReference(this.$context)).a(this.$isGeoFenceEnabled, g.f1302f.b(new WeakReference(this.$context)));
        Companion companion = SMTPreferenceHelper.Companion;
        companion.getAppPreferenceInstance(this.$context, null).setString(SMTPreferenceConstants.SMT_LAST_KNOWN_LATITUDE, String.valueOf(location.getLatitude()));
        companion.getAppPreferenceInstance(this.$context, null).setString(SMTPreferenceConstants.SMT_LAST_KNOWN_LONGITUDE, String.valueOf(location.getLongitude()));
    }
}
