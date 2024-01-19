package com.mpl.androidapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.mpl.androidapp.R;

public class MiniProfileViewBindingImpl extends MiniProfileViewBinding {
    public static final IncludedLayouts sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline7, 1);
        sViewsWithIds.put(R.id.guideline8, 2);
        sViewsWithIds.put(R.id.guideline9, 3);
        sViewsWithIds.put(R.id.imageView4, 4);
        sViewsWithIds.put(R.id.viewProfileRightBtnActionId, 5);
        sViewsWithIds.put(R.id.viewProfileLeftBtnActionId, 6);
        sViewsWithIds.put(R.id.backgroundGreyContainerId, 7);
        sViewsWithIds.put(R.id.guideline16, 8);
        sViewsWithIds.put(R.id.cashWonValueId, 9);
        sViewsWithIds.put(R.id.textView7, 10);
        sViewsWithIds.put(R.id.followersValueId, 11);
        sViewsWithIds.put(R.id.followingValueId, 12);
        sViewsWithIds.put(R.id.textView8, 13);
        sViewsWithIds.put(R.id.textView9, 14);
        sViewsWithIds.put(R.id.barrier, 15);
        sViewsWithIds.put(R.id.miniProfileImgViewId, 16);
        sViewsWithIds.put(R.id.guideline23, 17);
        sViewsWithIds.put(R.id.miniProfilePersonName, 18);
        sViewsWithIds.put(R.id.miniProfileDisplayName, 19);
        sViewsWithIds.put(R.id.miniProfileBadge, 20);
        sViewsWithIds.put(R.id.kycBadgeId, 21);
        sViewsWithIds.put(R.id.miniProfileDescription, 22);
        sViewsWithIds.put(R.id.barrier1, 23);
        sViewsWithIds.put(R.id.bottomStripHeaderId, 24);
    }

    public MiniProfileViewBindingImpl(DataBindingComponent dataBindingComponent, View[] viewArr) {
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

    public MiniProfileViewBindingImpl(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        super(dataBindingComponent, viewArr[0], 0, objArr[7], objArr[15], objArr[23], objArr[24], objArr[9], objArr[11], objArr[12], objArr[8], objArr[17], objArr[1], objArr[2], objArr[3], objArr[4], objArr[21], objArr[20], objArr[22], objArr[19], objArr[16], objArr[18], objArr[10], objArr[13], objArr[14], objArr[6], objArr[5]);
        this.mDirtyFlags = -1;
        ScrollView scrollView = objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        setRootTag(viewArr);
        invalidateAll();
    }
}
