package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, 16842824);
    }

    public static final int zab(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline41("Unknown color scheme: ", i));
    }
}
