package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    public boolean waitingForDismissAllowingStateLoss;

    public class BottomSheetDismissCallback extends BottomSheetCallback {
        public BottomSheetDismissCallback(AnonymousClass1 r2) {
        }

        public void onSlide(View view, float f2) {
        }

        public void onStateChanged(View view, int i) {
            if (i == 5) {
                BottomSheetDialogFragment.this.dismissAfterAnimation();
            }
        }
    }

    /* access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.waitingForDismissAllowingStateLoss = z;
        if (bottomSheetBehavior.state == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) getDialog();
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = bottomSheetDialog.behavior;
            bottomSheetBehavior2.callbacks.remove(bottomSheetDialog.bottomSheetCallback);
        }
        BottomSheetDismissCallback bottomSheetDismissCallback = new BottomSheetDismissCallback(null);
        if (!bottomSheetBehavior.callbacks.contains(bottomSheetDismissCallback)) {
            bottomSheetBehavior.callbacks.add(bottomSheetDismissCallback);
        }
        bottomSheetBehavior.setState(5);
    }

    private boolean tryDismissWithAnimation(boolean z) {
        Dialog dialog = getDialog();
        if (dialog instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
            if (bottomSheetDialog.behavior == null) {
                bottomSheetDialog.ensureContainerAndBehavior();
            }
            boolean z2 = bottomSheetDialog.behavior.hideable;
        }
        return false;
    }

    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}
