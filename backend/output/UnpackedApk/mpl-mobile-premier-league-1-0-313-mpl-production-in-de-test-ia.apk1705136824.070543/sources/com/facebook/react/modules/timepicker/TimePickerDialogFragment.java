package com.facebook.react.modules.timepicker;

import android.app.Dialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Calendar;
import java.util.Locale;

public class TimePickerDialogFragment extends DialogFragment {
    public OnDismissListener mOnDismissListener;
    public OnTimeSetListener mOnTimeSetListener;

    public Dialog onCreateDialog(Bundle bundle) {
        boolean z;
        Bundle arguments = getArguments();
        FragmentActivity activity = getActivity();
        OnTimeSetListener onTimeSetListener = this.mOnTimeSetListener;
        Calendar instance = Calendar.getInstance();
        int i = instance.get(11);
        int i2 = instance.get(12);
        boolean is24HourFormat = DateFormat.is24HourFormat(activity);
        TimePickerMode timePickerMode = TimePickerMode.DEFAULT;
        if (!(arguments == null || arguments.getString("mode", null) == null)) {
            timePickerMode = TimePickerMode.valueOf(arguments.getString("mode").toUpperCase(Locale.US));
        }
        if (arguments != null) {
            int i3 = arguments.getInt(TimePickerDialogModule.ARG_HOUR, instance.get(11));
            int i4 = arguments.getInt("minute", instance.get(12));
            z = arguments.getBoolean(TimePickerDialogModule.ARG_IS24HOUR, DateFormat.is24HourFormat(activity));
            i2 = i4;
            i = i3;
        } else {
            z = is24HourFormat;
        }
        if (timePickerMode == TimePickerMode.CLOCK) {
            DismissableTimePickerDialog dismissableTimePickerDialog = new DismissableTimePickerDialog(activity, activity.getResources().getIdentifier("ClockTimePickerDialog", "style", activity.getPackageName()), onTimeSetListener, i, i2, z);
            return dismissableTimePickerDialog;
        } else if (timePickerMode == TimePickerMode.SPINNER) {
            DismissableTimePickerDialog dismissableTimePickerDialog2 = new DismissableTimePickerDialog(activity, activity.getResources().getIdentifier("SpinnerTimePickerDialog", "style", activity.getPackageName()), onTimeSetListener, i, i2, z);
            return dismissableTimePickerDialog2;
        } else {
            DismissableTimePickerDialog dismissableTimePickerDialog3 = new DismissableTimePickerDialog(activity, onTimeSetListener, i, i2, z);
            return dismissableTimePickerDialog3;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
