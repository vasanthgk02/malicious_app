package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public enum zzhe {
    DOUBLE(zzhf.DOUBLE, 1),
    FLOAT(zzhf.FLOAT, 5),
    INT64(zzhf.LONG, 0),
    UINT64(zzhf.LONG, 0),
    INT32(zzhf.INT, 0),
    FIXED64(zzhf.LONG, 1),
    FIXED32(zzhf.INT, 5),
    BOOL(zzhf.BOOLEAN, 0),
    STRING(zzhf.STRING, 2),
    GROUP(zzhf.MESSAGE, 3),
    MESSAGE(zzhf.MESSAGE, 2),
    BYTES(zzhf.BYTE_STRING, 2),
    UINT32(zzhf.INT, 0),
    ENUM(zzhf.ENUM, 0),
    SFIXED32(zzhf.INT, 5),
    SFIXED64(zzhf.LONG, 1),
    SINT32(zzhf.INT, 0),
    SINT64(zzhf.LONG, 0);
    
    public final zzhf zzt;

    /* access modifiers changed from: public */
    zzhe(zzhf zzhf, int i) {
        this.zzt = zzhf;
    }

    public final zzhf zza() {
        return this.zzt;
    }
}
