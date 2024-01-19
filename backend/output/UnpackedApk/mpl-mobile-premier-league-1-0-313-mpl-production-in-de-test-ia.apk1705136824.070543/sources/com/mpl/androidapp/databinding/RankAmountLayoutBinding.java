package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class RankAmountLayoutBinding implements ViewBinding {
    public final TextView rankAmount;
    public final TextView rankPosition;
    public final LinearLayout rootView;

    public RankAmountLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.rankAmount = textView;
        this.rankPosition = textView2;
    }

    public static RankAmountLayoutBinding bind(View view) {
        int i = R.id.rankAmount;
        TextView textView = (TextView) view.findViewById(R.id.rankAmount);
        if (textView != null) {
            i = R.id.rankPosition;
            TextView textView2 = (TextView) view.findViewById(R.id.rankPosition);
            if (textView2 != null) {
                return new RankAmountLayoutBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static RankAmountLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RankAmountLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.rank_amount_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
