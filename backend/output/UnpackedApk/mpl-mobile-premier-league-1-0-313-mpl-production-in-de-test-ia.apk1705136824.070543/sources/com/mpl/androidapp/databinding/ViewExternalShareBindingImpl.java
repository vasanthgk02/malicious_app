package com.mpl.androidapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class ViewExternalShareBindingImpl extends ViewExternalShareBinding {
    public static final IncludedLayouts sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;

    public ViewExternalShareBindingImpl(DataBindingComponent dataBindingComponent, View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 8, sIncludes, sViewsWithIds));
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

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ViewExternalShareBindingImpl(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        // View[] viewArr2 = viewArr;
        super(dataBindingComponent, viewArr2[0], 0, (AppCompatImageView) objArr[6], (AppCompatTextView) objArr[7], (AppCompatImageView) objArr[4], (AppCompatTextView) objArr[5], (AppCompatImageView) objArr[2], (AppCompatTextView) objArr[3], (AppCompatImageView) objArr[0], (AppCompatTextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.copyLinkIcon.setTag(null);
        this.copyLinkText.setTag(null);
        this.instagramIcon.setTag(null);
        this.instagramText.setTag(null);
        this.telegramIcon.setTag(null);
        this.telegramText.setTag(null);
        this.whatsappIcon.setTag(null);
        this.whatsappText.setTag(null);
        setRootTag(viewArr2);
        invalidateAll();
    }
}
