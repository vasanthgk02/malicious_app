package com.braintreepayments.api.dropin.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.dropin.R$drawable;
import com.braintreepayments.api.dropin.R$id;
import com.braintreepayments.api.dropin.R$layout;
import com.braintreepayments.api.dropin.R$string;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.cardform.view.ErrorEditText;

public class EnrollmentCardView extends LinearLayout implements OnClickListener, OnEditorActionListener {
    public AnimatedButtonView mAnimatedButtonView;
    public boolean mEnrollmentFailed;
    public AddPaymentUpdateListener mListener;
    public ErrorEditText mSmsCode;
    public Button mSmsHelpButton;
    public TextView mSmsSentTextView;

    public EnrollmentCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public String getSmsCode() {
        return this.mSmsCode.getText().toString();
    }

    public final void init() {
        if (!isInEditMode()) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R$layout.bt_enrollment_card, this, true);
            ErrorEditText errorEditText = (ErrorEditText) findViewById(R$id.bt_sms_code);
            this.mSmsCode = errorEditText;
            errorEditText.setImeOptions(2);
            this.mSmsCode.setImeActionLabel(getContext().getString(R$string.bt_confirm), 2);
            this.mSmsCode.setOnEditorActionListener(this);
            this.mSmsSentTextView = (TextView) findViewById(R$id.bt_sms_sent_text);
            this.mSmsHelpButton = (Button) findViewById(R$id.bt_sms_help_button);
            AnimatedButtonView animatedButtonView = (AnimatedButtonView) findViewById(R$id.bt_animated_button_view);
            this.mAnimatedButtonView = animatedButtonView;
            animatedButtonView.setClickListener(this);
            this.mSmsHelpButton.setOnClickListener(this);
        }
    }

    public void onClick(View view) {
        if (view != this.mAnimatedButtonView || !TextUtils.isEmpty(this.mSmsCode.getText())) {
            AddPaymentUpdateListener addPaymentUpdateListener = this.mListener;
            if (addPaymentUpdateListener != null) {
                if (view == this.mAnimatedButtonView) {
                    addPaymentUpdateListener.onPaymentUpdated(this);
                } else if (view == this.mSmsHelpButton) {
                    addPaymentUpdateListener.onBackRequested(this);
                }
            }
        } else {
            this.mAnimatedButtonView.showButton();
            this.mSmsCode.setError(getContext().getString(R$string.bt_sms_code_required));
        }
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.mAnimatedButtonView.showLoading();
        onClick(this.mAnimatedButtonView);
        return true;
    }

    public void setAddPaymentUpdatedListener(AddPaymentUpdateListener addPaymentUpdateListener) {
        this.mListener = addPaymentUpdateListener;
    }

    public void setErrors(ErrorWithResponse errorWithResponse) {
        if (errorWithResponse.errorFor("unionPayEnrollment") != null) {
            this.mSmsCode.setError(getContext().getString(R$string.bt_unionpay_sms_code_invalid));
            this.mEnrollmentFailed = true;
        }
        this.mAnimatedButtonView.showButton();
    }

    public void setPhoneNumber(String str) {
        this.mSmsSentTextView.setText(getContext().getString(R$string.bt_sms_code_sent_to, new Object[]{str}));
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mAnimatedButtonView.showButton();
        this.mEnrollmentFailed = false;
        if (i == 0) {
            this.mSmsCode.requestFocus();
        }
    }

    public void setup(AppCompatActivity appCompatActivity) {
        ((ImageView) findViewById(R$id.bt_sms_code_icon)).setImageResource(k.isDarkBackground(appCompatActivity) ? R$drawable.bt_ic_sms_code_dark : R$drawable.bt_ic_sms_code);
    }

    public EnrollmentCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
