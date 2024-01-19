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
import java.util.List;

@Class
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Creator<BeginSignInRequest> CREATOR = new zba();
    @Field
    public final PasswordRequestOptions zba;
    @Field
    public final GoogleIdTokenRequestOptions zbb;
    @Field
    public final String zbc;
    @Field
    public final boolean zbd;
    @Field
    public final int zbe;

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class Builder {
        public PasswordRequestOptions zba;
        public GoogleIdTokenRequestOptions zbb;
        public String zbc;
        public boolean zbd;
        public int zbe;

        public Builder() {
            Builder builder = PasswordRequestOptions.builder();
            builder.zba = false;
            this.zba = new PasswordRequestOptions(builder.zba);
            Builder builder2 = GoogleIdTokenRequestOptions.builder();
            builder2.zba = false;
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = new GoogleIdTokenRequestOptions(builder2.zba, builder2.zbb, builder2.zbc, builder2.zbd, builder2.zbe, builder2.zbf, false);
            this.zbb = googleIdTokenRequestOptions;
        }
    }

    @Class
    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Creator<GoogleIdTokenRequestOptions> CREATOR = new zbg();
        @Field
        public final boolean zba;
        @Field
        public final String zbb;
        @Field
        public final String zbc;
        @Field
        public final boolean zbd;
        @Field
        public final String zbe;
        @Field
        public final List zbf;
        @Field
        public final boolean zbg;

        /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
        public static final class Builder {
            public boolean zba = false;
            public String zbb = null;
            public String zbc = null;
            public boolean zbd = true;
            public String zbe = null;
            public List zbf = null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
            r0 = false;
         */
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public GoogleIdTokenRequestOptions(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) boolean r3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) java.lang.String r4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) java.lang.String r5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) boolean r6, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) java.lang.String r7, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 6) java.util.List r8, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 7) boolean r9) {
            /*
                r2 = this;
                r2.<init>()
                r0 = 1
                if (r6 == 0) goto L_0x000a
                if (r9 != 0) goto L_0x0009
                goto L_0x000a
            L_0x0009:
                r0 = 0
            L_0x000a:
                java.lang.String r1 = "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups."
                com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
                r2.zba = r3
                if (r3 == 0) goto L_0x0018
                java.lang.String r3 = "serverClientId must be provided if Google ID tokens are requested"
                com.google.android.gms.common.internal.Preconditions.checkNotNull(r4, r3)
            L_0x0018:
                r2.zbb = r4
                r2.zbc = r5
                r2.zbd = r6
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest> r3 = com.google.android.gms.auth.api.identity.BeginSignInRequest.CREATOR
                r3 = 0
                if (r8 == 0) goto L_0x0032
                boolean r4 = r8.isEmpty()
                if (r4 == 0) goto L_0x002a
                goto L_0x0032
            L_0x002a:
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>(r8)
                java.util.Collections.sort(r3)
            L_0x0032:
                r2.zbf = r3
                r2.zbe = r7
                r2.zbg = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions.<init>(boolean, java.lang.String, java.lang.String, boolean, java.lang.String, java.util.List, boolean):void");
        }

        public static Builder builder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            if (this.zba != googleIdTokenRequestOptions.zba || !Objects.equal(this.zbb, googleIdTokenRequestOptions.zbb) || !Objects.equal(this.zbc, googleIdTokenRequestOptions.zbc) || this.zbd != googleIdTokenRequestOptions.zbd || !Objects.equal(this.zbe, googleIdTokenRequestOptions.zbe) || !Objects.equal(this.zbf, googleIdTokenRequestOptions.zbf) || this.zbg != googleIdTokenRequestOptions.zbg) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zba), this.zbb, this.zbc, Boolean.valueOf(this.zbd), this.zbe, this.zbf, Boolean.valueOf(this.zbg)});
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            boolean z = this.zba;
            parcel.writeInt(262145);
            parcel.writeInt(z ? 1 : 0);
            SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
            SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
            boolean z2 = this.zbd;
            parcel.writeInt(262148);
            parcel.writeInt(z2 ? 1 : 0);
            SafeParcelWriter.writeString(parcel, 5, this.zbe, false);
            SafeParcelWriter.writeStringList(parcel, 6, this.zbf, false);
            boolean z3 = this.zbg;
            parcel.writeInt(262151);
            parcel.writeInt(z3 ? 1 : 0);
            SafeParcelWriter.zzb(parcel, beginObjectHeader);
        }
    }

    @Class
    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Creator<PasswordRequestOptions> CREATOR = new zbh();
        @Field
        public final boolean zba;

        /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
        public static final class Builder {
            public boolean zba = false;
        }

        @Constructor
        public PasswordRequestOptions(@Param(id = 1) boolean z) {
            this.zba = z;
        }

        public static Builder builder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if ((obj instanceof PasswordRequestOptions) && this.zba == ((PasswordRequestOptions) obj).zba) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zba)});
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            boolean z = this.zba;
            parcel.writeInt(262145);
            parcel.writeInt(z ? 1 : 0);
            SafeParcelWriter.zzb(parcel, beginObjectHeader);
        }
    }

    @Constructor
    public BeginSignInRequest(@Param(id = 1) PasswordRequestOptions passwordRequestOptions, @Param(id = 2) GoogleIdTokenRequestOptions googleIdTokenRequestOptions, @Param(id = 3) String str, @Param(id = 4) boolean z, @Param(id = 5) int i) {
        Preconditions.checkNotNull(passwordRequestOptions);
        this.zba = passwordRequestOptions;
        Preconditions.checkNotNull(googleIdTokenRequestOptions);
        this.zbb = googleIdTokenRequestOptions;
        this.zbc = str;
        this.zbd = z;
        this.zbe = i;
    }

    public static Builder zba(BeginSignInRequest beginSignInRequest) {
        Preconditions.checkNotNull(beginSignInRequest);
        Builder builder = new Builder();
        GoogleIdTokenRequestOptions googleIdTokenRequestOptions = beginSignInRequest.zbb;
        Preconditions.checkNotNull(googleIdTokenRequestOptions);
        builder.zbb = googleIdTokenRequestOptions;
        PasswordRequestOptions passwordRequestOptions = beginSignInRequest.zba;
        Preconditions.checkNotNull(passwordRequestOptions);
        builder.zba = passwordRequestOptions;
        builder.zbd = beginSignInRequest.zbd;
        builder.zbe = beginSignInRequest.zbe;
        String str = beginSignInRequest.zbc;
        if (str != null) {
            builder.zbc = str;
        }
        return builder;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        if (!Objects.equal(this.zba, beginSignInRequest.zba) || !Objects.equal(this.zbb, beginSignInRequest.zbb) || !Objects.equal(this.zbc, beginSignInRequest.zbc) || this.zbd != beginSignInRequest.zbd || this.zbe != beginSignInRequest.zbe) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbc, Boolean.valueOf(this.zbd)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zba, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zbb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        boolean z = this.zbd;
        parcel.writeInt(262148);
        parcel.writeInt(z ? 1 : 0);
        int i2 = this.zbe;
        parcel.writeInt(262149);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
