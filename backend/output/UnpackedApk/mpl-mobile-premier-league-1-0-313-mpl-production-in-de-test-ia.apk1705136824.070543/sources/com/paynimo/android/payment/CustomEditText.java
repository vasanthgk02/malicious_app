package com.paynimo.android.payment;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;

public class CustomEditText extends EditText {
    public int activeColor;
    public Context currContext;
    public int height;
    public int inactiveColor;
    public Paint paint;
    public int width;

    public CustomEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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

    public CustomEditText(Context context) {
        super(context);
        this.currContext = context;
        if (!isInEditMode()) {
            setFont();
        }
    }

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currContext = context;
        if (!isInEditMode()) {
            setFont();
        }
    }
}
