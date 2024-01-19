package com.facebook.react.modules.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint({"ValidFragment"})
public class DatePickerDialogFragment extends DialogFragment {
    public OnDateSetListener mOnDateSetListener;
    public OnDismissListener mOnDismissListener;

    public Dialog onCreateDialog(Bundle bundle) {
        DatePicker datePicker;
        DismissableDatePickerDialog dismissableDatePickerDialog;
        Bundle arguments = getArguments();
        FragmentActivity activity = getActivity();
        OnDateSetListener onDateSetListener = this.mOnDateSetListener;
        Calendar instance = Calendar.getInstance();
        if (arguments != null && arguments.containsKey(DatePickerDialogModule.ARG_DATE)) {
            instance.setTimeInMillis(arguments.getLong(DatePickerDialogModule.ARG_DATE));
        }
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        DatePickerMode datePickerMode = DatePickerMode.DEFAULT;
        DismissableDatePickerDialog dismissableDatePickerDialog2 = null;
        if (!(arguments == null || arguments.getString("mode", null) == null)) {
            datePickerMode = DatePickerMode.valueOf(arguments.getString("mode").toUpperCase(Locale.US));
        }
        int ordinal = datePickerMode.ordinal();
        if (ordinal == 0) {
            dismissableDatePickerDialog = new DismissableDatePickerDialog(activity, activity.getResources().getIdentifier("CalendarDatePickerDialog", "style", activity.getPackageName()), onDateSetListener, i, i2, i3);
        } else if (ordinal != 1) {
            if (ordinal == 2) {
                dismissableDatePickerDialog = new DismissableDatePickerDialog(activity, onDateSetListener, i, i2, i3);
            }
            datePicker = dismissableDatePickerDialog2.getDatePicker();
            if (arguments != null || !arguments.containsKey(DatePickerDialogModule.ARG_MINDATE)) {
                datePicker.setMinDate(-2208988800001L);
            } else {
                instance.setTimeInMillis(arguments.getLong(DatePickerDialogModule.ARG_MINDATE));
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                datePicker.setMinDate(instance.getTimeInMillis());
            }
            if (arguments != null && arguments.containsKey(DatePickerDialogModule.ARG_MAXDATE)) {
                instance.setTimeInMillis(arguments.getLong(DatePickerDialogModule.ARG_MAXDATE));
                instance.set(11, 23);
                instance.set(12, 59);
                instance.set(13, 59);
                instance.set(14, 999);
                datePicker.setMaxDate(instance.getTimeInMillis());
            }
            return dismissableDatePickerDialog2;
        } else {
            dismissableDatePickerDialog = new DismissableDatePickerDialog(activity, 16973939, onDateSetListener, i, i2, i3);
            dismissableDatePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dismissableDatePickerDialog2 = dismissableDatePickerDialog;
        datePicker = dismissableDatePickerDialog2.getDatePicker();
        if (arguments != null) {
        }
        datePicker.setMinDate(-2208988800001L);
        instance.setTimeInMillis(arguments.getLong(DatePickerDialogModule.ARG_MAXDATE));
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        datePicker.setMaxDate(instance.getTimeInMillis());
        return dismissableDatePickerDialog2;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
