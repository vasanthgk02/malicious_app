package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzdl;
import com.google.android.gms.internal.auth.zzdm;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzdl<MessageType extends zzdm<MessageType, BuilderType>, BuilderType extends zzdl<MessageType, BuilderType>> implements zzfp {
    /* renamed from: zza */
    public abstract BuilderType clone();

    public abstract BuilderType zzb(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzfp zzc(zzfq zzfq) {
        if (zzh().getClass().isInstance(zzfq)) {
            return zzb((zzdm) zzfq);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
