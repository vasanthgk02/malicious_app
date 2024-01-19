package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzm implements Creator {
    public static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = getServiceRequest.zzc;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = getServiceRequest.zzd;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = getServiceRequest.zze;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        SafeParcelWriter.writeString(parcel, 4, getServiceRequest.zzf, false);
        SafeParcelWriter.writeIBinder(parcel, 5, getServiceRequest.zzg, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, getServiceRequest.zzh, i, false);
        SafeParcelWriter.writeBundle(parcel, 7, getServiceRequest.zzi, false);
        SafeParcelWriter.writeParcelable(parcel, 8, getServiceRequest.zzj, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, getServiceRequest.zzk, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, getServiceRequest.zzl, i, false);
        boolean z = getServiceRequest.zzm;
        parcel.writeInt(262156);
        parcel.writeInt(z ? 1 : 0);
        int i5 = getServiceRequest.zzn;
        parcel.writeInt(262157);
        parcel.writeInt(i5);
        boolean z2 = getServiceRequest.zzo;
        parcel.writeInt(262158);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 15, getServiceRequest.zzp, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        Feature[] featureArr2 = featureArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 3:
                    i3 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 5:
                    iBinder = SafeParcelReader.readIBinder(parcel2, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.createTypedArray(parcel2, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.createBundle(parcel2, readInt);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.createParcelable(parcel2, readInt, Account.CREATOR);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.createTypedArray(parcel2, readInt, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.createTypedArray(parcel2, readInt, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 13:
                    i4 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 14:
                    z2 = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 15:
                    str2 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        GetServiceRequest getServiceRequest = new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, i4, z2, str2);
        return getServiceRequest;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
