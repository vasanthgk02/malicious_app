package com.mpl.androidapp.unity.deepLink;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/unity/deepLink/Sender;", "", "userId", "", "(I)V", "getUserId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Sender.kt */
public final class Sender {
    public final int userId;

    public Sender(int i) {
        this.userId = i;
    }

    public static /* synthetic */ Sender copy$default(Sender sender, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sender.userId;
        }
        return sender.copy(i);
    }

    public final int component1() {
        return this.userId;
    }

    public final Sender copy(int i) {
        return new Sender(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Sender) && this.userId == ((Sender) obj).userId;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.userId;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline56(GeneratedOutlineSupport.outline73("Sender(userId="), this.userId, ')');
    }
}
