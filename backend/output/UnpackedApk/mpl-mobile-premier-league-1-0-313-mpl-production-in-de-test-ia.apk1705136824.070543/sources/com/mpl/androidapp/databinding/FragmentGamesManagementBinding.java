package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;
import com.mpl.androidapp.spacemanagment.GamesViewModel;

public abstract class FragmentGamesManagementBinding extends ViewDataBinding {
    public final Button btnFreeUpSpace;
    public final Button btnFreeUpSpaceNoGame;
    public final ConstraintLayout cvGame;
    public final ConstraintLayout cvGameNoFound;
    public final FrameLayout fvGameManagement;
    public final SimpleDraweeView ivGame;
    public final ImageView ivIcon;
    public final ImageView ivSort;
    public final LinearLayout lvGame;
    public final ConstraintLayout lvNoGameFound;
    public GamesViewModel mGamesViewModel;
    public final ProgressBar progress;
    public final RecyclerView rvGames;
    public final TextView tvGameInstallMsg;
    public final TextView tvGameName;
    public final TextView tvHeader;
    public final TextView tvMplGameVerified;
    public final TextView tvNoGameFound;
    public final TextView tvNoGameMsg;
    public final TextView tvSort;
    public final TextView tvSpaceInfo;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FragmentGamesManagementBinding(Object obj, View view, int i, Button button, Button button2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, SimpleDraweeView simpleDraweeView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ConstraintLayout constraintLayout3, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i);
        this.btnFreeUpSpace = button;
        this.btnFreeUpSpaceNoGame = button2;
        this.cvGame = constraintLayout;
        this.cvGameNoFound = constraintLayout2;
        this.fvGameManagement = frameLayout;
        this.ivGame = simpleDraweeView;
        this.ivIcon = imageView;
        this.ivSort = imageView2;
        this.lvGame = linearLayout;
        this.lvNoGameFound = constraintLayout3;
        this.progress = progressBar;
        this.rvGames = recyclerView;
        this.tvGameInstallMsg = textView;
        this.tvGameName = textView2;
        this.tvHeader = textView3;
        this.tvMplGameVerified = textView4;
        this.tvNoGameFound = textView5;
        this.tvNoGameMsg = textView6;
        this.tvSort = textView7;
        this.tvSpaceInfo = textView8;
    }

    public static FragmentGamesManagementBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static FragmentGamesManagementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    public GamesViewModel getGamesViewModel() {
        return this.mGamesViewModel;
    }

    public abstract void setGamesViewModel(GamesViewModel gamesViewModel);

    @Deprecated
    public static FragmentGamesManagementBinding bind(View view, Object obj) {
        return (FragmentGamesManagementBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_games_management);
    }

    public static FragmentGamesManagementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static FragmentGamesManagementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentGamesManagementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_games_management, viewGroup, z, obj);
    }

    @Deprecated
    public static FragmentGamesManagementBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentGamesManagementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_games_management, null, false, obj);
    }
}
