package com.facebook.react.modules.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.modules.dialog.DialogModule.AlertFragmentListener;

public class AlertFragment extends DialogFragment implements OnClickListener {
    public final AlertFragmentListener mListener;

    public AlertFragment() {
        this.mListener = null;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        AlertFragmentListener alertFragmentListener = this.mListener;
        if (alertFragmentListener != null) {
            alertFragmentListener.onClick(dialogInterface, i);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Bundle arguments = getArguments();
        Builder title = new Builder(activity).setTitle(arguments.getString("title"));
        if (arguments.containsKey("button_positive")) {
            title.setPositiveButton(arguments.getString("button_positive"), this);
        }
        if (arguments.containsKey("button_negative")) {
            title.setNegativeButton(arguments.getString("button_negative"), this);
        }
        if (arguments.containsKey("button_neutral")) {
            title.setNeutralButton(arguments.getString("button_neutral"), this);
        }
        if (arguments.containsKey("message")) {
            title.setMessage(arguments.getString("message"));
        }
        if (arguments.containsKey(DialogModule.KEY_ITEMS)) {
            title.setItems(arguments.getCharSequenceArray(DialogModule.KEY_ITEMS), this);
        }
        return title.create();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        AlertFragmentListener alertFragmentListener = this.mListener;
        if (alertFragmentListener != null) {
            alertFragmentListener.onDismiss(dialogInterface);
        }
    }

    @SuppressLint({"ValidFragment"})
    public AlertFragment(AlertFragmentListener alertFragmentListener, Bundle bundle) {
        this.mListener = alertFragmentListener;
        setArguments(bundle);
    }
}
