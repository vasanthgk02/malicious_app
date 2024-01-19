package com.mpl.androidapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import com.mpl.androidapp.R;

public class ActivityGamesManagementBindingImpl extends ActivityGamesManagementBinding {
    public static final IncludedLayouts sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final FrameLayout mboundView0;

    static {
        IncludedLayouts includedLayouts = new IncludedLayouts(30);
        sIncludes = includedLayouts;
        int[] iArr = {R.layout.content_game_managment};
        includedLayouts.layouts[1] = new String[]{"content_game_managment"};
        includedLayouts.indexes[1] = new int[]{2};
        includedLayouts.layoutIds[1] = iArr;
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.app_bar_layout, 3);
        sViewsWithIds.put(R.id.toolbar, 4);
        sViewsWithIds.put(R.id.iv_back, 5);
        sViewsWithIds.put(R.id.lv_titles, 6);
        sViewsWithIds.put(R.id.tv_primary_title, 7);
        sViewsWithIds.put(R.id.tv_subtitle, 8);
        sViewsWithIds.put(R.id.cv_sort, 9);
        sViewsWithIds.put(R.id.cv_content, 10);
        sViewsWithIds.put(R.id.view, 11);
        sViewsWithIds.put(R.id.tv_sort_by, 12);
        sViewsWithIds.put(R.id.lv_size, 13);
        sViewsWithIds.put(R.id.tv_size, 14);
        sViewsWithIds.put(R.id.lv_name, 15);
        sViewsWithIds.put(R.id.tv_name, 16);
        sViewsWithIds.put(R.id.tv_last_played, 17);
        sViewsWithIds.put(R.id.cv_uninstall, 18);
        sViewsWithIds.put(R.id.cv_content_confirmation, 19);
        sViewsWithIds.put(R.id.view_confirmation, 20);
        sViewsWithIds.put(R.id.iv_uninstall, 21);
        sViewsWithIds.put(R.id.tv_title, 22);
        sViewsWithIds.put(R.id.tv_message, 23);
        sViewsWithIds.put(R.id.btn_cancel, 24);
        sViewsWithIds.put(R.id.btn_uninstall, 25);
        sViewsWithIds.put(R.id.cv_progress, 26);
        sViewsWithIds.put(R.id.cv_progress_content, 27);
        sViewsWithIds.put(R.id.games_progress_bar, 28);
        sViewsWithIds.put(R.id.tv_scanning, 29);
    }

    public ActivityGamesManagementBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFragment(ContentGameManagmentBinding contentGameManagmentBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
        ViewDataBinding.executeBindingsOn(this.fragment);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.fragment.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.mpl.androidapp.databinding.ContentGameManagmentBinding r0 = r6.fragment
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.databinding.ActivityGamesManagementBindingImpl.hasPendingBindings():boolean");
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.fragment.invalidateAll();
        requestRebind();
    }

    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeFragment((ContentGameManagmentBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.fragment.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    public ActivityGamesManagementBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, objArr[3], objArr[24], objArr[25], objArr[10], objArr[19], objArr[1], objArr[26], objArr[27], objArr[9], objArr[18], objArr[2], objArr[28], objArr[5], objArr[21], objArr[15], objArr[13], objArr[6], objArr[4], objArr[17], objArr[23], objArr[16], objArr[7], objArr[29], objArr[14], objArr[12], objArr[8], objArr[22], objArr[11], objArr[20]);
        this.mDirtyFlags = -1;
        this.cvGameManagement.setTag(null);
        FrameLayout frameLayout = objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
