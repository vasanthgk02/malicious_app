package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;

public final class BattlePlayerLayoutItemBinding implements ViewBinding {
    public final View avatarOverlay;
    public final ProgressBar avatarProgress;
    public final SimpleDraweeView currentPlayerAvatar;
    public final TextView currentPlayerName;
    public final ConstraintLayout playerContainer;
    public final ConstraintLayout rootView;

    public BattlePlayerLayoutItemBinding(ConstraintLayout constraintLayout, View view, ProgressBar progressBar, SimpleDraweeView simpleDraweeView, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.avatarOverlay = view;
        this.avatarProgress = progressBar;
        this.currentPlayerAvatar = simpleDraweeView;
        this.currentPlayerName = textView;
        this.playerContainer = constraintLayout2;
    }

    public static BattlePlayerLayoutItemBinding bind(View view) {
        int i = R.id.avatarOverlay;
        View findViewById = view.findViewById(R.id.avatarOverlay);
        if (findViewById != null) {
            i = R.id.avatarProgress;
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.avatarProgress);
            if (progressBar != null) {
                i = R.id.currentPlayerAvatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.currentPlayerAvatar);
                if (simpleDraweeView != null) {
                    i = R.id.currentPlayerName;
                    TextView textView = (TextView) view.findViewById(R.id.currentPlayerName);
                    if (textView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        BattlePlayerLayoutItemBinding battlePlayerLayoutItemBinding = new BattlePlayerLayoutItemBinding(constraintLayout, findViewById, progressBar, simpleDraweeView, textView, constraintLayout);
                        return battlePlayerLayoutItemBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BattlePlayerLayoutItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BattlePlayerLayoutItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.battle_player_layout_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
