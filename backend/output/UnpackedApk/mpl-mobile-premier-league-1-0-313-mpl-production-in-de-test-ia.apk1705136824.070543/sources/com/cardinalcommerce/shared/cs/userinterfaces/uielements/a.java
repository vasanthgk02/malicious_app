package com.cardinalcommerce.shared.cs.userinterfaces.uielements;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView.BufferType;
import com.cardinalcommerce.cardinalmobilesdk.R$drawable;

@SuppressLint({"ViewConstructor"})
public class a extends CompoundButton {

    /* renamed from: a  reason: collision with root package name */
    public int f2210a = 0;

    /* renamed from: com.cardinalcommerce.shared.cs.userinterfaces.uielements.a$a  reason: collision with other inner class name */
    public interface C0031a extends OnCheckedChangeListener {
    }

    public a(Context context) {
        super(context);
        b();
        setCCAOnCheckedChangeListener(new C0031a() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a aVar = a.this;
                if (aVar.f2210a != 1) {
                    aVar.f2210a = 1;
                } else {
                    aVar.f2210a = 0;
                }
                a.this.b();
            }
        });
    }

    private void setCCAMarginsBetweenBoxes(a aVar) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(8, 8, 8, 16);
        aVar.setLayoutParams(layoutParams);
    }

    public final void b() {
        int i = this.f2210a != 1 ? R$drawable.ic_uncheck_box : R$drawable.ic_checked_box;
        super.setPadding(20, 4, 28, 4);
        setCCAButtonDrawable(i);
        setCCAMarginsBetweenBoxes(this);
    }

    public int getCCAId() {
        return super.getId();
    }

    public CharSequence getCCAText() {
        return super.getText();
    }

    public int getCheckState() {
        return this.f2210a;
    }

    public int getId() {
        return 0;
    }

    public CharSequence getText() {
        return "*";
    }

    public boolean isChecked() {
        return false;
    }

    public void setButtonDrawable(int i) {
    }

    public void setCCAButtonDrawable(int i) {
        super.setButtonDrawable(i);
    }

    public void setCCAElevation(float f2) {
        super.setElevation(f2);
    }

    public void setCCAId(int i) {
        super.setId(i);
    }

    public void setCCAOnCheckedChangeListener(C0031a aVar) {
        super.setOnCheckedChangeListener(aVar);
    }

    public void setCCAOnClickListener(c$a c_a) {
        super.setOnClickListener(c_a);
    }

    public void setCCAText(CharSequence charSequence) {
        super.setText(charSequence, BufferType.EDITABLE);
    }

    public void setCheckState(int i) {
        this.f2210a = i;
        b();
    }

    public void setElevation(float f2) {
    }

    public void setId(int i) {
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText("", bufferType);
    }
}
