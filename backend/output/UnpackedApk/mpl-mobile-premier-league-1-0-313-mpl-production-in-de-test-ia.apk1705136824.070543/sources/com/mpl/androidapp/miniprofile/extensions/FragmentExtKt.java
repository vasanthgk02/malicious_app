package com.mpl.androidapp.miniprofile.extensions;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0001\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u0002H\b\u001a!\u0010\u0004\u001a\u00020\u0001\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\b\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\n\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u000b*\u00020\u0002H\b\u001a2\u0010\t\u001a\u0004\u0018\u00010\f\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u000b*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\bH\b¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"finish", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Lkotlin/Unit;", "goActivity", "T", "Landroid/app/Activity;", "requestCode", "", "goService", "Landroid/content/ComponentName;", "Landroid/app/Service;", "", "sc", "Landroid/content/ServiceConnection;", "flags", "(Landroidx/fragment/app/Fragment;Landroid/content/ServiceConnection;I)Ljava/lang/Boolean;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FragmentExt.kt */
public final class FragmentExtKt {
    public static final Unit finish(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        activity.finish();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ <T extends Activity> void goActivity(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        fragment.getActivity();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static final /* synthetic */ <T extends Service> ComponentName goService(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        if (fragment.getActivity() == null) {
            return null;
        }
        fragment.getActivity();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static /* synthetic */ Boolean goService$default(Fragment fragment, ServiceConnection serviceConnection, int i, int i2, Object obj) {
        int i3 = i2 & 2;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(serviceConnection, "sc");
        if (fragment.getActivity() == null) {
            return null;
        }
        fragment.getActivity();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static final /* synthetic */ <T extends Activity> void goActivity(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        fragment.getActivity();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static final /* synthetic */ <T extends Service> Boolean goService(Fragment fragment, ServiceConnection serviceConnection, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(serviceConnection, "sc");
        if (fragment.getActivity() == null) {
            return null;
        }
        fragment.getActivity();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }
}
