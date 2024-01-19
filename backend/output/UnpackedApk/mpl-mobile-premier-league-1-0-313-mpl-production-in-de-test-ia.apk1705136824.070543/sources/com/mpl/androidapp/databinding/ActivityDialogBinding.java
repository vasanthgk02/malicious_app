package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityDialogBinding implements ViewBinding {
    public final Button cancelButton;
    public final TextView message;
    public final Button okButton;
    public final RelativeLayout rootView;
    public final TextView title;

    public ActivityDialogBinding(RelativeLayout relativeLayout, Button button, TextView textView, Button button2, TextView textView2) {
        this.rootView = relativeLayout;
        this.cancelButton = button;
        this.message = textView;
        this.okButton = button2;
        this.title = textView2;
    }

    public static ActivityDialogBinding bind(View view) {
        int i = R.id.cancel_button;
        Button button = (Button) view.findViewById(R.id.cancel_button);
        if (button != null) {
            i = R.id.message;
            TextView textView = (TextView) view.findViewById(R.id.message);
            if (textView != null) {
                i = R.id.ok_button;
                Button button2 = (Button) view.findViewById(R.id.ok_button);
                if (button2 != null) {
                    i = R.id.title;
                    TextView textView2 = (TextView) view.findViewById(R.id.title);
                    if (textView2 != null) {
                        ActivityDialogBinding activityDialogBinding = new ActivityDialogBinding((RelativeLayout) view, button, textView, button2, textView2);
                        return activityDialogBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
