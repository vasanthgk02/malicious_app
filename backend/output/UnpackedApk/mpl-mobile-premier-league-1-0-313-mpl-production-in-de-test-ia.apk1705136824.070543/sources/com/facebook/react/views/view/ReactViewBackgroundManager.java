package com.facebook.react.views.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public class ReactViewBackgroundManager {
    public ReactViewBackgroundDrawable mReactBackgroundDrawable;
    public View mView;

    public ReactViewBackgroundManager(View view) {
        this.mView = view;
    }

    public final ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(this.mView.getContext());
            Drawable background = this.mView.getBackground();
            ViewCompat.setBackground(this.mView, null);
            if (background == null) {
                this.mView.setBackground(this.mReactBackgroundDrawable);
            } else {
                this.mView.setBackground(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
        }
        return this.mReactBackgroundDrawable;
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.mReactBackgroundDrawable != null) {
            ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
            orCreateReactViewBackground.mColor = i;
            orCreateReactViewBackground.invalidateSelf();
        }
    }

    public void setBorderRadius(float f2) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        if (!ImageOriginUtils.floatsEqual(orCreateReactViewBackground.mBorderRadius, f2)) {
            orCreateReactViewBackground.mBorderRadius = f2;
            orCreateReactViewBackground.mNeedUpdatePathForBorderRadius = true;
            orCreateReactViewBackground.invalidateSelf();
        }
    }
}
