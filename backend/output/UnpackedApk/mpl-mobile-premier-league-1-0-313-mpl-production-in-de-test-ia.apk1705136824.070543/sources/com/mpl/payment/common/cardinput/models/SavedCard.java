package com.mpl.payment.common.cardinput.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/payment/common/cardinput/models/SavedCard;", "", "additionalDetails", "Lcom/mpl/payment/common/cardinput/models/AdditionalDetails;", "(Lcom/mpl/payment/common/cardinput/models/AdditionalDetails;)V", "getAdditionalDetails", "()Lcom/mpl/payment/common/cardinput/models/AdditionalDetails;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SavedCardsModel.kt */
public final class SavedCard {
    public final AdditionalDetails additionalDetails;

    public SavedCard(AdditionalDetails additionalDetails2) {
        this.additionalDetails = additionalDetails2;
    }

    public static /* synthetic */ SavedCard copy$default(SavedCard savedCard, AdditionalDetails additionalDetails2, int i, Object obj) {
        if ((i & 1) != 0) {
            additionalDetails2 = savedCard.additionalDetails;
        }
        return savedCard.copy(additionalDetails2);
    }

    public final AdditionalDetails component1() {
        return this.additionalDetails;
    }

    public final SavedCard copy(AdditionalDetails additionalDetails2) {
        return new SavedCard(additionalDetails2);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SavedCard) && Intrinsics.areEqual(this.additionalDetails, ((SavedCard) obj).additionalDetails));
    }

    public final AdditionalDetails getAdditionalDetails() {
        return this.additionalDetails;
    }

    public int hashCode() {
        AdditionalDetails additionalDetails2 = this.additionalDetails;
        if (additionalDetails2 != null) {
            return additionalDetails2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SavedCard(additionalDetails=");
        outline73.append(this.additionalDetails);
        outline73.append(")");
        return outline73.toString();
    }
}
