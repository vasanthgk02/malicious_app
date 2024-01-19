package com.google.android.gms.common;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.common.internal.zaz;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class SignInButton extends FrameLayout implements OnClickListener {
    public int zaa;
    public int zab;
    public View zac;
    public OnClickListener zad;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public @interface ColorScheme {
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onClick(View view) {
        OnClickListener onClickListener = this.zad;
        if (onClickListener != null && view == this.zac) {
            onClickListener.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.zaa, i);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zac.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.zad = onClickListener;
        View view = this.zac;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(Scope[] scopeArr) {
        setStyle(this.zaa, this.zab);
    }

    public void setSize(int i) {
        setStyle(i, this.zab);
    }

    public void setStyle(int i, int i2) {
        this.zaa = i;
        this.zab = i2;
        Context context = getContext();
        View view = this.zac;
        if (view != null) {
            removeView(view);
        }
        try {
            this.zac = zaz.zaa(context, this.zaa, this.zab);
        } catch (RemoteCreatorException unused) {
            int i3 = this.zaa;
            int i4 = this.zab;
            zaaa zaaa = new zaaa(context, null);
            Resources resources = context.getResources();
            zaaa.setTypeface(Typeface.DEFAULT_BOLD);
            zaaa.setTextSize(14.0f);
            int i5 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
            zaaa.setMinHeight(i5);
            zaaa.setMinWidth(i5);
            int i6 = R.drawable.common_google_signin_btn_icon_dark;
            int i7 = R.drawable.common_google_signin_btn_icon_light;
            int zab2 = zaaa.zab(i4, i6, i7, i7);
            int i8 = R.drawable.common_google_signin_btn_text_dark;
            int i9 = R.drawable.common_google_signin_btn_text_light;
            int zab3 = zaaa.zab(i4, i8, i9, i9);
            if (i3 == 0 || i3 == 1) {
                zab2 = zab3;
            } else if (i3 != 2) {
                throw new IllegalStateException(GeneratedOutlineSupport.outline41("Unknown button size: ", i3));
            }
            Drawable wrap = b.wrap(resources.getDrawable(zab2));
            wrap.setTintList(resources.getColorStateList(R.color.common_google_signin_btn_tint));
            wrap.setTintMode(Mode.SRC_ATOP);
            zaaa.setBackgroundDrawable(wrap);
            int i10 = R.color.common_google_signin_btn_text_dark;
            int i11 = R.color.common_google_signin_btn_text_light;
            ColorStateList colorStateList = resources.getColorStateList(zaaa.zab(i4, i10, i11, i11));
            Preconditions.checkNotNull(colorStateList);
            zaaa.setTextColor(colorStateList);
            if (i3 == 0) {
                zaaa.setText(resources.getString(R.string.common_signin_button_text));
            } else if (i3 == 1) {
                zaaa.setText(resources.getString(R.string.common_signin_button_text_long));
            } else if (i3 == 2) {
                zaaa.setText(null);
            } else {
                throw new IllegalStateException(GeneratedOutlineSupport.outline41("Unknown button size: ", i3));
            }
            zaaa.setTransformationMethod(null);
            if (DeviceProperties.isWearable(zaaa.getContext())) {
                zaaa.setGravity(19);
            }
            this.zac = zaaa;
        }
        addView(this.zac);
        this.zac.setEnabled(isEnabled());
        this.zac.setOnClickListener(this);
    }

    /* JADX INFO: finally extract failed */
    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zad = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SignInButton, 0, 0);
        try {
            this.zaa = obtainStyledAttributes.getInt(R.styleable.SignInButton_buttonSize, 0);
            this.zab = obtainStyledAttributes.getInt(R.styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.zaa, this.zab);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
