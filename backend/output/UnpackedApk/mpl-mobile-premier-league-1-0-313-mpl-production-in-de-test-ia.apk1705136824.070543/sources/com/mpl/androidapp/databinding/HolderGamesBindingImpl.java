package com.mpl.androidapp.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;
import com.mpl.androidapp.spacemanagment.GamesViewModel;

public class HolderGamesBindingImpl extends HolderGamesBinding {
    public static final IncludedLayouts sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_games, 1);
        sViewsWithIds.put(R.id.lv_games, 2);
        sViewsWithIds.put(R.id.tv_name, 3);
        sViewsWithIds.put(R.id.tv_game_desc, 4);
        sViewsWithIds.put(R.id.lv_uninstall, 5);
        sViewsWithIds.put(R.id.iv_uninstall, 6);
        sViewsWithIds.put(R.id.tv_uninstall, 7);
        sViewsWithIds.put(R.id.lv_update, 8);
        sViewsWithIds.put(R.id.iv_update, 9);
        sViewsWithIds.put(R.id.tv_update, 10);
        sViewsWithIds.put(R.id.cv_games, 11);
    }

    public HolderGamesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
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

    public void setMovieViewModel(GamesViewModel gamesViewModel) {
        this.mMovieViewModel = gamesViewModel;
    }

    public boolean setVariable(int i, Object obj) {
        if (4 != i) {
            return false;
        }
        setMovieViewModel((GamesViewModel) obj);
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public HolderGamesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CheckBox) objArr[11], (SimpleDraweeView) objArr[1], (ImageView) objArr[6], (ImageView) objArr[9], (LinearLayout) objArr[2], (LinearLayout) objArr[5], (LinearLayout) objArr[8], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[10]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
