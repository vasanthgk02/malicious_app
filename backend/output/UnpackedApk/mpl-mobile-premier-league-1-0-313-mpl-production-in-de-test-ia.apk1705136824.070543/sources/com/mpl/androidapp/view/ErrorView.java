package com.mpl.androidapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.ErrorViewBinding;

public class ErrorView extends ConstraintLayout {
    public ErrorViewBinding mBinding;

    public ErrorView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mBinding = (ErrorViewBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.error_view, this, true);
    }

    public ErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
