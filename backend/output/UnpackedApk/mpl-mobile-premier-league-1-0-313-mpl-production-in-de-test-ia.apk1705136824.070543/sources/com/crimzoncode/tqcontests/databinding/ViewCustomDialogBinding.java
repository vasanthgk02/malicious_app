package com.crimzoncode.tqcontests.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.crimzoncode.tqcontests.R;
import com.crimzoncode.tqcontests.util.dialog.DialogDetails;
import com.crimzoncode.tqcontests.util.dialog.OnCustomDialogInteractionListener;

public abstract class ViewCustomDialogBinding extends ViewDataBinding {
    public final Button actionButton;
    public final FrameLayout customViewContainer;
    public final TextView descriptionBig;
    public final TextView descriptionSmall;
    public final TextView dialogTitle;
    public DialogDetails mDialogDetails;
    public OnCustomDialogInteractionListener mListener;
    public final ImageView popupLogo;
    public final Button secondaryActionButton;

    public ViewCustomDialogBinding(DataBindingComponent dataBindingComponent, View view, int i, Button button, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, Button button2) {
        super(dataBindingComponent, view, i);
        this.actionButton = button;
        this.customViewContainer = frameLayout;
        this.descriptionBig = textView;
        this.descriptionSmall = textView2;
        this.dialogTitle = textView3;
        this.popupLogo = imageView;
        this.secondaryActionButton = button2;
    }

    public static ViewCustomDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static ViewCustomDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    public DialogDetails getDialogDetails() {
        return this.mDialogDetails;
    }

    public OnCustomDialogInteractionListener getListener() {
        return this.mListener;
    }

    public abstract void setDialogDetails(DialogDetails dialogDetails);

    public abstract void setListener(OnCustomDialogInteractionListener onCustomDialogInteractionListener);

    public static ViewCustomDialogBinding bind(View view, DataBindingComponent dataBindingComponent) {
        return (ViewCustomDialogBinding) bind(dataBindingComponent, view, R.layout.view_custom_dialog);
    }

    public static ViewCustomDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    public static ViewCustomDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, DataBindingComponent dataBindingComponent) {
        return (ViewCustomDialogBinding) DataBindingUtil.inflate(layoutInflater, R.layout.view_custom_dialog, viewGroup, z, dataBindingComponent);
    }

    public static ViewCustomDialogBinding inflate(LayoutInflater layoutInflater, DataBindingComponent dataBindingComponent) {
        return (ViewCustomDialogBinding) DataBindingUtil.inflate(layoutInflater, R.layout.view_custom_dialog, null, false, dataBindingComponent);
    }
}
