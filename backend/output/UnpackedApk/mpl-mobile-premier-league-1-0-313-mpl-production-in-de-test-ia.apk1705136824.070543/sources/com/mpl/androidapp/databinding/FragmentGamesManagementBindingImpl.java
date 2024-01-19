package com.mpl.androidapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.mpl.androidapp.R;
import com.mpl.androidapp.spacemanagment.GamesViewModel;

public class FragmentGamesManagementBindingImpl extends FragmentGamesManagementBinding {
    public static final IncludedLayouts sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cv_game, 1);
        sViewsWithIds.put(R.id.iv_game, 2);
        sViewsWithIds.put(R.id.lv_game, 3);
        sViewsWithIds.put(R.id.tv_game_name, 4);
        sViewsWithIds.put(R.id.tv_mpl_game_verified, 5);
        sViewsWithIds.put(R.id.tv_game_install_msg, 6);
        sViewsWithIds.put(R.id.progress, 7);
        sViewsWithIds.put(R.id.tv_space_info, 8);
        sViewsWithIds.put(R.id.tv_header, 9);
        sViewsWithIds.put(R.id.iv_sort, 10);
        sViewsWithIds.put(R.id.tv_sort, 11);
        sViewsWithIds.put(R.id.rv_games, 12);
        sViewsWithIds.put(R.id.btn_free_up_space, 13);
        sViewsWithIds.put(R.id.cv_game_no_found, 14);
        sViewsWithIds.put(R.id.lv_no_game_found, 15);
        sViewsWithIds.put(R.id.iv_icon, 16);
        sViewsWithIds.put(R.id.tv_no_game_found, 17);
        sViewsWithIds.put(R.id.tv_no_game_msg, 18);
        sViewsWithIds.put(R.id.btn_free_up_space_no_game, 19);
    }

    public FragmentGamesManagementBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
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
            this.mDirtyFlags = 2;
        }
        requestRebind();
    }

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public void setGamesViewModel(GamesViewModel gamesViewModel) {
        this.mGamesViewModel = gamesViewModel;
    }

    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        setGamesViewModel((GamesViewModel) obj);
        return true;
    }

    public FragmentGamesManagementBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[13], objArr[19], objArr[1], objArr[14], objArr[0], objArr[2], objArr[16], objArr[10], objArr[3], objArr[15], objArr[7], objArr[12], objArr[6], objArr[4], objArr[9], objArr[5], objArr[17], objArr[18], objArr[11], objArr[8]);
        this.mDirtyFlags = -1;
        this.fvGameManagement.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
