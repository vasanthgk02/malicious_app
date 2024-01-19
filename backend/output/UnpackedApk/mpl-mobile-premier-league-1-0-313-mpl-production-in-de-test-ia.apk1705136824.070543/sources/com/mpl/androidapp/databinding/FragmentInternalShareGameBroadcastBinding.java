package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class FragmentInternalShareGameBroadcastBinding implements ViewBinding {
    public final RecyclerView recyclerViewShare;
    public final ConstraintLayout rootView;

    public FragmentInternalShareGameBroadcastBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.recyclerViewShare = recyclerView;
    }

    public static FragmentInternalShareGameBroadcastBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewShare);
        if (recyclerView != null) {
            return new FragmentInternalShareGameBroadcastBinding((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.recyclerViewShare)));
    }

    public static FragmentInternalShareGameBroadcastBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentInternalShareGameBroadcastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_internal_share_game_broadcast, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
