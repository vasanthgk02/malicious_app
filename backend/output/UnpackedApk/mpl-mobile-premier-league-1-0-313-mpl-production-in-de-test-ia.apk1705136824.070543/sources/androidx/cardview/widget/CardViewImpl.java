package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;

public interface CardViewImpl {
    ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate);

    float getElevation(CardViewDelegate cardViewDelegate);

    float getMaxElevation(CardViewDelegate cardViewDelegate);

    float getMinHeight(CardViewDelegate cardViewDelegate);

    float getMinWidth(CardViewDelegate cardViewDelegate);

    float getRadius(CardViewDelegate cardViewDelegate);

    void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f2, float f3, float f4);

    void onCompatPaddingChanged(CardViewDelegate cardViewDelegate);

    void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate);

    void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList);

    void setElevation(CardViewDelegate cardViewDelegate, float f2);

    void setMaxElevation(CardViewDelegate cardViewDelegate, float f2);

    void setRadius(CardViewDelegate cardViewDelegate, float f2);

    void updatePadding(CardViewDelegate cardViewDelegate);
}
