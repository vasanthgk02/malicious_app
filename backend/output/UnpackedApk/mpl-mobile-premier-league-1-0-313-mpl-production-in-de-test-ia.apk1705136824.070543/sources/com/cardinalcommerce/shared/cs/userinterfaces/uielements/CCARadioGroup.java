package com.cardinalcommerce.shared.cs.userinterfaces.uielements;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.cardinalcommerce.cardinalmobilesdk.R$drawable;

public class CCARadioGroup extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f2207a = -1;

    public CCARadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CCARadioGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static void a(CCARadioGroup cCARadioGroup) {
        for (int i = 0; i < cCARadioGroup.getChildCount(); i++) {
            View childAt = cCARadioGroup.getChildAt(i);
            if (childAt instanceof b) {
                cCARadioGroup.setButtonToUnselectedState((b) childAt);
            }
        }
    }

    private void setButtonToUnselectedState(b bVar) {
        bVar.setCCAButtonDrawable(R$drawable.ic_radio_button_unchecked);
    }

    private void setCheckedId(int i) {
        this.f2207a = i;
    }

    /* access modifiers changed from: private */
    public void setSelectedButtonToSelectedState(b bVar) {
        bVar.setCCAButtonDrawable(R$drawable.ic_check_circle);
        setCheckedId(bVar.getId());
    }

    public void a(final View view) {
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CCARadioGroup.a(CCARadioGroup.this);
                CCARadioGroup.this.setSelectedButtonToSelectedState((b) view);
            }
        });
        super.addView(view);
    }

    public void addView(View view) {
    }

    public int getCheckedCCARadioButtonId() {
        return this.f2207a;
    }
}
