package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$dimen;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

public final class IndicatorViewController {
    public Animator captionAnimator;
    public FrameLayout captionArea;
    public int captionDisplayed;
    public int captionToShow;
    public final float captionTranslationYPx;
    public final Context context;
    public boolean errorEnabled;
    public CharSequence errorText;
    public int errorTextAppearance;
    public TextView errorView;
    public CharSequence errorViewContentDescription;
    public ColorStateList errorViewTextColor;
    public CharSequence helperText;
    public boolean helperTextEnabled;
    public int helperTextTextAppearance;
    public TextView helperTextView;
    public ColorStateList helperTextViewTextColor;
    public LinearLayout indicatorArea;
    public int indicatorsAdded;
    public final TextInputLayout textInputView;
    public Typeface typeface;

    public IndicatorViewController(TextInputLayout textInputLayout) {
        Context context2 = textInputLayout.getContext();
        this.context = context2;
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = (float) context2.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    public void addIndicator(TextView textView, int i) {
        if (this.indicatorArea == null && this.captionArea == null) {
            LinearLayout linearLayout = new LinearLayout(this.context);
            this.indicatorArea = linearLayout;
            linearLayout.setOrientation(0);
            this.textInputView.addView(this.indicatorArea, -1, -2);
            this.captionArea = new FrameLayout(this.context);
            this.indicatorArea.addView(this.captionArea, new LayoutParams(0, -2, 1.0f));
            if (this.textInputView.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (i == 0 || i == 1) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(textView);
        } else {
            this.indicatorArea.addView(textView, new LayoutParams(-2, -2));
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    public void adjustIndicatorPadding() {
        if ((this.indicatorArea == null || this.textInputView.getEditText() == null) ? false : true) {
            EditText editText = this.textInputView.getEditText();
            boolean isFontScaleAtLeast1_3 = ImageOriginUtils.isFontScaleAtLeast1_3(this.context);
            this.indicatorArea.setPaddingRelative(getIndicatorPadding(isFontScaleAtLeast1_3, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingStart(editText)), getIndicatorPadding(isFontScaleAtLeast1_3, R$dimen.material_helper_text_font_1_3_padding_top, this.context.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), getIndicatorPadding(isFontScaleAtLeast1_3, R$dimen.material_helper_text_font_1_3_padding_horizontal, editText.getPaddingEnd()), 0);
        }
    }

    public void cancelCaptionAnimator() {
        Animator animator = this.captionAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void createCaptionAnimators(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView != null && z) {
            if (i == i3 || i == i2) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{i3 == i ? 1.0f : 0.0f});
                ofFloat.setDuration(167);
                ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                list.add(ofFloat);
                if (i3 == i) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0.0f});
                    ofFloat2.setDuration(217);
                    ofFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                    list.add(ofFloat2);
                }
            }
        }
    }

    public boolean errorShouldBeShown() {
        if (this.captionToShow != 1 || this.errorView == null || TextUtils.isEmpty(this.errorText)) {
            return false;
        }
        return true;
    }

    public final TextView getCaptionViewFromDisplayState(int i) {
        if (i == 1) {
            return this.errorView;
        }
        if (i != 2) {
            return null;
        }
        return this.helperTextView;
    }

    public int getErrorViewCurrentTextColor() {
        TextView textView = this.errorView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int getIndicatorPadding(boolean z, int i, int i2) {
        return z ? this.context.getResources().getDimensionPixelSize(i) : i2;
    }

    public void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (!this.helperTextEnabled || TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 0;
            } else {
                this.captionToShow = 2;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeIndicator(android.widget.TextView r2, int r3) {
        /*
            r1 = this;
            android.widget.LinearLayout r0 = r1.indicatorArea
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            if (r3 == 0) goto L_0x000d
            if (r3 != r0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            r3 = 0
            goto L_0x000e
        L_0x000d:
            r3 = 1
        L_0x000e:
            if (r3 == 0) goto L_0x0018
            android.widget.FrameLayout r3 = r1.captionArea
            if (r3 == 0) goto L_0x0018
            r3.removeView(r2)
            goto L_0x001d
        L_0x0018:
            android.widget.LinearLayout r3 = r1.indicatorArea
            r3.removeView(r2)
        L_0x001d:
            int r2 = r1.indicatorsAdded
            int r2 = r2 - r0
            r1.indicatorsAdded = r2
            android.widget.LinearLayout r3 = r1.indicatorArea
            if (r2 != 0) goto L_0x002b
            r2 = 8
            r3.setVisibility(r2)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.IndicatorViewController.removeIndicator(android.widget.TextView, int):void");
    }

    public final boolean shouldAnimateCaptionView(TextView textView, CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.textInputView) && this.textInputView.isEnabled() && (this.captionToShow != this.captionDisplayed || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void updateCaptionViewsVisibility(int i, int i2, boolean z) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        if (i3 != i4) {
            if (z2) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.captionAnimator = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i5 = i;
                int i6 = i2;
                createCaptionAnimators(arrayList2, this.helperTextEnabled, this.helperTextView, 2, i5, i6);
                createCaptionAnimators(arrayList2, this.errorEnabled, this.errorView, 1, i5, i6);
                ImageOriginUtils.playTogether(animatorSet, arrayList);
                final TextView captionViewFromDisplayState = getCaptionViewFromDisplayState(i);
                final TextView captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i4);
                final int i7 = i2;
                final int i8 = i;
                AnonymousClass1 r0 = new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        IndicatorViewController indicatorViewController = IndicatorViewController.this;
                        indicatorViewController.captionDisplayed = i7;
                        indicatorViewController.captionAnimator = null;
                        TextView textView = captionViewFromDisplayState;
                        if (textView != null) {
                            textView.setVisibility(4);
                            if (i8 == 1) {
                                TextView textView2 = IndicatorViewController.this.errorView;
                                if (textView2 != null) {
                                    textView2.setText(null);
                                }
                            }
                        }
                        TextView textView3 = captionViewFromDisplayState2;
                        if (textView3 != null) {
                            textView3.setTranslationY(0.0f);
                            captionViewFromDisplayState2.setAlpha(1.0f);
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        TextView textView = captionViewFromDisplayState2;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                    }
                };
                animatorSet.addListener(r0);
                animatorSet.start();
            } else if (i3 != i4) {
                if (i4 != 0) {
                    TextView captionViewFromDisplayState3 = getCaptionViewFromDisplayState(i4);
                    if (captionViewFromDisplayState3 != null) {
                        captionViewFromDisplayState3.setVisibility(0);
                        captionViewFromDisplayState3.setAlpha(1.0f);
                    }
                }
                if (i3 != 0) {
                    TextView captionViewFromDisplayState4 = getCaptionViewFromDisplayState(i);
                    if (captionViewFromDisplayState4 != null) {
                        captionViewFromDisplayState4.setVisibility(4);
                        if (i3 == 1) {
                            captionViewFromDisplayState4.setText(null);
                        }
                    }
                }
                this.captionDisplayed = i4;
            }
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateLabelState(z2, false);
            this.textInputView.updateTextInputBoxState();
        }
    }
}
