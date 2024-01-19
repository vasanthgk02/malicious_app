package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public final class WrappedDrawableState extends ConstantState {
    public int mChangingConfigurations;
    public ConstantState mDrawableState;
    public ColorStateList mTint = null;
    public Mode mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;

    public WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        if (wrappedDrawableState != null) {
            this.mChangingConfigurations = wrappedDrawableState.mChangingConfigurations;
            this.mDrawableState = wrappedDrawableState.mDrawableState;
            this.mTint = wrappedDrawableState.mTint;
            this.mTintMode = wrappedDrawableState.mTintMode;
        }
    }

    public int getChangingConfigurations() {
        int i = this.mChangingConfigurations;
        ConstantState constantState = this.mDrawableState;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return new WrappedDrawableApi21(this, null);
    }

    public Drawable newDrawable(Resources resources) {
        return new WrappedDrawableApi21(this, resources);
    }
}
