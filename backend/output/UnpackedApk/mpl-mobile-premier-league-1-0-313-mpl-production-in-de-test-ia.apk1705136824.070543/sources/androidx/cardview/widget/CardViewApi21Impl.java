package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.cardview.widget.CardView.AnonymousClass1;

public class CardViewApi21Impl implements CardViewImpl {
    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).mBackground;
    }

    public final RoundRectDrawable getCardBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) ((AnonymousClass1) cardViewDelegate).mCardBackground;
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return CardView.this.getElevation();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).mPadding;
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).mRadius * 2.0f;
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).mRadius * 2.0f;
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).mRadius;
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        RoundRectDrawable roundRectDrawable = new RoundRectDrawable(colorStateList, f2);
        AnonymousClass1 r3 = (AnonymousClass1) cardViewDelegate;
        r3.mCardBackground = roundRectDrawable;
        CardView.this.setBackgroundDrawable(roundRectDrawable);
        CardView cardView = CardView.this;
        cardView.setClipToOutline(true);
        cardView.setElevation(f3);
        setMaxElevation(cardViewDelegate, f4);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getCardBackground(cardViewDelegate).mPadding);
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getCardBackground(cardViewDelegate).mPadding);
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        RoundRectDrawable cardBackground = getCardBackground(cardViewDelegate);
        cardBackground.setBackground(colorStateList);
        cardBackground.invalidateSelf();
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f2) {
        CardView.this.setElevation(f2);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f2) {
        RoundRectDrawable cardBackground = getCardBackground(cardViewDelegate);
        AnonymousClass1 r1 = (AnonymousClass1) cardViewDelegate;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        boolean preventCornerOverlap = r1.getPreventCornerOverlap();
        if (!(f2 == cardBackground.mPadding && cardBackground.mInsetForPadding == useCompatPadding && cardBackground.mInsetForRadius == preventCornerOverlap)) {
            cardBackground.mPadding = f2;
            cardBackground.mInsetForPadding = useCompatPadding;
            cardBackground.mInsetForRadius = preventCornerOverlap;
            cardBackground.updateBounds(null);
            cardBackground.invalidateSelf();
        }
        updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f2) {
        RoundRectDrawable cardBackground = getCardBackground(cardViewDelegate);
        if (f2 != cardBackground.mRadius) {
            cardBackground.mRadius = f2;
            cardBackground.updateBounds(null);
            cardBackground.invalidateSelf();
        }
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        AnonymousClass1 r0 = (AnonymousClass1) cardViewDelegate;
        if (!CardView.this.getUseCompatPadding()) {
            r0.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float f2 = getCardBackground(cardViewDelegate).mPadding;
        float f3 = getCardBackground(cardViewDelegate).mRadius;
        int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.calculateHorizontalPadding(f2, f3, r0.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.calculateVerticalPadding(f2, f3, r0.getPreventCornerOverlap()));
        r0.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }
}
