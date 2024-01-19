package com.facebook.react.views.textinput;

import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.widget.EditText;

public final class ReactTextInputLocalData {
    public final int mBreakStrategy;
    public final int mInputType;
    public final int mMaxLines;
    public final int mMinLines;
    public final CharSequence mPlaceholder;
    public final SpannableStringBuilder mText;
    public final float mTextSize;

    public ReactTextInputLocalData(EditText editText) {
        this.mText = new SpannableStringBuilder(editText.getText());
        this.mTextSize = editText.getTextSize();
        this.mInputType = editText.getInputType();
        this.mPlaceholder = editText.getHint();
        this.mMinLines = editText.getMinLines();
        this.mMaxLines = editText.getMaxLines();
        if (VERSION.SDK_INT >= 23) {
            this.mBreakStrategy = editText.getBreakStrategy();
        } else {
            this.mBreakStrategy = 0;
        }
    }
}
