package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public abstract class zzen extends zzbn implements zzeo {
    public zzen() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzbo.zzc(parcel);
                zzk((zzav) zzbo.zza(parcel, zzav.CREATOR), (zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                zzbo.zzc(parcel);
                zzt((zzll) zzbo.zza(parcel, zzll.CREATOR), (zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                zzbo.zzc(parcel);
                zzj((zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzbo.zzc(parcel);
                zzl((zzav) zzbo.zza(parcel, zzav.CREATOR), readString, readString2);
                parcel2.writeNoException();
                break;
            case 6:
                zzbo.zzc(parcel);
                zzs((zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                boolean zzg = zzbo.zzg(parcel);
                zzbo.zzc(parcel);
                List zze = zze((zzp) zzbo.zza(parcel, zzp.CREATOR), zzg);
                parcel2.writeNoException();
                parcel2.writeTypedList(zze);
                break;
            case 9:
                String readString3 = parcel.readString();
                zzbo.zzc(parcel);
                byte[] zzu = zzu((zzav) zzbo.zza(parcel, zzav.CREATOR), readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zzu);
                break;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                zzbo.zzc(parcel);
                zzq(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                break;
            case 11:
                zzbo.zzc(parcel);
                String zzd = zzd((zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzd);
                break;
            case 12:
                zzbo.zzc(parcel);
                zzn((zzab) zzbo.zza(parcel, zzab.CREATOR), (zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzbo.zzc(parcel);
                zzo((zzab) zzbo.zza(parcel, zzab.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                zzbo.zzc(parcel);
                List zzh = zzh(parcel.readString(), parcel.readString(), zzbo.zzg(parcel), (zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzh);
                break;
            case 15:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                boolean zzg2 = zzbo.zzg(parcel);
                zzbo.zzc(parcel);
                List zzi = zzi(readString7, readString8, readString9, zzg2);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzi);
                break;
            case 16:
                zzbo.zzc(parcel);
                List zzf = zzf(parcel.readString(), parcel.readString(), (zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzf);
                break;
            case 17:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                zzbo.zzc(parcel);
                List zzg3 = zzg(readString10, readString11, readString12);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzg3);
                break;
            case 18:
                zzbo.zzc(parcel);
                zzm((zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                break;
            case 19:
                zzbo.zzc(parcel);
                zzr((Bundle) zzbo.zza(parcel, Bundle.CREATOR), (zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                break;
            case 20:
                zzbo.zzc(parcel);
                zzp((zzp) zzbo.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
