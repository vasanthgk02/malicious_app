package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class UpdateListHeaderBinding implements ViewBinding {
    public final LinearLayout rootView;
    public final TextView tvMessage;
    public final TextView tvStatus;

    public UpdateListHeaderBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.tvMessage = textView;
        this.tvStatus = textView2;
    }

    public static UpdateListHeaderBinding bind(View view) {
        int i = R.id.tv_message;
        TextView textView = (TextView) view.findViewById(R.id.tv_message);
        if (textView != null) {
            i = R.id.tv_status;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_status);
            if (textView2 != null) {
                return new UpdateListHeaderBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static UpdateListHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UpdateListHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.update_list_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
