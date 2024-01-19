package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class LifecycleCallback {
    @KeepForSdk
    public final LifecycleFragment mLifecycleFragment;

    @KeepForSdk
    public LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    @Keep
    public static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r1 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        if (r1 == null) goto L_0x001c;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.common.api.internal.LifecycleFragment getFragment(com.google.android.gms.common.api.internal.LifecycleActivity r3) {
        /*
            java.lang.Object r3 = r3.zza
            boolean r0 = r3 instanceof androidx.fragment.app.FragmentActivity
            if (r0 == 0) goto L_0x0056
            androidx.fragment.app.FragmentActivity r3 = (androidx.fragment.app.FragmentActivity) r3
            java.lang.String r0 = "SupportLifecycleFragmentImpl"
            java.util.WeakHashMap r1 = com.google.android.gms.common.api.internal.zzd.zza
            java.lang.Object r1 = r1.get(r3)
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            if (r1 == 0) goto L_0x001c
            java.lang.Object r1 = r1.get()
            com.google.android.gms.common.api.internal.zzd r1 = (com.google.android.gms.common.api.internal.zzd) r1
            if (r1 != 0) goto L_0x004c
        L_0x001c:
            androidx.fragment.app.FragmentManager r1 = r3.getSupportFragmentManager()     // Catch:{ ClassCastException -> 0x004d }
            androidx.fragment.app.Fragment r1 = r1.findFragmentByTag(r0)     // Catch:{ ClassCastException -> 0x004d }
            com.google.android.gms.common.api.internal.zzd r1 = (com.google.android.gms.common.api.internal.zzd) r1     // Catch:{ ClassCastException -> 0x004d }
            if (r1 == 0) goto L_0x002e
            boolean r2 = r1.isRemoving()
            if (r2 == 0) goto L_0x0042
        L_0x002e:
            com.google.android.gms.common.api.internal.zzd r1 = new com.google.android.gms.common.api.internal.zzd
            r1.<init>()
            androidx.fragment.app.FragmentManager r2 = r3.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r2 = r2.beginTransaction()
            androidx.fragment.app.FragmentTransaction r0 = r2.add(r1, r0)
            r0.commitAllowingStateLoss()
        L_0x0042:
            java.util.WeakHashMap r0 = com.google.android.gms.common.api.internal.zzd.zza
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r2.<init>(r1)
            r0.put(r3, r2)
        L_0x004c:
            return r1
        L_0x004d:
            r3 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl"
            r0.<init>(r1, r3)
            throw r0
        L_0x0056:
            boolean r0 = r3 instanceof android.app.Activity
            if (r0 == 0) goto L_0x00aa
            android.app.Activity r3 = (android.app.Activity) r3
            java.lang.String r0 = "LifecycleFragmentImpl"
            java.util.WeakHashMap r1 = com.google.android.gms.common.api.internal.zzb.zza
            java.lang.Object r1 = r1.get(r3)
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            if (r1 == 0) goto L_0x0070
            java.lang.Object r1 = r1.get()
            com.google.android.gms.common.api.internal.zzb r1 = (com.google.android.gms.common.api.internal.zzb) r1
            if (r1 != 0) goto L_0x00a0
        L_0x0070:
            android.app.FragmentManager r1 = r3.getFragmentManager()     // Catch:{ ClassCastException -> 0x00a1 }
            android.app.Fragment r1 = r1.findFragmentByTag(r0)     // Catch:{ ClassCastException -> 0x00a1 }
            com.google.android.gms.common.api.internal.zzb r1 = (com.google.android.gms.common.api.internal.zzb) r1     // Catch:{ ClassCastException -> 0x00a1 }
            if (r1 == 0) goto L_0x0082
            boolean r2 = r1.isRemoving()
            if (r2 == 0) goto L_0x0096
        L_0x0082:
            com.google.android.gms.common.api.internal.zzb r1 = new com.google.android.gms.common.api.internal.zzb
            r1.<init>()
            android.app.FragmentManager r2 = r3.getFragmentManager()
            android.app.FragmentTransaction r2 = r2.beginTransaction()
            android.app.FragmentTransaction r0 = r2.add(r1, r0)
            r0.commitAllowingStateLoss()
        L_0x0096:
            java.util.WeakHashMap r0 = com.google.android.gms.common.api.internal.zzb.zza
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r2.<init>(r1)
            r0.put(r3, r2)
        L_0x00a0:
            return r1
        L_0x00a1:
            r3 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl"
            r0.<init>(r1, r3)
            throw r0
        L_0x00aa:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Can't get fragment for unexpected activity."
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.LifecycleCallback.getFragment(com.google.android.gms.common.api.internal.LifecycleActivity):com.google.android.gms.common.api.internal.LifecycleFragment");
    }

    @KeepForSdk
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @KeepForSdk
    public Activity getActivity() {
        Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
        Preconditions.checkNotNull(lifecycleActivity);
        return lifecycleActivity;
    }

    @KeepForSdk
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @KeepForSdk
    public void onCreate(Bundle bundle) {
    }

    @KeepForSdk
    public void onDestroy() {
    }

    @KeepForSdk
    public void onResume() {
    }

    @KeepForSdk
    public void onSaveInstanceState(Bundle bundle) {
    }

    @KeepForSdk
    public void onStart() {
    }

    @KeepForSdk
    public void onStop() {
    }
}
