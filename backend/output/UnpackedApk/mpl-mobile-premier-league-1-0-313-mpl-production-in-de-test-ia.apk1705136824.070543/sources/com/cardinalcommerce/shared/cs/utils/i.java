package com.cardinalcommerce.shared.cs.utils;

import a.a.a.a.d.b;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.CompoundButtonCompat;
import com.cardinalcommerce.cardinalmobilesdk.R$color;
import com.cardinalcommerce.cardinalmobilesdk.R$id;
import com.cardinalcommerce.cardinalmobilesdk.R$string;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAButton;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.a;
import com.cardinalcommerce.shared.models.enums.ButtonType;
import com.cardinalcommerce.shared.userinterfaces.ButtonCustomization;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2228a = a.e();

    public static Typeface a(String str, Activity activity) {
        try {
            return Typeface.createFromAsset(activity.getAssets(), str);
        } catch (Exception e2) {
            f2228a.b(String.valueOf(13201), e2.getMessage(), null);
            return null;
        }
    }

    public static void a(Toolbar toolbar, UiCustomization uiCustomization, Activity activity) {
        if (uiCustomization != null) {
            toolbar.setTitle(R$string.secured_checkout);
            CCATextView cCATextView = (CCATextView) activity.findViewById(R$id.toolbarButton);
            cCATextView.setCCAText(activity.getResources().getString(R$string.cancel));
            cCATextView.setTextColor(activity.getResources().getColor(R$color.colorBlack));
            return;
        }
        throw null;
    }

    public static void b(CCATextView cCATextView, UiCustomization uiCustomization, Activity activity) {
        if (uiCustomization == null) {
            throw null;
        }
    }

    public static void a(CCAButton cCAButton, ButtonCustomization buttonCustomization, Activity activity) {
        if (buttonCustomization != null) {
            String str = buttonCustomization.f2233a;
            if (str != null) {
                Typeface a2 = a(str, activity);
                if (a2 != null) {
                    cCAButton.setTypeface(a2);
                }
            }
            cCAButton.setBackground(new GradientDrawable());
            return;
        }
        throw null;
    }

    public static void a(CCATextView cCATextView, UiCustomization uiCustomization, Activity activity) {
        if (cCATextView != null && uiCustomization.getButtonCustomization(ButtonType.CANCEL) != null) {
            ButtonCustomization buttonCustomization = uiCustomization.getButtonCustomization(ButtonType.CANCEL);
            if (buttonCustomization != null) {
                String str = buttonCustomization.f2233a;
                if (str != null) {
                    Typeface a2 = a(str, activity);
                    if (a2 != null) {
                        cCATextView.setTypeface(a2);
                    }
                }
                cCATextView.setBackgroundColor(Color.parseColor("#00FF0000"));
                cCATextView.setBackground(new GradientDrawable());
                return;
            }
            throw null;
        }
    }

    public static void a(a aVar, UiCustomization uiCustomization, Activity activity) {
        int i;
        if (uiCustomization != null) {
            int[][] iArr = {new int[]{-16842912}, new int[]{16842912}};
            int[] iArr2 = new int[2];
            if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) == null) {
                i = activity.getResources().getColor(R$color.blue);
            } else if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) != null) {
                i = Color.parseColor(null);
            } else {
                throw null;
            }
            iArr2[0] = i;
            iArr2[1] = -12303292;
            ColorStateList colorStateList = new ColorStateList(iArr, iArr2);
            aVar.setButtonTintList(colorStateList);
            Drawable wrap = b.wrap(VERSION.SDK_INT >= 23 ? aVar.getButtonDrawable() : CompoundButtonCompat.getButtonDrawable(aVar));
            if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) == null) {
                wrap.setTint(activity.getResources().getColor(R$color.blue));
            } else if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) != null) {
                wrap.setTint(Color.parseColor(null));
                aVar.setButtonTintList(colorStateList);
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }

    public static void a(com.cardinalcommerce.shared.cs.userinterfaces.uielements.b bVar, UiCustomization uiCustomization, Activity activity) {
        int i;
        int i2;
        if (uiCustomization != null) {
            int[][] iArr = {new int[]{-16842912}, new int[]{16842912}};
            int[] iArr2 = new int[2];
            if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) == null) {
                i = activity.getResources().getColor(R$color.blue);
            } else if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) != null) {
                i = Color.parseColor(null);
            } else {
                throw null;
            }
            iArr2[0] = i;
            if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) == null) {
                i2 = activity.getResources().getColor(R$color.blue);
            } else if (uiCustomization.getButtonCustomization(ButtonType.VERIFY) != null) {
                i2 = Color.parseColor(null);
            } else {
                throw null;
            }
            iArr2[1] = i2;
            bVar.setButtonTintList(new ColorStateList(iArr, iArr2));
            return;
        }
        throw null;
    }
}
