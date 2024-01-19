package com.freshchat.consumer.sdk.m;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import com.freshchat.consumer.sdk.b.i;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public abstract class y extends BottomSheetDialogFragment {
    public int orientation;
    public FrameLayout pq;
    public DisplayMetrics pr = new DisplayMetrics();
    public int ps;
    public int pt;
    public int pu = 1;

    private int S(int i) {
        int i2;
        int T = T(i);
        if (getContext() != null) {
            i2 = i.cb(getContext()) + i.ca(getContext());
        } else {
            i2 = 0;
        }
        int i3 = T - i2;
        if (this.pu == 2) {
            return i3;
        }
        int i4 = this.ps;
        if (i4 < i3) {
            i3 = i4;
        }
        return i3;
    }

    private int T(int i) {
        int i2;
        if (i == 1) {
            DisplayMetrics displayMetrics = this.pr;
            int i3 = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
            if (i3 > i2) {
                return i3;
            }
        } else {
            DisplayMetrics displayMetrics2 = this.pr;
            int i4 = displayMetrics2.heightPixels;
            i2 = displayMetrics2.widthPixels;
            if (i4 < i2) {
                return i4;
            }
        }
        return i2;
    }

    private void hT() {
        LayoutParams layoutParams = (LayoutParams) this.pq.getLayoutParams();
        layoutParams.height = S(this.orientation);
        this.pq.setLayoutParams(layoutParams);
    }

    public void R(int i) {
        this.pu = 1;
        this.ps = i + this.pt;
        hT();
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void hS() {
        if (this.pu != 2) {
            this.pu = 2;
            hT();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.orientation = configuration.orientation;
        hT();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null && getActivity().getWindowManager() != null) {
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.pr);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        bottomSheetDialog.setOnShowListener(new z(this, bottomSheetDialog));
        return bottomSheetDialog;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }
}
