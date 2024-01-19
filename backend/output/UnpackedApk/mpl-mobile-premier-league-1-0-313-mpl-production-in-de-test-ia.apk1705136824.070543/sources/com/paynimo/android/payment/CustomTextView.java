package com.paynimo.android.payment;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;

public class CustomTextView extends AppCompatTextView {
    public Context currContext;

    public CustomTextView(Context context) {
        super(context);
        this.currContext = context;
        if (!isInEditMode()) {
            setFont();
        }
    }

    private void setFont() {
        AssetManager assets = this.currContext.getAssets();
        Resources resources = this.currContext.getResources();
        setTypeface(Typeface.createFromAsset(assets, GeneratedOutlineSupport.outline32(this.currContext, getResources(), "paynimo_fontpath", NetworkingModule.REQUEST_BODY_KEY_STRING, resources)));
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currContext = context;
        if (!isInEditMode()) {
            setFont();
        }
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currContext = context;
        if (!isInEditMode()) {
            setFont();
        }
    }
}
