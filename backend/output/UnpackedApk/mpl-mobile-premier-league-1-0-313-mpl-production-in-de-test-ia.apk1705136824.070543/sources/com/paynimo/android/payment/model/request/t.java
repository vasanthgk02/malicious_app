package com.paynimo.android.payment.model.request;

import android.graphics.drawable.Drawable;
import java.io.Serializable;

public class t implements Serializable {
    public Drawable drawable;
    public String name;
    public String packageName;

    public Drawable getDrawable() {
        return this.drawable;
    }

    public String getName() {
        return this.name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setDrawable(Drawable drawable2) {
        this.drawable = drawable2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}
