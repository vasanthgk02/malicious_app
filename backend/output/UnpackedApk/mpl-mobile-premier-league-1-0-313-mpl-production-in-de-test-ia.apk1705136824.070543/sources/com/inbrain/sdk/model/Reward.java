package com.inbrain.sdk.model;

import android.text.TextUtils;
import java.io.Serializable;

public class Reward implements Serializable {
    public float amount;
    public String currency;
    public long transactionId;
    public int transactionType;

    public Reward(long j, float f2, String str, int i) {
        this.transactionId = j;
        this.amount = f2;
        this.currency = str;
        this.transactionType = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Reward)) {
            return false;
        }
        Reward reward = (Reward) obj;
        return reward.transactionId == this.transactionId && reward.amount == this.amount && TextUtils.equals(reward.currency, this.currency) && reward.transactionType == this.transactionType;
    }

    public int hashCode() {
        return (int) this.transactionId;
    }
}
