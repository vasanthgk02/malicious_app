package com.braintreepayments.cardform.utils;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import org.apache.fontbox.cmap.CMap;

public class CardNumberTransformation implements TransformationMethod {
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence.length() < 9) {
            return charSequence;
        }
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("••••", CMap.SPACE);
        outline78.append(charSequence.subSequence(charSequence.length() - 4, charSequence.length()));
        char[] cArr = new char[(charSequence.length() - outline78.length())];
        Arrays.fill(cArr, 0);
        outline78.insert(0, cArr);
        return outline78.toString();
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
