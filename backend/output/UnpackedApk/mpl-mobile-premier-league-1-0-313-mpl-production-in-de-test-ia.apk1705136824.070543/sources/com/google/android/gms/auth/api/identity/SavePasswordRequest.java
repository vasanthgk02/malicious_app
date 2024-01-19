package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;

@Class
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class SavePasswordRequest extends AbstractSafeParcelable {
    public static final Creator<SavePasswordRequest> CREATOR = new zbk();
    @Field
    public final SignInPassword zba;
    @Field
    public final String zbb;
    @Field
    public final int zbc;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class Builder {
        public SignInPassword zba;
        public String zbb;
        public int zbc;
    }

    @Constructor
    public SavePasswordRequest(@Param(id = 1) SignInPassword signInPassword, @Param(id = 2) String str, @Param(id = 3) int i) {
        Preconditions.checkNotNull(signInPassword);
        this.zba = signInPassword;
        this.zbb = str;
        this.zbc = i;
    }

    public static Builder zba(SavePasswordRequest savePasswordRequest) {
        Preconditions.checkNotNull(savePasswordRequest);
        Builder builder = new Builder();
        builder.zba = savePasswordRequest.zba;
        builder.zbc = savePasswordRequest.zbc;
        String str = savePasswordRequest.zbb;
        if (str != null) {
            builder.zbb = str;
        }
        return builder;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SavePasswordRequest)) {
            return false;
        }
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
        if (!Objects.equal(this.zba, savePasswordRequest.zba) || !Objects.equal(this.zbb, savePasswordRequest.zbb) || this.zbc != savePasswordRequest.zbc) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zba, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        int i2 = this.zbc;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
