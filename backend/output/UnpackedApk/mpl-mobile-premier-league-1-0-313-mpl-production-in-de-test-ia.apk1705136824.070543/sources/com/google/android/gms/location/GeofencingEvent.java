package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzbe;
import com.google.android.gms.location.Geofence.GeofenceTransition;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class GeofencingEvent {
    public final int zza;
    @GeofenceTransition
    public final int zzb;
    public final List<Geofence> zzc;
    public final Location zzd;

    public GeofencingEvent(int i, @GeofenceTransition int i2, List<Geofence> list, Location location) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = list;
        this.zzd = location;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        ArrayList arrayList = null;
        if (intent == null) {
            return null;
        }
        int i = -1;
        int intExtra = intent.getIntExtra("gms_error_code", -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra2 != -1) {
            if (intExtra2 == 1 || intExtra2 == 2) {
                i = intExtra2;
            } else if (intExtra2 == 4) {
                i = 4;
            }
        }
        ArrayList arrayList2 = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2.size());
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                byte[] bArr = (byte[]) arrayList2.get(i2);
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                obtain.recycle();
                arrayList.add(zzbe.CREATOR.createFromParcel(obtain));
            }
        }
        return new GeofencingEvent(intExtra, i, arrayList, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }
}
