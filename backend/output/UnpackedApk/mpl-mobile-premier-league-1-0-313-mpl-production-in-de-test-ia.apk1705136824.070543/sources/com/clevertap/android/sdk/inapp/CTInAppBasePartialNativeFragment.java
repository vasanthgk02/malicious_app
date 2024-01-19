package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment.CTInAppNativeButtonClickListener;

public abstract class CTInAppBasePartialNativeFragment extends CTInAppBasePartialFragment implements OnTouchListener, OnLongClickListener {
    public final GestureDetector gd = new GestureDetector(this.context, new GestureListener(null));
    public View inAppView;

    public class GestureListener extends SimpleOnGestureListener {
        public GestureListener(AnonymousClass1 r2) {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (motionEvent.getX() - motionEvent2.getX() > 120.0f && Math.abs(f2) > 200.0f) {
                remove(false);
                return true;
            } else if (motionEvent2.getX() - motionEvent.getX() <= 120.0f || Math.abs(f2) <= 200.0f) {
                return false;
            } else {
                remove(true);
                return true;
            }
        }

        public final boolean remove(boolean z) {
            TranslateAnimation translateAnimation;
            AnimationSet animationSet = new AnimationSet(true);
            if (z) {
                translateAnimation = new TranslateAnimation(0.0f, (float) CTInAppBasePartialNativeFragment.this.getScaledPixels(50), 0.0f, 0.0f);
            } else {
                translateAnimation = new TranslateAnimation(0.0f, (float) (-CTInAppBasePartialNativeFragment.this.getScaledPixels(50)), 0.0f, 0.0f);
            }
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setDuration(300);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    CTInAppBasePartialNativeFragment.this.didDismiss(null);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            CTInAppBasePartialNativeFragment.this.inAppView.startAnimation(animationSet);
            return true;
        }
    }

    public void hideSecondaryButton(Button button, Button button2) {
        button2.setVisibility(8);
        button.setLayoutParams(new LayoutParams(0, -1, 2.0f));
        button2.setLayoutParams(new LayoutParams(0, -1, 0.0f));
    }

    public boolean onLongClick(View view) {
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.gd.onTouchEvent(motionEvent) || motionEvent.getAction() == 2;
    }

    public void setupInAppButton(Button button, CTInAppNotificationButton cTInAppNotificationButton, int i) {
        if (cTInAppNotificationButton != null) {
            button.setTag(Integer.valueOf(i));
            button.setVisibility(0);
            button.setText(cTInAppNotificationButton.text);
            button.setTextColor(Color.parseColor(cTInAppNotificationButton.textColor));
            button.setBackgroundColor(Color.parseColor(cTInAppNotificationButton.backgroundColor));
            button.setOnClickListener(new CTInAppNativeButtonClickListener());
            return;
        }
        button.setVisibility(8);
    }
}
