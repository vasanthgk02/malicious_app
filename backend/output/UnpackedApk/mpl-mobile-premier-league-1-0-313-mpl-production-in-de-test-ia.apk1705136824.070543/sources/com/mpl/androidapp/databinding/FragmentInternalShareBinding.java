package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class FragmentInternalShareBinding implements ViewBinding {
    public final EmptyInternalShareBinding emptyListView;
    public final ErrorViewInternalShareBinding errorView;
    public final RecyclerView recyclerViewInternalShare;
    public final ConstraintLayout rootView;

    public FragmentInternalShareBinding(ConstraintLayout constraintLayout, EmptyInternalShareBinding emptyInternalShareBinding, ErrorViewInternalShareBinding errorViewInternalShareBinding, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.emptyListView = emptyInternalShareBinding;
        this.errorView = errorViewInternalShareBinding;
        this.recyclerViewInternalShare = recyclerView;
    }

    public static FragmentInternalShareBinding bind(View view) {
        int i = R.id.emptyListView;
        View findViewById = view.findViewById(R.id.emptyListView);
        if (findViewById != null) {
            EmptyInternalShareBinding bind = EmptyInternalShareBinding.bind(findViewById);
            View findViewById2 = view.findViewById(R.id.errorView);
            if (findViewById2 != null) {
                ErrorViewInternalShareBinding bind2 = ErrorViewInternalShareBinding.bind(findViewById2);
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewInternalShare);
                if (recyclerView != null) {
                    return new FragmentInternalShareBinding((ConstraintLayout) view, bind, bind2, recyclerView);
                }
                i = R.id.recyclerViewInternalShare;
            } else {
                i = R.id.errorView;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentInternalShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentInternalShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_internal_share, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
