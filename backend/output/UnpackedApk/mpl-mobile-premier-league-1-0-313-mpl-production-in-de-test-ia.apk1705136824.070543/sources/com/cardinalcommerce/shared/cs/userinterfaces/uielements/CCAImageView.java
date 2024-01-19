package com.cardinalcommerce.shared.cs.userinterfaces.uielements;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class CCAImageView extends ImageView {
    public CCAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CCAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getCCADrawable() {
        return super.getDrawable();
    }

    public Drawable getDrawable() {
        return null;
    }

    public void setCCAImageBitmap(Bitmap bitmap) {
        setCCAImageDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    public void setCCAImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public void setCCAImageIcon(Icon icon) {
        super.setImageIcon(icon);
    }

    public void setCCAImageResource(int i) {
        super.setImageResource(i);
    }

    public void setCCAImageUri(Uri uri) {
        super.setImageURI(uri);
    }

    public void setCCAOnClickListener(c$a c_a) {
        super.setOnClickListener(c_a);
    }

    public void setCCAOnFocusChangeListener(c$b c_b) {
        super.setOnFocusChangeListener(c_b);
    }

    public void setCCAOnTouchListener(c$d c_d) {
        super.setOnTouchListener(c_d);
    }

    public void setImageBitmap(Bitmap bitmap) {
    }

    public void setImageDrawable(Drawable drawable) {
    }

    public void setImageIcon(Icon icon) {
    }

    public void setImageResource(int i) {
    }

    public void setImageURI(Uri uri) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
    }
}
