package com.braintreepayments.cardform.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.braintreepayments.cardform.R$string;

public class ExpirationDateEditText extends ErrorEditText implements TextWatcher, OnClickListener {
    public boolean mChangeWasAddition;
    public OnClickListener mClickListener;
    public ExpirationDateDialog mExpirationDateDialog;
    public boolean mUseExpirationDateDialog = false;

    public ExpirationDateEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private String getString() {
        Editable text = getText();
        return text != null ? text.toString() : "";
    }

    private void init() {
        setInputType(2);
        setFilters(new InputFilter[]{new LengthFilter(6), new DigitsOnlyFilter(new StringBuilder(6))});
        addTextChangedListener(this);
        setShowKeyboardOnFocus(!this.mUseExpirationDateDialog);
        setCursorVisible(!this.mUseExpirationDateDialog);
        super.setOnClickListener(this);
    }

    private void setShowKeyboardOnFocus(boolean z) {
        setShowSoftInputOnFocus(z);
    }

    public void afterTextChanged(Editable editable) {
        if (this.mChangeWasAddition && editable.length() == 1 && Character.getNumericValue(editable.charAt(0)) >= 2) {
            editable.replace(0, 1, "0").append(editable.charAt(0));
        }
        for (Object removeSpan : editable.getSpans(0, editable.length(), SlashSpan.class)) {
            editable.removeSpan(removeSpan);
        }
        if (2 <= editable.length()) {
            editable.setSpan(new SlashSpan(), 1, 2, 33);
        }
        if (((getSelectionStart() == 4 && !editable.toString().endsWith("20")) || getSelectionStart() == 6) && isValid()) {
            focusNextView();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public String getErrorMessage() {
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(R$string.bt_expiration_required);
        }
        return getContext().getString(R$string.bt_expiration_invalid);
    }

    public String getMonth() {
        if (getString().length() < 2) {
            return "";
        }
        return getString().substring(0, 2);
    }

    public String getYear() {
        String string = getString();
        if (string.length() == 4 || string.length() == 6) {
            return getString().substring(2);
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValid() {
        /*
            r9 = this;
            boolean r0 = r9.mOptional
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0079
            java.lang.String r0 = r9.getMonth()
            java.lang.String r3 = r9.getYear()
            com.braintreepayments.cardform.utils.DateValidator r4 = com.braintreepayments.cardform.utils.DateValidator.INSTANCE
            if (r4 == 0) goto L_0x0077
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L_0x0019
            goto L_0x0073
        L_0x0019:
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 == 0) goto L_0x0020
            goto L_0x0073
        L_0x0020:
            boolean r5 = android.text.TextUtils.isDigitsOnly(r0)
            if (r5 == 0) goto L_0x0073
            boolean r5 = android.text.TextUtils.isDigitsOnly(r3)
            if (r5 != 0) goto L_0x002d
            goto L_0x0073
        L_0x002d:
            int r0 = java.lang.Integer.parseInt(r0)
            if (r0 < r2) goto L_0x0073
            r5 = 12
            if (r0 <= r5) goto L_0x0038
            goto L_0x0073
        L_0x0038:
            java.util.Calendar r5 = r4.mCalendar
            int r5 = r5.get(r2)
            int r5 = r5 % 100
            int r6 = r3.length()
            r7 = 2
            if (r6 != r7) goto L_0x004c
            int r3 = java.lang.Integer.parseInt(r3)
            goto L_0x0057
        L_0x004c:
            r8 = 4
            if (r6 != r8) goto L_0x0073
            java.lang.String r3 = r3.substring(r7)
            int r3 = java.lang.Integer.parseInt(r3)
        L_0x0057:
            if (r3 != r5) goto L_0x0063
            java.util.Calendar r4 = r4.mCalendar
            int r4 = r4.get(r7)
            int r4 = r4 + r2
            if (r0 >= r4) goto L_0x0063
            goto L_0x0073
        L_0x0063:
            r0 = 20
            if (r3 >= r5) goto L_0x006d
            int r4 = r3 + 100
            int r4 = r4 - r5
            if (r4 <= r0) goto L_0x006d
            goto L_0x0073
        L_0x006d:
            int r5 = r5 + r0
            if (r3 <= r5) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r0 = 1
            goto L_0x0074
        L_0x0073:
            r0 = 0
        L_0x0074:
            if (r0 == 0) goto L_0x007a
            goto L_0x0079
        L_0x0077:
            r0 = 0
            throw r0
        L_0x0079:
            r1 = 1
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.cardform.view.ExpirationDateEditText.isValid():boolean");
    }

    public void onClick(View view) {
        if (this.mUseExpirationDateDialog) {
            closeSoftKeyboard();
            this.mExpirationDateDialog.show();
        }
        OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExpirationDateDialog expirationDateDialog = this.mExpirationDateDialog;
        if (expirationDateDialog != null && expirationDateDialog.isShowing()) {
            this.mExpirationDateDialog.dismiss();
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.mExpirationDateDialog != null) {
            if (z && this.mUseExpirationDateDialog) {
                closeSoftKeyboard();
                this.mExpirationDateDialog.show();
            } else if (this.mUseExpirationDateDialog) {
                this.mExpirationDateDialog.dismiss();
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.mChangeWasAddition = i3 > i2;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void useDialogForExpirationDateEntry(Activity activity, boolean z) {
        this.mExpirationDateDialog = ExpirationDateDialog.create(activity, this);
        this.mUseExpirationDateDialog = z;
        setShowKeyboardOnFocus(!z);
        setCursorVisible(!this.mUseExpirationDateDialog);
    }

    public ExpirationDateEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
