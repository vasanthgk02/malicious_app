package com.paynimo.android.payment;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    public int day;
    public int month;
    public OnDateSetListener onDateSet;
    public int year;

    public Dialog onCreateDialog(Bundle bundle) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), getResources().getIdentifier("DialogStylePaynimo", "style", getActivity().getPackageName()), this.onDateSet, this.year, this.month, this.day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(1) + 30, this.month, this.day);
        datePickerDialog.getDatePicker().setMaxDate(instance.getTimeInMillis() - 1000);
        return datePickerDialog;
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.year = bundle.getInt(AnonymousClass27.YEAR);
        this.month = bundle.getInt(AnonymousClass27.MONTH);
        this.day = bundle.getInt("day");
    }

    public void setCallBack(OnDateSetListener onDateSetListener) {
        this.onDateSet = onDateSetListener;
    }
}
