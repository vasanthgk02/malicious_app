package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Class
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class SaveAccountLinkingTokenRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<SaveAccountLinkingTokenRequest> CREATOR = new zbi();
    @Field
    public final PendingIntent zba;
    @Field
    public final String zbb;
    @Field
    public final String zbc;
    @Field
    public final List zbd;
    @Field
    public final String zbe;
    @Field
    public final int zbf;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class Builder {
        public PendingIntent zba;
        public String zbb;
        public String zbc;
        public List zbd = new ArrayList();
        public String zbe;
        public int zbf;
    }

    @Constructor
    public SaveAccountLinkingTokenRequest(@Param(id = 1) PendingIntent pendingIntent, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) List list, @Param(id = 5) String str3, @Param(id = 6) int i) {
        this.zba = pendingIntent;
        this.zbb = str;
        this.zbc = str2;
        this.zbd = list;
        this.zbe = str3;
        this.zbf = i;
    }

    public static Builder zba(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Preconditions.checkNotNull(saveAccountLinkingTokenRequest);
        Builder builder = new Builder();
        builder.zbd = saveAccountLinkingTokenRequest.zbd;
        builder.zbc = saveAccountLinkingTokenRequest.zbc;
        builder.zba = saveAccountLinkingTokenRequest.zba;
        builder.zbb = saveAccountLinkingTokenRequest.zbb;
        builder.zbf = saveAccountLinkingTokenRequest.zbf;
        String str = saveAccountLinkingTokenRequest.zbe;
        if (!TextUtils.isEmpty(str)) {
            builder.zbe = str;
        }
        return builder;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        if (this.zbd.size() != saveAccountLinkingTokenRequest.zbd.size() || !this.zbd.containsAll(saveAccountLinkingTokenRequest.zbd) || !Objects.equal(this.zba, saveAccountLinkingTokenRequest.zba) || !Objects.equal(this.zbb, saveAccountLinkingTokenRequest.zbb) || !Objects.equal(this.zbc, saveAccountLinkingTokenRequest.zbc) || !Objects.equal(this.zbe, saveAccountLinkingTokenRequest.zbe) || this.zbf != saveAccountLinkingTokenRequest.zbf) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbd, this.zbe});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zba, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zbd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zbe, false);
        int i2 = this.zbf;
        parcel.writeInt(262150);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
