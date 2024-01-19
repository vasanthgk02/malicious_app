package com.facebook.react.views.text;

import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageSpan;

public abstract class TextInlineImageSpan extends ReplacementSpan implements ReactSpan {
    public static void possiblyUpdateInlineImageSpans(Spannable spannable, TextView textView) {
        for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spannable.getSpans(0, spannable.length(), TextInlineImageSpan.class)) {
            FrescoBasedReactTextInlineImageSpan frescoBasedReactTextInlineImageSpan = (FrescoBasedReactTextInlineImageSpan) textInlineImageSpan;
            frescoBasedReactTextInlineImageSpan.mDraweeHolder.onAttach();
            frescoBasedReactTextInlineImageSpan.mTextView = textView;
        }
    }
}
