package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zat;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaco {
    public static final ExecutorService zaa = zat.zaa().zaa(new NumberedThreadFactory("GAC_Transform"), 1);
}
