package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mpl.androidapp.R;

public abstract class LayoutErrorDialogBottomSheetBinding extends ViewDataBinding {
    public final AppCompatButton cancel;
    public final AppCompatTextView description;
    public final AppCompatImageView errorIcon;
    public final View gestureBar;
    public final AppCompatTextView header;
    public final AppCompatButton retry;

    public LayoutErrorDialogBottomSheetBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, View view2, AppCompatTextView appCompatTextView2, AppCompatButton appCompatButton2) {
        super(obj, view, i);
        this.cancel = appCompatButton;
        this.description = appCompatTextView;
        this.errorIcon = appCompatImageView;
        this.gestureBar = view2;
        this.header = appCompatTextView2;
        this.retry = appCompatButton2;
    }

    public static LayoutErrorDialogBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static LayoutErrorDialogBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static LayoutErrorDialogBottomSheetBinding bind(View view, Object obj) {
        return (LayoutErrorDialogBottomSheetBinding) ViewDataBinding.bind(obj, view, R.layout.layout_error_dialog_bottom_sheet);
    }

    public static LayoutErrorDialogBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    @Deprecated
    public static LayoutErrorDialogBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutErrorDialogBottomSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_error_dialog_bottom_sheet, viewGroup, z, obj);
    }

    @Deprecated
    public static LayoutErrorDialogBottomSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutErrorDialogBottomSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_error_dialog_bottom_sheet, null, false, obj);
    }
}
