package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;
import com.mpl.androidapp.spacemanagment.GamesViewModel;

public abstract class HolderGamesBinding extends ViewDataBinding {
    public final CheckBox cvGames;
    public final SimpleDraweeView ivGames;
    public final ImageView ivUninstall;
    public final ImageView ivUpdate;
    public final LinearLayout lvGames;
    public final LinearLayout lvUninstall;
    public final LinearLayout lvUpdate;
    public GamesViewModel mMovieViewModel;
    public final TextView tvGameDesc;
    public final TextView tvName;
    public final TextView tvUninstall;
    public final TextView tvUpdate;

    public HolderGamesBinding(Object obj, View view, int i, CheckBox checkBox, SimpleDraweeView simpleDraweeView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.cvGames = checkBox;
        this.ivGames = simpleDraweeView;
        this.ivUninstall = imageView;
        this.ivUpdate = imageView2;
        this.lvGames = linearLayout;
        this.lvUninstall = linearLayout2;
        this.lvUpdate = linearLayout3;
        this.tvGameDesc = textView;
        this.tvName = textView2;
        this.tvUninstall = textView3;
        this.tvUpdate = textView4;
    }

    public static HolderGamesBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static HolderGamesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    public GamesViewModel getMovieViewModel() {
        return this.mMovieViewModel;
    }

    public abstract void setMovieViewModel(GamesViewModel gamesViewModel);

    @Deprecated
    public static HolderGamesBinding bind(View view, Object obj) {
        return (HolderGamesBinding) ViewDataBinding.bind(obj, view, R.layout.holder_games);
    }

    public static HolderGamesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static HolderGamesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderGamesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_games, viewGroup, z, obj);
    }

    @Deprecated
    public static HolderGamesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderGamesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_games, null, false, obj);
    }
}
