package com.braintreepayments.cardform.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.NotificationCompat.WearableExtender;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.cardform.R$anim;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ErrorEditText extends TextInputEditText {
    public boolean mError;
    public Animation mErrorAnimator;
    public boolean mOptional;

    public ErrorEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void closeSoftKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public View focusNextView() {
        View view;
        if (getImeActionId() == 2) {
            return null;
        }
        try {
            view = focusSearch(2);
        } catch (IllegalArgumentException unused) {
            view = focusSearch(130);
        }
        if (view == null || !view.requestFocus()) {
            return null;
        }
        return view;
    }

    public String getErrorMessage() {
        return null;
    }

    public TextInputLayout getTextInputLayoutParent() {
        if (getParent() == null || !(getParent().getParent() instanceof TextInputLayout)) {
            return null;
        }
        return (TextInputLayout) getParent().getParent();
    }

    public final void init() {
        this.mErrorAnimator = AnimationUtils.loadAnimation(getContext(), R$anim.bt_error_animation);
        this.mError = false;
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            setTextDirection(3);
            setGravity(WearableExtender.DEFAULT_CONTENT_ICON_GRAVITY);
        }
    }

    public boolean isValid() {
        return true;
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z && !isValid() && !TextUtils.isEmpty(getText())) {
            setError(getErrorMessage());
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (i2 != i3) {
            setError(null);
        }
    }

    public void setError(String str) {
        this.mError = !TextUtils.isEmpty(str);
        TextInputLayout textInputLayoutParent = getTextInputLayoutParent();
        if (textInputLayoutParent != null) {
            textInputLayoutParent.setErrorEnabled(!TextUtils.isEmpty(str));
            textInputLayoutParent.setError(str);
        }
        Animation animation = this.mErrorAnimator;
        if (animation != null && this.mError) {
            startAnimation(animation);
            k.vibrate(getContext(), 10);
        }
    }

    public void setFieldHint(int i) {
        setFieldHint(getContext().getString(i));
    }

    public void setOptional(boolean z) {
        this.mOptional = z;
    }

    public void validate() {
        if (isValid() || this.mOptional) {
            setError(null);
        } else {
            setError(getErrorMessage());
        }
    }

    public void setFieldHint(String str) {
        if (getTextInputLayoutParent() != null) {
            getTextInputLayoutParent().setHint((CharSequence) str);
        } else {
            setHint(str);
        }
    }

    public ErrorEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
