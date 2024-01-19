package com.mpl.androidapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class MiniProfileLoadingViewBindingImpl extends MiniProfileLoadingViewBinding {
    public static final IncludedLayouts sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;
    public final ImageView mboundView17;
    public final AppCompatImageView mboundView4;
    public final LinearLayout mboundView9;

    public MiniProfileLoadingViewBindingImpl(DataBindingComponent dataBindingComponent, View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 25, sIncludes, sViewsWithIds));
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        requestRebind();
    }

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    public MiniProfileLoadingViewBindingImpl(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        super(dataBindingComponent, viewArr[0], 0, objArr[15], objArr[3], objArr[7], objArr[8], objArr[10], objArr[11], objArr[12], objArr[13], objArr[14], objArr[16], objArr[18], objArr[0], objArr[1], objArr[2], objArr[20], objArr[21], objArr[19], objArr[22], objArr[23], objArr[24], objArr[6], objArr[5]);
        this.mDirtyFlags = -1;
        this.barrier.setTag(null);
        this.guideline10.setTag(null);
        this.guideline11.setTag(null);
        this.guideline12.setTag(null);
        this.guideline13.setTag(null);
        this.guideline14.setTag(null);
        this.guideline16.setTag(null);
        this.guideline18.setTag(null);
        this.guideline19.setTag(null);
        this.guideline21.setTag(null);
        this.guideline23.setTag(null);
        this.guideline7.setTag(null);
        this.guideline8.setTag(null);
        this.guideline9.setTag(null);
        ImageView imageView = objArr[17];
        this.mboundView17 = imageView;
        imageView.setTag(null);
        AppCompatImageView appCompatImageView = objArr[4];
        this.mboundView4 = appCompatImageView;
        appCompatImageView.setTag(null);
        LinearLayout linearLayout = objArr[9];
        this.mboundView9 = linearLayout;
        linearLayout.setTag(null);
        this.miniProfileBadge.setTag(null);
        this.miniProfileDescription.setTag(null);
        this.miniProfilePersonName.setTag(null);
        this.textView12.setTag(null);
        this.textView13.setTag(null);
        this.textView14.setTag(null);
        this.viewProfileLoadingLeftBtnActionId.setTag(null);
        this.viewProfileLoadingRightBtnActionId.setTag(null);
        setRootTag(viewArr);
        invalidateAll();
    }
}
