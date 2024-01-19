package com.inbrain.sdk.model;

import android.text.TextUtils;
import java.io.Serializable;

public class Survey implements Serializable {
    public boolean currencySale;
    public String id;
    public float multiplier;
    public long rank;
    public long time;
    public float value;

    public Survey(String str, long j, long j2, float f2, boolean z, float f3) {
        this.id = str;
        this.rank = j;
        this.time = j2;
        this.value = f2;
        this.currencySale = z;
        this.multiplier = f3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Survey)) {
            return false;
        }
        Survey survey = (Survey) obj;
        return TextUtils.equals(survey.id, this.id) && survey.rank == this.rank && survey.time == this.time && survey.value == this.value && survey.currencySale == this.currencySale && survey.multiplier == this.multiplier;
    }

    public int hashCode() {
        return this.id.hashCode();
    }
}
