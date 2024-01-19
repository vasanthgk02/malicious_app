package com.mpl.androidapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public class GameStreamErrorViewBindingImpl extends GameStreamErrorViewBinding {
    public static final IncludedLayouts sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;

    public GameStreamErrorViewBindingImpl(DataBindingComponent dataBindingComponent, View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 7, sIncludes, sViewsWithIds));
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

    public GameStreamErrorViewBindingImpl(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        super(dataBindingComponent, viewArr[0], 0, (ImageView) objArr[1], (Guideline) objArr[6], (ImageView) objArr[0], (ImageView) objArr[5], (CustomRegularTextView) objArr[3], (CustomMediumTextView) objArr[2], (CustomMediumTextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.connectivityImgId.setTag(null);
        this.guideline6.setTag(null);
        this.smallLineId.setTag(null);
        this.streamCloseId.setTag(null);
        this.txtPleaseTryAgain.setTag(null);
        this.txtSomethingWentWrong.setTag(null);
        this.txtTryAgain.setTag(null);
        setRootTag(viewArr);
        invalidateAll();
    }
}
