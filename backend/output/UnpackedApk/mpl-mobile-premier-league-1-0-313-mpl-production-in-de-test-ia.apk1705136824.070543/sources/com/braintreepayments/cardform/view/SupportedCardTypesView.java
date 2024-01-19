package com.braintreepayments.cardform.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;
import com.braintreepayments.cardform.utils.CardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"AppCompatCustomView"})
public class SupportedCardTypesView extends TextView {
    public List<CardType> mSupportedCardTypes = new ArrayList();

    public SupportedCardTypesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSelected(CardType... cardTypeArr) {
        int i = 0;
        if (cardTypeArr == null) {
            cardTypeArr = new CardType[0];
        }
        SpannableString spannableString = new SpannableString(new String(new char[this.mSupportedCardTypes.size()]));
        while (i < this.mSupportedCardTypes.size()) {
            PaddedImageSpan paddedImageSpan = new PaddedImageSpan(getContext(), this.mSupportedCardTypes.get(i).getFrontResource());
            paddedImageSpan.mDisabled = !Arrays.asList(cardTypeArr).contains(this.mSupportedCardTypes.get(i));
            int i2 = i + 1;
            spannableString.setSpan(paddedImageSpan, i, i2, 33);
            i = i2;
        }
        setText(spannableString);
    }

    public void setSupportedCardTypes(CardType... cardTypeArr) {
        if (cardTypeArr == null) {
            cardTypeArr = new CardType[0];
        }
        this.mSupportedCardTypes.clear();
        this.mSupportedCardTypes.addAll(Arrays.asList(cardTypeArr));
        setSelected(cardTypeArr);
    }

    public SupportedCardTypesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
