package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.mpl.androidapp.R;

public abstract class ActivityGamesManagementBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final Button btnCancel;
    public final Button btnUninstall;
    public final ConstraintLayout cvContent;
    public final ConstraintLayout cvContentConfirmation;
    public final CoordinatorLayout cvGameManagement;
    public final ConstraintLayout cvProgress;
    public final ConstraintLayout cvProgressContent;
    public final ConstraintLayout cvSort;
    public final ConstraintLayout cvUninstall;
    public final ContentGameManagmentBinding fragment;
    public final ProgressBar gamesProgressBar;
    public final ImageView ivBack;
    public final ImageView ivUninstall;
    public final LinearLayout lvName;
    public final LinearLayout lvSize;
    public final LinearLayout lvTitles;
    public final Toolbar toolbar;
    public final TextView tvLastPlayed;
    public final TextView tvMessage;
    public final TextView tvName;
    public final TextView tvPrimaryTitle;
    public final TextView tvScanning;
    public final TextView tvSize;
    public final TextView tvSortBy;
    public final TextView tvSubtitle;
    public final TextView tvTitle;
    public final View view;
    public final View viewConfirmation;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ActivityGamesManagementBinding(Object obj, View view2, int i, AppBarLayout appBarLayout2, Button button, Button button2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CoordinatorLayout coordinatorLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ContentGameManagmentBinding contentGameManagmentBinding, ProgressBar progressBar, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, Toolbar toolbar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view3, View view4) {
        // ContentGameManagmentBinding contentGameManagmentBinding2 = contentGameManagmentBinding;
        super(obj, view2, i);
        this.appBarLayout = appBarLayout2;
        this.btnCancel = button;
        this.btnUninstall = button2;
        this.cvContent = constraintLayout;
        this.cvContentConfirmation = constraintLayout2;
        this.cvGameManagement = coordinatorLayout;
        this.cvProgress = constraintLayout3;
        this.cvProgressContent = constraintLayout4;
        this.cvSort = constraintLayout5;
        this.cvUninstall = constraintLayout6;
        this.fragment = contentGameManagmentBinding2;
        setContainedBinding(contentGameManagmentBinding2);
        this.gamesProgressBar = progressBar;
        this.ivBack = imageView;
        this.ivUninstall = imageView2;
        this.lvName = linearLayout;
        this.lvSize = linearLayout2;
        this.lvTitles = linearLayout3;
        this.toolbar = toolbar2;
        this.tvLastPlayed = textView;
        this.tvMessage = textView2;
        this.tvName = textView3;
        this.tvPrimaryTitle = textView4;
        this.tvScanning = textView5;
        this.tvSize = textView6;
        this.tvSortBy = textView7;
        this.tvSubtitle = textView8;
        this.tvTitle = textView9;
        this.view = view3;
        this.viewConfirmation = view4;
    }

    public static ActivityGamesManagementBinding bind(View view2) {
        return bind(view2, DataBindingUtil.sDefaultComponent);
    }

    public static ActivityGamesManagementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ActivityGamesManagementBinding bind(View view2, Object obj) {
        return (ActivityGamesManagementBinding) ViewDataBinding.bind(obj, view2, R.layout.activity_games_management);
    }

    public static ActivityGamesManagementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static ActivityGamesManagementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGamesManagementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_games_management, viewGroup, z, obj);
    }

    @Deprecated
    public static ActivityGamesManagementBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGamesManagementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_games_management, null, false, obj);
    }
}
