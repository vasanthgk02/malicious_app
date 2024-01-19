package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;

@Class
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class GetPhoneNumberHintIntentRequest extends AbstractSafeParcelable {
    public static final Creator<GetPhoneNumberHintIntentRequest> CREATOR = new zbe();
    @Field
    public final int zba;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class Builder {
    }

    @Constructor
    public GetPhoneNumberHintIntentRequest(@Param(id = 1) int i) {
        this.zba = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GetPhoneNumberHintIntentRequest)) {
            return false;
        }
        return Objects.equal(Integer.valueOf(this.zba), Integer.valueOf(((GetPhoneNumberHintIntentRequest) obj).zba));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zba)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zba;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
