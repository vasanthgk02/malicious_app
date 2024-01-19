package androidx.appcompat.widget;

import a.a.a.a.d.b;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.widget.CompoundButtonCompat;

public class AppCompatCompoundButtonHelper {
    public ColorStateList mButtonTintList = null;
    public Mode mButtonTintMode = null;
    public boolean mHasButtonTint = false;
    public boolean mHasButtonTintMode = false;
    public boolean mSkipNextApply;
    public final CompoundButton mView;

    public AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    public void applyButtonTint() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            Drawable mutate = b.wrap(buttonDrawable).mutate();
            if (this.mHasButtonTint) {
                mutate.setTintList(this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                mutate.setTintMode(this.mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(mutate);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041 A[SYNTHETIC, Splitter:B:12:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068 A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e A[Catch:{ all -> 0x0074 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFromAttributes(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.mView
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R$styleable.CompoundButton
            r2 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r11, r1, r12, r2)
            android.widget.CompoundButton r3 = r10.mView
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R$styleable.CompoundButton
            android.content.res.TypedArray r7 = r0.mWrapped
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0074 }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x0074 }
            if (r11 == 0) goto L_0x003e
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0074 }
            int r11 = r0.getResourceId(r11, r2)     // Catch:{ all -> 0x0074 }
            if (r11 == 0) goto L_0x003e
            android.widget.CompoundButton r12 = r10.mView     // Catch:{ NotFoundException -> 0x003e }
            android.widget.CompoundButton r1 = r10.mView     // Catch:{ NotFoundException -> 0x003e }
            android.content.Context r1 = r1.getContext()     // Catch:{ NotFoundException -> 0x003e }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r11)     // Catch:{ NotFoundException -> 0x003e }
            r12.setButtonDrawable(r11)     // Catch:{ NotFoundException -> 0x003e }
            r11 = 1
            goto L_0x003f
        L_0x003e:
            r11 = 0
        L_0x003f:
            if (r11 != 0) goto L_0x0060
            int r11 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch:{ all -> 0x0074 }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x0074 }
            if (r11 == 0) goto L_0x0060
            int r11 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch:{ all -> 0x0074 }
            int r11 = r0.getResourceId(r11, r2)     // Catch:{ all -> 0x0074 }
            if (r11 == 0) goto L_0x0060
            android.widget.CompoundButton r12 = r10.mView     // Catch:{ all -> 0x0074 }
            android.widget.CompoundButton r1 = r10.mView     // Catch:{ all -> 0x0074 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0074 }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r11)     // Catch:{ all -> 0x0074 }
            r12.setButtonDrawable(r11)     // Catch:{ all -> 0x0074 }
        L_0x0060:
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0074 }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x0074 }
            if (r11 == 0) goto L_0x0076
            android.widget.CompoundButton r11 = r10.mView     // Catch:{ all -> 0x0074 }
            int r12 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0074 }
            android.content.res.ColorStateList r12 = r0.getColorStateList(r12)     // Catch:{ all -> 0x0074 }
            r11.setButtonTintList(r12)     // Catch:{ all -> 0x0074 }
            goto L_0x0076
        L_0x0074:
            r11 = move-exception
            goto L_0x0095
        L_0x0076:
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0074 }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x0074 }
            if (r11 == 0) goto L_0x008f
            android.widget.CompoundButton r11 = r10.mView     // Catch:{ all -> 0x0074 }
            int r12 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0074 }
            r1 = -1
            int r12 = r0.getInt(r12, r1)     // Catch:{ all -> 0x0074 }
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r12, r1)     // Catch:{ all -> 0x0074 }
            r11.setButtonTintMode(r12)     // Catch:{ all -> 0x0074 }
        L_0x008f:
            android.content.res.TypedArray r11 = r0.mWrapped
            r11.recycle()
            return
        L_0x0095:
            android.content.res.TypedArray r12 = r0.mWrapped
            r12.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }
}
