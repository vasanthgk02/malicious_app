package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.location.zzaz;
import com.google.android.gms.location.zzba;
import com.google.android.gms.location.zzbd;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbc extends AbstractSafeParcelable {
    public static final Creator<zzbc> CREATOR = new zzbd();
    @Field
    public final int zza;
    @Field
    public final zzba zzb;
    @Field
    public final zzbd zzc;
    @Field
    public final PendingIntent zzd;
    @Field
    public final zzba zze;
    @Field
    public final zzai zzf;

    @Constructor
    public zzbc(@Param(id = 1) int i, @Param(id = 2) zzba zzba, @Param(id = 3) IBinder iBinder, @Param(id = 4) PendingIntent pendingIntent, @Param(id = 5) IBinder iBinder2, @Param(id = 6) IBinder iBinder3) {
        zzbd zzbd;
        zzba zzba2;
        this.zza = i;
        this.zzb = zzba;
        zzai zzai = null;
        if (iBinder == null) {
            zzbd = null;
        } else {
            zzbd = com.google.android.gms.location.zzbc.zzb(iBinder);
        }
        this.zzc = zzbd;
        this.zzd = pendingIntent;
        if (iBinder2 == null) {
            zzba2 = null;
        } else {
            zzba2 = zzaz.zzb(iBinder2);
        }
        this.zze = zzba2;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface instanceof zzai) {
                zzai = (zzai) queryLocalInterface;
            } else {
                zzai = new zzag(iBinder3);
            }
        }
        this.zzf = zzai;
    }

    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.location.zzbc zza(com.google.android.gms.location.zzbd r8, com.google.android.gms.internal.location.zzai r9) {
        /*
            com.google.android.gms.internal.location.zzbc r7 = new com.google.android.gms.internal.location.zzbc
            if (r9 != 0) goto L_0x0005
            r9 = 0
        L_0x0005:
            r6 = r9
            r1 = 2
            r2 = 0
            r4 = 0
            r5 = 0
            r0 = r7
            r3 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzbc.zza(com.google.android.gms.location.zzbd, com.google.android.gms.internal.location.zzai):com.google.android.gms.internal.location.zzbc");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.location.zzbc zzb(com.google.android.gms.internal.location.zzba r8, android.app.PendingIntent r9, com.google.android.gms.internal.location.zzai r10) {
        /*
            com.google.android.gms.internal.location.zzbc r7 = new com.google.android.gms.internal.location.zzbc
            r1 = 1
            r3 = 0
            r5 = 0
            r0 = r7
            r2 = r8
            r4 = r9
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzbc.zzb(com.google.android.gms.internal.location.zzba, android.app.PendingIntent, com.google.android.gms.internal.location.zzai):com.google.android.gms.internal.location.zzbc");
    }

    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r5v0, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.location.zzbc zzc(com.google.android.gms.location.zzba r8, com.google.android.gms.internal.location.zzai r9) {
        /*
            com.google.android.gms.internal.location.zzbc r7 = new com.google.android.gms.internal.location.zzbc
            if (r9 != 0) goto L_0x0005
            r9 = 0
        L_0x0005:
            r6 = r9
            r1 = 2
            r2 = 0
            r3 = 0
            r4 = 0
            r0 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzbc.zzc(com.google.android.gms.location.zzba, com.google.android.gms.internal.location.zzai):com.google.android.gms.internal.location.zzbc");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        IBinder iBinder2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzbd zzbd = this.zzc;
        IBinder iBinder3 = null;
        if (zzbd == null) {
            iBinder = null;
        } else {
            iBinder = zzbd.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        zzba zzba = this.zze;
        if (zzba == null) {
            iBinder2 = null;
        } else {
            iBinder2 = zzba.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, iBinder2, false);
        zzai zzai = this.zzf;
        if (zzai != null) {
            iBinder3 = zzai.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder3, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
