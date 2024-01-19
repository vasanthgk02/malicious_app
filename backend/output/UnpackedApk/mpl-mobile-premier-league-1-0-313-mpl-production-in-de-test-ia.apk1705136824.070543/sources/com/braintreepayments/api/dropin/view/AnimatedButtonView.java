package com.braintreepayments.api.dropin.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ViewAnimator;
import com.braintreepayments.api.dropin.R$id;
import com.braintreepayments.api.dropin.R$layout;
import com.braintreepayments.api.dropin.R$styleable;

public class AnimatedButtonView extends RelativeLayout implements OnClickListener {
    public Button mButton;
    public OnClickListener mOnClickListener;
    public ViewAnimator mViewAnimator;

    public AnimatedButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public final void init(AttributeSet attributeSet) {
        if (!isInEditMode()) {
            LayoutInflater.from(getContext()).inflate(R$layout.bt_animated_button_view, this);
            this.mViewAnimator = (ViewAnimator) findViewById(R$id.bt_view_animator);
            Button button = (Button) findViewById(R$id.bt_button);
            this.mButton = button;
            button.setOnClickListener(this);
            this.mViewAnimator.setInAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
            this.mViewAnimator.setOutAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.bt_AnimatedButtonAttributes);
            this.mButton.setText(obtainStyledAttributes.getString(R$styleable.bt_AnimatedButtonAttributes_bt_buttonText));
            obtainStyledAttributes.recycle();
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
    }

    public void onClick(View view) {
        showLoading();
        OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void showButton() {
        if (this.mViewAnimator.getDisplayedChild() == 1) {
            this.mViewAnimator.showPrevious();
        }
    }

    public void showLoading() {
        if (this.mViewAnimator.getDisplayedChild() == 0) {
            this.mViewAnimator.showNext();
        }
    }

    public AnimatedButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }
}
