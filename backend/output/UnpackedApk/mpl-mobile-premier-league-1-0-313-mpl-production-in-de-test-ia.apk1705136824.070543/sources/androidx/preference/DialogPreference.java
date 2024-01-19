package androidx.preference;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public abstract class DialogPreference extends Preference {
    public CharSequence mDialogTitle;

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DialogPreference, i, i2);
        String string = b.getString(obtainStyledAttributes, R$styleable.DialogPreference_dialogTitle, R$styleable.DialogPreference_android_dialogTitle);
        this.mDialogTitle = string;
        if (string == null) {
            this.mDialogTitle = this.mTitle;
        }
        int i3 = R$styleable.DialogPreference_dialogMessage;
        int i4 = R$styleable.DialogPreference_android_dialogMessage;
        if (obtainStyledAttributes.getString(i3) == null) {
            obtainStyledAttributes.getString(i4);
        }
        int i5 = R$styleable.DialogPreference_dialogIcon;
        int i6 = R$styleable.DialogPreference_android_dialogIcon;
        if (obtainStyledAttributes.getDrawable(i5) == null) {
            obtainStyledAttributes.getDrawable(i6);
        }
        int i7 = R$styleable.DialogPreference_positiveButtonText;
        int i8 = R$styleable.DialogPreference_android_positiveButtonText;
        if (obtainStyledAttributes.getString(i7) == null) {
            obtainStyledAttributes.getString(i8);
        }
        int i9 = R$styleable.DialogPreference_negativeButtonText;
        int i10 = R$styleable.DialogPreference_android_negativeButtonText;
        if (obtainStyledAttributes.getString(i9) == null) {
            obtainStyledAttributes.getString(i10);
        }
        obtainStyledAttributes.getResourceId(R$styleable.DialogPreference_dialogLayout, obtainStyledAttributes.getResourceId(R$styleable.DialogPreference_android_dialogLayout, 0));
        obtainStyledAttributes.recycle();
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.getAttr(context, R$attr.dialogPreferenceStyle, 16842897));
    }
}
