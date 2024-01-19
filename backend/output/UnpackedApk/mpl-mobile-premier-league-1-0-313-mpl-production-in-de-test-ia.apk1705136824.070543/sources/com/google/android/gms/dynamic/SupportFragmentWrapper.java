package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper.Stub;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class SupportFragmentWrapper extends Stub {
    public Fragment zza;

    public SupportFragmentWrapper(Fragment fragment) {
        this.zza = fragment;
    }

    public final boolean zzA() {
        return this.zza.isVisible();
    }

    public final int zzb() {
        return this.zza.getId();
    }

    public final int zzc() {
        return this.zza.getTargetRequestCode();
    }

    public final Bundle zzd() {
        return this.zza.getArguments();
    }

    public final IFragmentWrapper zze() {
        Fragment parentFragment = this.zza.getParentFragment();
        if (parentFragment != null) {
            return new SupportFragmentWrapper(parentFragment);
        }
        return null;
    }

    public final IFragmentWrapper zzf() {
        Fragment targetFragment = this.zza.getTargetFragment();
        if (targetFragment != null) {
            return new SupportFragmentWrapper(targetFragment);
        }
        return null;
    }

    public final IObjectWrapper zzg() {
        return new ObjectWrapper(this.zza.getActivity());
    }

    public final IObjectWrapper zzh() {
        return new ObjectWrapper(this.zza.getResources());
    }

    public final IObjectWrapper zzi() {
        return new ObjectWrapper(this.zza.getView());
    }

    public final String zzj() {
        return this.zza.getTag();
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Fragment fragment = this.zza;
        Preconditions.checkNotNull(view);
        fragment.registerForContextMenu(view);
    }

    public final void zzl(boolean z) {
        this.zza.setHasOptionsMenu(z);
    }

    public final void zzm(boolean z) {
        this.zza.setMenuVisibility(z);
    }

    public final void zzn(boolean z) {
        this.zza.setRetainInstance(z);
    }

    public final void zzo(boolean z) {
        this.zza.setUserVisibleHint(z);
    }

    public final void zzp(Intent intent) {
        this.zza.startActivity(intent);
    }

    public final void zzq(Intent intent, int i) {
        this.zza.startActivityForResult(intent, i);
    }

    public final void zzr(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Fragment fragment = this.zza;
        Preconditions.checkNotNull(view);
        fragment.unregisterForContextMenu(view);
    }

    public final boolean zzs() {
        return this.zza.getRetainInstance();
    }

    public final boolean zzt() {
        return this.zza.getUserVisibleHint();
    }

    public final boolean zzu() {
        return this.zza.isAdded();
    }

    public final boolean zzv() {
        return this.zza.isDetached();
    }

    public final boolean zzw() {
        return this.zza.isHidden();
    }

    public final boolean zzx() {
        return this.zza.isInLayout();
    }

    public final boolean zzy() {
        return this.zza.isRemoving();
    }

    public final boolean zzz() {
        return this.zza.isResumed();
    }
}
